<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/product/list.css" rel="stylesheet">
	
	
</head>
<body>

	<!-- JSP파일 안에 다른 JSP파일 import하기 -->
	<%@include file = "../header.jsp"%>
	
	<div class="mapcontent">	<!-- 지도와 사이드바 포함된 구역 -->
		
		<!-- 지도를 표시할 div 입니다 -->
		<div id="map"></div>
		
		<!-- 사이드바 구역 -->
		<div class="sidebar">  </div>
		
	</div>
	
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c51f4ebd6d93bf1f15d0f4ba2809fea5&libraries=clusterer"></script>
	
	
	<script src="/jspweb/js/product/list.js" type="text/javascript"></script>
	
</body>
</html>