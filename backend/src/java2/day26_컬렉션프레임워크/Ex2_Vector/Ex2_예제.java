package java2.day26_컬렉션프레임워크.Ex2_Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import java2.day26_컬렉션프레임워크.Ex1_ArrayList.Board;

public class Ex2_예제 {
	public static void main(String[] args) {
		
		//List<Board> list = new Vector<>();
		List<Board> list = new ArrayList<>();
		
		// 2. 작업 스레드 A추가
		// Thread threadA = new Thread(){};		
		Thread threadA = new Thread(){
			public void run() {
				for(int i=0; i<=1000; i++) {
					list.add( new Board( "제목", "내용", "글쓴이" ) );
				}
			}
		};
		// 2. 작업 스레드 B추가
		Thread threadB = new Thread(){
			public void run() {
				for(int i=1001; i<=2000; i++) {
					list.add( new Board( "제목", "내용", "글쓴이" ) );
				}
			}
		};
		
		
		// 3. 스레드 실행
		threadA.start();
		threadB.start();
		
		// 4. main 스레드 대기상태 만들기 [ 두 스레드의 작업이 모두 끝날때까지 main 스레드 기다림 => 작업결과를 확인하기위함 ]
		try {
			threadA.join();
			threadB.join();
		} catch (Exception e) {
			
		}
		System.out.println("두 스레드가 추가한 리스트에 추가한 객체수 : "+list.size());
		
		
	}
}



















