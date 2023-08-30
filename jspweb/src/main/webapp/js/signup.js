console.log('js실행');
// onchange 	: 포커스(커서)가 변경되었을 때 이벤트 실행
// onkeyup		: 키보드에서 키를 누르고 떼었을 때
// onkeydown	: 키보드에서 키를 눌렀을 때

/*
	정규표현식 : 문자열에 특정 규칙/패턴 집합 표현할 때 사용되는 언어
		문법
			/^ 		: 정규표현식 시작 알림
			$/ 		: 정규표현식 끝 알림
			[a-z]	: 소문자 a-z 패턴 검색
			[A-Z]	: 대문자 A-Z 패턴 검색
			[0-9]	: 0~9 패턴 검색
			[가-힣]	: 한글 패턴
			{ 최소길이, 최대길이 } : 문자열 길이 패턴
			+ : 앞에 있는 패턴 1개 이상 반복
			? : 앞에 있는 패턴 0개 혹은 1개 이상 반복
			* : 앞에 있는 패턴 0개 반복
			
			예시]
				1. [a-z]			: 소문자 A-Z 패턴
				2. [a-zA-Z]			: 영문(대,소) 패턴
				3. [a-zA-Z0-9]		: 영문 + 숫자 조합 패턴
				4. [a-zA-Z0-9가-힣]	: 영문 + 숫자 + 한글 조합 패턴
				5. [ac]				: a와c 패턴
				6. (?=.*[패턴문자])	: 해당 패턴문자가 한 개 이상 포함 패턴
					(?=.*[a-z])		: 소문자 한 개 이상 필수
					(?=.*[A-Z])		: 대문자 한 개 이상 필수
					(?=.*[0-9])		: 숫자 한 개 이상 필수
					(?=.*[!@#$%^&*]): 패턴문자내 특수문자 한 개 이상 필수
				
				
				/^[a-zA-Z0-9]{5,20}$/
				영대소문자 + 숫자포함 5~20글자 사이
				
				/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9]{5,20}$/
				영대문자1개 + 영소문자1개 + 숫자 1개 이상 필수로 갖는 5~20글자 사이

				/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9]{5,20}$/
				영대문자1개 + 영소문자1개 + 숫자 1개 이상 + 특수문자를 필수로 갖는 5~20글자 사이
				
					
				
			1. /^[a-z0-9]{5,30}$/	: 영문(소) + 숫자조합 5~30글자 패턴
			
		패턴검사
			"패턴".test( 검사할데이터 )	: 해당 데이터가 패턴에 일치하면 true / 아니면 false
			
*/
	
	
	
	
// 1. 아이디 유효성검사
function idcheck(){
	console.log('idcheck() open');
	
	// 1. 값 호출
	let mid = document.querySelector('.mid').value;
	let idcheckbox = document.querySelector('.idcheckbox');
	
	// 2. 유효성검사
		// 제어문을 이용한 검사 if( mid.length < 5 || mid.length >= 30 ){}	
		
		// 1. 아이디는 영문(소문자)+숫자 조합의 5~30글자 사이이면
			// 1. 정규표현식 작성
		let midj = /^[a-z0-9]{5,30}$/
			// 2. 정규표현식 검사
		console.log( midj.test(mid) );
		if( midj.test(mid) ){	// 통과
			idcheckbox.innerHTML = '패턴합격';
			// 입력한 아이디가 일치하면 아이디 중복검사
			$.ajax({
				url : "/jspweb/MemberFindController",
				method : "get",
				data : { type : "mid", data : mid },
				success : r => {
					console.log('통신성공');
					if( r ){
						idcheckbox.innerHTML = '사용 중인 아이디 입니다';
						checkList[0] = false;
					} else {
						idcheckbox.innerHTML = '사용가능한 아이디 입니다';
						checkList[0] = true;
					}
				},
				error : r => {
					console.log(r);
				}
			})
			
		} else {	// 실패
			document.querySelector('.idcheckbox').innerHTML = '영문(소문자)+숫자 조합의 5~30글자 가능합니다';
			checkList[0] = false;
		}
	// 3. 결과 출력	
}




