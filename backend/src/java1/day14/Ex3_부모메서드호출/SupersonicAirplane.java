package java1.day14.Ex3_부모메서드호출;

public class SupersonicAirplane extends Airplane{
	
	// 상수 생성
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	
	// 인스턴스 생성
	public int flyMode = NORMAL;
	
	
	@Override
	public void fly() {
		if( flyMode == SUPERSONIC ) {
			System.out.println("초음속 비행합니다");
		} else {
			super.fly(); 	// 부모 생성자 호출 -> Airplane -> object	
		}
	}
	
}

/*

	 	this			super
	 	현재클래스			부모클래스
멤버	 	this.멤버변수명		super.멤버변수명
생성자 	this()			super()
메서드 	this.메서드명()	super.메서드명()
 
 
 		오버로딩	: 동일한 메서드명일 때 매개변수에 따른 식별 가능
 		오버라이딩	: 부모클래스로 상속받은 메서드를 재정의할 때
 
*/
