package model.dao;

import java.util.ArrayList;

import model.dto.VisitDto;

public class VisitDao extends Dao {
	
	// 0 싱글톤
	private static VisitDao visitDao = new VisitDao();
	public static VisitDao getInstance() {
		return visitDao;
	}
	private VisitDao() {};
	
	// 1. 저장 [ 인수 : 저장할 내용이 담긴 DTO, 리턴 : 성공/실패 = false/true ]
	public boolean vwrite( VisitDto visitDto ) {
		// 0 try catch
		try {
			String sql = "insert into visitlog( vwriter, vpwd, vcontent ) values( ?, ?, ? )";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, visitDto.getVwriter());
			ps.setString(2, visitDto.getVpwd());
			ps.setString(3, visitDto.getVcontent());
			
			ps.executeUpdate();
			return true;

		} catch (Exception e) {
			System.out.println(e);
		}
		
		// 1 SQL 작성
		// 2 SQL 연결
		// 3 SQL 매개변수 대입
		// 4 SQL 실행
		// 5 결과 반환
		
		return false;
	}
	
	// 2. 호출 [ 인수 : x. 리턴 : 여러개의 방문록(ArrayList)의 DTO]
	public ArrayList<VisitDto> vread(){
		
		ArrayList<VisitDto> list = new ArrayList<>();
		
		try {
			
			String sql = "select * from visitlog order by vdate desc";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				VisitDto visitDto = new VisitDto( rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) );
				list.add(visitDto);
				
			}
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	// 3. 수정 [ 인수 : 수정할번호(int)/수정할방문록 내용(String)/비밀번호검토(String), 리턴 : 성공/실패 true/false ]
	public boolean vupdate( int vno, String vcontent, String vpwd ) {
		
		try {
			String sql = "update visitlog set vcontent=? where vno = ? and vpwd = ?;";
			
			ps = conn.prepareStatement(sql);
			ps.setString( 1, vcontent );
			ps.setInt( 2, vno );
			ps.setString( 3, vpwd );
			int row = ps.executeUpdate();
			if( row == 1 ) return true;
			return false;
				
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Dao 수정실패");
		}
		return false;
	}
	
	// 4. 삭제 [ 인수 : 삭제할 방문록번호(int), 리턴 : 성공/실패 = true/false ]
	public boolean vdelete( int vno, String vpwd ) {
		
		try {
			String sql = "delete from visitlog where vno = ? and vpwd = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vno);
			ps.setString(2, vpwd);
			int row = ps.executeUpdate();
				// executeUpdate() 반환값 == int 
				//		--> update한 field의 개수를 count
			if(row == 1) return true;
			return false;
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Dao 삭제실패");
		}
		return false;
	}
	
	
	
	
}











