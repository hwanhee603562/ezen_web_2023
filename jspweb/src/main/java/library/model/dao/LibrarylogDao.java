package library.model.dao;

import library.model.dto.LibrarylogDto;
import model.dao.Dao;

public class LibrarylogDao extends Dao{
	private static LibrarylogDao instance = new LibrarylogDao();
    public static LibrarylogDao getInstanct () {return instance;}
    private LibrarylogDao() {};
	
	public Boolean entranceLog(int lno)
	{
		try {
			String sql = "insert into librarylog (lno) values (?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, lno);
		
			return (ps.executeUpdate() == 1) ? true:false;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("로그 기록 에러 "+e);
		}
		return false;
	}
	public LibrarylogDto leaveGetLogInfo(int lno)
	{
		try {
			String sql = "select * from librarylog where lno = "+lno;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			return new LibrarylogDto(rs.getInt(1), rs.getString(2), rs.getInt(3));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println( "퇴실 로그 에러 "+e);
		}
		
		return null;
	}
	
}
