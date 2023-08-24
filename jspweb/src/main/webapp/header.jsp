<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 헤더 -->
	<div>
		<ul>
			<li> <a href="/jspweb/index.jsp"> 홈으로 </a> </li>
			<!-- 절대경로 사용 -->
			<li> <a href="http://192.168.17.17/jspweb/visitlog/visitlog.jsp"> 방문록 </a> </li>
			<!-- 상대경로 사용 -->
			<li> <a href="/jspweb/가계부/accountBook.jsp"> 가계부 </a> </li>
			<li> <a href="/jspweb/member/signup.jsp"> 회원가입 </a> </li>
		</ul>
	</div>

	<!-- 최신 JQUERY 불러오기 : AJAX메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	
	
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





















