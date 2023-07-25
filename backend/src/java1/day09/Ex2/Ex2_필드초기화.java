package java1.day09.Ex2;

public class Ex2_필드초기화 {
	
	public static void main(String[] args) {
		
		
		
		// 1. 필드초기화
			// 1. 기본생성자	: 객체 생성시 초기화X
		Korean k = new Korean();
			System.out.println("기본생성자 : "+k.nation);
			System.out.println("기본생성자 : "+k.name);
			// 2. 정의한 생성자	: 객체 생성시 해당 매개변수를 초기화
			// 힙생성은 "박자바","011225-1234567",new Korean으로 3개가 생성됨
			// 문자열의 '리터럴'로 들어갔기 때문
		Korean k1 = new Korean("박자바", "011225-1234567");
			System.out.println("정의한생성자 : "+k1.nation);
			System.out.println("정의한생성자 : "+k1.name);
			
			// 3. 정의한 생성자2 :
		Korean k2 = new Korean("김자바", "930525-0654321");
			System.out.println("정의한생성자2 : "+k2.nation);
			System.out.println("정의한생성자2 : "+k2.name);
			
		
			
		// 2. 생성자 오버로딩
		//Korean k1 = new Korean()	ctrl + 스페이스바를 사용하여 직접 만든 생성자를 확인가능
			
	}
}
// 오버로딩 : 동일한 메서드명으로 선언 불가능
	//해결책 : 매개변수의 개수/타입/순서를 이용한 메서드 식별 => 동일한 메서드명도 여러개 선언
