package java2.day21_예외처리;

public class 잔고부족예외 extends Exception {

	// 기본생성자
	public 잔고부족예외() {
		
	}
	
	// 매개변수1개 생성자 : 예외 정보를 받기 위한 매개변수
	public 잔고부족예외 (String message) {
		super(message);
	}
	
	
	
	
	
}
