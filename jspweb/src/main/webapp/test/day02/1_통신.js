function 예제1(){

	$.ajax({
		url : "/jspweb/Test2"  ,    // 1. 통신할 경로
		method : "get",        						// 2. 통신할 HTTP 메소드 방식 
		success : function 함수명(result){ console.log(result) }   // 3. 통신을 성공했을때 반환된 데이터
   });
}

function 예제2(){

	$.ajax({
		url : "/jspweb/Test03"  ,   // 1. 통신할 경로
		method : "get",        						// 2. 통신할 HTTP 메소드 방식 
		success : function 함수명(result){ console.log(result) }   // 3. 통신을 성공했을때 반환된 데이터
   });
}

function 예제3(){

	$.ajax({
		url : "/jspweb/Test04"  ,   // 1. 통신할 경로
		method : "get",        						// 2. 통신할 HTTP 메소드 방식 
		success : function 함수명(result){ console.log(result) }   // 3. 통신을 성공했을때 반환된 데이터
   });
}

function 예제4(){

	$.ajax({
		url : "/jspweb/Test05"  ,   // 1. 통신할 경로
		method : "get",        						// 2. 통신할 HTTP 메소드 방식 
		success : function 함수명(result){ console.log(result) }   // 3. 통신을 성공했을때 반환된 데이터
   });
}




/*
	$.ajax({
		url : "통신할경로/서블릿주소"  ,
		method : "통신할 HTTP 메소드 방식 ",      
		success : ( 통신을 성공했을때 반환된 데이터 ) => { 통신성공했을 때 실행코드 }

	})



	- 1. success 속성에서 반환함수 작성시
		1. success : function 함수명( 통신반환함수 ) { 통신성공했을 때 실행코드 }
		2. success : function ( 통신반환함수 ) { 통신성공했을 때 실행코드 }
		3. success : ( 통신반환함수 ) => { 통신성공했을 때 실행코드 }
	
	
*/ 