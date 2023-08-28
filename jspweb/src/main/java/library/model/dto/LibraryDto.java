package library.model.dto;
 
public class LibraryDto {
	
	private int lno;
	private String lname;
	private String lphone;
	private int lseat;
	
	// 생성자
	public LibraryDto() {
		// TODO Auto-generated constructor stub
	}

	public LibraryDto(int lno, String lname, String lphone, int lseat) {
		super();
		this.lno = lno;
		this.lname = lname;
		this.lphone = lphone;
		this.lseat = lseat;
	}
	
	public LibraryDto(String lname, String lphone, int lseat) {
		this.lname = lname;
		this.lphone = lphone;
		this.lseat = lseat;
	}

	// getter setter
	public int getLno() {
		return lno;
	}

	public void setLno(int lno) {
		this.lno = lno;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLphone() {
		return lphone;
	}

	public void setLphone(String lphone) {
		this.lphone = lphone;
	}

	public int getLseat() {
		return lseat;
	}

	public void setLseat(int lseat) {
		this.lseat = lseat;
	}

	
	@Override
	public String toString() {
		return "LibraryDto [lno=" + lno + ", lname=" + lname + ", lphone=" + lphone + ", lseat=" + lseat + "]";
	}


	
	
	
	
	
	
	
	
}
