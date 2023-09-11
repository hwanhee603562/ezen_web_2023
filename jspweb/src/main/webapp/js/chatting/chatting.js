	
	
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


	// ---------메소드
		// 1. (자동실행) 클라이언트 소켓이 정상적으로 서버소켓에 접속했을 때
clientSocket.onopen = e => {
	console.log('서버와 접속 성공 : '+e);
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

// 3. 서버에게 메시지 전송
function onSend(){
	// 3-1 textarea 입력값 호출
	let msg = document.querySelector('.msg').value;
	if( msg == '' ){
		alert('내용을 입력해주세요');
		return;
	}
	// 3-2 메시지 전송
	clientSocket.send( msg );
	// 클라이언트 소켓과 연결된 서버소켓에게 메시지 전송
	
}

// 4. 메시지를 받았을 때 추후 행동(메소드) 선언
function onMsg( e ){
	console.log(e);			// e : 메시지 받았을 때 발생한 이벤트 정보가 들어있는 객체
	console.log(e.data);	// .data 속성에 전달 받은 메시지 내용
	
	let msg = JSON.parse(e.data);
		// JSON.parse()		: 문자열타입의 json형식을 json타입으로 변환
		// JSON.Stringify()	: JSON타입을 문자열 타입 (JSON형식 유지)으로 변환
	
	// 1. 어디에 출력할건지
	let chatcont = document.querySelector('.chatcont');
	
	let html = ''
	// 2. 무엇을
		// 2-1 만약에 내가 보냈으면
	if( msg.frommid == loginMid ){
		
		html = `
			<!-- 보냈을 때 메시지 [오른쪽] -->
			<div class="rcont">
				<div class="subcont"> 
					<div class="date"> 시간 </div>
					<div class="content"> ${msg.msg} </div>
				 </div>
			</div>
		`;
		
	} else {	// 2-2 내가 보내지 않았으면
		html = `
			<!-- 받았을 때 메시지 [왼쪽] -->
			<div class="lcont"> 
				<img class="pimg" src="/jspweb/member/img/default.webp">
				<div>
					<div class="name"> ${msg.frommid} </div>		<!-- 보낸 사람 -->
					<div class="subcont">
						<div class="content"> ${msg.msg}	<!-- 보낸 내용 -->
						<div class="date"> 시간 </div>	<!-- 보낸 시간 -->
					</div>
				</div>
			</div>
		`;
		
	}

	// 3. 누적 대입 [기존 채팅에 이어서 추가 +=]
	chatcont.innerHTML += html;
	
			/*
				
				
				<!-- 알림 메시지 -->
				<div class="alarm"> 강호동님이 입장하셨습니다 </div>
				
				
			*/

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
































