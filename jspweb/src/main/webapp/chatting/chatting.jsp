<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/chatting/chatting.css" rel="stylesheet">

</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div class="webcontainer">
	
		<!-- 채팅전체구역 -->
		<div class="chatbox">  
			
			<!-- 채팅내용 목록 -->
			<div class="chatcont"> 
			
				<!-- JS HTML 대입되는 자리 -->

				
				
				
				
			</div>
		
			<!-- 채팅입력창, 전송버튼 -->
			<div class="chatbottom">  
				<textarea class="msg">  </textarea>
				<button onclick="onSend()" type="button"> 전송 </button>
			</div>
		
		</div>
	</div>
	
	<script src="/jspweb/js/chatting/chatting.js" type="text/javascript"></script>

</body>
</html>


