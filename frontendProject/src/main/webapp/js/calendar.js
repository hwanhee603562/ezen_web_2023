// 0. 현재 연도/월 [초기값]
	// new Date()	: 현재 날짜/시간 반환해주는 클래스
		// .getFullYear(),
let year = new Date().getFullYear();	// 현재 연도
let month = new Date().getMonth()+1;	// 현재 월[ 0~11 ]+1

let contents = []	// 여러개의 일정객체를 저장하는 배열

// 1. 현재 연도/월 기준으로 달력 출력하는 함수
calPrint()

function calPrint(){
	//현재 연도와 월을 해당 구역에 출력
	document.querySelector('.caldate').innerHTML = `${year}년 ${month}월` 
	// 1. 요일 과 일 출력
	
		/*
			1. 시작 요일
			2. 현재 월 마지막 일 
		*/
	
	// 현재 보고있는 캘린더의 날짜
	let now = new Date( year, month-1, 1) 
	let sweek = now.getDay();
	// 현재 월의 마지막 일 구하기
	let now2 = new Date( year, month, 0)
	let eDay = now2.getDate()
	
	
	let calendar = document.querySelector('.calendar')
	let html = ''
		// 1. 요일
	html += `<div class="week sunday"> 일 </div><div class="week"> 월 </div>
			<div class="week"> 화 </div><div class="week"> 수 </div>
			<div class="week"> 목 </div><div class="week"> 금 </div><div class="week"> 토 </div>`
	
	for(let b=1; b<=sweek; b++){// 1부터 1일의요일까지 공백 구역 출력
		html += `<div></div>`
	}
	
		// 2. 현재 달력 마지막 일 까지 일수 출력
	for(let day=1; day<=eDay; day++){
		html += `<div onclick="openModal(${day})">
					${day} 
					${contentPrint( `${year}-${month}-${day}` ) }
				</div>`
				// 만약에 현재 날짜와 일정목록에 등록된 일정의 날짜와 같으면 출력
				
				
				
	}
	
	calendar.innerHTML = html

}

// 일정 출력함수[ 현재 날짜와 동일한 일정 날짜를 찾아서 출력 ]
	// 인수 : 함수 안으로 들어오는 수/값/코드
	// 반환 : 함수{}  끝나고 함수 호출 했던 곳으로 수/값/데이터 보내기 = 해당 날짜의 일정 내용 HTML
function contentPrint(date){
	
	let html = ''
	for(let i=0; i<contents.length; i++){
		if(date == contents[i].date){
			html += `<span class="content" style="background-color : ${contents[i].color}">
						${ contents[i].content }
					</span>`
		}
	}
	return html
	
}


// 버튼을 클릭했을 때 현재 월 변화해주는 함수
function onNext( check ){
	
	// 버튼 식별 후 월 증감
	if(check == 0){	// 이전 달
		month--
		
		// 월이 1보다 작아지면 연도 1차감
		if(month<1){
			month=12
			year--
		}
		
		
	}else if(check == 1){ // 다음 달 
		month++
		
		// 월이 1보다 커지면 연도 1증가
		if(month>12){
			month=1
			year++
		}
	}
	
	// 월 증감 후 새로고침
	calPrint()
	
	
}




// 모달 열기
function openModal( day ){
	document.querySelector('.modalwrap').style.display = 'flex'
	
	//현재 클릭한 일수의 날짜 출력
	document.querySelector('.date').innerHTML = `${year}-${month}-${day}`
}
// 모달 닫기
function closeModal(  ){
	document.querySelector('.modalwrap').style.display = 'none'
}





//일정등록 버튼 클릭했을 때
function onWrite(){
	let color = document.querySelector('.color')
	let contentInput = document.querySelector('.contentInput')
	let date = document.querySelector('.date')
	
	//객체화
	let object = {
		color : color.value,
		content : contentInput.value,
		date : date.innerHTML
	}
	
	contents.push( object )
	console.log( contents )
	
	color.value = ''
	contentInput.value = ''
	
	closeModal()
	calPrint()
}




















