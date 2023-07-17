package 과제.과제2.Level1.ex3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_3 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_3 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		/* 문제풀이 위치 */
		
		Scanner sc = new Scanner(System.in);
		
		boolean boolean1 = sc.nextBoolean();
		byte byte1 = sc.nextByte();
		char char1 = sc.next().charAt(0);
		short short1 = sc.nextShort();
		int int1 = sc.nextInt();
		long long1 = sc.nextLong();
		float float1 = sc.nextFloat();
		double double1 = sc.nextDouble();
		
		System.out.println("boolean : "+boolean1);
		System.out.println("byte : "+byte1);
		System.out.println("char : "+char1);
		System.out.println("short : "+short1);
		System.out.println("int : "+int1);
		System.out.println("long : "+long1);
		System.out.println("float : "+float1);
		System.out.println("double : "+double1);
		

		/* ----------- */
	}
}
/* 
	[문제] 그림과 같이 기본자료형을 이용하여 변수 8개를 출력하시오.
	[조건] 
		1. 모든 기본자료형 8개 사용
		2. print() 메소드 사용
		3. scanner 객체 사용하여 입력받기
*/
