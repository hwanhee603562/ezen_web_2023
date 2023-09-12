
	/*
		ajax는 기본적으로 '비동기화'방식이므로 로그인을 하였음에도 채팅방 입장이 불가할 수 있음
		즉, loginState가 변경되기 전에 실행될 수 있으므로 문제 발생
			=> 해결방안) ajax 동기화 통신
				getMemberInfo() 메서드의 ajax 동기화로 변경
	*/
	
// 1. 비로그인시 입장 불가능 [ 세션 이용 ]
if( loginState == false ){
	alert('회원전용 페이지입니다.');
	location.href = "/jspweb/member/login.jsp";
}


console.log('채팅방에 입장한 아이디 : '+loginMid);

// 2. JS 클라이언트[유저] 소켓 만들기
let clientSocket = new WebSocket(`ws://192.168.17.17:80/jspweb/serversocket/${loginMid}`);

	// - 클라이언트소켓이 생성되었을 때 자동으로 서버소켓에 접속		----> @OnOpen
	// - 서버소켓 url에 매개변수 전달하기 [ - 주로 식별자 전달 ] 서버소켓URL/데이터1/데이터2/데이터3


//================ JS 소켓 메소드===========
	// ServerSocket 자바 클래스와 비교

		// 1. (자동실행) 클라이언트 소켓이 정상적으로 서버소켓에 접속했을 때
clientSocket.onopen = e => {
	
	console.log('서버와 접속 성공 : '+e);
	// 1-2 : 만약에 접속을 성공하면 알림 메시지 전송
	let msg = { type : 'alarm', content : `${loginMid}님이 입장했습니다` }
	clientSocket.send( msg );	
	// 문제발생 : 해당 메시지를 받는 JAVA는 JSON타입을 로르기에 문자열 타입으로 전송
	clientSocket.send( JSON.stringify( msg ) )
	
	
};
		// 2. (자동실행) 클라이언트 소켓이 서버소켓과 연결에서 오류가 발생했을 때
clientSocket.onerror = e => {
	console.log('서버와 오류발생 : '+e);
};
		// 3. (자동실행) 클라이언트 소켓이 서버소켓과 연결이 끊겼을 때
clientSocket.onclose = e => {
	console.log('연결 끊김 : '+e);
};
		// 4. (자동실행) 클라이언트 소켓이 메시지를 받았을 때
clientSocket.onmessage = e => onMsg(e);
		// 보내기x
		
//========================================


// 3. 서버에게 메시지 전송
function onSend(){
	// 3-1 textarea 입력값 호출
	let msaValue = document.querySelector('.msg').value;
	if( msaValue == '' || msaValue == '\n' ){
		document.querySelector('.msg').value = ``;
		alert('내용을 입력해주세요');
		return;
	}
	// 3-2 메시지 전송
	let msg = { type : 'message', content : msaValue }
	
	clientSocket.send( JSON.stringify( msg ) );
	// 클라이언트 소켓과 연결된 서버소켓에게 메시지 전송 ----> 서버소켓의 @OnMessage 으로 이동 
	
	// 3-3 메시지 전송 성공시 입력상자 초기화
	document.querySelector('.msg').value = ``;
}

