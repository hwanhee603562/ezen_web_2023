<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<%@include file = "../header.jsp"%>
	
	<div class="webcontainer">
		<form class="registerForm">
			카테고리 : <select name="pcno">
						<option value="1"> 컴퓨터 </option>
						<option value="2"> 태블릿 </option>
						<option value="3"> 냉장고 </option>
					</select><br>
			제품명 : <input name="pname" type="text"><br>
			제품설명 : <textarea name="pcontent" rows="" cols=""></textarea><br>
			제품가격 : <input name="pprice" type="number"><br>
			
			제품장소 : 	<div id="map" style="width:300px;height:350px;"></div>
						<p><em>지도를 클릭해주세요!</em></p> 
						<div id="clickLatlng"></div>
			
			
			
			
			
			
			
			
			
			<!-- 1. 첨부파일 1개일 때 -->
				<!-- 제품이미지 : <input name="pimg" type="file" multiple="multiple"> <br> -->
			
			<!-- 2. 첨부파일 여러개일 때 multiple 속성 사용 -- multiple사용 시 여러 개 파일명 호출 불가능 -->
			<!-- 제품이미지 : <input name="pimg" type="file" multiple="multiple"> <br> -->
				<!-- 2. cos.jar 첨부파일 여러 개일 때 -->
			
			<!-- 3. 드래그앤드랍 cos.jar 와 commons.jar 기능 -->
			<div class="fileDropBox" style="width: 300px; height: 100px; border: 1px solid red;">
				여기에 드래그해서 파일을 올려주세요
				
				
				
			</div>
			
			<button onclick="onRegister()" type="button"> 등록 </button>
		</form>
	</div>
	
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c51f4ebd6d93bf1f15d0f4ba2809fea5"></script>
	
	<script src="/jspweb/js/product/register.js" type="text/javascript"></script>
	
	
</body>
</html>