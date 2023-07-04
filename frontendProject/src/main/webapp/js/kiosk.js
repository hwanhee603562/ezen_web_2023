console.log('index.js열림')

// 1. 광고이미지 변경
	// 1. 광고이미지 여러개 저장하는 공간 = 배열
let bimgList = [ '버거킹1.png', '버거킹2.png', '버거킹3.jpg', '버거킹4.png', '버거킹5.png' ]
	// 2. 특정시간마다 이미지의 src 변경 하기
		// setInterval(함수/기능, 밀리초) 함수 : 1/1000초
let viewhimg = 0 //현재 출력중인 광고이미지 인덱스 저장하고 있는 변수
		
		
setInterval( ()=>{ 
	let himg = document.querySelector('.himg')
	
	viewhimg++;
	if( viewhimg >= bimgList.length){
		viewhimg = 0;
	}
	himg.src= `../img/${bimgList[viewhimg]}`
	
}, 2000 );	// 2초마다 실행코드가 주기적으로 실행

// 2. 카테고리 출력 함수
let categoryList = [ '신제품(NEW)', '프리미엄', '와퍼&주니어', '치킨&슈프림버거', '올데이킹&킹모닝' ]

categoryPrint( 0 );//최초 한 번 실행
function categoryPrint(selectNo){
	let categorymenu = document.querySelector('.categorymenu ')

	let html = ``
	
	for(let i=0; i<categoryList.length; i++){
		if(i == selectNo){
			html += `<li onclick="categorySelect(${i})" class="categoryselect">${ categoryList[i] }</li>`
		} else {
			html += `<li onclick="categorySelect(${i})">${ categoryList[i] }</li>`
		} 
	}
	categorymenu.innerHTML = html

}


function categorySelect( selectNo ){

	let categoryli = document.querySelectorAll('.categorymenu li')
	
	console.log(categoryli)
	
	for(let i=0; i<categoryList.length; i++){
		if(i==selectNo){
			categoryli[i].classList.add('categoryselect')
			//DOM객체명.classList.add('새로운클래스명')
		}else{
			categoryli[i].classList.remove('categoryselect')
			//DOM객체명.classList.remove('삭제클래스명')
		}
	}
}

// 3. 카테고리 클릭 함수
















