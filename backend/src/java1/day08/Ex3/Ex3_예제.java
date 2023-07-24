package java1.day08.Ex3;

// 현 클래스의 사용목적 : 실행
public class Ex3_예제 {
	
	// 실행 목적의 클래스이므로 클래스멤버(필드, 생성자, 메서드) 구성 생략가능
	public static void main(String[] args) {
		
		// 1. 객체 선언
		Car myCar = new Car();
	
		// 2. 객체의 필드 호출
			// .도트연산자 : 변수명.필드명		: 해당 변수가 가지고 있는 객체의 주소로 이동해서 필드 호출
		
		System.out.println("모델명 : "+myCar.model);
		System.out.println("시동여부 : "+myCar.start);
		System.out.println("현재속도 : "+myCar.speed);
		
		
		
	}
	
}