// 4. 메시지를 받았을 때 추후 행동(메소드) 선언
function onMsg( e ){
	console.log(e);			// e : 메시지 받았을 때 발생한 이벤트 정보가 들어있는 객체
	console.log(e.data);	// .data 속성에 전달 받은 메시지 내용
	
	let msgBox = JSON.parse(e.data);
		// JSON.parse()		: 문자열타입의 json형식을 json타입으로 변환
		// JSON.Stringify()	: JSON타입을 문자열 타입 (JSON형식 유지)으로 변환
	
	
	// 1. 특정 문자열 찾아서 1개 치환/바꾸기/교체 
	let content = msgBox.msg.replace( '\n' , '<br>' );	// replace( '변경할문자열|정규표현식' , '새로운문자' );
	// 2. 특정 문자열 찾아서 찾은 문자열 모두 치환/바꾸기/교체 => java : .replaceAll();   js : 정규표현식 
	content  = msgBox.msg.replace( /\n/g , '<br>');	// /g : 동일한 패턴의 모든 문자찾기[전체]

	msgBox.msg	= JSON.parse( content ); // 치환하고 대입.


	// 1. 어디에 출력할건지
	let chatcont = document.querySelector('.chatcont');
	
	let html = ''
	// 2. 무엇을
	
	// 2-1 만약에 알람 메시지 이면
	if( msgBox.msg.type == 'alarm' ){
		html = `${typeHTML( msgBox.msg )}`
	}
	// 2-2 만약에 내가 보냈으면
	else if( msgBox.frommid == loginMid ){
		
		html = `
			<!-- 보냈을 때 메시지 [오른쪽] -->
			<div class="rcont">
				<div class="subcont"> 
					<div class="date"> ${msgBox.date} </div>
					${ typeHTML( msgBox.msg ) }
				 </div>
			</div>
		`;
		
	}
	// 2-3 내가 보내지 않았으면
	else {	
		html = `
			<!-- 받았을 때 메시지 [왼쪽] -->
			<div class="lcont"> 
				<img class="pimg" src="/jspweb/member/img/${msgBox.frommimg}">
				<div>
					<div class="name"> ${msgBox.frommid} </div>		<!-- 보낸 사람 -->
					<div class="subcont">
						${ typeHTML( msgBox.msg ) }		<!-- 보낸 내용 -->
						<div class="date"> ${msgBox.date} </div>		<!-- 보낸 시간 -->
					</div>
				</div>
			</div>
		`;
		
	}
	

	
	

	// 3. 누적 대입 [기존 채팅에 이어서 추가 +=]
	chatcont.innerHTML += html;
	
	/*
	// ============== 스크롤 최하단으로 내리기 [ 스크롤 이벤트 ]
	// 1. 현재 스크롤의 상단 위치 좌표
	let topHeight = chatcont.scrollTop;			// dom객체.scrollTop		: 해당 div에서 스크롤을 상단위치
	console.log(topHeight)
	// 2. 현재 dom객체의 전체 높이
	let scrollHeight = chatcont.scrollHeight	// dom객체.scrollHeight	: 해당 div에
	console.log(scrollHeight)
	*/
	
	// 3. 전체 높이 값을 현재 스크롤 상단 위치에 대입
	chatcont.scrollTop = chatcont.scrollHeight;
	
}

// 5. textarea 입력창에서 입력할 때마다 이벤트 발생 함수
function onEnterKey(){
	
	// 1. 만약에 ctrl + 엔터 이면 줄바꿈
		// 조합키 : 한번에 두 개 이상 입력 가능한 키
		// 조합키를 사용할 경우 키 코드를 사용하지 않음
	if( window.event.keyCode == 13 && window.event.ctrlKey ){	
		document.querySelector('.msg').value += `\n`;
		return;
	}
	
	// 2. 만약에 입력한 키가 [엔터키]이면 메시지 전송
		// !! 키보드 아스키 코드 참고
		// 기본적으로 쉬프트+엔터키가 줄바꿈을 지원하기 때문에
		// 엔터를 누를 시 쉬프트키를 누르지 않을 경우 전송 
	if( window.event.keyCode == 13 && !window.event.shiftKey ){
		onSend();
		return;
	}
}

// 6. 이모티콘 출력하기
getEmo()
function getEmo(){
	
	//  -
	for( let i=0; i<=43; i++ ){
		document.querySelector('.emolistbox').innerHTML
		+= `<img onclick="onEmoSend(${i})" src="/jspweb/img/imoji/emo${i}.gif" />`
	}
	
}

// 7. 클릭한 이모티콘 서버로 보내기
function onEmoSend( i ){
	
	// 1. msg 구성
	let msg = { type : 'emo', content : i+"" }
		// type : 1msg[메시지], 2emo[이모티콘], 3img[사진]
		// content : 내용들
		
	// 2. 보내기
	clientSocket.send( JSON.stringify( msg ) );
		// JSON타입을 String타입으로 변환해주는 함수
}

// 8. msg 타입에 따른 HTML 반환 함수 
function typeHTML( msg ){
	
	let html = ``;
	
	// 1. 메시지 타입 일때는 <div> 반환  
	if( msg.type == 'message'){
		html += `<div class="content"> ${ msg.content } </div>`;
	}
	// 2. 이모티콘 타입 일때는 <img> 반환 
	else if( msg.type == 'emo' ){
		html += `<img src="/jspweb/img/imoji/emo${msg.content}.gif" />`;
	}
	// 3. 만약에 알림 타입일 때는 <div> 변환
	else if( msg.type == 'alarm' ){
		html += `<div class="alarm"> ${ msg.content } </div>`
	}
	return html;
	
}




