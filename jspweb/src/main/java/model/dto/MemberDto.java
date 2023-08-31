package model.dto;

public class MemberDto {
	
	// 필드
		// 1-1 DB 있는 필드
	int mno;
	String mid;
	String mpwd;
	String memail;
	String mimg;
	
	// 1-2 DB 없는 필드
	private String loginDateTime;	// 로그인 시간
	

	// 생성자
		// 2-1 빈생성자
	public MemberDto() {}
	
		// 2-2 풀생성자
	public MemberDto(int mno, String mid, String mpwd, String memail, String mimg, String loginDateTime) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
		this.loginDateTime = loginDateTime;
	}
	
		// 기존 생성자
	public MemberDto(int mno, String mid, String mpwd, String memail, String mimg) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
	}

		// 2-3 세션에 저장하기 위한 생성자( 세션에 패스워드는 저장되면 안되기에 패스워드만 제외 )
	public MemberDto(String loginDateTime, int mno, String mid, String memail, String mimg) {
		super();
		this.loginDateTime = loginDateTime;
		this.mno = mno;
		this.mid = mid;
		this.memail = memail;
		this.mimg = mimg;
	}

		// 2-4 회원가입용 생성자
	public MemberDto(String mid, String mpwd, String memail, String mimg) {
		super();
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
	}
	
	
	
	
	
	// getter setter
	public String getLoginDateTime() {
		return loginDateTime;
	}

	public void setLoginDateTime(String loginDateTime) {
		this.loginDateTime = loginDateTime;
	}
	
	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", memail=" + memail + ", mimg=" + mimg
				+ ", loginDateTime=" + loginDateTime + "]";
	}

	
	
	
	
}
