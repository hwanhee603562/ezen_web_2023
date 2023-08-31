console.log('open');
// 0. 로그인된 회원의 정보
getInfo()
function getInfo(){
	
	$.ajax({
		url: "/jspweb/MemberinfoController",
		method: "get",
		data: { type : "info" },
		success: r => {
			if( r == null ){ 	// 비로그인 상태	-> 페이지 차단
				alert('회원전용 페이지입니다 [로그인]페이지로 이동');
				location.href = "/jspweb/member/login.jsp";
			} else {			// 로그인 상태		-> 마이페이지 구역에 정보 넣어주기
				document.querySelector('.preimg').src = `img/${ r.mimg }`;
				document.querySelector('.mid').innerHTML = r.mid;
				document.querySelector('.memail').innerHTML = r.memail;
			}
		},
		error: e => {
			console.log(e);
		}
	})
	
}

// 1. 수정
function mupdate(){
	// 첨부파일 전송할 때
		// 1. form 가져오기
	let form = document.querySelectorAll('.signupForm')[0];
		// 2. form 데이터 객체화 하기
	let formdata = new FormData( form );
	
	// * form 전송 ajax
	$.ajax({
		url : "/jspweb/MemberinfoController",
		method: "put",
		data: formdata,
		contentType: false,
		processData: false,
		success: r => {
			if(r){
				alert('수정 성공');
				logout();
			} else {
				alert('수정 실패');
			}
		},
		error: e => {}
	})
	
}



// 2. 탈퇴
function mdelete(){
	// 1. 탈퇴여부 확인		confirm() 확인/취소 버튼 알림창
	let dconfirm = confirm('정말 탈퇴하시겠습니까');
	// 2. 확인 버튼을 눌렀을 때
	if( dconfirm == true ){
		let mpwd = prompt('비밀번호 확인');
		// 3. ajax  [ 입력받은 패스워드 전송해서 로그인된 회원의 패스워드 와 입력받은 패스워드가 일치하면 탈퇴]
		$.ajax({
			url: "/jspweb/MemberinfoController",
			method: "delete",
			data: { mpwd : mpwd },
			success: r => {
				if(r){
					alert('회원탈퇴 했습니다');
					logout();
				} else {
					alert('패스워드가 일치하지 않습니다');
				}
			},
			error: e => {
				console.log(e);
			}
		})
	}
	
}


















