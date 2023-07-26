package java1.day10.Ex3;

// 실행
public class Ex3_리턴 {
	public static void main(String[] args) {
		
		// 1. 자동차 객체 생성
		Car myCar = new Car();
		// 2. 메소드를 이용한 필드에 값 대입
		// 가스충전
		myCar.setGas( 5 );
		
		// 3. 메소드 호출
		// 가스가 있으면 작동, 없으면 gas 주입 문구 출력
		if(myCar.isLeftGas()) {
			
			System.out.println("출발합니다");
			
			// 4. 메소드 호출
			myCar.run();
		}
		
		System.out.println("gas를 주입하세요");
		
	}
}
