
// 제품등록은 회원제이므로 비로그인시 접근 제한
if( loginState == false ){
	alert('로그인 후 사용가능한 페이지')
	location.href = "/jspweb/member/login.jsp"
}


// 6. --------------- 카카오 지도 표시 -------------- //

	// 1. 현재 접속한 클라이언트[브라우저]의 위치 좌표 구하기
navigator.geolocation.getCurrentPosition( e => { 
	
	console.log(e)
	console.log(e.coords.latitude)		// 위도
	console.log(e.coords.longitude)		// 경도
	let currentlat = e.coords.latitude;
	let currentlng = e.coords.longitude;


	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(currentlat, currentlng), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };
	
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	// 지도를 클릭한 위치에 표출할 마커입니다
	var marker = new kakao.maps.Marker({ 
	    // 지도 중심좌표에 마커를 생성합니다 
	    position: map.getCenter() 
	}); 
	// 지도에 마커를 표시합니다
	marker.setMap(map);
	
	// 지도에 클릭 이벤트를 등록합니다
	// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
	kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
	    
	    // 클릭한 위도, 경도 정보를 가져옵니다 
	    var latlng = mouseEvent.latLng; 
	    
	    // 마커 위치를 클릭한 위치로 옮깁니다
	    marker.setPosition(latlng);
	    
	    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
	    message += '경도는 ' + latlng.getLng() + ' 입니다';
	    
	    var resultDiv = document.getElementById('clickLatlng'); 
	    resultDiv.innerHTML = message;
	    
	    plat = latlng.getLat();	// 위도와 경도를 전역변수로 이동 후 제품등록 시 사용
	    plng = latlng.getLng();	// 
	    
	});
});


// 현재 카카오 지도에서 선택한 좌표 [초기값 0]
let plat = 0;
let plng = 0;




// 1. 제품 등록
function onRegister(){
	
	// 1. form dom객체 호출
	let registerForm = document.querySelectorAll('.registerForm')[0];
	console.log(registerForm);
	
	// 2. formData 객체 생성
	let formData = new FormData( registerForm );
	console.log(formData);
	
	// *** 카카오지도에서 선택된 좌표 사용했을 때
	if( plat == 0 || plng == 0 ){
		alert('제품위치를 선택해주세요');
		return;
	}
		// dto와 같이 key 저장
	formData.set( 'plat', plat );
	formData.set( 'plng', plng );
	
	
	// *** 드랍앤드랍을 사용했을 때
		// 현재 드랍된 파일들을 form 같이 추가하기
		// [왜? div는 value 속성이 없다. 즉, 드랍된 파일은 input 태그 드랍된 파일이 아님]
	if( fileList.length >= 1 ){ // 드랍된 파일이 1개 이상, 즉 존재하면
		
		fileList.forEach( f=> {
			formData.append( 'fileList', f );
			// 폼데이터객체.set( '키/필드명/속성명', '값' );		: 기존 데이터 덮어쓰기 
			// 폼데이터객체.append( '키/필드명/속성명', '값' );	: 폼데이터객체에 데이터를 추가
			// 폼데이터객체.delete('키')						: 폼데이터객체 삭제	
			
		});
		
	}
	
	// 3. 
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method: "post",
		data: formData,
		contentType: false,
		processData: false,
		success: result =>{
			
			if( result ){
				alert('제품등록성공')
				location.href = "/jspweb/index.jsp";
			} else {
				alert('제품등록실패')
			}
			
		}
	});
	
	
}


// 2. 드래그 앤 드랍
	// 1. 드래그 앤 드랍할 구역 dom객체 호출
let fileDropBox = document.querySelector('.fileDropBox');

	// 2. button.addEventListener('dragenter', 함수);
		// 드래그해서 해당 식별자 구역(dom객체)으로 들어왔을 때(dragenter 될 때) 함수 실행
fileDropBox.addEventListener("dragenter", e => {
	
	// 상위 이벤트 무시하고 현 이벤트 우선 점유
	e.preventDefault();	
	
	console.log('드래그가 들어왔어');
})


	// 3. 해당 dom객체에 구역내 드래그가 들어왔을 때
