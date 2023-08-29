package java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬.기준2_comparator;

import java.util.TreeSet;

public class Ex4_예제 {

	public static void main(String[] args) {
		
		// 1. (Fruit)정렬 구현객체 생성
		FruitComparator fruitComparator = new FruitComparator();
		
		// 2. TreeSet 객체 생성
		TreeSet<Fruit> treeSet = new TreeSet<>( fruitComparator );
		// ★ 제네릭이 Fruit 이기 때문에 Fruit클래스에 대한 정렬 기준이 필요함
			// 단, 정렬 기준은 Comparator 인터페이스를 정의한 fruitComparator를 생성자로
			// 지정함으로써 정렬 기준은 지정함
		
		// 3. 무작위 Fruit 객체 대입
		treeSet.add( new Fruit("포도", 3000) );
		treeSet.add( new Fruit("수박", 10000) );
		treeSet.add( new Fruit("딸기", 6000) );
		
		System.out.println( "이진트리 상태 : " + treeSet );
		
		
		
	}
}
