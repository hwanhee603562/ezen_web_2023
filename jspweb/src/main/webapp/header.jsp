<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/header.css" rel="stylesheet">
</head>
<body>

	<!-- 헤더 -->
	<div id="header">
		
		<div class="mainlogo"><!-- 로고 -->
			<a href="/jspweb/index.jsp">
				<img alt="" src="/jspweb/img/ezenlogo.png">
			</a>
		</div>
		
		<ul class="mainmenu">	<!-- 본메뉴 -->
			<li> <a href="http://192.168.17.17/jspweb/visitlog/visitlog.jsp"> 방문록 </a> </li>
			<li> <a href="/jspweb/board/list.jsp"> 게시판 </a> </li>
			<li> <a href="/jspweb/datago/datago.jsp"> 공공데이터 </a> </li>
			<li> <a href="/jspweb/chatting/chatting.jsp"> 채팅 </a> </li>
			<li> <a href="/jspweb/product/register.jsp"> 제품등록 </a> </li>
			<li> <a href="/jspweb/product/list.jsp"> 제품찾기 </a> </li>
			<li> <a href="/jspweb/가계부/accountBook.jsp"> (과1):가계부 </a> </li>
			<li> <a href="/jspweb/library/library.jsp"> (과2):도서관열람실 </a> </li>
			<li> <a href="/jspweb/hrm/hrm.jsp"> (과3):직원관리 </a> </li>
		</ul>
		
		
		<ul class="submenu">	<!-- 서브메뉴 : 로그인했을 때와 안했을 때 -->
		</ul>
		
	</div>	<!-- 헤더 end -->

	<!-- 최신 JQUERY 불러오기 : AJAX메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script src="/jspweb/js/header.js" type="text/javascript"></script>
	
</body>
</html>

<!-- 

	헤더는 많은 페이지에서 참조하는 페이지이므로 공통적인 코드
	1. 라이브러리 : <script src="http://code.jquery.com/jquery-latest.min.js"></script>
	2. 

 -->

<!--

	상대경로 : 현 위치 기준 경로 작성
	절대경로 : 모든 경로 작성
		http://192.168.17.17/jspweb/visitlog/visitlog.jsp
		- 헤더파일은 불특정 페이지 경로에서 사용되므로 절대경로 링크 권장
		(생략가능) http://192.168.17.17

  -->





