/* ------------------------------------------------- */
/*
	JS[ HTML파일 종속된 파일 - HTML 안에서 실행되는 구조 ] - 추후 node.js 라는 프레임워크 는 HTML로부터 벗어남.
	
	* 
		클라이언트 : 사용 데이터 요청 하는 PC
		서버 : 데이터 제공하는 PC
		
	* URL[주소] 상의 매개변수 전달하는 방법
		1. 쿼리스트링 방식 : URL?매개변수명1=데이터1&매개변수명2=데이터2&매개변수명3=데이터3
		2. 경로매개변수 방식 : URL/데이터1/데이터2/데이터3
		
	* 소켓이란. 
		- 통신의 종착점[데이터가 전달되는 위치 -받는사람 -보낸사람]
		- 예시 
		[클라이언트소켓]							[서버소켓]
		JS=강호동집									우체국		
			안산시 상록구[소켓]	----------------->					
			
		JS=신동엽집
			수원시 영통구[소켓]	<------------------
		
	* WebSocket 클라이언트 웹 소켓 라이브러리 
		- 소켓 관련된 함수들을 제공하는 클래스 
		1. 웹소켓 객체 생성 
			new WebSocket("ws://IP주소:PORT번호/프로젝트명/서버소켓경로");
		2. 메소드 제공
			- .send() : 칼라이언트소켓이 연결된 서버소켓에게 메시지를 전송하는 메소드
			
	* 동기화 vs 비동기화 
	
	
	동기화[ 요청1 결과에 따른 다음 요청이 필요할때 ]		비동기화[ 여러 기능을 별도로 처리 ]
	
	Client				Server						Client				Server
	
		--------요청1------->							--------요청1------->
	대기상태o				요청1처리중					대기상태x				요청1처리중[5분]
		<-------응답1--------							--------요청2------->
																		요청2처리중[1분]
		--------요청2------->							<-------응답2--------
						요청2처리중						
		<-------응답2--------							<-------응답1--------

*/


















// 1. 클라이언트 소켓 만들기

	// 1. JS웹소켓 객체	[ WebSocket 클래스 ]
		// new WebSocket( 'ws://ip주소:포트번호/서버소켓URL' );
let 클라이언트소켓 = new WebSocket( 'ws://192.168.17.17:80/jspweb/ChattingSocket' );
/*
	테스트시 동일한 컴퓨터에서 2개 이상의 웹을 사용하여 테스트하게 되는데
	이는 클라이언트에 대한 식별기준이 ip가 아닌 new생성자를 이용하여
	힙 메모리 영역에 서로 다른 주소값을 생성하기 때문이다
*/
   


		// onopen, onclose, send, onmessage
	
		// 내가 만든 함수를 클라이언트소켓 속성에 대입
클라이언트소켓.onmessage = (event) => onmsg(event);
		// 웹콘솔창에서 확인한 속성 ==>  onmessage : (e) => onmsg(e)
	
// 2. 연결된 서버소켓에게 메시지 보내기
function send(){
	// 1. input 입력된 값 가져오기
	let msg = document.querySelector('.inputcontent').value;
	
	// 2. 클라이언트소켓 .send()
	클라이언트소켓.send( msg );		// input에서 입력받은 데이터를 보내기
	// 여기서의 send는 내장함수임
	
	document.querySelector('.inputcontent').value = ``;
}

// 3. 연결된 서버소켓으로부터 메시지를 받았을 때
function onmsg(event){
	console.log(event);
	
	document.querySelector('.contentbox').innerHTML += `<div> ${event.data} </div>`
}




/*

	1. AJAX
		
		발신자(요청 보내는 사람) 	: ajax
		수신자(요청 받는 사람) 		: 서블릿
		
		JS  				JAVA[서블릿]

		AJAX
		
				rest		get
							post
							put
							delete

	2. (웹) 소켓
		소켓 : 통신의 종착점 [도착위치]
	
		WS	: 
	
		JS					JAVA
		[클라이언트 소켓]		[서버소켓]
		websocket
		
		
		

*/
/*
			클라이언트								서버
		강호동카카오톡								
		
		
		
		유재석카카오톡								카카오서버[제주도]
		
		
		
		신동엽카카오톡
		
		
		
		하하카카오톡



		이환희카카오톡
		
		
		
		김영태카카오톡
		
		
		
		이건모르겠지카카오톡
		
		
		
		키키카카오톡
		

*/
































