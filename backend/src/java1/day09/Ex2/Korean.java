package java1.day09.Ex2;

public class Korean {
	// 1. 필드
	String nation = "대한민국";// 1. 객체마다 동일한 값을 갖고 있다면 / 객체의 필드값을 미리 초기화
		// nation은 동일한 주소값을 공유한다
	String name;			// 2. 객체마다 다른 값을 가져야 한다면 / 객체의 필드값 기본값 -> 생성자 이용 권장 
	String ssn;
		
	// 2. 생성자
		// 0. 기본 생성자 = 깡통생성자
	public Korean() {
			
	}
		// 1. 매개변수1개인 생성자
	public Korean(String name) {
		
	}
		// 2. 매개변수2개인 생성자
	public Korean(String name, String ssn) {
			//가독성을 위해 매개변수명을 멤버변수와 동일하게 사용하는 것을 권장
			//this : 현재 클래스 뜻 [매개변수명이 동일할 때 현 클래스의 멤버변수에 this를 사용]
			//this는 해당 메서드/생성자를 호출한 객체에 사용 = 주체자
				// this.필드명	this.메소드명()	this() : 생성자
		this.name = name;
		this.ssn = ssn;
	}
		// 3. 매개변수가3개인 생성자	[ 1. 매개변수의 개수가 다를 경우 ]
	public Korean(String name, String ssn, String nation) {
		this(name,ssn);
		this.nation = nation;
		
	}
		// 4. 매개변수가2개인 생성자	[ 2. 매개변수의 타입이 다를 경우 ]
	public Korean(String name, int ssn) {
	}
		// 5. 매개변수가2개인 생성자	[ 3. 매개변수의 타입순서가 다를 경우 ]
	public Korean(int ssn, String name) {
	}
	
	// 3. 메소드
}
