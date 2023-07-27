package java1.day11.Ex2;

import java1.day11.Ex1.*;

public class C {

	// 1. 오류발생 : A와 C클래스는 다른 패키지
	//	A a = new A)(); 
	
	
	// 2. B클래스의 접근제어가 public이므로 가능
	B b = new B();
	
	// C클래스 생성자
	private C() {}
	
	
	
	
}
