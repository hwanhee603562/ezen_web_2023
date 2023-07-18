package java1.day04;

import java.util.Scanner;

public class Ex2_확인문제7 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = 0;
		
		while(true) {
			System.out.println("--------------------------------");
			System.out.println("1.예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("--------------------------------");
			System.out.println("선택>");
			
			
			switch(sc.nextInt()) {
				case 1 :
					System.out.println("예금액>");
					n += sc.nextInt();
					break;
				case 2 :
					System.out.println("출금액>");
					n -= sc.nextInt();
					break;
				case 3 : 
					System.out.println("잔고>"+n);
					break;
				case 4 : 
					System.out.println("프로그램종료");
					return;
			}
			
		}
		
		
		
		
		
		
		
		

		
		
	}
}
