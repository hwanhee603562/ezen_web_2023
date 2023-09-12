<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/chatting/chatting.css" rel="stylesheet">
	
	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	
	<!-- 폰트어썸 css -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
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
				<textarea onkeyup="onEnterKey()" class="msg"></textarea>
				<button onclick="onSend()" type="button"> 전송 </button>
			</div>
			
			<!-- 이모티콘, 첨부파일 등 구매 -->
			<div class="dropdown">
				<button class="emobtn" type="button" data-bs-toggle="dropdown">
					<i class="far fa-grin-squint"></i>	<!-- 폰트어썸 -->
				</button>
				<ul class="dropdown-menu emolistbox">
					
				</ul>
			</div>
			
		
		</div>
	</div>
	
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	    
	<script src="/jspweb/js/chatting/chatting.js" type="text/javascript"></script>
	
	
</body>
</html>


