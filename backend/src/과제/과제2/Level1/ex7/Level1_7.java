package 과제.과제2.Level1.ex7;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_7 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_7 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		String output = "";
		
		/* 문제풀이 위치 */
		
		String 회원명 = scanner.nextLine();
		boolean 상태 = scanner.nextBoolean();
		byte 회원번호 = scanner.nextByte();
		char 성별 = scanner.next().charAt(0);
		short 나이 = scanner.nextShort();
		int 포인트 = scanner.nextInt();
		long 예금액 = scanner.nextLong();
		float 키 = scanner.nextFloat();
		double 몸무게 = scanner.nextDouble();
		
		System.out.println("===========회원 개인정보===========");
		System.out.println("|          회원명 : "+회원명+"        |");
		System.out.println("|          상태 : "+상태+"          |");
		System.out.println("|          회원번호 : "+회원번호+"     |");
		System.out.println("|          성별 : "+성별+"           |");
		System.out.println("|          나이 : "+나이+"           |");
		System.out.println("|          포인트 : "+포인트+"        |");
		System.out.println("|          예금액 : "+예금액+"        |");
		System.out.println("|          평균 : "+키+"            |");
		System.out.println("|          평균 : "+몸무게+"         |");
		System.out.println("===============================");
		

		/* ----------- */
	}
}
/* 
	[문제조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 기본 자료형8개 + 문자열클래스 변수 1개 를 이용한 9개변수를 입력 받습니다.
		3. 입력받은 9개 변수를 그림과 같이 출력합니다.
		4. 기존에 미리 작성된 변수를 최대한 활용합니다.
		
*/
