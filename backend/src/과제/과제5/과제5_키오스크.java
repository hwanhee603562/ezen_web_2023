package 과제.과제5;

import java.util.Scanner;

public class 과제5_키오스크 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String 재고관리 = "";
		/* 재고관리 변수 샘플  */
		재고관리 = "~~~";
		/* ----------- */
		재고관리 = "콜라:사이다:환타,300:200:100,10/10_10";
		//재고관리 = "콜라:사이다:환타|300:200:100|콜라바구니:사이다바구니:환타바구니";
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			/* 문제풀이 위치 */
			//콜라 22,23
			//환타 25,26
			
			

			
			
			
			String str = "";	
			if(ch==1) {
				if(Character.getNumericValue(재고관리.charAt(22)) <= 0) {
					// 콜라재고가 없을 경우
					System.out.println("재고없음");
				}
				else {
					// 콜라재고가 있을 경우
					
					if( 재고관리.charAt(23)==48 ) {
						//콜라재고가 두자릿수인 경우
						
						for(int i=0; i<재고관리.length(); i++) {
							
							if(i==22) {
								str += '9';
							} else if(i==23){
								continue;
							} else {
								str += 재고관리.charAt(i);
							}		
						}
						재고관리 = str;
						str = "";
						System.out.println(재고관리);
						
					} else {
						//콜라재고가 한자릿수인 경우
						for(int i=0; i<재고관리.length(); i++) {
							
							if(i==22){
								str += Integer.toString((Character.getNumericValue(재고관리.charAt(22))-1)).charAt(0);
							} else {
								str += 재고관리.charAt(i);
							}
						}
						재고관리 = str;
						str = "";
					}
				}
			}			
						//콜라:사이다:환타,300:200:100,10/10_10
						// 환타재고가 없을 경우의 문자열
						// 24 25 26 /0/
						// 23 24 25 /0/
						// 25 26 27 /0/
			
			if(ch==2) {
				if(재고관리.split(",")[2].split("/")[1].split("_")[0].equals("0")) {
					// 환타재고가 없을 경우
					System.out.println("재고없음");
				}
				else {
					// 환타재고가 있을 경우
					
					if( 재고관리.split(",")[2].split("/")[1].split("_")[0].equals("10") ) {
						
						//환타재고가 두자릿수인 경우
						
						for(int i=0; i<재고관리.length(); i++) {
							
							int a = 0;
							if(재고관리.charAt(i)=='/') {
								a = i+1;
								str += 재고관리.charAt(i);
							} else if(i==a) {
								str += '9';
							} else if(i==a+1) {
								continue;
							} else {
								str += 재고관리.charAt(i);
							}
							
						}
						재고관리 = str;
						str = "";
						System.out.println(재고관리);
						
					} else {
						//콜라재고가 한자릿수인 경우
						for(int i=0; i<재고관리.length(); i++) {
							
							if(i==22){
								str += Integer.toString((Character.getNumericValue(재고관리.charAt(22))-1)).charAt(0);
							} else {
								str += 재고관리.charAt(i);
							}
						}
						재고관리 = str;
						str = "";
					}
				}
			}
			
			
			
			
			
			
			
			
			/* ----------- */
			
		} // while end 
	} // main end 
	
} // class end 

/*

	 주제 : 키오스크(변수버전)
	 	- 실행예시 사진은 없습니다.
		조건 
		1. 제품 가격/재고/바구니 상태를 하나의 문자열 변수에서 관리 
			// 샘플 : 
					이름 : 콜라 , 환타 , 사이다
					가격 : 300 , 200 , 100
					바구니 : 0 , 0 , 0
			
		2. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
			1. 콜라 2.사이다 3.환타 4.결제
			[ 1~3 선택시 ]
				- 재고가 있을경우 장바구니 담기 / 없으면 '재고부족' 출력
				 
			[ 4 선택시 ] 
				- 현재 장바구니 현황 표시 목록 
				----------------------------------
				제품명	수량	가격
				사이다	1	400
				환타		2	1000
				총가격 : 1400
				- 결제메뉴 표시
					1. 결제 2.취소 
					[결제]
						- 금액 입력받아 총가격에 뺀 잔액 출력 -> 결제 성공시 장바구니 초기화 
						- 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
					[취소]
						- [ 장바구니 초기화 / 재고 다시 되돌리기 ]
 
 */







