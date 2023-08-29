package java2.day28_컬렉션프레임워크3.Ex1_TreeSet;

import java.util.TreeSet;

/*
 	검색 기능을 강화시킨 컬렉션
 		- 컬렉션 안에 있는 데이터를 검색할 때 효율성 제공 [필수x]
 		- 
 
 */
 

public class Ex1_예제 {
	public static void main(String[] args) {
		
		// 1. TreeSet 객체 생성
		TreeSet<Integer> scores = new TreeSet<>();
		
		// 2. 무작위로 숫자 저장
		scores.add( 87 );
		scores.add( 98 );
		scores.add( 75 );
		scores.add( 95 );
		scores.add( 80 );
		System.out.println( "이진트리 상태 : "+scores );
		// [75, 80, 87, 95, 98] 오름차순 정렬이 되어서 출력됨
		
		// 3. 
		System.out.println("가장 왼쪽 노드 : "+scores.first());
		// 가장 왼쪽 노드 : 75
		System.out.println("가장 오른쪽 노드 : "+scores.last());
		// 가장 오른쪽 노드 : 98
		System.out.println("95점 아래 노드 : "+scores.lower(95));
		// 95점 아래 노드 : 87
		System.out.println("95점 위의 노드 : "+scores.higher(95));
		// 95점 위의 노드 : 98
		System.out.println("95점이거나 아래 노드 : "+scores.floor(95));
		// 95점이거나 아래 노드 : 95
		System.out.println("95점이거나 위 노드 : "+scores.ceiling(95));
		// 95점이거나 위 노드 : 95
		
		// 4. 내림차순
		System.out.println("이진트리 내림차순 : "+scores.descendingSet());
		// 이진트리 내림차순 : [98, 95, 87, 80, 75]
		
		// 5-1. 범위검색 (숫자, 옵션[true(이상), false(초과)])
		System.out.println("이진트리 80 이상 : "+scores.tailSet(80, true));
		// 이진트리 80 이상 : [80, 87, 95, 98]
		
		// 5-2. 범위검색 (시작순서, 옵션, 글숫자, 옵션)
		System.out.println("이진트리 80 이상 90 미만 : "+scores.subSet(80, true, 90, false));
		// 이진트리 80 이상 90 미만 : [80, 87]
	}
}


