// 2. 비밀번호 유효성검사 [ 1.정규표현식 검사 2. 비밀번호와 비밀번호 확인 일치여부 ]
function pwcheck(){
	let pwcheckbox = document.querySelector('.pwcheckbox');
	
	// 1. 입력 값 호출
	let mpwd = document.querySelector('.mpwd').value;
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value;
	
	// 2. 유효성 검사
		// 1. 정규표현식 만들기 [ 영대소문자 + 숫자 포함 5~20글자 사이 ]
	let mpwdj = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/
		
	// 1. 비밀번호 정규표현식 검사
	if(mpwdj.test( mpwd )){
		
		// 2. 비밀번호 확인 정규표현식 검사
		if(mpwdj.test( mpwdconfirm )){
			// 3. 비밀번호와 비밀번호 확인 일치여부
			if( mpwd == mpwdconfirm ){
				pwcheckbox.innerHTML = `사용가능한 비밀번호`;
				checkList[1] = true;
			} else {
				pwcheckbox.innerHTML = `비밀번호가 일치하지않습니다`;
				checkList[1] = false;
			}
		} else {
			pwcheckbox.innerHTML = `영대소문자1개이상+숫자1개이상조합 5~20글자 사이로 입력해주세요`;
			checkList[1] = false;	
		}
	} else {
		pwcheckbox.innerHTML = `영대소문자1개이상+숫자1개이상조합 5~20글자 사이로 입력해주세요`;
		checkList[1] = false;
	}
	
} 




// 3. 이메일 유효성 검사 [ 1. 정규표현식 2. 중복검사 ]
function emailcheck(){
	let emailcheckbox = document.querySelector('.emailcheckbox');
	let authReqBtn = document.querySelector('.authReqBtn');
	
	// 1. 입력된 값 호출
	let memail = document.querySelector('.memail').value;
	
	// 2. 이메일 정규표현식 [ 영대소문자, 숫자,_- @ ]
		// itdanja@kakao.com
		// 1. itdanja	: 이메일 아이디부분은 영대소문자, 숫자, _- 패턴
		// 2. @			: +@  	@앞에 패턴이 1개 이상 필수
		// 3. 도메인
			// 회사명		: +@ 	뒤에 그리고, 앞에 패턴은 a-zA-Z0-9_-
			// .		: +\.  	. 앞에 패턴이 1개 이상 필수	('.'을 기준으로 앞에 패턴이 존재해야함)
			// 도메인		: . 뒤에 패턴은 a-zA-Z
			
			
	let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/
	
	if( memailj.test(memail) ){
		
		$.ajax({
			url : "/jspweb/MemberFindController",
			method : "get",
			data : { type : "memail", data : memail },	// 이메일 중복검사
			//data : { type : "mid", data : mid }	// 아이디 중복검사
			success : r => {
				if(r){
					emailcheckbox.innerHTML = `사용중인 이메일입니다`;
					authReqBtn.disabled = true;	// jsp상 disabled속성 적용
					checkList[2] = false;
				} else {
					emailcheckbox.innerHTML = `사용가능한 이메일입니다`;
					authReqBtn.disabled = false;	// jsp상 disabled속성 해제
				}
			},
			error : r => {
				console.log(r);
			}
		})
	} else {
		emailcheckbox.innerHTML = `이메일형식에 맞게 입력해주세요`;
		authReqBtn.disabled = true;	// jsp상 disabled속성 적용
		checkList[2] = false;
	}
}




