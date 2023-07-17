package 과제.과제2.Level1.ex2;

import java.time.LocalDateTime;

public class Level1_2 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_2 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		System.out.printf("%-10s   %15s   %30s\n" , "type" , "value" , "range" );
		System.out.println("-------------------------------------------------------------");
		/* 문제풀이 위치 */
		
		boolean boolean1 = true;
		byte byte1 = 100;
		char char1 = 'A';
		short short1 = 30000;
		int int1 = 2000000000;
		long long1 = 40000000000L;
		float float1 = 3.1231232f;
		double double1 = 3.123123123;
		
		
		System.out.printf("%-10s   %b   %30s\n" , "boolean" , boolean1 , "true of false" );
		System.out.printf("%-10s   %d   %30s\n" , "byte" , byte1 , "-128 ~ 127" );
		System.out.printf("%-10s   %c   %30s\n" , "char" , char1 , "0~65535[ character 1 ]" );
		System.out.printf("%-10s   %d   %30s\n" , "short" , short1 , "-32768 ~ 32767" );
		System.out.printf("%-10s   %d   %30s\n" , "int" , int1 , "-+2000 million" );
		System.out.printf("%-10s   %d   %30s\n" , "long" , long1 , "-+2000 million Excess" );
		System.out.printf("%-10s   %f   %30s\n" , "float" , float1 , "8 decimal places" );
		System.out.printf("%-10s   %f   %30s\n" , "double" , double1 , "17 decimal places" );
		
		
		
		
		/* ----------- */
	}
}
/* 
	[문제] 그림과 같이 기본자료형을 이용하여 변수 8개 선언하고 임의값을 대입하여 출력하시오.
	[조건] 
		1. 모든 기본자료형 8개 사용
		2. printf() 메소드 사용
*/
