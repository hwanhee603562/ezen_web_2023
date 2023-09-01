<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="library.css" rel="stylesheet">
</head>
<body>
	<%@include file = "../header.jsp" %>

   <div class="library_wrap">
      <div class="library_top">
         <div class="seats_table">
            
         </div>
         <div class="input_info">
            이름  <input class="name" type="text"> <br>
            전화번호  <input class="phone" type="text"> <br>
         </div>
      </div>
      <div class="library_bottom">
         <button onclick="checkIn()" type="button">입실</button>
           <button onclick="checkOut()" type="button">퇴실</button>
      </div>
   </div>
   
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script src="library.js" type="text/javascript"></script>
</body>
</html>