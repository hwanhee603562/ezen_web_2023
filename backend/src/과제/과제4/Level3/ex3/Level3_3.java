package 과제.과제4.Level3.ex3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level3_3 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level3_3 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		
		int july1 = 3532100; 
		int july2 = 9123700;
		int july3 = 5183400;
		int july4 = 11738700;
		
		/* 문제풀이 위치 */
		
		
		String str1 = String.valueOf(july1);
		String str11 = "";
		for(int i=0; i<str1.length()-6; i++) {
			str11 += str1.charAt(i);
		}
		int s1 = Integer.parseInt(str11);
		for(int i=0; i<s1; i++) {
			System.out.print('■');
		}
		
		for(int i=0; i<str1.length()-4; i++) {
			System.out.print(str1.charAt(i));
		}
		System.out.print("만원\n");
		
		
		
		
		
		
		String str2 = String.valueOf(july2);
		String str22 = "";
		for(int i=0; i<str2.length()-6; i++) {
			str22 += str2.charAt(i);
		}
		int s2 = Integer.parseInt(str22);
		for(int i=0; i<s2; i++) {
			System.out.print('■');
		}
		
		for(int i=0; i<str1.length()-4; i++) {
			System.out.print(str2.charAt(i));
		}
		System.out.print("만원\n");
		
		
		
		
		
		
		
		String str3 = String.valueOf(july3);
		String str33 = "";
		for(int i=0; i<str3.length()-6; i++) {
			str33 += str3.charAt(i);
		}
		int s3 = Integer.parseInt(str33);
		for(int i=0; i<s3; i++) {
			System.out.print('■');
		}
		
		for(int i=0; i<str1.length()-4; i++) {
			System.out.print(str3.charAt(i));
		}
		System.out.print("만원\n");
		
		
		
		
		
		
		
		String str4 = String.valueOf(july4);
		String str44 = "";
		for(int i=0; i<str4.length()-6; i++) {
			str44 += str4.charAt(i);
		}
		int s4 = Integer.parseInt(str44);
		for(int i=0; i<s4; i++) {
			System.out.print('■');
		}
		
		for(int i=0; i<str1.length()-4; i++) {
			System.out.print(str4.charAt(i));
		}
		System.out.print("만원\n");
		
		
		
		/* ----------- */
	}
}
/* 
	[문제] 
		다음과 같이 july1,july2,july3,july4 변수는 7월의 1주차,2주차,3주차,4주차 의 매출액이 저장된 변수 입니다.
		1. 주차별로 100만원당 도형 '■' 출력하시오.
		2. 도형 뒤로는 그림과 같이 만원대 까지만 출력하시오.
	[조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.

*/
