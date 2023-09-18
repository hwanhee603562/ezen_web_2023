<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>
	<!-- JSP파일 안에 다른 JSP파일 import하기 -->
	<%@include file = "header.jsp"%>

	
	<!-------------------------- 캐러셀(bs) : 이미지 슬라이드 -->
	<div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
	  <div class="carousel-inner">
	    <div class="carousel-item active" data-bs-interval="3000">
	      <img src="/jspweb/img/제네시스1.png" class="d-block w-100" alt="...">
	    </div>
	    <div class="carousel-item" data-bs-interval="3000">
	      <img src="/jspweb/img/제네시스2.png" class="d-block w-100" alt="...">
	    </div>
	    <div class="carousel-item" data-bs-interval="3000">
	      <img src="/jspweb/img/제네시스3.png" class="d-block w-100" alt="...">
	    </div>
	  </div>
	  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Previous</span>
	  </button>
	  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Next</span>
	  </button>
	</div>
	 
	<!-------------------------- 그리디 카드(bs) : 다양한 컨텐츠를 표시하는 컨테이너[구역] -->
	<div class="container">	<!-- container -->
		
		<div class="productBox row row-cols-1 row-cols-md-4 g-4">


		</div>
		
	</div>
	

	

	
	
	<!-- JSP파일 안에 다른 JSP파일 import하기 -->
	<%@include file = "footer.jsp"%>
	
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
	
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

</body>
</html>