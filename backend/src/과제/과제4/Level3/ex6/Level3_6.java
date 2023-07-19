package 과제.과제4.Level3.ex6;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Level3_6 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level3_6 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		/* 문제풀이 위치 */
		
	
		
		System.out.println("메뉴 : 1.예약하기 2.예약취소 3.예약현황 ");
		
		String sum = "000000";
		
		
		while(true) {
			String result = "";
			
			int n1 = scanner.nextInt();
			if(n1==1) {
				System.out.println("예약좌석 선택");
				
				int n3 = scanner.nextInt();
				if(sum.charAt(n3)=='1') {
					System.out.println("예약 실패");
				} else if(sum.charAt(n3)=='0') {
					System.out.println("예약 성공");
					
					for(int i=0; i<6; i++) {
						
						if(i==n3) {
							result += '1';
						}
						else if(true) {
							result += sum.charAt(i);
						}
					}
					sum = result;
				}

			}
			else if(n1==2) {
				System.out.println("예약좌석 취소");
				int n4 = scanner.nextInt();
				
				for(int i=0; i<6; i++) {
					if(i==n4) {
						result += '0';
					}
					else if(true) {
						result += sum.charAt(i);		
					}

				}
				sum = result;
			}
			else if(n1==3) {
				for(int i=0; i<6; i++) {
					if(i==3) {
						System.out.println("\n");
					}
					if(sum.charAt(i)=='0') {
						System.out.print("[]");
					} else if(sum.charAt(i)=='1') {
						System.out.print("[예약]");
					}
				}
			}
		}
		
		
		/* ----------- */

	}
}
/* 
	주제 : 예약 좌석 시스템
	실행결과는 제공하지 않습니다.
	
	- 변수 조건 
		1. 변수 : 6개의 좌석 은 변수를 이용합니다. [ 배열X ]
		2. 그외 자유롭게 사용. 배열/리스트 사용 금지 [ day1~day4 문법 이용 ]
	- 메뉴 조건
		0. 메뉴 : 1.예약하기 2.예약취소 3.예약현황 
	- 기능 조건 
	 	예약하기 출력예시 )
	 		1. 예약할 좌석을 선택한다.
	 		2. 만약에 비어 있으면 예약성공 아니면 예약 실패 
	 	예약취소 출력예시 )
	 		1. 예약할 취소할 좌석을 선택한다.
	 	예약현황 출력예시 )
	 		* 3개씩 2줄로 출력합니다.
			[ 예약 ]	[ ]	[ ]
			[ ] [예약] [ ]  
			- 예약이 되어 있는 좌석은 [예약] 예약이 없으면 [ ] 공란으로 출력합니다.
			
*/
