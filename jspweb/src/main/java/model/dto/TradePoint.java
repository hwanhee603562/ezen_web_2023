package model.dto;

// 대면거래방식의 대면거래 위치정보 위도 경도
	// 거래 전 물품만 해당
public class TradePoint {
	private int dno; 		// 대면거래 위치 pk
	private String dlat;	// 위도
	private String dlng;	// 경도
	private int ino;		// 판매물품 번호 pk
    
    public TradePoint() {
		// TODO Auto-generated constructor stub
	}

	public TradePoint(int dno, String dlat, String dlng, int ino) {
		super();
		this.dno = dno;
		this.dlat = dlat;
		this.dlng = dlng;
		this.ino = ino;
	}
	
	
	// setter getter
	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}

	public String getDlat() {
		return dlat;
	}

	public void setDlat(String dlat) {
		this.dlat = dlat;
	}

	public String getDlng() {
		return dlng;
	}

	public void setDlng(String dlng) {
		this.dlng = dlng;
	}

	public int getIno() {
		return ino;
	}

	public void setIno(int ino) {
		this.ino = ino;
	}

	
	
	@Override
	public String toString() {
		return "TradePoint [dno=" + dno + ", dlat=" + dlat + ", dlng=" + dlng + ", ino=" + ino + "]";
	}
    
	
	
	
    
}