fileDropBox.addEventListener("dragover", e => {
	
	// 상위 이벤트 무시하고 현 이벤트 우선 점유
	e.preventDefault();	
	
	console.log('현재구역에 드래그가 위치 중');
	fileDropBox.style.backgroundColor = '#e8e8e8';
})

	// 4. 해당 dom객체에서 구역내 드래그가 나갔을 때
fileDropBox.addEventListener("dragleave", e => {
	
	// 상위 이벤트 무시하고 현 이벤트 우선 점유
	e.preventDefault();	
	
	console.log('드래그가 나갔을 때');
	fileDropBox.style.backgroundColor = '#ffffff';
})

	// 5. 해당 dom객체에서 구역내 드래그를 마쳤을 때(즉, 마우스 클릭을 놓았을 때)
fileDropBox.addEventListener("drop", e => {
	
	console.log(e)
	// * 브라우저 자체적으로 'drop' 이벤트가 우선적으로 실행되므로 해당 이벤트실행 불가
		// ex) 크롬 : 해당 첨부파일 출력		/ 엣지 : 해당 첨부파일 다운로드
	
	// 상위 이벤트 무시하고 현 이벤트 우선 점유
	e.preventDefault();	
		
	// ----------- 드랍된 파일의 정보 ------------ //
		// 1. 드랍된 데이터 정보를 이벤트 결과에서 찾기
			// console.log(e.dataTransfer)
			// console.log(e.dataTransfer.files[0].name)
	
		// 2. 드랍된 파일들을 특정 리스트에 저장
	let files = e.dataTransfer.files;
	
	for( let i=0; i<files.length; i++ ){
		if( files[i] != null & files[i] != undefined ){
			// 드랍된 파일의 정보가 존재하면 [null 과 undefined 이 아닌 상태]
			fileList.push( files[i] );
		}
	}
	
	// 3. 배경색 초기화(흰색)
	fileDropBox.style.backgroundColor = '#ffffff';
	
	// 4. 현재 드랍된 파일의 정보를 드래그앤드랍 구역에 표시
	fileListPrint();
})

let fileList = [];	// 현재 드래그앤 드랍으로 등록된 파일들

// 3. 현재 드랍된 파일들의 정보를 구역에 표시하는 함수
function fileListPrint(){
	// 1. [어디에] fileDropBox 에 [ fileDropBox dom 객체가 함수 밖에 존재하므로 재호출x ]
	
	// 2. [무엇을] HTML 구성
	let html = ``;
	
		// forEach( 반복변수, 인덱스 )
	fileList.forEach( (f, i) => {
		let fname = f.name;	// 파일명
		let fsize = (f.size/1024).toFixed;	// 파일용량 [ 바이트 단위 ]	kb 변환
		 			// .toFixed(소수점단위) : 소수점 자르기
		html +=
				`<div>
					<span> ${fname} </span>
					<span> ${fsize} </span>
					<span> <button onclick="fileDelete(${i})" type="button"> 삭제 </button> </span>
				</div>`
				
		console.log('파일명 혹은 경로 확인')
		console.log(fname)
	})
	
	// 3. [대입] 
	fileDropBox.innerHTML = html;
}

// 4. 현재 드랍된 파일들 중에 삭제버튼 클릭시 해당 파일 제거
function fileDelete(i){
	
	// 리스트에서 해당 인덱스부터 1개 까지 제거
	fileList.splice(i, 1);
	
	// 새로고침
	fileListPrint()
}


/*

	dom객체 이벤트 추가하는 방법 2가지
		가정 : 특정 구역에 클릭(onclick) 이벤트 추가
		1. HTML 속성 이벤트 사용하는 방법
			<button onclick="" type="button"></button>
		
		2. .addEventListener('이벤트명', 실행함수) 사용하는 방법
			let fileDropBox = document.querySelector('button');
			button.addEventListener('onclick', 함수);
			
		이벤트
			- 종류 	: onclick, keyup, keydown, drag 등등
			- 정의 	: 특정 조건(자동)을 충족하면 발생하고 발생한 이벤트의 결과물을 반환하는 구조
			
			
			
			

	드래그 앤 드랍 관련 이벤트
		1. dragenter
		2. dragover
		3. dragleave
		4. drop
	
	
	
*/


































