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
   <div class="library_wrap">
      <div class="library_top">
         <div class="seats_table">
            <button class="seat seats_i">1</button> <button class="seat seats">2</button>
            <button class="seats">3</button> <button class="seat seats_i">4</button> 
            <button class="seats_i">5</button> <button class="seats">6</button>
            <button class="seats">7</button> <button class="seats">8</button>
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