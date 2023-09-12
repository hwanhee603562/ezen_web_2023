package controller.chatting;

import java.util.List;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ClientDto;
import model.dto.MsgDto;

@ServerEndpoint("/serversocket/{mid}")	// 서버 소켓 url 
										// mid는 경로상의 매개변수를 의미
public class ServerSocket {

	/*
	* WebSocket 서버 소켓 라이브러리 제공
		1. 서버소켓 클래스 생성 
			- 클래스위에 서버소켓의 URL 만들기 
				@ServerEndpoint("/serversokcet")
			- 만약에 서버소켓의 URL 경로상의 매개변수를 받을때. 
				@ServerEndpoint("/serversokcet/{매개변수명1}/{매개변수명2}")
				
		2. 서버소켓 메소드 제공 
				- 메소드 매개변수의 규칙 존재 
				
				1. 클라이언트 소켓이 접속했을때. (자동실행)되는 메소드
				@OnOpen
					1. 
					public void onOpen( Session session ) { }
						- Session : 서버소켓의 접속된 클라이언트소켓 정보
					2. 
					public void onOpen( Session session , @PathParam("매개변수명1") 타입 매개변수명 ) { }
						- @PathParam("매개변수명1") 타입 매개변수명 : 서버소켓(URL)경로상의 매개변수를 호출 
				
				2. 클라이언트 소켓과 오류가 발생했을때 . (자동실행)되는 메소드
				@OnError
					public void onError( Session session , Throwable throwable ) { }
						- Session : 서버소켓과 오류가 발생한 클라이언트소켓 정보 
						- Throwable : 오류 발생한 사유 정보 
				
				3. 클라이언트 소켓과 연결이 끊겼을때. (자동실행)되는 메소드
				@OnClose
					public void OnClose( Session session ) { }
						- Session : 서버소켓과 연결이 끊긴 클라이언트소켓 정보 
				
				4. 클라이언트 소켓으로부터 메시지를 받았을때. (자동실행)되는 메소드
				@OnMessage
					public void onMessage( Session session , String msg ) { } 
						- Session : 서버소켓에게 메시지를 보낸 클라이언트소켓 정보 
						- String 매개변수 : 클라이언트소켓으로 부터 받은 메시지 [문자열타입]
						
				5. 클라이언트소켓에게 메시지 전송 
					클라이언트소켓.getBasicRemote().sendText("내용");
					
	*/
	
	// 0. 소켓 저장
	public static List<ClientDto> clientList = new Vector<>();
	
	// 1. 서버 소켓으로부터 접속 받았을 때
	@OnOpen
	public void onOpen( Session session, @PathParam("mid") String mid  ) {
		System.out.println("클라이언트 소켓이 입장했습니다 "+session);
		System.out.println("접속한 회원아이디 "+mid);
		
		// 1-1 : 접속된 클라이언트소켓을 리스트에 저장하자
		ClientDto clientDto = new ClientDto(session, mid);
		clientList.add(clientDto);
		
	}
	
	// 2. 
	@OnError
		// OnError은 에러를 처리하는 Throwable 을 추가해야함
	public void onError( Session sessoin, Throwable throwable ) {
		
	}
	
	// 3. 클라이언트 소켓과 서버소켓이 연결이 끊겼을 때
	@OnClose
	public void onClose( Session session ) {
		// * 접속목록에서 세션 제거
		for( ClientDto clientDto : clientList ) {
			// 접속목록에서 연결이 끊긴 세션 찾기
			if( clientDto.getSession() == session ) {
				// 클라이언트 소켓의 세션과 연결이 끊긴 세션과 같으면 dto 제거
				clientList.remove( clientDto );
				break;
			}
		}
	}
	
	
	// 4.
	@OnMessage// 매개변수 : 1. 메시지를 보낸 클라이언트소켓(세션) 2. 메시지 내용 [문자열]
	public void onMessage( Session session, String msg ) throws Exception {
	//	System.out.println( "test1 : "+msg );
		
			// 2-2 메시지를 보낼 내용 구성 [ 보낸사람, 보낸내용 ]
		MsgDto msgDto = new MsgDto();
				// - 보낸사람 찾기 [ 보낸 세션을 이용한 보낸 mid 찾기 ]
		for( ClientDto clientDto : clientList ) {
			if( clientDto.getSession() == session ) {
				// 회원목록 중에 보낸 세션과 일치하면
				msgDto = new MsgDto( clientDto.getMid(), msg );
				break;
			}
		}
		// msgDto를 JSON 사용할 수 있도록 형변환
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonMsg = objectMapper.writeValueAsString(msgDto);
		
		// 2-1 받은 메시지를 접속된 회원들에게 모두 전송
		for( ClientDto clientDto : clientList ) {
			// 예외처리 필수!
			clientDto.getSession().getBasicRemote().sendText(jsonMsg);
			// 클라이언트 소켓에게 메시지 전송
				// 클라이언트소켓.getSession().getBasicRemote().sendText("보내고자하는 말");
		}
	}

	
	

	
}




























