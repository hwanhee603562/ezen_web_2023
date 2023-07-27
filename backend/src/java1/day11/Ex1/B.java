package java1.day11.Ex1;

public class B {

	A a = new A();
	
	// B클래스 생성자
	public B() {
		
	}
	
	// 3. 오류발생 : C클래스는 호출이 가능하지만 생성자는 private이므로 호출 불가
	// C c = new C();
}
