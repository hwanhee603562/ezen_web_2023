<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="../css/member.css" rel="stylesheet">

</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div>
		아이디 : <input class="mid" type="text"> 
		비밀번호 : <input class="mpwd" type="password">
		비밀번호 확인 : <input class="mpwdconfirm" type="password">
		이메일 : <input class="memail" type="text">
		이메일 인증코드 : <input class="ecode" type="text">
		프로필 :<input class="mimg" type="file">
		<button onclick="signup()" type="button"> 회원가입 </button>
	</div>
	
	<script src="../js/signup.js" type="text/javascript"></script>
	
</body>
</html>














