<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="../hrm/hrm.css" rel="stylesheet">

</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<!-- 전체구역 -->
	<div id="hwrap">
		<!-- 상단 직원정보 입력 구역 -->
		<form class="uploadForm">
			<div class="topInput">
				<!-- 직원사진 첨부 -->
				<div class="hintitle">직원사진</div>
				<input onchange="hpreimg( this )" name="himg" class="himg" type="file" accept="image/*"><br/>
				<img class="hpreimg" alt="" src="img/default.webp">
				
				<div class="hintitle">이름</div>
				<input maxlength="30" name="hname" class="hname" type="text"> 
				
				<div class="hintitle">전화번호</div>
				<input maxlength="30" name="hphone" class="hphone" type="text"> 
				
				<div class="hintitle">직급</div>
				<select name="hrank" class="hrank">
					<option value="사장">사장</option>
					<option value="부장">부장</option>
					<option value="팀장">팀장</option>
					<option value="대리">대리</option>
					<option value="주임">주임</option>
					<option value="사원">사원</option>
				</select>
				<button onclick="uploadInfo()"> 직원등록 </button>
			</div>
		</form>

		
		<!-- 하단 직원정보 출력 구역 -->
		<div class="bottomInfo">
			<table class="hrmList" border ="1">
				<th> 직원번호 </th>
				<th> 직원사진 </th>
				<th> 이름 </th>
				<th> 전화번호 </th>
				<th> 직급 </th>
				<th> 등록일 </th>
			</table>
		</div>
		

		
	</div><!-- 전체구역 end -->
	
	
	
	
	<script src="../hrm/hrm.js" type="text/javascript"></script>

</body>
</html>