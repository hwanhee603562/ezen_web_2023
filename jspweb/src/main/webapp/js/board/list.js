
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



/* 게시물 조회 조건 객체 */
let pageObject = { type : 1, bcno : 0, listsize : 10, page : 1 }
	// * type : (1:전체조회, 2:개별조회)
	// * bcno : 조회할 카테고리 번호 [ 기본값은 전체보기 0 ]
	// * listsize : 하나의 페이지에 최대표시할 게심루수 [ 기본값은 10개 ]

// 3. 카테고리 버튼을 클릭했을 때
function onCategory( bcno ){
	pageObject.bcno = bcno;	// 조회조건 객체 내 카테고리번호를 변경
	getList(1);				// 조건이 변경되었기 때문에 다시 출력 [ 재랜더링/새로고침 ]
}
// 4. 한 페이지 최대 표시할 개수를 변경했을 때
function onlistSize(){
	// 선택된 게시물 수를 조회조건 객체 저장
	pageObject.listsize = document.querySelector('.listsize').value;
	getList(1);	// 기본 페이지 번호 1
}



// 2. 모든 글 조회 [ js열렸을 때 1회 자동실행 ]
	// 페이지번호 클릭
getList(1);	// 기본 페이지 번호 1
function getList( page ){	
	// page : 조회할 페이지 번호

	//-------------------------1. 게시물 출력
	pageObject.page = page;
	// 클릭된 페이지번호를 조건객체에 대입
	
	$.ajax({
		url: "/jspweb/BoardInfoController",
		method:"get",
		data: pageObject,
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
			r.boardList.forEach( b => {
				html += `
					<tr>
						<td> ${ b.bno } </td>
						<td> ${ b.bcname } </td>
						<td><a href="/jspweb/board/view.jsp?bno=${ b.bno }"> ${ b.btitle } </a></td>
						<td> 
							${ b.mid }
							<img src="/jspweb/member/img/${b.mimg}" /> 
						</td>
						<td> ${ b.bview } </td>
						<td> ${ b.bdate } </td>
					</tr>
						`
			});
			// 3. 구성된 html 내용 출력
			boardTable.innerHTML = html;
			
			// -------------------- 2. 페이지 번호 출력
			
			html = ``;
			
			// 페이지 개수만큼 페이징번호 구성
				// A 이전버튼
				// 이전 버튼 [ page <= 1 ? page : page-1 : 만약에 1페이지에서 이전 버튼 클릭시 1페이지로 고정 하고 아니면 1차감 ]
			html += `<button onclick="getList(${page-1})" type="button"> < </button>	<!-- 이전버튼 -->`;
	
				// B 페이지번호 버튼 [ * 페이지 개수만큼 반복 ]
			for( let i=1; i<=r.totalpage; i++ ){
				// 만일 현재페이지(page)와 i가 같으면 페이지와 일치하면 버튼태그에 class="selectpage"
				html += `<button class="${ page == i ? 'selectpage' : '' }" onclick="getList(${i})" type="button"> ${i} </button>`
			}
	
				// C 다음버튼		
			html += `<button onclick="getList(${page >= r.totalpage ? page : page+1})" type="button"> > </button>`;
			
			
			
			// pagebox 구역에 구성된 html
			document.querySelector('.pagebox').innerHTML = html;
			
			// ----------------- 3. 게시물 수 출력
			let boardcount = document.querySelector('.boardcount');
			
			boardcount.innerHTML = `총게시물 수 : ${ r.totalsize }`;
			
			

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

































