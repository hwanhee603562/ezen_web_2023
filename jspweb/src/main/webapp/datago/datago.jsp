<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	
	<div class="webcontainer">
		<div>
			<h2> - 카카오지도  - </h2>
			<div class="detailbox">
			
			</div>
			<div id="map" style="width:100%;height:500px;"></div>
		</div>
	
		<h2> 공공데이터 </h2>
		<div>
			<h6> 안산시 착한가격업소 현황 </h6>
			<table class="apiTable1"> 
			</table>
			
		</div>
	</div>
	
	<!-- 카카오 map api -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c51f4ebd6d93bf1f15d0f4ba2809fea5&libraries=clusterer"></script>
	<!-- &libraries=clusterer 	마커클러스터 추가-->
	
	<script src="/jspweb/js/datago/datago.js" type="text/javascript"></script>

</body>
</html>