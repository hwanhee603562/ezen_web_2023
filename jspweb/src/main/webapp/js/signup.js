
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
			
			예시]
				1. [a-z]			: 소문자 A-Z 패턴
				2. [a-zA-Z]			: 영문(대,소) 패턴
				3. [a-zA-Z0-9]		: 영문 + 숫자 조합 패턴
				4. [a-zA-Z0-9가-힣]	: 영문 + 숫자 + 한글 조합 패턴
				5. [ac]				: a와c 패턴
				
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
				data : { mid : mid },
				success : r => {
					console.log('통신성공');
					if( r ){
						idcheckbox.innerHTML = '사용 중인 아이디 입니다';
					} else {
						idcheckbox.innerHTML = '사용가능한 아이디 입니다';
					}
					
				},
				error : r => {
					console.log(r);
				}
			})
			
		} else {	// 실패
			document.querySelector('.idcheckbox').innerHTML = '영문(소문자)+숫자 조합의 5~30글자 가능합니다';
		}
		
		
	// 3. 결과 출력
	
	
	
}


// 1. 회원가입 메소드
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




















