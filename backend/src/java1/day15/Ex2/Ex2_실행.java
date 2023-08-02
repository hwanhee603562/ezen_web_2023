package java1.day15.Ex2;

import java.io.IOException;

public class Ex2_실행 {
	public static void main(String[] args) throws IOException {
		
		// 1. 부모객체 생성
		Parent parent = new Parent();	// 힙 : Parent 객체1개
		
		// 2. 자식객체 생성
		Child child = new Child();		// 힙 : Parent, Child 객체2개
		
		// 3. 자식객체를 부모객체에 대입
		Parent parent2 = child;			// 가능 : 자식객체는 부모객체가 될 수 있다
		// !! : 자식객체가 부모객체로 대입 후에 변환된 부모객체는 자식객체의 멤버로 사용할 수 없다
		// 단, 오버라이딩된 메소드는 사용할 수 있다
			//parent2.method3();		// 불가능
		parent2.method1();				// 가능
		parent2.method2();				// 가능
		
		// 4. 부모객체를 자식객체에 대입
		//Child child2 = parent;		// 불가능 : 부모객체는 자식객체가 될 수 없다
		
		// 강제타입변환 : 캐스팅
		Child child2 = (Child)parent;
		// 단, 강제 캐스팅을 이용하여 형변환 가능
		
		child2.method1();
		child2.method2();
		child2.method3();
		
	}
}
