package java1.day10.Ex2;

// 목적 : 설계
public class Computer {

	// 1. 멤버
	
	// 2. 생성자
	
	// 3. 메서드
	
		// 1. 가변(정해져있지 않는)길이 매개변수를 갖는 메소드 선언
		// 2. 가변길이와 일반매개변수가 있을 경우 가변길이매개변수 가장 뒤에 선언
			// ex)	int sum(String str, int ...values) {
	int sum(int ...values) {	
		// 형식 : ...배열변수명
		
		// 매개변수로 들어온 여러개의 변수를 더한 변수
		int sum = 0;
		
		for(int i=0; i<values.length; i++) {
			sum += values[i];
			// 배열내 하나씩 누적합계
		}
		
		return sum;
	}
	
	
}
