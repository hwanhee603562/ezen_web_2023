package controller.chatting;

import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/*

	1. 서버 소켓 만들기
		1. 클래스 선언
		2. 클래스 위에 @ServerEndpoint	("서버소켓의 URL정의")	: 클라이언트소켓들이 접속하는 종착점
		3. 서버 웹소켓의 필수 메소드
			@OnOpen		: 클라이언트소켓이 서버소켓과 연결이 접속되었을 때
			@OnClose	: 클라이언트소켓이 서버소켓과 연결이 닫혔을 때
			@OnMessage	: 클라이언트소켓이 메시지를 보냈을 때
			@OnError	: 클라이언트소켓이 서버소켓과 연결에 에러가 발생했을 때
*/

@ServerEndpoint("/ChattingSocket")
public class ChattingSocket {

	// ☆★☆★☆★ import는 모두 websocket 으로 지정
	
	public static ArrayList<Session> 접속명단 = new ArrayList<>();
	
	// 1. 클라이언트가 서버소켓 접속했을 때 매핑/즉, 연결
	@OnOpen	
	public void OnOpen( Session session ) {		
		// * 들어온 클라이언트소켓들을 서버소켓에 저장..
		접속명단.add(session);
	}
	
	// 2. 클라이언트가 서버소켓과 연결이 닫혔을 때 매핑/연결 
		//	( JS에서 웹소켓 객체를 초트 소켓 중 하나
					// getBasicRemote()	:기화 = 새로고침[f5], 페이지전환 등 )
	@OnClose
	public void onClose( Session session ) {
		접속명단.remove(session);	
	}
	
	// 3. 클라이언트가 서버소켓의 메시지를 보냈을 때 연결/매핑
	@OnMessage
	public void onMessage( Session session, String msg ) {
		
		
		System.out.println( "입력자 : "+session.getQueryString() );
		System.out.println( "입력자 : "+session.getUserPrincipal().toString() );
		// 현재 좁속된 명단(클라이언트소켓) 들에게 메시지 전달
		
		접속명단.forEach( s -> {
			
			try {
				
				System.out.println("s : "+s.getUserProperties().get("javax.websocket.endpoint.remoteAddress") );
				s.getBasicRemote().sendText(msg);
				// getBasicRemote : 접속명단에 있는 클라이언트 메시지 전송 메소드 제공
						// .sendText : 메시지를 String 타입으로 전송[ 예외처리 필수 ]
			
			} catch (Exception e) {
				System.out.println(e);
			}
			
		});
	}
	
	
	
	// 4. 
	
	
	
}















