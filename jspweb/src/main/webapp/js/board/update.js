// 2. 쿼리스트링(URL 주소상의 변수) 의 변수 가져오기
	// 쿼리스트링 : URL?변수명=값&변수명=값
	// new URL(location.href).searchParams.get("변수명"")
let bno = new URL(location.href).searchParams.get("bno");

// 1. 수정 전 수정할 게시물의 현재 저장된 정보를 보여주기
getBoard();
function getBoard(){

	// 3. ajax에게 bno 전달해서 게시물 정보 가져오기
	$.ajax({
		url : "/jspweb/BoardInfoController",
		method : "get",
		data : { type : 2, bno : bno },
		success : r => {

			// 응답 결과를 html 대입
			document.querySelector('.bcno').value = `${r.bcno}`
			document.querySelector('.btitle').value = `${r.btitle}`
			document.querySelector('.bcontent').value = `${r.bcontent}`
			document.querySelector('.oldfile').value = `${r.bfile}`
		},
		error : e => {
			console.log('실패')
		}
	})
}

// 2. 수정하기
function onUpdate(){
	
	// 1. 입력된(수정된) form 정보 한 번에 가져오기
		// 1-1. form 가져오기
	let writeForm = document.querySelectorAll('.writeForm')[0];
		// 1-2. form 객체화
	let formData = new FormData( writeForm );
		// 1-3. form 겍체에 데이터 속성 추가 [ bno ]
			// .set( 속성명, 값 );	// form에 데이터 속성 추가
	formData.set( "bno", bno );

	// 2. ajax 대용량(첨부파일) multipart
	$.ajax({
		url : "/jspweb/BoardInfoController",
		method : "put",
		data : formData,
		contentType : false,
		processData : false,
		success : r => {
			if(r){
				alert('수정성공');
				location.href = `/jspweb/board/view.jsp?bno=${bno}`
			} else {
				alert('수정실패');
			}
		},
		error : e => {
			console.log('수정실패')
		}
	})
	
}

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 