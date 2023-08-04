package 과제.과제11.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {	// 각종 Dao 클래스를 대표하는 부모클래스
	
	// 1. 필드
		// 이름이 혼동되는 것이 많기에 [ import java.sql ]에 있는 아래 3가지를 사용해야함 
	public Connection conn;			// DB연동 객체
	public PreparedStatement ps;	// 연동된 DB에서 SQL조작(SQL매개변수대입, SQL실행/취소) 하는 객체
	public ResultSet rs;			// SQL조작 결과를 가져오는 객체
	
	// 2. 생성자	: 객체 생성시 초기화 담당
		// 기본생성자에 DB연동 코드 작성
		// * DAO객체생성시 바로 DB연동
	
	public Dao() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web", "root", "123");
			System.out.println("안내) DB연동성공");
			
		} catch(Exception e) {
			
			System.out.println("안내) DB연동실패 : "+e);
			
		}
		
	}
	
	
	// 3. 메서드
	
	

}
