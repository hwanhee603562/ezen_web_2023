package model.dto;

// 찜 (판매중인 물품만 해당)
public class WatchItem {
	private int wno;	// 찜번호 pk
	private int mno;	// 찜한 이용자
	private int ino;	// 찜한 물품
	
	
	// 생성자
	public WatchItem() {
		// TODO Auto-generated constructor stub
	}
	public WatchItem(int wno, int mno, int ino) {
		super();
		this.wno = wno;
		this.mno = mno;
		this.ino = ino;
	}
	
	
	// getter setter
	public int getWno() {
		return wno;
	}
	public void setWno(int wno) {
		this.wno = wno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	
	
	
	@Override
	public String toString() {
		return "WatchItem [wno=" + wno + ", mno=" + mno + ", ino=" + ino + "]";
	}
	
	
	
	
	
	
	
	
}
