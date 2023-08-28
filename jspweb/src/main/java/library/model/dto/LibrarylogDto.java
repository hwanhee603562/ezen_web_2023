package library.model.dto;

public class LibrarylogDto {
	private int llno;
    private String ldatetime;
    
    private int lno;
	public int getLlno() {
		return llno;
	}
	public void setLlno(int llno) {
		this.llno = llno;
	}

	public String getDatetime() {
		return ldatetime;
	}
	public void setDatetime(String ldatetime) {
		this.ldatetime = ldatetime;
	}

	public int getLno() {
		return lno;
	}
	public void setLno(int lno) {
		this.lno = lno;
	}
	public LibrarylogDto(int llno, String ldatetime, int lno) {
		super();
		this.llno = llno;
		this.ldatetime = ldatetime;

		this.lno = lno;
	}
    
}
