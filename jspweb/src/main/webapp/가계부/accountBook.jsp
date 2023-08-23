<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- css import -->
	<link href = "accountBook.css" rel="stylesheet" />

</head>
<body>

	<!-- CRUD 기반의 비회원 게시판/방문록 구현 -->
	<div class="accountBookWrap">	<!-- 전체 구역 -->
			
		<div class="accountBook_Top"><!-- 쓰기 구역 -->
			<textarea class="acontent" placeholder="내용"></textarea>
			<input class="aprice" type="text" placeholder="금액">
			<input class="adate" type="datetime" placeholder="날짜">
			<button onclick="awrite()" type="button">등록</button>
		</div>
		
		<div class="category">
			<h1>내용</h1>
			<h1>가격</h1>
			<h1>일시</h1>
		</div>
		<div class="accountBook_Bottom"><!-- 출력 구역 -->
			<div class="comView">
				<div class="acontentView"> 내용 </div>
				<div class="apriceView"> 금액 </div>
				<div class="adateView"> 일자 </div>
				<div class="abutton">
					<button onclick="aupdate()" type="button">수정</button>
					<button onclick="adelete()" type="button">삭제</button>
				</div>
			</div>
		</div>
	
	</div>

		<!-- 최신 JQUERY 불러오기 : AJAX메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- js import -->
	<script src="accountBook.js" type="text/javascript"></script>
</body>
</html>