package model.dto;

// 거래내역 (거래완료된 물품만 해당)
public class TradeLog {
	private int tno;			// 거래내역번호 pk
	private int buyer;			// 구매자
	private String tradedate;	// 거래일시
	private int ino;			// 거래물품
    
    // 생성자
    public TradeLog() {
		// TODO Auto-generated constructor stub
	}
    
	public TradeLog(int tno, int buyer, String tradedate, int ino) {
		super();
		this.tno = tno;
		this.buyer = buyer;
		this.tradedate = tradedate;
		this.ino = ino;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public int getBuyer() {
		return buyer;
	}

	public void setBuyer(int buyer) {
		this.buyer = buyer;
	}

	public String getTradedate() {
		return tradedate;
	}

	public void setTradedate(String tradedate) {
		this.tradedate = tradedate;
	}

	public int getIno() {
		return ino;
	}

	public void setIno(int ino) {
		this.ino = ino;
	}
    
    
    
    
}
