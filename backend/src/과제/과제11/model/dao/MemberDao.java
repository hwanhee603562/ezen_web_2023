package 과제.과제11.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao {
	// DB를 연동하기 위한 클래스인 Dao를 현 클래스에 상속함으로써 매번 클래스마다 DB를 연동할 필요가 없다

	// 0 싱글톤 객체
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {
		return memberDao;
	}
	private MemberDao() {}
	
	

	
	// 회원가입SQL
	public void signupSQL( MemberDto dto ) {
		System.out.println("--- signupSQL 다오 도착");
		System.out.println(dto);
		
		//1 회원가입에 필요한 SQL을 문자열에 작성해서 저장
			// 테이블에 레코드 삽입 : insert into 테이블명 ( 필드명, 필드명, 필드명 ) values(값, 값, 값);
		String sql = "insert into member(mid, mpw, mname, mphone) values(?,?,?,?)";
		
		try {	// Connection, prepareStatement, ResultSet은 예외처리필수 
		
			//2 위에서 작성한 SQL을 DB연동객체에 대입 [ conn.prepareStatement( sql ) ]
			//3 대입한 SQL 조작하기 위해 반환된 prepareStatement를 ps 대입
			ps = conn.prepareStatement( sql );
				// conn, ps 필드는 Dao 부모클래스에게 받음
				// prepareStatement( 조작할 문자열 );
			
			//4 SQL에서 작성한 매개변수에 대해 값 대입	[ .setString(순서번호, 값) ]
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMname());
			ps.setString(4, dto.getMphone());
			
			
			//5 SQL 실행							[ ps.executeUpdate(); 	: SQL실행 ]
			ps.executeUpdate();
		
		} catch(Exception e) {
			
			System.out.println("경고) 회원가입 실패 사유 "+e);
			
		}
		
		
	}
	
	// 로그인SQL	
	public void loginSQL( String id, String pw ) {
		System.out.println("--- loginLogic 다오 도착");
	}
	
	
}
