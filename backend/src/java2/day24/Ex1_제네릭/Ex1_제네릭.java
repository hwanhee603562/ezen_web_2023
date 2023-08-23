package java2.day24.Ex1_제네릭;

import 과제.과제11.model.dto.MemberDto;

public class Ex1_제네릭 {
	public static void main(String[] args) {
		
		/* 목적 : 하나의 필드에 여러 타입의 데이터를 저장하고 싶을 때 */
			
		// 1. 제네릭을 사용하지 않을 때 = > Object
		Box2 box2 = new Box2();
		
			// 1. 자식객체는 부모객체로 대입[자동타입변환] : 무조건 가능
		box2.content = 1;	// 1[int] 
		box2.content = "안녕";
		box2.content = new MemberDto();
		
			// 2. 부모는 자식의 멤버를 사용할 수 없다 [형변환] : 강제타입변환
	
			// 강제타입변환하는 방법 2가지
				// 1. 타입을 알고 있을 경우 (형변환할 타입)
		MemberDto dto = (MemberDto)box2.content;
		dto.getMpw();
				// 2. instanceof 타입 조사 후 사용
					// 모든 클래스를 조사해야할 경우 비효율적이므로 권장X
		if( box2.content instanceof MemberDto) {}
		  
		// 2. 제네릭을 사용할 때
		// 2-1
		Box<String> box1 = new Box<>();
			// 1. Box 클래스에 넣을 타입 선정 < >
				// String content;
		
		box1.content = "안녕하세요";
		String str = box1.content;
		System.out.println( str );
		
		// 2-2
		Box<Integer> box3 = new Box<>();
			// 2. Box 클래스에 넣을 타입 선정 < >
		box3.content = 100;
		int value = box3.content;
		System.out.println( value );
		
		
		// -------------------------------
		
		Box<MemberDto> box4 = new Box<>();
		box4.content = new MemberDto();
		MemberDto dto2 = box4.content;
		System.out.println( dto2 );
		
		
		
		
	}
}
