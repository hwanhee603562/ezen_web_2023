package library.model.dao;

import java.util.ArrayList;

import library.model.dto.LibraryDto;
import model.dao.Dao;

public class LibraryDao extends Dao {

	// 싱글톤
	private static LibraryDao libraryDao = new LibraryDao();
	public static LibraryDao getInstance() {
		return libraryDao;
	}
	private LibraryDao() {};
	
	// 좌석조회
	public ArrayList<Integer> serchSeat() {
		
		try {
			ArrayList<Integer> list = new ArrayList<>();
			
			for(int i=0; i<8; i++) {
				list.add(1);
			}
			String sql = "select lseat from library";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.set( rs.getInt(1)-1, 0 );
			}
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	 
	// 현 좌석 입실 여부확인
		// 현재 좌석 입실 중인 경우 1
		// 좌석이 빈 경우 0 반환
	public int stateSeat( int lseat ) {
		
		try { 
			String sql = "select * from library where lseat = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, lseat);
			rs = ps.executeQuery();
			if(rs.next()) {
				return 1;
			} else return 0;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 2;
	}
	
	
	// 좌석 입실
	public int inSeat(LibraryDto libraryDto) {
	
		try {
			
			// 현 좌석 입실 여부확인
			// 현재 좌석 입실 중인 경우 1
			// 좌석이 빈 경우 0 반환
			int state = stateSeat( libraryDto.getLseat() );
			if(state==1) return 1;	// 좌석 대여 중
			
			String sql = "insert into library(lname, lphone, lseat) value(?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, libraryDto.getLname());
			ps.setString(2, libraryDto.getLphone());
			ps.setInt(3, libraryDto.getLseat());
			ps.executeUpdate();
			return 0;	// 좌석 입실성공
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 2;	// DB오류
	}
	
	// 해당 입실좌석 휴대전화 일치여부 확인
		// 일치할 경우 true
		// 불일치할 경우 false 반환
	public boolean checkPhone( String lphone ) {
		
		try {
			String sql = "select * from library where lphone = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, lphone);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	// 좌석 삭제
	public int deleteSeat(String lphone, int lseat) {
		
		try {
			// 현 좌석 입실 여부확인
			// 현재 좌석 입실 중인 경우 1
			// 좌석이 빈 경우 0 반환
			int state = stateSeat( lseat );
			if(state==0) return 2;	// 좌석 대여 중이 아님
			
			// 해당 입실좌석 휴대전화 일치여부 확인
			// 일치할 경우 true
			// 불일치할 경우 false 반환
			boolean checkP = checkPhone( lphone );
			if( !checkP ) return 1;
			
			String sql = "delete from library where lseat = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1, lseat );
			ps.executeUpdate();
			
			return 4; 
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 3;
	}
}

























