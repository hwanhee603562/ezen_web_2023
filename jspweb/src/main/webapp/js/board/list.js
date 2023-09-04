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

// 2. 모든 글 조회 [ js열렸을 때 1회 자동실행 ]
getList();
function getList(){
	arguments
	$.ajax({
		url: "/jspweb/BoardInfoController",
		method:"get",
		data: { type : 1 },
		success: r => {
			
			// 1. 출력할 위치
			let boardTable = document.querySelector('.boardTable');
			
			// 2. 출력할 내용 구성
			let html = `
				<tr>
					<th> 번호 </th>
					<th> 카테고리 </th>
					<th> 제목 </th>
					<th> 작성자 </th>
					<th> 조회수 </th>
					<th> 작성일 </th>
				</tr>
					`
			// 서블릿으로부터 전달받은 내용[배열] 반복해서 html 구성
			// 배열명.forEach
			r.forEach( b => {
				html += `
					<tr>
						<th> ${ b.bno } </th>
						<th> ${ b.bcname } </th>
						<th><a href="/jspweb/board/view.jsp?bno=${ b.bno }"> ${ b.btitle } </a></th>
						<th> ${ b.mid } / <img src="/jspweb/member/img/${b.mimg}" /> </th>
						<th> ${ b.bview } </th>
						<th> ${ b.bdate } </th>
					</tr>
						`
			});
		// 3. 구성된 html 내용 출력
		boardTable.innerHTML = html;

		},
		error: e => {}
	})
}


/*
	QUERY String
		HTTP URL에 매개변수(파라미터) 전달
			- 정의 : 페이지 전환시 매개변수(PK, 식별) 전달
			- 형태
				URL?변수명=데이터
				URL?변수명=데이터?&변수명=데이터
				http://localhost/jspweb/board/view.jsp?bno=3
				href="/jspweb/board/view.jsp?bno${ b.bno }"

			- URL에서 매개변수 호출
				new URL(location.href).searchParams.get('key입력');
				
	
				
				
				
*/

































