console.log( 'visitlog.js 열림' );

// 1. create ( 저장 )
function vwrite(){
	console.log('저장실행');
	// 1. input 태그 호출
	let vwriterInput = document.querySelector('.vwriter');
	console.log('vwriterInput'+vwriterInput);
	let vpwdInput = document.querySelector('.vpwd');
	console.log('vpwdInput'+vpwdInput);
	let vcontentInput = document.querySelector('.vcontent');
	console.log('vcontentInput'+vcontentInput);
	
	
	// 2. 객체화
		// let 변수명 = { 속성명 : 데이터, 속성명 : 데이터 }
	let info = {
		vwriter : vwriterInput.value ,
		vpwd : vpwdInput.value ,
		vcontent : vcontentInput.value ,
	}; console.log( info );
	
	// 3. 유효성 검사
	
	// 4. AJAX ( HTML에 JQUERY 라이브러리 필수로 호출)
		
	$.ajax({
		url : "/jspweb/visitlogController",
		method : "post",
		data : info,
		success : function f(r){
			console.log('통신성공');
			if(r == true){
				alert('등록성공');	
				vread();
				// 등록 성공시 HTML에서 작성한 INPUT 내용을 공백으로 채움
				vwriterInput.value = '';
				vpwdInput.value = '';
				vcontentInput.value = '';
			} else {
				alert('등록실패');
			}
		},
		error : function f(r){
			console.log('통신실패');
		}
	});
}

// 2. read ( 호출 )
	
vread();		
function vread(){
	// JS가 실행될 때 1번 실행
	// 등록 성공, 수정 성공, 삭제 성공 시 실행
	
	
	$.ajax({
		url : "/jspweb/visitlogController",
		method : "get",
		data : "",
		success : function f(r){
			console.log(r);
			
			// - 응답 받은 객체를 HTML에 출력
				// 1. [어디에] 출력할 구역의 객체 호출
				let output = document.querySelector('.visit_Bottom'); 
				// 2. [무엇을] 반복문 이용한 데이터를 HTML 형식으로 만들기
				let html = ``;
				
					// 리스트내 모든 데이터를 출력
					for(let i=0; i<r.length; i++){
						// 객체를 HTML형식으로 누적 더하기
						html += `
							<div class="visitbox">	<!-- 방문록 1개의 표시구역 -->
								<div class="visitbox_top">
									<div> ${ r[i].vwriter} </div>
									<div class="visitdate"> ${ r[i].vdate } </div>
								</div>
								<div class="visitbox_center"> ${ r[i].vcontent } </div>
								<div class="visitbox_bottom">
									<button onclick="vupdate( ${ r[i].vno } )" type="button">수정</button>
									<button onclick="vdelete( ${ r[i].vno } )" type="button">삭제</button>
								</div>
							</div>`
					}
				
				// 3. [대입] 출력객체 HTML형식 대입
				output.innerHTML = html;

		},
		error : function f(r){}
		
		
		
	})
}

// 3. update ( 수정 )
function vupdate( vno ){
	console.log('vupdate() open : '+vno);
	
	// 1. 수정할 내용 입력
	let vcontent = prompt('수정할 방문록내용 : ')
	// 2. 비밀번호가 일치할 경우에도 수정하므로 확인용 비밀번호 입력받기
	let vpwd = prompt('방문록비밀번호 : ')
	
	// 수정 준비물 : vno(누구를), vcontent(어떤 내용으로), vpwd(조건용 : 비밀번호일치여부)
	$.ajax({
		url : "/jspweb/visitlogController",
		method : "put",
		data : { vno : vno, vcontent : vcontent, vpwd : vpwd },
		success : function f(r){
			console.log('update통신성공');
			if(r == true){
				alert('수정성공');
				vread();
			} else {
				alert('수정실패] 비밀번호가 일지하지 않습니다');
			}
		},
		error : function f(r){
			console.log(r);
		}
	})
	
	
}

// 4. delete ( 삭제 )
function vdelete( vno ){
	console.log('vdelete() open : '+vno);
	
	// 1. 비밀번호가 일치할 경우에 수정하므로 확인용 비밀번호 입력받기
	let vpwd = prompt('방문록비밀번호 : ')
	
	// 삭제 준비물 : vno(누구를), vpwd(조건용 : 비밀번호일치여부)
	
	$.ajax({
		url : "/jspweb/visitlogController",
		method : "delete",
		data : {vno : vno, vpwd : vpwd},
		success : function f(r){
			console.log('delete통신성공');
			if(r == true){
				alert('수정성공');
				vread();
			} else {
				alert('수정실패] 비밀번호가 일지하지 않습니다');
			}
		},
		error : function f(r){
			console.log(r);
		}
	})
	
	
}

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 