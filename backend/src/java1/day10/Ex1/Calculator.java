package java1.day10.Ex1;

// 목적 : 설계
public class Calculator {
	// 1. 멤버
	
	// 2. 생성자
	
	// 3. 메서드
	
	// 1. 리턴이 없는 메소드	리턴x(필요시 return가능) 매개변수x
	void powerOn() {
		System.out.println("전원을 켭니다");
	}
	
	// 2. 리턴값 없는 메소드	리턴x(필요시 return가능) 매개변수x
	void powerOff(){
		System.out.println("전원을 끕니다");
	}
	
	// 3. 리턴값 있는 메소드 리턴o 매개변수o
	// void를 제외한 리턴타입이 있을 경우 return키워드 필수
	int plus(int x, int y) {
		
		int result = x + y;
		// 매개변수로부터 전달받은 2개의 변수를 더하기
		
		return result;
		// 호출했던 곳으로 result값 전달
	}
	
	// 4. 리턴값/매개변수가 있는 메소드 리턴o 매개변수o
	double devide(int x, int y) {
		double result = (double)x / (double)y;
		// 매개변수로부터 전달받은 2개의 변수를 나누기
		
		return result;
		// 호출했던 곳으로 result값 전달
	}
	
}
