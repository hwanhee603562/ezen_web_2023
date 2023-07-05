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
	// 1. 주문(주문내역) 배열
		/*		주문 {주문번호: , 주문날짜 : , 결제금액 : , 주문제품들 [] , 상태 : 0[주문요청] / 1[완료] / 2[주문취소] }	*/

let orderList = [
	{ ono : 1, date : '2023-07-05 13:30 13:30:21', pay : 30000, products : [ 0, 0, 2 ], state : 1 }
		
				]

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
	let totalPrice = 0
	for(let i=0; i<cartList.length; i++){
		let burgerIndex = cartList[i]
		html += `<div class="citem">
					<div class="iname">${burgerList[burgerIndex].name}</div>
					<div class="iprice">${burgerList[burgerIndex].price.toLocaleString()}원</div>
					<span onclick="productCancel(${i})" class="icancel">X</span>
				</div>`
		totalPrice += burgerList[burgerIndex].price
		
	}
	
	cartbottom.innerHTML = html
	
	document.querySelector('.ccount').innerHTML = `${cartList.length}`
	
	document.querySelector('.ctotal').innerHTML = `${totalPrice.toLocaleString()}원`

	// 카트내 제품이 많아서 스크롤이 생겨났을 경우 자동으로 가장 오른쪽으로 이동
	cartbottom.scrollLeft = 10000;
}

// 7. 카트내 버거 부분 개별 함수
function productCancel( cartIndex ){
	
	cartList.splice(cartIndex, 1)

	
	cartPrint();
	
	
}

// 8. 카트내 버거 전체 개별 함수
function cartCancel(){
	cartList.splice(0)
	
	cartPrint();
}

/*		주문 {주문번호: , 주문날짜 : , 결제금액 : , 주문제품들 [] , 상태 : 0[주문요청] / 1[완료] / 2[주문취소] }	*/

// 9. 카트내 저장된 버거 주문(등록) 함수 [실행조건 : 주문하기 버튼을 클릭했을 때]
function productOrder(){
	
	let ono = orderList[orderList.length-1].ono
	
	let products = [];	// 주문이 들어가는 버거들 인덱스
	let totalprice = 0;
	
	for(let i=0; i<cartList.length; i++){
		products.push(cartList[i])	// i번째 버거를 새로운 배열에 저장
		totalprice += burgerList[cartList[i]].price
	}
	
	let order = {
		ono : ono+1,		// 주문번호 생성해서 저장
		date : new Date(), 	// 현재날짜/시간 구해주는 함수 이용해서 자동으로 대입
		pay : totalprice, 			// 카트 내 제품들의 총가격
		products : products,		//카트에 있던 모든 제품들
		state : 0				//주문객체 생성시 '주문요청'으로 상태 초기로 사용
	}
	
	orderList.push( order )
	alert('주문이 들어갔습니다')
	
	cartCancel()
	console.log(orderList)
	
} 


















