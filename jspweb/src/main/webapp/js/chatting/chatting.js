

// 1. 클라이언트 소켓 만들기

	// 1. JS웹소켓 객체	[ WebSocket 클래스 ]
		// new WebSocket( 'ws://ip주소:포트번호/서버소켓URL' );
let 클라이언트소켓 = new WebSocket( 'ws://192.168.17.17:80/jspweb/ChattingSocket' );
/*
	테스트시 동일한 컴퓨터에서 2개 이상의 웹을 사용하여 테스트하게 되는데
	이는 클라이언트에 대한 식별기준이 ip가 아닌 new생성자를 이용하여
	힙 메모리 영역에 서로 다른 주소값을 생성하기 때문이다
*/
   
console.log(클라이언트소켓);

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



*/
































