

//setPoint( 1000, '회원가입 축하' )
getPoint();
getPointList();

// 1. 포인트 사용함수
function setPoint( mpamount, mpcomment ){
	if( !loginState ){
		return;
	}
	
	$.ajax({
		url: "/jspweb/PointController",
		method: "post",
		data: { mpamount : mpamount, mpcomment : mpcomment },
		success: result =>{
			console.log('1 성공')
			console.log(result)
		},
		error: e =>{
			console.log('에러발생')
			console.log(e)
		}
	})
	
}


// 2. 내 포인트 확인 함수
function getPoint(){
	if( !loginState ){
		return;
	}
	$.ajax({
		url: "/jspweb/PointController",
		method: "get",
		data: { type : 'findByPoint' },
		success: result =>{
			console.log('2 성공')
			console.log(result)
		},
		error: e =>{
			console.log('에러발생')
			console.log(e)
		}
	})
}


// 3. 내 포인트 내역 전체 출력 함수
function getPointList(){
	if( !loginState ){
		return;
	}
	$.ajax({
		url: "/jspweb/PointController",
		method: "get",
		data: { type : 'findByAll' },
		success: result =>{
			console.log('3 성공')
			console.log(result)
		},
		error: e =>{
			console.log('에러발생')
			console.log(e)
		}
	})
}





























