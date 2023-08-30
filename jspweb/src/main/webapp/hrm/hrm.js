// 직원 등록
function uploadInfo(){
	
	let uploadForm = document.querySelectorAll('.uploadForm')[0];
	let uploadData = new FormData( uploadForm );
	
	$.ajax({
		url : "/jspweb/HrmController",
		method : "post",		// 첨부파일 form 전송은 무조건 post 방식
		data : uploadData,		// FormData 객체를 전송
		contentType : false,	// form 객체 타입
		processData : false,
		success : r => {
				
			if(r){ // 파일첨부 성공
				alert('직원등록 성공');
				hread();
			} else { // 파일첨부 실패
				alert('직원등록 실패');
			}
		},
		error : e => {
			alert('실패] 기 등록된 전화번호입니다');
		}
	})
}
// 첨부한 이미지 미리보기
function hpreimg( object ){
	console.log('사진 선택 변경');
	console.log( object );
	console.log( document.querySelector('.himg') );

	console.log( object.files );
	console.log( object.files[0] );	
	

	let file = new FileReader();	
	
	// 3. 파일 읽어오기 함수 제공
		// input에 등록된 파일리스트 붕 1개를 파일객체로 읽어오기
	file.readAsDataURL( object.files[0] );	
	console.log( file );
	
	// 4. 읽어온 파일을 해당 html img태그에 load
	file.onload = e => {
		console.log(e);		// onload() 실행한 FileReader 객체
		console.log( e.target.result );	// 읽어온 파일의 바이트코드
		document.querySelector('.hpreimg').src = e.target.result;	// img src 속성에 대입
	}
}
// 직원 리스트 출력
hread();		
function hread(){
	// JS가 실행될 때 1번 실행
	// 등록 성공, 수정 성공, 삭제 성공 시 실행
	
	
	$.ajax({
		url : "/jspweb/HrmController",
		method : "get",
		data : "",
		success : function f(r){
			console.log(r);
			

				let output = document.querySelector('.hrmList'); 

				let html = `<th> 직원번호 </th>
							<th> 직원사진 </th>
							<th> 이름 </th>
							<th> 전화번호 </th>
							<th> 직급 </th>
							<th> 등록일 </th>`;

			for(let i=0; i<r.length; i++){
				// 객체를 HTML형식으로 누적 더하기
				html += `
					<tr>
						<td>${r[i].hno}</td>
						<td><img class="box_himg" src="/jspweb/hrm/img/${r[i].himg}"></td>
						<td>${r[i].hname}</td>
						<td>${r[i].hphone}</td>
						<td>${r[i].hrank}</td>
						<td>${r[i].hdate}</td>
					</tr>`
			}
				
			// 3. [대입] 출력객체 HTML형식 대입
			output.innerHTML = html;
		},
		error : function f(r){}
	})
}


