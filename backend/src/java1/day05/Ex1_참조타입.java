package java1.day05;

public class Ex1_참조타입 {
	public static void main(String[] args) {
		
		int[] arr1;
		int[] arr2;
		int[] arr3;
		
		arr1 = new int[] {1, 2, 3};
		// 배열 {1, 2, 3}을 생성[ 힙 영역에 메모리할당 ] 하고 [할당된주소를] 스택영역변수에 대입
		arr2 = new int[] {1, 2, 3};
		arr3 = arr2;
		// arr3, arr2는 값은 같을 수 있지만 arr3에 대입함과 동시에 새로운 주소값을 생성하여 값을 할당하기에 같다고 할 수 없음
		
		
				
		
		
		
		int[] intArray = null;
		// int[] intArray 스택영역에 변수가 메모리 할당, 참조 중인 객체번지x // 힙 영역x
		
		String str = null;
		//System.out.println( str.length() );
		
		String hobby = "여행";
			// 1. 스택영역에 hobby 지역변수 선언
			// 2. 힙영역에 "여행" 문자열 객체 생성
			// 3. 생성된 힙영역에 "여행"객체의 주소/번지[32번지]를 스택영역에 hobby 지역변수에게 대입
			// * hobby = [ 32번지 ] 주소
		hobby = null;
			// 4. 스택영역에 hobby 지역변수에 null 대입 [ 대입 : 새로운 값으로 대체 ]
			// 5. 아무도 힙 영역에 있는 "여행" 문자열 객체를 참조하지 않으면 GC쓰레기수집기 자동으로 객체 삭제
		
		
		// '==' 값을 비교하며 기본형 변수타입에서 사용
		// 'equals' String클래스에서 구현된 것으로 주소값을 비교하여 동일한 주소값을 가리키는지 확인
		// 단, new 가 아닌 '리터럴'로 입력받은 문자열 객체는 == 가능 
		String kind1 = "자동차";	// 스택영역 : kind1 [32번지]	힙영역 : "자동차" 객체 [32번지] 
		String kind2 = kind1;	// 스택영역 : kind2 [32번지]
				
		// 리터럴로 입력받은 값으로써 '=='을 사용하여도 같음
		if(kind1==kind2){
			System.out.println("1");
		}
		
		
		
		
		
		
	}

}
