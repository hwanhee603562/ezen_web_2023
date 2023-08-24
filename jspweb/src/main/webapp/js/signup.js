
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




