// 4. 인증요청 버튼을 눌렀을 때
function authReq(){
	
	let authbox = document.querySelector('.authbox');
	
	// 2. auth html 구성
	let html = `<span class="timebox"> 02:00 </span>
				<input class="ecode" type="text"/>
				<button onclick="auth()" type="button">인증</button>`
	
	// 3. auth html 대입
	authbox.innerHTML = html;
		
	// 4. 타이머 실행
	authcode = "1234";	// 인증코드에 난수 대입
	timer = 120;	// 인증 제한시간 120초 설정
	settimer();		// 타이머 실행
	
	/*
	// -- 인증요청시 서블릿통신[ 인증코드 생성, 이메일 전송 ]
	$.ajax({
		url : "/jspweb/AuthSendEmailController",
		method : "get",
		data : { memail : document.querySelector('.memail').value },
		success : r => {
			console.log('인증코드 : '+r);
			
			// 1. 'authbox' div 호출
			let authbox = document.querySelector('.authbox');
			
			// 2. auth html 구성
			let html = `<span class="timebox"> 02:00 </span>
						<input class="ecode" type="text"/>
						<button onclick="auth()" type="button">인증</button>`
			
			// 3. auth html 대입
			authbox.innerHTML = html;
				
			// 4. 타이머 실행
			authcode = r;	// 인증코드에 난수 대입
			timer = 120;	// 인증 제한시간 120초 설정
			settimer();		// 타이머 실행
		},
		error : r => {
			console.log(r);
		}
	})
	*/
	

}

// 4번, 5번, 6번 함수에서 공통적으로 사용할 변수[전역변수]
let authcode = '';
let timer = 0;	// 인증 시간 변수
let timerInter; // setInterval() 함수를 가지고 있는 변수 [ setInterval 종료시 필요 ]




// 5. 타이머 함수 만들기
function settimer(){
	//setInterval( 함수명, 실행간격[밀리초] ) : 특정 시간마다 함수를 실행 함수
	timerInter = setInterval( () => {
		// 형식상 timerInter변수 없이 작동하지만
		// clear 메서드를 사용하기 위해 변수에 대입시켜야함
		 
		// 시간 형식 만들기
			// 1. 분 만들기 [ 초 / 60 ] => 분
			//			  [ 초 % 60 ] => 초
		let m = parseInt( timer/60 );
		let s = parseInt( timer%60 );
			// 2. 두 자릿수 맞춤 3 -> 03
		m = m < 10 ? "0"+m : m;	// 만약에 분이 10보다 작으면 한자리수 이므로 0 붙이고 아니면
		s = s < 10 ? "0"+s : s;
		
		document.querySelector('.timebox').innerHTML = `${m}:${s}`;
		timer--;
		
		// 만약에 타이머가 0이면 [ 시간 끝 ]
		if( timer < 0 ){
			// 1. setInterval 종료 [ 누구를 종료할건지 식별자.. 변수 선언 = timerInter ]
			clearInterval( timerInter );
			// 2. 인증실패 알림
			document.querySelector('.emailcheckbox').innerHTML = `인증실패`;
			// 3. authbox 다시 숨기기
			document.querySelector('.authbox').innerHTML = ``;
			checkList[2] = false;
		}
	}, 1000 );
}




// 6. 인증요청 후 인증코드를 입력하고 인증하는 함수
function auth(){
	
	// 1. 입력 받은 인증코드
	let ecode = document.querySelector('.ecode').value;
	
	// 2. 비교[ 인증코드와 입력받은 인증코드 ]
	if( authcode == ecode ){
		// 1. setInterval 종료
		clearInterval( timerInter );
		// 2. 인증성공 알림
		document.querySelector('.emailcheckbox').innerHTML = `인증성공`;
		checkList[2] = true;
		// 3. authbox 구역 HTML 초기화
		document.querySelector('.authbox').innerHTML = ``;
	} else {
		// 1. 인증코드불일치 알림
		document.querySelector('.emailcheckbox').innerHTML = `인증코드 불일치`;
		checkList[2] = false;
	}
}




// 7. 첨부파일에 사진 등록시 등록 사진을 HTML 표시하기 < 등록사진을 미리보기 기능 >
function preimg( object ){
	console.log('사진 선택 변경');
	console.log( object );
		// 이벤트 실행시킨 태그의 DOM객체를 인수로 받음
	console.log( document.querySelector('.mimg') );
	// 1. input태그의 속성 [ type, class, onchange, name 등등 ]
	// 1. input태그 이면서 type="file" 이면 추가적인 속성, 
		// .files : input type="file" 에 선택한 파일 정보를 리스트로 받음
	console.log( object.files );
		// 리스트 중에서 하나의 파일만 가져오기
	console.log( object.files[0] );	
	
	// --- 해당 파일을 바이트코드 변환
	// 2. JS 파일클래스 선언
		// 파일 읽기 클래스를 이용한 파일읽기객체 선언
	let file = new FileReader();	
	
	// 3. 파일 읽어오기 함수 제공
		// input에 등록된 파일리스트 붕 1개를 파일객체로 읽어오기
	file.readAsDataURL( object.files[0] );	
	console.log( file );
	
	// 4. 읽어온 파일을 해당 html img태그에 load
	file.onload = e => {
		console.log(e);		// onload() 실행한 FileReader 객체
		console.log( e.target.result );	// 읽어온 파일의 바이트코드
		document.querySelector('.preimg').src = e.target.result;	// img src 속성에 대입
	}
}





