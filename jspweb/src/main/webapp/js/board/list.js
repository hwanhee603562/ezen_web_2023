console.log('js open')

function onWrite(){
	
	if( loginState ){
		location.href="/jspweb/board/write.jsp";
	} else {
		alert('로그인 후 글쓰기가 가능합니다');
		location.href="/jspweb/member/login.jsp";
	}
	
	// - 만일 비 로그인이면 로그인 페이지로 이동
	// - 로그인이면 쓰기 페이지로 이동
	
	
}