

// 1. 포인트 사용함수
function setPoint( mpamount, mpcomment ){
	if( !loginState ){
		return;
	}
	
	$.ajax({
		url: "/jspweb/PointController",
		method: "post",
		async : false,		/* ajax가 응답이 올때까지 대기상태 */
		data: { mpamount : mpamount, mpcomment : mpcomment },
		success: result =>{
			console.log('1 성공')
			console.log(result)
			returnData = result;
		},
		error: e =>{
			console.log('에러발생')
			console.log(e)
		}
	})
	
	return returnData;	
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


/* ------------------------ 결제 연동 ---------------------- */

// 1. 아임포트 관리자 식별키
IMP.init('imp74472512') // 아임포트 콘솔에서 확인

// 2. 결제 함수 [ 속성은 PG사 별로 상이 ]
function requestPay() {
	
	// 2-1 : 만약에 결제방식을 선택하지 않았으면
	if( pay_method == '' ){
		alert('결제방식을 선택해주세요');
		return;
	}
	if( amount == 0 ){
		alert('포인트를 선택해주세요')
		return
	}
	
	// 2-2 : 주문번호 만들기
		// * 고유성/중복x/PK/식별키
		// 1. 날짜 + 상품코드 + 회원번호 조합해서 설계
		// 2. 회사전화번호 + 사업자번호 조합해서 설계 등
	let now = new Date();
	let time = now.getTime();
	let merchant_uid = time+"-p-"+loginMid;	// 가급적 회원번호 조합 권장 / 로그인세션에서 아이디 가져옴
	console.log(merchant_uid)
	
	IMP.request_pay({
		pg: "html5_inicis.INIBillTst",		// 아임포트 콘솔에서 확인
		pay_method: pay_method,				// 결제방식
		merchant_uid: merchant_uid,   		// 주문번호
		name: "포인트결제",
		amount: amount,                     // 숫자 타입
		buyer_email: "gildong@gmail.com",
		buyer_name: "이환희",
		buyer_tel: "010-4242-4242",
		buyer_addr: "서울특별시 강남구 신사동",
		buyer_postcode: "12345",
		vbank_due : 1						// 가상계좌 입금마감일시 : 미기입시 default값 30일
	}, function(rsp) { // callback
		//rsp.imp_uid 값으로 결제 단건조회 API를 호출하여 결제결과를 판단합니다.

		if (rsp.success) {	// 결제 성공



		} else {	// 결제실패 : 사업자번호가 없기 때문에 실패가 성공이라는 가정으로 진행
			alert('결제성공')

			// 1. 포인트 적립 기능처리
			setPoint( amount, '포인트결제' )
			
			// 2. 결제내역 테이블 기능처리 [ 구현x ]
			
			
		}

	});
}

// 3. 결제 방식 선택 함수
let pay_method = ''		// 결제방식
function onPayMethod( method ){
	pay_method = method;
}

// 4. 결제 금액 선택 함수
let amount = 0;
function onAmount( value ){
	amount = value;
} 


















