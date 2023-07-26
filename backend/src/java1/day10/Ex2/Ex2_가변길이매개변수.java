package java1.day10.Ex2;

// 목적 : 실행
public class Ex2_가변길이매개변수 {
	public static void main(String[] args) {
		

		
		
		// 1. 다른 클래스에 있는 메소드를 호출하기 위한 객체 생성
		Computer myCom = new Computer();
		
		// 2. 3개 인수로 전달
		System.out.println( myCom.sum(1, 2, 3) );
		
		// 3. 5개 인수로 전달
		System.out.println( myCom.sum(1, 2, 3, 4, 5) );
		
		// 4. 배열 전달1
		int[] values = {1, 2, 3, 4, 5}; 
		System.out.println( myCom.sum(values) );
		
		// 5. 배열 전달2
		System.out.println( new int[] { 1, 2, 3, 4, 5 } );
		
		/*
	  		2, 3번과 같이 여러 개의 리터럴을 사용할 경우 배열보다 가변길이매개변수를 사용하기 유용하며,
	  		메서드에서 받는 매개변수를 배열로 사용한다면 new생성자를 통한 메모리할당을 해야하지만
	  		...가변길이매개변수를 사용한다면 굳이 new생성자를 사용하지 않아도된다	 
		*/
		
	}
}