let checkList = [false, false, false];
// true 통과 / false 불통과
	// [0] : 아이디 통과여부
	// [1] : 패스워드 통과여부
	// [2] : 이메일 통과여부

// 8. 회원가입 메소드
function signup(){
	
	// 1. 아이디 비밀번호 이메일 유효성검사 통과여부 체크
	if( checkList[0] && checkList[1] && checkList[2] ){
		// checkList에 저장된 논리가 모두 true이면
		console.log('회원가입이 진행가능');
		
		// 2. 입력받은 데이터를 한 번에 가져오기 form 태그 이용
			// <form> 각종 input/button </from>
			// 1. form 객체 호출 document.querySelectorAll( 폼태그식별자 );
		let signupForm = document.querySelectorAll('.signupForm')[0];
		
			// 2. form 데이터 객체화
				// 일반객체로 첨부파일 전송x -> 
		let signupData = new FormData( signupForm );	// 첨부파일시 필수.. [ 대용량 ]시 필수
		
			// 3. AJAX에게 첨부파일[대용량] 전송 하기
				// 3-1 첨부파일 없을 때
		/*
		$.ajax({
			url : "/jspweb/MemberinfoController",
			method : "post",		// 첨부파일 form 전송은 무조건 post 방식
			data : signupData,		// FormData 객체를 전송
			success : r => {
				console.log(r);
			},
			error : e => {
				console.log(e);
				}
		})
		*/
				// 3-2 첨부파일 있을 때 [ 기존 json형식의 전송x form객체 전송 타입으로 변환 ]
		$.ajax({
			url : "/jspweb/MemberinfoController",
			method : "post",		// 첨부파일 form 전송은 무조건 post 방식
			data : signupData,		// FormData 객체를 전송
			contentType : false,	// form 객체 타입
			processData : false,
			success : r => {
				
				if(r){ // 회원가입 성공
					alert('회원가입 성공');
					location.href = '/jspweb/member/login.jsp';	// 하이퍼링크
					console.log('111');
				} else { // 회원가입 실패
					alert('회원가입 실패');
				}
			},
			error : e => {
				alert('회원가입 실패 [관리자 문의]');
			}
		})
		
	} else {
		alert('정상적으로 입력이 안된 내용이 있습니다');
	}
}




// 유효성검사가 없는 회원가입 메소드 [미사용]
/*
function signup(){
	console.log('signup JS 실행');
	// 1. HTML에 가져올 데이터의 TAG객체 호출 [ DOM객체 : html 태그를 객체화 ]
	let midInput = document.querySelector('.mid');
	let mpwdInput = document.querySelector('.mpwd');
	let mpwdconfirmInput = document.querySelector('.mpwconfirm');
	let memailInput = document.querySelector('.memail');
	let mimgInput = document.querySelector('.mimg');
	
	// 2. (객체화)
	let info = {
		// 인증코드, 패스워드 확인 유효성검사 확인을 위한 것이므로 DB에 넣을 필요가 없음
		mid : midInput.value,
		mpwd : mpwdInput.value,
		memail : memailInput.value,
		mimg : mimgInput.value,
	};
	
	// 3. 유효성검사
	
	
	
	// 4. AJAX메소드를 이용한 Servlet과 통신
	$.ajax({
		url : "/jspweb/MemberinfoController",
		method : "post",
		data : info,
		success : r => {
			console.log(r);
			console.log('통신성공');
		},
		error : e => {
			console.log(e);
			console.log('통신실패');
		}
	})
	// 5. Servlet 의 response에 따른 제어
}
*/



















