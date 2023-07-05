console.log('index.js열림')

// 1. 광고이미지 변경
	// 1. 광고이미지 여러개 저장하는 공간 = 배열
let bimgList = [ '버거킹1.png', '버거킹2.png', '버거킹3.jpg', '버거킹4.png', '버거킹5.png' ]


	// 1. 카테고리 여러개 저장하는 배열
let burgerList = [
				{name : '헬로디아블로와퍼', price : 9500, img : '헬로디아블로와퍼.png', category : 0 },
				{name : '헬로릴리트와퍼', price : 12500, img : '헬로릴리트와퍼.png', category : 0 },
				{name : '치킨킹', price : 8000, img : '치킨킹.png', category : 3} ]
				
let cartList = []

/*---------------------------------------------------*/

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
	
	productPrint(selectNo)

}


// 3. 카테고리 클릭 함수
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
	productPrint(selectNo)
}


// 4. 제품 출력 함수[ 실행조건 : 1. 카테고리 클릭(변경)되면 ]

function productPrint( categoryNo ){	// 어떤 카테고리의 제품 출력할건지? 인수판단
	let productbox = document.querySelector('.productbox')
	
	let html = '';

		for(let i=0; i<burgerList.length; i++){	// 모든 버거배열/리트스[서랍장] 열어서[하나씩] 확인
			// 버거리스트의 객체 중 category key의 value와 categoryNo(인자값)과 같을 경우
			if( burgerList[i].category == categoryNo ){
				html += `<div onclick="productSelect(${i})" class="product"><!-- 제품 1개 기준 -->
				
					<img class="himg" src="../img/${burgerList[i].img}">
					<div class="pinfo">
						<div class="pname">${burgerList[i].name} </div>
						<div class="pprice">${burgerList[i].price.toLocaleString()}원</div>
					</div>
				</div>`
			}
		}
		
	productbox.innerHTML = html		
}




// 5. 제품 선택해서 카트에 담는 함수 [ 실행조건 : 1. 제품 이미지 클릭하면 ] 
function productSelect( productNo ){		// 어떤 제품을 카트에 담을건지? 인수판단
	console.log(burgerList[productNo].name)
	// 1. 선택된 버거의 인덱스를 배열에 저장 [ 버거 모든 정보를 저장할 필요가 없음 ]
	cartList.push(productNo)
	console.log(cartList)
	
	cartPrint()
}

// 6. 카트내 버거들을 출력 함수  
function cartPrint(){
	let cartbottom = document.querySelector('.cartbottom')

	let html = ''
	let total = 0
	for(let i=0; i<cartList.length; i++){
		let burgerIndex = cartList[i]
		html += `<div class="citem">
					<div class="iname">${burgerList[burgerIndex].name}</div>
					<div class="iprice">${burgerList[burgerIndex].price.toLocaleString()}원</div>
					<span onclick="productCancel(${i})" class="icancel">X</span>
				</div>`
		total += burgerList[burgerIndex].price
		
	}
	
	cartbottom.innerHTML = html
	
	document.querySelector('.ccount') = `${cartList.length}`
	
	document.querySelector('.ctotal') = `${totalPrice.toLocaleString()}원`

}

// 7. 카트내 버거 부분 개별 함수
function productCancel( cartIndex ){
	
	cartList.splice(cartIndex, 1)
	alert('취소되었습니다')
	
	cartPrint();
	
	
}

// 8. 카트내 버거 전체 개별 함수
function cartCancel(){
	cartList.splice(0)
	alert('모두 취소되었습니다')
	
	cartPrint();
}
