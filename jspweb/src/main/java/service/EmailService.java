package service;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	
	// 1. 필드
		// 보내는 사람의 이메일 [관리자 이메일]
	private String fromEmail = "abb258@naver.com";	
		// 보내는 사람의 이메일주소 비밀번호
	private String fromEmailPwd = "lhh603562@#*";
	
	// 2. 생성자
	public EmailService() {}
	
	// 3. 메소드
	public boolean authsend( String toEmail, String contentHTML ) {
		
		// 1. 호스팅 설정[ 네이버 기준 ]
			// Properties : 키와 값으로 구성된 map컬렉션 중 하나 [설정 관련된 데이터 객체화]
		Properties properties = new Properties();
		properties.put( "mail.smtp.host", "smtp.naver.com" );
		properties.put( "mail.smtp.port", 587 );
		properties.put( "mail.smtp.auth", true );
		properties.put( "mail.smtp.ssl.protocols", "TLSv1.2" );
		
		// 2. 인증처리[ 네이버에 보내는 사람의 정보가 맞는지 ]
		Authenticator authenticator = new Authenticator() {
			// 패스워드 검증 함수[ 구현 ]
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, fromEmailPwd);
			}
		};
			// Authenticator : import java.net.Authenticator;
				// - 패스워드 검증[인증] 메소드 구현
				// .getPasswordAuthentication( return new PasswordAuthentication("보내는 사람 이메일", "보내는 사람의 이메일 패스워드") )
		
			// session : 인증 후 결과정보를 담고 있는 객체
		Session session = Session.getDefaultInstance(properties, authenticator);
			// Session : import javax.mail.Session;
			// .getDefaultInstance( 호스트설정properties, 인증할계정정보 )
		
		// 3. 메일 전송 - 예외처리 필수
		try {
			
			// Mime 프로토콜 : smtp가 보낼 수 있는 표준 형식/포멧
			// 3-1 MimeMessage 객체 생성
			MimeMessage message = new MimeMessage( session );
			// 3-2 .setFrom( new InternetAddress("보내는 사람의 이메일 주소") )
			message.setFrom( new InternetAddress(fromEmail) );
			// 3-3 .add
			message.addRecipient( Message.RecipientType.TO, new InternetAddress( toEmail ) );
			// 3-4 .setSubject("메일제목")
			message.setSubject("Ezen JSP회원가입 인증코드 발송");
			// 3-5 .setText("메일내용")
			message.setText("안녕하세요 이메일 인증코드 : "+contentHTML);
			
			// 메일전송
				// Transport.send( mime객체 )
			Transport.send( message );
			return true;	//
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	

	
}















