package java2.day24.Ex4;

public class Ex4_제네릭 {
	
	// 제네릭메소드 선언
		// 목적 : 함수 매개변수 받을 때 정해져 있지 않는 타입을 받고 싶을 때
		// 메소드 선언부<제네릭타입> : 함수내에서도 제네릭을 사용가능
	public static <T> Box<T> boxing( T t ){
	// 별도 제네릭 타입지정을 하지 않을시 암묵적으로 Object타입으로 지정
	
	// ☆★ public static <T> Box<T> boxing( T t ){
	/*
	 	static <T>	: 매개변수에 제네릭을 사용하기 위해 <T> 선언부에 정의
	 				- 정확한 위치는 return타입 앞에 정의해야 한다
	  	T t = 100
	  	
	  	Box<T>		: 여기서의 리턴 제네릭은 매개변수의 제네릭과 아무 연관이 없음
	  		* 즉, 기본자료형과 같은 다른 자료형으로 사용 가능
	  
	*/
		
		Box<T> box = new Box<>();
		box.setT(t);
		return box;
	}
	
	// main 메소드 선언
	public static void main(String[] args) {
		
		// 1. Box 객체 t필드를 Integer 타입으로 선정
		Box<Integer> box1 = boxing(100);
			// = boxing(100);
			/*
			 	해당 위 부분은 결과적으로 2가지의 기능을 하였다
			 	
				 	1) 힙 메모리 생성 
				 		- "Box<Integer> box1 = new Box<>()"
				 	2) 해당 힙 메모리의 인스턴스 변수에 object 타입으로 100 저장
			*/

			// Box<Integer> box1 = boxing(100);
			/*
				boxing(100) 이후 결과적으로 다음 기능이 실행된다
				
					1) 해당 힙 메모리의 object 타입으로 지정되었던 100을 int형으로 저장
			*/
		
		
		int intvalue = box1.getT();
		System.out.println( intvalue );
		
		
		
		
		
		
		
		
		
		
		
	}
}
