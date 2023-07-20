package java1.day06;

import java.util.Arrays;

public class Ex1_배열 {
	public static void main(String[] args) {
		
		// 1. 선언
		String[] season = {"spring", "summer", "fall", "winter"};
			// String : String 클래스(타입)으로 배열 선언 = String데이터만 저장 가능!!
			// {값1, 값2, 값3} : 배열에 저장할 데이터 순서대로 작성
		
		// 2. 호출
		System.out.println(season);
		System.out.println( Arrays.toString(season) );
		// Arrays.toString( 배열변수명 )	// 주소를 찾아서 배열의 정보 호출
		
		System.out.println(season[0]);
		System.out.println(season[1]);
		System.out.println(season[2]);
		System.out.println(season[3]);
		
		// 3. 변경( 새로운 값 대입 )
		season[1] = "여름";
		System.out.println( season[1] );
		
		// 4. 삭제( 없음 : 배열은 선언될 때 고정 )
		season[1] = null;
		System.out.println(Arrays.toString( season ));
		
		// 5. 추가( 없음 : 배열은 선언될 때 고정 )
		if( season[1] == null) season[1] = "초여름";
		else System.out.println("공간이 부족합니다");
		System.out.println( Arrays.toString(season));
		
		
		int[] scores = {83, 90, 87};
		// int형 배열 선언하고 3개의 정수를 초기화함
		
		
		int sum = 0;
		for(int i=0; i<=2; i++) {
			sum += scores[i];
			
		}
		System.out.println("총합 : "+sum);
		System.out.println("평균 : "+sum/3.0);
		

		// 1. int형 배열 선언 - 초기값 1
			// 1. new 연산자를 이용한 배열 선언
			int[] arr1 = new int[3];
				System.out.println( Arrays.toString(arr1));
				
			// 2. 배열 내 모든 데이터 호출
			for(int i=0; i<3; i++) {
				System.out.println( arr1[i] );
			}
			
			// 3. 배열내 값 변경
			arr1[0] = 10;
			arr1[1] = 20;
			arr1[2] = 30;
			
			System.out.println(Arrays.toString(arr1));

		
		//2. double형 배열 - 초기값 0.0
			//1. new 연산자를 이용한 배열선언
			double[] arr2 = new double[3];
				System.out.println( Arrays.toString(arr2));

			//2. 배열내 모든 데이터 호출 // 길이를 모르는 경우 => 배열명.length : 배열의 길이 수 반환	
			for(int i=0; i<arr2.length; i++) {
				System.out.println(arr2[i]);
			}
			
			arr2[0] = 0.1;
			arr2[1] = 0.2;
			arr2[2] = 0.3;
			
			System.out.println(Arrays.toString(arr2));
			
			
		//3. String 클래스 배열 - 초기값 null
			String[] arr3 = new String[3];
			
			for(int i=0; i<arr3.length; i++) {
				System.out.println(arr3);
			}
			
			arr3[0] = "1월";
			arr3[1] = null;
			arr3[2] = "3월";
			
			System.out.println(Arrays.toString(arr3));
			
			// * 값 추가 ( 불가능 : 배열은 선언시 고정 길이이므로, null 빈공간을 있으면 값 변경 )
			for(int i=0; i<arr3.length; i++) {
				if(arr3[i] == null) {
					arr3[i] = "5월";
					break;
				}
			}
			System.out.println(Arrays.toString(arr3));
			

	}

}
