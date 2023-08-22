package model.dto;

public class VisitDto {
	private int vno;		// 식별번호( 방문록번호 )
    private String vwriter;	// (방문록 작성자명)
    private String vpwd;	// (방문록 비밀번호)
    private String vcontent;// (방문록 내용)
    private String vdate; 	// (방무록 작성일/시간)
    
    
    
    // 기본 생성자
    public VisitDto() {
		
	}
    
    // 풀 생성자
	public VisitDto(int vno, String vwriter, String vpwd, String vcontent, String vdate) {
		super();
		this.vno = vno;
		this.vwriter = vwriter;
		this.vpwd = vpwd;
		this.vcontent = vcontent;
		this.vdate = vdate;
	}
	
	public VisitDto(String vwriter, String vpwd, String vcontent) {
		super();

		this.vwriter = vwriter;
		this.vpwd = vpwd;
		this.vcontent = vcontent;

	}

	
	// getter / setter
	public int getVno() {
		return vno;
	}

	public void setVno(int vno) {
		this.vno = vno;
	}

	public String getVwriter() {
		return vwriter;
	}

	public void setVwriter(String vwriter) {
		this.vwriter = vwriter;
	}

	public String getVpwd() {
		return vpwd;
	}

	public void setVpwd(String vpwd) {
		this.vpwd = vpwd;
	}

	public String getVcontent() {
		return vcontent;
	}

	public void setVcontent(String vcontent) {
		this.vcontent = vcontent;
	}

	public String getVdate() {
		return vdate;
	}

	public void setVdate(String vdate) {
		this.vdate = vdate;
	}

	
	
	// toString
	@Override
	public String toString() {
		return "VisitlogDto [vno=" + vno + ", vwriter=" + vwriter + ", vpwd=" + vpwd + ", vcontent=" + vcontent
				+ ", vdate=" + vdate + "]";
	}


    







}


