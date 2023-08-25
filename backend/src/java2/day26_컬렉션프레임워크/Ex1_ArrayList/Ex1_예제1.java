package java2.day26_컬렉션프레임워크.Ex1_ArrayList;

import java.util.ArrayList;
import java.util.List;





public class Ex1_예제1 {
	public static void main(String[] args) {
		// ArrayList 컬렉션 객체 생성
		List<Board> list = new ArrayList<>();
		ArrayList<Board> list2 = new ArrayList<>();
			// 위 두 경우는 동일한 구현체다
		
		
		
	// 1. ArrayList 객체 안에 객체 추가
		list.add( new Board( "제목1", "내용1", "글쓴이1" ) );
		list.add( new Board( "제목2", "내용2", "글쓴이2" ) );
		list.add( new Board( "제목3", "내용3", "글쓴이3" ) );
		list.add( new Board( "제목4", "내용4", "글쓴이4" ) );
		list.add( new Board( "제목5", "내용5", "글쓴이5" ) );
		System.out.println("------------- 1 : \n"+list);
		/*
		 	------------- 1 : 
			[Borad [subject=제목1, content=내용1, writer=글쓴이1]
			, Borad [subject=제목2, content=내용2, writer=글쓴이2]
			, Borad [subject=제목3, content=내용3, writer=글쓴이3]
			, Borad [subject=제목4, content=내용4, writer=글쓴이4]
			, Borad [subject=제목5, content=내용5, writer=글쓴이5]
		 */
		
		
		
	// 2. 해당 인덱스 위치에 삽입
		list.add( 0, new Board( "제목6", "내용6", "글쓴이6" ) );
		System.out.println("------------- 2 : \n"+list);
		/*
		 	------------- 2 : 
			[Borad [subject=제목6, content=내용6, writer=글쓴이6]
			, Borad [subject=제목1, content=내용1, writer=글쓴이1]
			, Borad [subject=제목2, content=내용2, writer=글쓴이2]
			, Borad [subject=제목3, content=내용3, writer=글쓴이3]
			, Borad [subject=제목4, content=내용4, writer=글쓴이4]
			, Borad [subject=제목5, content=내용5, writer=글쓴이5]
		 */
		
		
		
	// 3. 해당 인덱스 위치 변경
		list.set( 1, new Board( "제목7", "내용7", "글쓴이7" ) );
		System.out.println("------------- 3 : \n"+list);
		/*
		 	------------- 3 : 
			[Borad [subject=제목6, content=내용6, writer=글쓴이6]
			, Borad [subject=제목7, content=내용7, writer=글쓴이7]
			, Borad [subject=제목2, content=내용2, writer=글쓴이2]
			, Borad [subject=제목3, content=내용3, writer=글쓴이3]
			, Borad [subject=제목4, content=내용4, writer=글쓴이4]
			, Borad [subject=제목5, content=내용5, writer=글쓴이5]
		 */
		
		
		
	// 4. 해당 리스트의 크기
		System.out.println("------------- 4 : \n인덱스 개수 "+list.size()+"개");
		/*
		 	------------- 4 :
		 	인덱스 개수 6개
		 */
		
		
		
	// 5. 인덱스에 저장된 값 확인
		System.out.println("------------- 5 : \n2번 인덱스의 값 "+list.get(2));
		/*
		 	------------- 5 :
		 	2번 인덱스의 값 
		 	Borad [subject=제목2, content=내용2, writer=글쓴이2]
		*/
		
		
		
	// 6. List 안에 특정 객체 검색	[ 반환타입 boolean ]
	//		: 객체가 있으면 true / 없으면 false
		Board board = new Board( "제목8", "제목8", "제목8" );
		list.add( board );
		Board board2 = new Board( "제목9", "제목9", "제목9" );
		System.out.println("------------- 6-1 : \n"+list.contains(board));
		System.out.println("------------- 6-2 : \n"+list.contains(board2));
		System.out.println(list);
		/*
			------------- 6-1 : 
			true
			------------- 6-2 : 
			false
			
			[Borad [subject=제목6, content=내용6, writer=글쓴이6]
			, Borad [subject=제목7, content=내용7, writer=글쓴이7]
			, Borad [subject=제목2, content=내용2, writer=글쓴이2]
			, Borad [subject=제목3, content=내용3, writer=글쓴이3]
			, Borad [subject=제목4, content=내용4, writer=글쓴이4]
			, Borad [subject=제목5, content=내용5, writer=글쓴이5]
			, Borad [subject=제목8, content=제목8, writer=제목8]
		 */
		
		
		
		
	// 7. 비어있는지 확인	[ 반환타입 boolean ]
	//		: 비어있으면 true / 아니면 false
		System.out.println("------------- 7 : \n리스트 isEmpty() - "+list.isEmpty());
		/*
		 	------------- 7 : 
			리스트 isEmpty() - false
		*/
		
		
	
	// 8. 특정 객체 삭제
	//		: list.remove( 인덱스 )		- 해당 인덱스 삭제 후 1칸씩 당겨짐
	//		: list.remove( 객체 ) 		- 해당 객체가 존재할 시 삭제 후 1칸씩 당겨짐
		list.remove(3);
		System.out.println("------------- 8-1 : \nlist.remove(3) - "+list);
		list.remove( board );
		System.out.println("------------- 8-2 : \nlist.remove( board ) - "+list);
		
		/*
		 	------------- 8-1 : 
			list.remove(3) - [Borad [subject=제목6, content=내용6, writer=글쓴이6]
			, Borad [subject=제목7, content=내용7, writer=글쓴이7]
			, Borad [subject=제목2, content=내용2, writer=글쓴이2]
			, Borad [subject=제목4, content=내용4, writer=글쓴이4]
			, Borad [subject=제목5, content=내용5, writer=글쓴이5]
			, Borad [subject=제목8, content=제목8, writer=제목8]
			
			// Borad [subject=제목3, content=내용3, writer=글쓴이3] 삭제
			
			------------- 8-2 : 
			list.remove( board ) - [Borad [subject=제목6, content=내용6, writer=글쓴이6]
			, Borad [subject=제목7, content=내용7, writer=글쓴이7]
			, Borad [subject=제목2, content=내용2, writer=글쓴이2]
			, Borad [subject=제목4, content=내용4, writer=글쓴이4]
			, Borad [subject=제목5, content=내용5, writer=글쓴이5]
		*/
		
		
		
	// List와 for문의 활용
	// 1. for문
		System.out.println("1=================================================");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	
	// 2. 향상된 for문 : 리스트 인덱스 0번 부터 size()-1 까지 반복변수에 순차적으로 대입
		System.out.println("2=================================================");
		for( Board i : list ) {
			System.out.println( i );
		}
		
		
	// 3. [람다식] forEach() 메서드
		// 매개변수 -> { 실행문 }
		System.out.println("3=================================================");
		//list.forEach( b ->{ System.out.println(b); } );
		
	}
}
























