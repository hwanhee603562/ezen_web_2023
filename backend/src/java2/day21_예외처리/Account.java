package java2.day21_예외처리;

public class Account {
	
	// 필드
	private long balance;	// 잔고
	
	// 생성자
	public Account() {}

	// 메서드
	public long getBalance() {
		return balance;
	}
	
		// 예금 메서드
	public void deposit(int money) {
		balance += money;
	}
		// 출금 메서드
	public void withdraw(int money) throws 잔고부족예외 {
		// 예금 부족하면 출금 금지
		if( this.balance < money ) {
			// 고의적으로 조건에 해당될 시 예외발생
			 throw new 잔고부족예외("잔고부족 : "+(money-this.balance)+" 만큼 부족");
		}
		this.balance -= money;
	}
	
}
