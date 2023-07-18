package java1.day04;

import java.util.Scanner;

public class Ex1_반복문 {
	public static void main(String[] args) {
		
		int sum = 0;
		
		sum = sum+1;
		sum += 2;
		sum += 3;
		sum += 4;
		sum += 5;
		sum += 6;
		sum += 7;
		sum += 8;
		sum += 9;
		sum += 10;
		
		int sum2 = 0;
		for(int i=1; i<=10; i++){
			sum2 += i;
			System.out.println(sum2);
		}
		
		System.out.println("-------------------------");
		
		int sum3 = 0;
		for(int 반복변수=1; 반복변수<=100; 반복변수++){
			sum3 += 반복변수;
		}
		
		
		int sum4 = 0;
		int i;
		for(i = 1; i<=100; i++){
			sum4 += i;
		}
		System.out.println("1~" + (i-1)+" 합 : "+sum4);
		
		
		for(float x = 0.1f; x<=1.0f; x+=0.1f) {
			System.out.println(x + " ");
		}
		System.out.println("1~" + (i-1)+" 합 : "+sum4);
		
		
		for( double x = 0.1; x<=1.0; x+=0.1) {
			System.out.println( x + " ");
		}
		
		System.out.println("-------------------------");
		
		
		
		for(int 곱=1; 곱<=9; 곱++) {
			System.out.println( 2 * 곱 + " ");
		}
		
		
		
		for(int 단=2; 단<=9; 단++) {
			System.out.println(단);
		}
		for(int 곱=1; 곱<=9; 곱++) {
			System.out.println(곱);
		}
		
		
		for(int 단=2; 단<=9; 단++) {
			for(int 곱=1; 곱<=9; 곱++) {
				System.out.printf("%2d X %2d = %2d \n", 단, 곱, 단*곱);
			}
		}	// 78회 출력
		
		
		System.out.println("-------------------------");
		
		int a = 1;
		while( a<=10 ) {
			System.out.println(a+" ");
			a++;
		}
		
		int sum5 = 0;
		int b = 1;
		while( b<=100 ) {
			sum5 += b;
			b++;
		}
		
		/*
		while(true) {
			System.out.println("무한반복");
		}
		*/
		
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		int speed = 0;
		
		while(run) {
			System.out.println("-----------------------");
			System.out.println("1. 종속 | 2. 감속 | 3. 중지");
			System.out.println("-----------------------");
			System.out.println("선택 : ");
			
			String strNum = scanner.nextLine();
			
			if(strNum.equals("1")) {
				speed++;
				System.out.println("현재속도 = "+speed);
			} else if(strNum.equals("2")) {
				speed--;
				System.out.println("현재속도1 = "+speed);
			} else if(strNum.equals("3")) {
				run = false;
				// or break;
				// or return;
			}
		}
		
		System.out.println("반복문 종료후 코드");
		
		//1. for문에 식별이름 정의 : for이름 : for(){}
		
		//2. break;
		
		//2. break for(이름);
			// : 해당 for 탈출, continue for 이름
		
		//3. continue;
			// : 가장 가까운 반복문 for증감식/while조건식으로 이동;
		
		//3. continue for이름;
			// : 해당 for 반복문 증감식/조건식으로 이동;
		// 공통점 : break; continue;	아래 코드는 실행x
		
		
		대문자for : for( char upper = 'A'; upper <= 'Z'; upper++ ) {
			System.out.println( upper+" " );
			
			소문자for : for(char lower = 'a'; lower <= 'z'; lower++ ) {
				System.out.print("\t"+ lower);
				// * 특정 for break;
				if( lower =='g' ) break 대문자for;
				
			}
			System.out.println('\n');
		}
		
		
		숫자for : for(int j=1; j<=10; j++) {
			if(j%2 != 0) {	// 홀수 찾기
				continue 숫자for;
			}
			System.out.println(j + " ");
		}
		
		
		
	}
}










