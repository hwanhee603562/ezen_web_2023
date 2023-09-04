package model.dto;

public class BoardDto {	// 게시물, 카테고리
	
	private int bno;			// 게시물 번호
	private String btitle;		// 제목
	private String bcontent;	// 내용
	private String bfile;		// 첨부파일
	private String bdate;		// 작성일
	private int bview;			// 조회수
	private int mno;			// 작성자
	private int bcno;			// 카테고리 번호
	// - DB에는 없지만 추가하면 좋은 필드 ( DB에서 JOIN하여 호출 예정 )
	private String mid;			// 작성자 회원아이디
	private String bcname;		// 카테고리명
	private String mimg;		// 작성자 프로필
	// - 조회대상자와 게시물작성자 일치 여부 [ 본인글 체크여부 ]
	private boolean ishost;
	
	
	
	

	// 생성자
	public BoardDto() {}
	
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int mno, int bcno,
			String mid, String bcname) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.mno = mno;
		this.bcno = bcno;
		this.mid = mid;
		this.bcname = bcname;
	}
	
	
	
	// 글 등록시 사용되는 생성자 
	public BoardDto(String btitle, String bcontent, String bfile, int mno, int bcno) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.mno = mno;
		this.bcno = bcno;
	}
	
	// 모든 글 조회시 사용되는 생성자
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int mno, int bcno,
			String mid, String bcname, String mimg) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.mno = mno;
		this.bcno = bcno;
		this.mid = mid;
		this.bcname = bcname;
		this.mimg = mimg;
	}
	
	// 게시글 수정시 사용되는 생성자
	public BoardDto(int bno, String btitle, String bcontent, String bfile, int bcno) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bcno = bcno;
	}
	
	
	
	// getter setter
	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBfile() {
		return bfile;
	}

	public void setBfile(String bfile) {
		this.bfile = bfile;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBview() {
		return bview;
	}

	public void setBview(int bview) {
		this.bview = bview;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getBcno() {
		return bcno;
	}

	public void setBcno(int bcno) {
		this.bcno = bcno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getBcname() {
		return bcname;
	}

	public void setBcname(String bcname) {
		this.bcname = bcname;
	}
	
	public boolean isIshost() {
		return ishost;
	}

	public void setIshost(boolean ishost) {
		this.ishost = ishost;
	}
	
	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bfile=" + bfile
				+ ", bdate=" + bdate + ", bview=" + bview + ", mno=" + mno + ", bcno=" + bcno + ", mid=" + mid
				+ ", bcname=" + bcname + ", mimg=" + mimg + "]";
	}


	
	
	
	
	
	
}
