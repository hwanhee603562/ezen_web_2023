package java2.day27_컬렉션프레임워크2.Ex3_HashTable;

import java.util.Hashtable;
import java.util.Map;

public class Ex3_예제 {
	public static void main(String[] args) {
		
		// 1. HashTalbe 객체에 String, Integer 2개 객체를 저장하는 map객체 선언
		Map<String, Integer> map = new Hashtable<>();
		
			// 1-1. //------ 멀티스레드를 이요한 각 1000개씩 2000개를 동시 저장
		Thread threadA = new Thread() {
			public void run() {
				for( int i=1; i<=1000; i++ ) {
					map.put( String.valueOf(i), i );
				}
			};
		};
			// 1-2. 
		Thread threadB = new Thread() {
			public void run() {
				for( int i=1001; i<=2000; i++ ) {
					map.put( String.valueOf(i), i );
				}
			};
		};
		
		// 두 스레드 실행
		threadA.start();
		threadB.start();

		// main스레드는 다른 두 스레드가 적업(저장)이 끝날 때까지 main스레드 잠시 대기
		try {
			threadA.join();
			threadB.join();
		} catch (Exception e) {}
		
		System.out.println( "map 상태 : "+map );
		System.out.println( map.size() );
		
		// join을 하지 않을 시 map은 비어있음
		//	 	: 두 스레드가 저장을 하기 전에 main스레드가 출력을 먼저 했기 때문
		

		
	}
}












