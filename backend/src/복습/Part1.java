package 복습;

import java.util.Scanner;

public class Part1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int 콜라재고 = 10 ; int 환타재고 = 3; int 사이다재고 = 2;
		int 콜라바구니 = 0 ; int 환타바구니 = 0 ; int 사이다바구니 = 0;
		int 콜라가격 = 300 ; int 환타가격 = 200 ; int 사이다가격 = 100 ;
			
		/*
		 3. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ]
	    1. 콜라 2.사이다 3.환타 4.결제
	            [ 1~3 선택시 ]
	                - 재고가 있을경우 바구니 담기 / 없으면 '재고부족' 출력
	
	            [ 4 선택시 ]
	                - 현재 바구니 현황 표시 목록[ * 바구니가 0보다 컸을경우에만 출력합니다 ]
	                    ----------------------------------
	                        제품명 수량 가격
	                        사이다 1 400
	                        환타 2 1000
	                        총가격 : 1400
	                - 결제메뉴 표시
	                    1. 결제 2.취소
	                        [결제 선택시]
	                        - 금액을 입력받아 바구니의 총가격에 뺀 잔액 출력 -> 결제 성공시 바구니 초기화 하기
	                        - 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
	                        [취소 선택시]
	                        - 장바구니 초기화 / 재고 다시 되돌리기
		 **/
		
		while(true) {
			System.out.println("---------메뉴--------");
			System.out.println("1.콜라 2.환타 3.사이다 4.결제");
			int ch = sc.nextInt();
			
			if(ch==1) {
				System.out.println(">>>>선택1");
				if(콜라재고<=0) {
					System.out.println("안내) 콜라재고가 없습니다. [관리자에게 문의]");
				} else {
					System.out.println("안내) 콜라 담았습니다");
					콜라재고--;
					콜라바구니++;
				}
				
				
			} else if(ch==2) {
				System.out.println(">>>>선택2");
				if(환타재고<=0) {
					System.out.println("안내) 환타재고가 없습니다. [관리자에게 문의]");
				} else {
					System.out.println("안내) 환타 담았습니다");
					환타재고--;
					환타바구니++;
				}
				
			} else if(ch==3) {
				System.out.println(">>>>선택3");
				if(사이다재고<=0) {
					System.out.println("안내) 사이다재고가 없습니다. [관리자에게 문의]");
				} else {
					System.out.println("안내) 사이다 담았습니다");
					사이다재고--;
					사이다바구니++;
				}
			} else if(ch==4) {
				System.out.println(">>>>선택4");
				System.out.println("1. 결제 2. 취소");
				int ch2 = sc.nextInt();
				int sum = (콜라바구니*콜라가격)+(환타바구니*환타가격)+(사이다바구니*사이다가격);
				
				if(ch2 == 1) {
					System.out.println(">>>>선택4");
					System.out.println("-------------------");
					System.out.println("제품명\t수량\t가격");
					
					if(콜라바구니>0) {
						System.out.println("콜라\t"+콜라바구니+"\t콜라가격");
					}
					if(환타바구니>0) {
						System.out.println("환타\t"+환타바구니+"\t환타가격");
					}if(사이다바구니>0) {
						System.out.println("사이다\t"+사이다바구니+"\t사이다가격");
					}
					
					System.out.println("총가격\t"+sum);
					System.out.println("1.결제 2.취소");	
					
					int p = sc.nextInt();
					if(p==1) {
						System.out.println("안내금액투여 : ");	
						int z = sc.nextInt();
						if(sum<=z) {
							System.out.println("잔액 : "+(z-sum));
							
							콜라바구니=0;
							사이다바구니=0;
							환타바구니=0;
							
						} else {
							System.out.println("금액부족");
							콜라재고 += 콜라바구니;
							사이다재고 += 사이다바구니;
							환타재고 += 환타바구니;
							
							콜라바구니=0;
							사이다바구니=0;
							환타바구니=0;
						}
					}
					
					
				}else if(ch2 == 2) {

					콜라재고 += 콜라바구니;
					사이다재고 += 사이다바구니;
					환타재고 += 환타바구니;
					
					콜라바구니=0;
					사이다바구니=0;
					환타바구니=0;
					
				}
				
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	}
}
