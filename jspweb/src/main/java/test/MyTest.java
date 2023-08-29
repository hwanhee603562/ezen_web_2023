package test;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MyTest {

		private String fromEmail = "abb258@naver.com";	
		private String fromEmailPwd = "보내는 사람의 이메일주소 비밀번호";
		public MyTest() {}
		
		public boolean authsend( String toEmail, String contentHTML ) {
			
			Properties properties = new Properties();
			properties.put( "mail.smtp.host", "smtp.naver.com" );
			properties.put( "mail.smtp.port", 587 );
			properties.put( "mail.smtp.auth", true );
			properties.put( "mail.smtp.ssl.protocols", "TLSv1.2" );
			
			Authenticator authenticator = new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, fromEmailPwd);
				}
			};

			Session session = Session.getDefaultInstance(properties, authenticator);

			try {
				MimeMessage message = new MimeMessage( session );
				message.setFrom( new InternetAddress(fromEmail) );
				message.addRecipient( Message.RecipientType.TO, new InternetAddress() );
				message.setSubject("Ezen JSP회원가입 인증코드 발송");
				message.setText(contentHTML);
				
				Transport.send( message );
			} catch (Exception e) {
				System.out.println(e);
			}
			return false;
		}
	}