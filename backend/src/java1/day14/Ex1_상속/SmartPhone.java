package java1.day14.Ex1_상속;

public class SmartPhone extends Phone {
// SmartPhone클래스가 Phone 클래스를 상속받음
	
	// 필드
	public boolean wifi;
	
	// 생성자
	public SmartPhone(String model, String color) {
		
		super();
		// [생략가능] 
		this.model = model;
		this.color = color;
		// Phone 클래스의 멤버를 상속받았기에 'this.'을 이용하여 인스턴스 식별 가능
	}
	
	
	// 메소드
	public void setwifi( boolean wifi ) {
		this.wifi = wifi;
		System.out.println( "와이파이 상태를 변경했습니다" );
	}
	
	public void internet() {
		System.out.println( "인터넷에 연결합니다" );
	}
}
