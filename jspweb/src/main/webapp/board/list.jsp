<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/board/list.css" rel="stylesheet">
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div class="webcontainer">
		<button onclick="onWrite()" type="button"> 글쓰기 </button>
	</div>
	
	
	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
	
	

	
	<!-- 최신 JQUERY 불러오기 : AJAX메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	


</body>
</html>