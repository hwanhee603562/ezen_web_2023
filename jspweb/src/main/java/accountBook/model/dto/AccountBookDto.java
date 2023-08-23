package accountBook.model.dto;

public class AccountBookDto {

	int ano;
    String acontent;
    int aprice;
	String adate; 
	
	// 생성자
	public AccountBookDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public AccountBookDto(String acontent, int aprice, String adate) {
		super();
		this.acontent = acontent;
		this.aprice = aprice;
		this.adate = adate;
	}




	public AccountBookDto(int ano, String acontent, int aprice, String adate) {
		super();
		this.ano = ano;
		this.acontent = acontent;
		this.aprice = aprice;
		this.adate = adate;
	}
	
	
	// getter/setter
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getAcontent() {
		return acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	public int getAprice() {
		return aprice;
	}

	public void setAprice(int aprice) {
		this.aprice = aprice;
	}

	public String getAdate() {
		return adate;
	}

	public void setAdate(String adate) {
		this.adate = adate;
	}

	
	
	@Override
	public String toString() {
		return "AccountBookDto [ano=" + ano + ", acontent=" + acontent + ", aprice=" + aprice + ", adate=" + adate
				+ "]";
	}
	
	
	
	
	
}
