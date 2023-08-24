package model.dao;

public class MemberDao extends Dao {
	
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {
		return memberDao;
	}
	private MemberDao() {};
	
	
	
	
	
}
