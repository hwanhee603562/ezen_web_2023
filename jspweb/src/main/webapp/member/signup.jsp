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
	
	<div> <!-- 회원가입 전체 구역 -->
		<form class="signupForm">	<!-- 폼 전송시 각 input name 속성 -->
			<!-- 아이디 -->
			아이디 : <input onkeyup="idcheck()" name="mid" class="mid" type="text"> 
			<span class="idcheckbox"></span>
			<br/>
			
			<!-- 비밀번호 -->
			비밀번호 : <input onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password"> 
			<br/>
			비밀번호 확인 : <input onkeyup="pwcheck()" class="mpwdconfirm" type="password">
			<span class="pwcheckbox"></span>
			<br/>
			
			<!-- 이메일 -->
			이메일 : <input onkeyup="emailcheck()" name="memail" class="memail" type="text">
			<!-- 이메일 인증요청 버튼 ->  -->
			<button class="authReqBtn" onclick="authReq()" disabled type="button">인증요청</button>
			<span class="emailcheckbox"></span>
			
			<div class="authbox">
				<!-- 인증요청 버튼 클릭시 보이는 구역 -->
				
			</div>
	
			
			<!-- 프로필 -->
				<!--  accept="image/*" = image 확장자만 업로드 가능  -->
				<!--  accept="video/*" = video 확장자만 업로드 가능  -->
			프로필 :<input onchange="preimg( this )" name="mimg" class="mimg" type="file" accept="image/*"><br/>
			<!-- <태그명 이벤트명="함수명( this )" /> --> 
			<img class="preimg" alt="" src="img/default.webp" width="100px">	<!-- 등록 사진을 미리보기할 사진 태그 -->
			<br/>
			<button onclick="signup()" type="button"> 회원가입 </button>
		</form>
	</div>
	
	<script src="../js/signup.js" type="text/javascript"></script>
	
</body>
</html>














