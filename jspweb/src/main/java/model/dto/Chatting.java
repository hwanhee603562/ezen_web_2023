package model.dto;

public class Chatting {
	private int jno;				
	private int Caller;			// 발신자
	private int receiver;		// 수신자
	private String jcontent;	// 내용
	private String jchatdate;	// 채팅일시
	private int ino;			// 판매물품
	
	
	// 생성자
	public Chatting() {
		// TODO Auto-generated constructor stub
	}


	public Chatting(int jno, int caller, int receiver, String jcontent, String jchatdate, int ino) {
		super();
		this.jno = jno;
		Caller = caller;
		this.receiver = receiver;
		this.jcontent = jcontent;
		this.jchatdate = jchatdate;
		this.ino = ino;
	}

	// setter getter
	public int getJno() {
		return jno;
	}


	public void setJno(int jno) {
		this.jno = jno;
	}


	public int getCaller() {
		return Caller;
	}


	public void setCaller(int caller) {
		Caller = caller;
	}


	public int getReceiver() {
		return receiver;
	}


	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}


	public String getJcontent() {
		return jcontent;
	}


	public void setJcontent(String jcontent) {
		this.jcontent = jcontent;
	}


	public String getJchatdate() {
		return jchatdate;
	}


	public void setJchatdate(String jchatdate) {
		this.jchatdate = jchatdate;
	}


	public int getIno() {
		return ino;
	}


	public void setIno(int ino) {
		this.ino = ino;
	}


	@Override
	public String toString() {
		return "Chatting [jno=" + jno + ", Caller=" + Caller + ", receiver=" + receiver + ", jcontent=" + jcontent
				+ ", jchatdate=" + jchatdate + ", ino=" + ino + "]";
	}
	
	
	
	
	
	
	
	
}
