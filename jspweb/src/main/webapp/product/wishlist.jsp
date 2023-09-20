<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 부트스트랩에서 만든 CSS 적용 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

	<link href="/jspweb/css/product/wishlist.css" rel="stylesheet">

</head>
<body>

	<!-- JSP파일 안에 다른 JSP파일 import하기 -->
	<%@include file = "../header.jsp"%>

	<div class="container"> <!-- bs : container 디바이스 크기에 따른 반응형 구역 -->
		
		
		<h3> 찜 목록 현황 </h3>
		<table class="table table-hover text-center align-middle"> <!-- table -->


		</table>
		
		<div class="selectbtn">
			<button type="button"> 선택 삭제 </button>
			<button type="button"> 전체 삭제 </button>
		</div>
		
		<div class="buybtn">
			<button type="button"> 선택 구매 </button>
			<button type="button"> 전체 구매 </button>
		</div>
		
	</div>
	





	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

	<script src="/jspweb/js/product/wishlist.js" type="text/javascript"></script>
</body>
</html>