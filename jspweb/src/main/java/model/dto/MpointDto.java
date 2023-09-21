package model.dto;

public class MpointDto {
	
	private String mpno;		// 포인트내역 식별번호
	private int mno;			// 지급대상 [ 회원번호 fk ]
	private long mpamount;		// 대략 +-21억
	private String mpcomment;	// 지급내역
	private String mpdate;		// 지급/사용날짜
    
    
    // 생성자
    public MpointDto() {
		// TODO Auto-generated constructor stub
	}

	public MpointDto(String mpno, int mno, long mpamount, String mpcomment, String mpdate) {
		super();
		this.mpno = mpno;
		this.mno = mno;
		this.mpamount = mpamount;
		this.mpcomment = mpcomment;
		this.mpdate = mpdate;
	}

	
	
	// getter setter
	public String getMpno() {
		return mpno;
	}

	public void setMpno(String mpno) {
		this.mpno = mpno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public long getMpamount() {
		return mpamount;
	}

	public void setMpamount(long mpamount) {
		this.mpamount = mpamount;
	}

	public String getMpcomment() {
		return mpcomment;
	}

	public void setMpcomment(String mpcomment) {
		this.mpcomment = mpcomment;
	}

	public String getMpdate() {
		return mpdate;
	}

	public void setMpdate(String mpdate) {
		this.mpdate = mpdate;
	}

	
	
	@Override
	public String toString() {
		return "MpointDto [mpno=" + mpno + ", mno=" + mno + ", mpamount=" + mpamount + ", mpcomment=" + mpcomment
				+ ", mpdate=" + mpdate + "]";
	}
    
    
	
	
	
	
	
}
