package Hrm;

import java.util.ArrayList;

import model.dao.Dao;

public class HrmDao extends Dao {
	
	private static HrmDao hrmDao = new HrmDao();
	public static HrmDao getInstance() {
		return hrmDao;
	}
	private HrmDao() {};
	
	
	// 1. 직원등록
	public boolean uploadInfo( HrmDto hrmDto ) {
		
		try {
			
			String sql = "insert into hrm(himg, hname, hphone, hrank) value(?, ?, ?, ?)"; 
			ps = conn.prepareStatement(sql);
			ps.setString(1, hrmDto.getHimg());
			ps.setString(2, hrmDto.getHname());
			ps.setString(3, hrmDto.getHphone());
			ps.setString(4, hrmDto.getHrank());
			ps.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	// 2. 직원리스트 호출
	public ArrayList<HrmDto> hread(){
		
		try {
			ArrayList<HrmDto> list = new ArrayList<>();
			
			String sql = "select * from hrm order by hdate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				
				HrmDto hrmDto = new HrmDto( rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) );
				list.add(hrmDto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	
}















