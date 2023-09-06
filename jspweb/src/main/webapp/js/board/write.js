/* 썸머노트 실행 */
$(document).ready(function() {

	let option = { // 썸머노트 옵션관련 객체 만들기 
		lang : 'ko-KR' , 
		height : 500 , 
		placeholder : '여기에 내용작성'
	}
   
	$('#summernote').summernote( option );
  
});


function bwrite(){
	
	// 1. form 가져오기
		// querySelectorALL()	: 배열타입으로 여러 DOM객체
		// querySelector()		: 객체타입으로 한 개 DOM객체
	let form = document.querySelectorAll('.writeForm')[0];
	
	// 2. form 객체화 하기
	let formData = new FormData( form );
	
	
	// 3. .ajax 로 대용량 form 전송하기
	$.ajax({
		url: "/jspweb/BoardInfoController",
		method: "post",
		data: formData,
		contentType: false,
		processData: false,
		success: r => {
			
			if(r){
				alert('글쓰기 성공');
				location.href = "/jspweb/board/list.jsp";	
			} else {
				alert('글쓰기 실패');
			}
			
		},
		error: e => {
			alert('글쓰기 실패 [관리자 문의]');
		}
		
	})
	
}











