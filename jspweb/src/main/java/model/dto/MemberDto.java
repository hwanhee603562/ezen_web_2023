package model.dto;

public class MemberDto {
	int mno;
	String mid;
	String mpwd;
	String memail;
	String mimg;
	
	// 생성자
	public MemberDto() {}

	public MemberDto(int mno, String mid, String mpwd, String memail, String mimg) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
	}
	
	
	// getter setter
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
				+ "]";
	}
	
	
	
}
