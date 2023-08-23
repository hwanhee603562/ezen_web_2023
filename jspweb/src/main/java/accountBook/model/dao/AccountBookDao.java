package accountBook.model.dao;

import java.util.ArrayList;

import accountBook.model.dto.AccountBookDto;
import model.dao.Dao;

public class AccountBookDao extends Dao {

	// 0 싱글톤
	private static AccountBookDao accountBookDao = new AccountBookDao();
	public static AccountBookDao getInstance() {
		return accountBookDao;
	}
	private AccountBookDao() {};
	
	// 등록
	public boolean awrite( AccountBookDto accountBookDto ) {
		
		try {
			String sql = "insert into accountbook( acontent, aprice, adate ) values( ?, ?, ? )";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, accountBookDto.getAcontent());
			ps.setInt(2, accountBookDto.getAprice());
			ps.setString(3, accountBookDto.getAdate());
			ps.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	// 조회
	public ArrayList<AccountBookDto> aread() {
		
		try {
			ArrayList<AccountBookDto> list = new ArrayList<>();
			
			String sql = "select * from accountbook";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				AccountBookDto accountBookDto = new AccountBookDto( rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4) );
				list.add(accountBookDto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println();
		}
		
		return null;
	}

	// 수정
	public boolean aupdate( int ano, String acontent, int aprice, String adate ) {
		
		try {
			String sql = "update accountbook set acontent=?, aprice=?, adate=? where ano = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(4, ano);
			ps.setString(1, acontent);
			ps.setInt(2, aprice);
			ps.setString(3, adate);
			ps.executeUpdate();
			
			return true;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	// 삭제
	public boolean adelete( int ano ) {
		
		try {
			String sql = "delete from accountbook where ano = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ano);
			ps.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
	
	
	
	
}

























