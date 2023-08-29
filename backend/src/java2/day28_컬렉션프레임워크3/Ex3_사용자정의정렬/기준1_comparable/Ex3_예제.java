package java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬.기준1_comparable;

import java.util.TreeMap;
import java.util.TreeSet;

public class Ex3_예제 {
	public static void main(String[] args) {
		
		// - Integer, String, Double 정렬 기준이 명확 (숫자, 문자 이므로)
		// - 사용자정의 클래스인 MemberDto( 여러개 필드 ) 정렬 기준이 명확하지 않음
		
		// 1. compareTo메소드[ Comparable 인터페이스로부터 구현 ] 이용한 정렬 기준 만들기
			// ★ 제네릭이 Person 이기 때문에 Person클래스에 대한 정렬 기준이 필요함
		TreeSet<Person> treeSet = new TreeSet<>();
			// comparable 로 부터 구현된 클래스의 객체만 저장 가능
		
		// 2. 무작위 person 객체 대입
		treeSet.add( new Person("홍길동", 45) );
		treeSet.add( new Person("김자바", 25) );
		treeSet.add( new Person("박지원", 31) );
		treeSet.add( new Person("유재석", 10) );
		
		System.out.println( "이진트리 상태 : "+treeSet );
		
	}
}
