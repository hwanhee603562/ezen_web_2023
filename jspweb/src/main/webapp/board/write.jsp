<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<link href="/jspweb/css/board/write.css" rel="stylesheet">
<body>
	
	<%@include file = "../header.jsp" %>
	
	<div class="webcontainer">
		<h3> 글 쓰기 페이지 </h3>
		<a href="list.jsp"> 목록보기 </a>
		
		<form>	<!-- 쓰기 입력 구역 -->
			카테고리 : 	<select name="bcno" class="bcno">
							<!-- 게시물에 저장되는 카테고리 정보는 카테고리를 x 카테고리명번호 [FK] -->
							<option value="1"> 공지사항 </option>
						</select>
			제목 : <input type="text" name="btitle" class="btitle">
			내용 : <textarea name="bcontent" class="bcontent"></textarea>
			첨부파일 : <input type="file" name="bfile" class="bfile"> 
			<button onclick="write()" type="button"> 글등록 </button>
			<a href="list.jsp"> 목록보기 </a>
			<button type="reset"> 다시쓰기 </button>
		</form>
	</div>
	
	<script src="/jspweb/js/board/write.js" type="text/javascript"></script>

	<!-- 최신 JQUERY 불러오기 : AJAX메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	




</body>
</html>