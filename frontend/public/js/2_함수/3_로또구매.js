console.log('js 실행')

let 선택번호목록 = [];


// 1. 로또 구매함수 정의
function 로또구매(){
	console.log('로또구매() 실행')
	// 1~45개의 button 생성해서 변수에 담기
	let buttonHTML = ``;
	for(let i=1; i<=45; i++){
		buttonHTML +=`<button onclick="숫자버튼(${i})">${i}</button>`
		if(i%5==0){
			buttonHTML += `<br/>`
		}
	}
	// 1~45개 button을 버튼목록구역 class에 생성
	document.querySelector('.버튼목록구역').innerHTML = buttonHTML
}

// 2. 숫자(선택) 버튼 함수 정의
function 숫자버튼(선택된번호){

	
	if(선택번호목록.indexOf(선택된번호) != -1){
		선택번호목록.splice(선택번호목록.indexOf(선택된번호), 1)
		//alert('이미 선택된 번호입니다')
		선택번호출력();
		return
	}
	
	if(선택번호목록.length == 6){
		alert('이미 6개 번호 모두 선택하셨습니다')
		return;
	}
	
	console.log(선택된번호+'을 숫자바튼을 클릭했군요')
	선택번호목록.push(선택된번호)
	선택번호출력();
	console.log(선택번호목록)

}

/* 3. 선택된 번호들을 출력 하는 함수*/
function 선택번호출력(){
	document.querySelector('.선택번호출력구역').innerHTML = 선택번호목록;

	if(선택번호목록.length == 6){
		document.querySelector('.추첨결과버튼구역').innerHTML
		= `<button onclick="추첨결과()"> 추첨결과보기 </button>`
	}
	else{
		document.querySelector('.추첨결과버튼구역').innerHTML = ``
	}

}

//4. 추첨결과 함수 [실행조건 : 배열내 6개 숫자존재하고 추첨결과보기 버튼을 클릭했을 때]
function 추첨결과(){
	alert('로또 추첨 진행합니다.[ 잠시 대기 ]')
	
	/*
	console.log(Math.random())
	// Math.random() : 0~1 사이의 난수(실수) 생성
	console.log(Math.random()+1)
	// (0~1)+1 => 1~2사이의 난수 생성 */
	// console.log(parseInt(Math.random()*45+1))
	// (0~1)*45+1 => 1~46 사이의 난수 생성
	//	* 실제 46미만의 수가 생성됨
		// 실수에서 정수 형변환
		// parseInt
	
	let 추첨번호목록 = [];
	
	for(let i=0; i<6; i++){
		let 추첨번호 = parseInt(Math.random()*45+1)
		if(추첨번호목록.indexOf(추첨번호) == -1 ){
			추첨번호목록.push(추첨번호);
		}else{	// 동일한추첨번호가 있으면
			i--
		}
	}
	console.log(추첨번호목록)
	
	let count = 0;
	
	for(let i=0; i<추첨번호목록.length; i++){
		if(선택번호목록.indexOf(추첨번호목록[i])!=-1){
			count++
		}
	}
	
	//for 관련함수		[배열명.forEach() vs 배열명.map() vs filter() ]
			// 배열명.forEach( 반복변수명 => {실행문})
	/*		선택번호목록.forEach( (데이터, 인덱스)=>{
				console.log(데이터) //인덱스 내 데이터
				console.log(인덱스) //인덱스 번호
				
				if(추첨번호목록.indexOf(데이터)!=-1){
					count++
				}
			})
	*/
	
	if(count==6){
		alert("1등 당첨")
	}else if(count==5){
		alert("2등 당첨")
	}else if(count==4){
		alert("3등 당첨")
	}else{
		alert("낙첨입니다")
	}
}


















