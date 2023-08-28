package java2.day26_컬렉션프레임워크.Ex3_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex3_예제 {
	public static void main(String[] args) {
		
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		 
		for(int i=0; i<3; i++) {
			list1.add(i+"");
			list2.add(i+"");
		}
		
		
		// 두 객체의 저장 속도 체크
		long startTime;
		long endTime;
		
		// 밀리초( 1/1000 초 )  나노초( 1/1000000000초 )
		startTime = System.nanoTime();
		for( int i=0; i<100000; i++) {
			list1.add( 2, i+"" );
		}
		endTime = System.nanoTime();
		
		System.out.println("ArrayList  10000개를 저장하는데 걸리는 시간 : "+(endTime+startTime));
		
		
		// 밀리초( 1/1000 초 )  나노초( 1/1000000000초 )
		startTime = System.nanoTime();
		for( int i=0; i<100000; i++) {
			list2.add( 2, i+"" );
		}
		endTime = System.nanoTime();
		
		System.out.println("LinkedList 10000개를 저장하는데 걸리는 시간 : "+(endTime+startTime));
		
		
	}
}
