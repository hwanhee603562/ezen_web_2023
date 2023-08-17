<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h6> 1. [응답 : 문자타입] 외부 링크[ 자바(서블렛) ]에 데이터 통신 </h6>
	<button onclick="예제1()" type="button"> 예제1 </button>

	<h6> 2. [응답 : 한글인코딩] JS에서 servlet[자바웹클래스] 에게 통신하고 데이터 변환 받기 </h6>
	<button onclick="예제2()" type="button"> 예제2 </button>
	
	<h6> 3. [응답 : JSON타입/한글인코딩] JS에서 servlet[자바웹클래스] 에게 통신하고 데이터 변환 받기 </h6>
	<button onclick="예제3()" type="button"> 예제3 </button>
	
	<h6> 4. [응답 : JSON타입[JACKSON타입]] JS에서 servlet[자바웹클래스] 에게 통신하고 데이터 변환 받기 </h6>
	<button onclick="예제4()" type="button"> 예제4 </button>

	<!-- 최신 JQUERY 불러오기 : AJAX메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>


	<!-- JS파일 불러오기 -->
	<script src="1_통신.js" type="text/javascript"></script>

</body>
</html>