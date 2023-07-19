package 과제.과제5;

import java.util.Scanner;

public class 과제5_키오스크 {
	
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String 재고관리 = "";
		/* 재고관리 변수 샘플  */
		재고관리 = "~~~";
		/* ----------- */
		재고관리 = "콜라:환타:사이다,300:200:100,10:10:10,0:0:0";
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			String str = "";	
			if(ch==1) {	// 콜라재고 없을 경우
				if(Integer.parseInt(재고관리.split(",")[2].split(":")[0])<=0) {
					System.out.println("재고없음");
				} else {	// 콜라재고 있을 경우
					str = 재고관리.substring(0, 22);
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[2].split(":")[0])-1)+":";
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[2].split(":")[1]))+":";
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[2].split(":")[2]))+",";
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[3].split(":")[0])+1)+":";
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[3].split(":")[1]))+":";
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[3].split(":")[2]));
					재고관리 = str;
					str = "";
				}
			} else if(ch==2) {	// 환타재고 없을 경우
				if(Integer.parseInt(재고관리.split(",")[2].split(":")[1])<=0) {
					System.out.println("재고없음");
				} else {	// 환타재고 있을 경우
					str = 재고관리.substring(0, 22);
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[2].split(":")[0]))+":";
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[2].split(":")[1])-1)+":";
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[2].split(":")[2]))+",";
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[3].split(":")[0]))+":";
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[3].split(":")[1])+1)+":";
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[3].split(":")[2]));
					재고관리 = str;
					str = "";
				}
			} else if(ch==3) {	// 사이다재고 없을 경우
				if(Integer.parseInt(재고관리.split(",")[2].split(":")[2])<=0) {
					System.out.println("재고없음");
				} else {	// 사이다재고 있을 경우
					str = 재고관리.substring(0, 22);
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[2].split(":")[0]))+":";
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[2].split(":")[1]))+":";
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[2].split(":")[2])-1)+",";
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[3].split(":")[0]))+":";
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[3].split(":")[1]))+":";
					str += String.valueOf(Integer.parseInt(재고관리.split(",")[3].split(":")[2])+1);
					재고관리 = str;
					str = "";
				}
			} else if(ch==4) {
				System.out.println("제품명\t수량\t가격");
				if(Integer.parseInt(재고관리.split(",")[3].split(":")[0])>0){
					System.out.println("콜라\t"+Integer.parseInt(재고관리.split(",")[3].split(":")[0])+"\t"+(Integer.parseInt(재고관리.split(",")[3].split(":")[0])*300));
				}
				if(Integer.parseInt(재고관리.split(",")[3].split(":")[1])>0){
					System.out.println("환타\t"+Integer.parseInt(재고관리.split(",")[3].split(":")[1])+"\t"+(Integer.parseInt(재고관리.split(",")[3].split(":")[1])*200));
				}
				if(Integer.parseInt(재고관리.split(",")[3].split(":")[2])>0){
					System.out.println("사이다\t"+Integer.parseInt(재고관리.split(",")[3].split(":")[2])+"\t"+(Integer.parseInt(재고관리.split(",")[3].split(":")[2])*100));
				}
				System.out.println("총가격 : "+((Integer.parseInt(재고관리.split(",")[3].split(":")[0])*300)+(Integer.parseInt(재고관리.split(",")[3].split(":")[1])*200)+(Integer.parseInt(재고관리.split(",")[3].split(":")[2])*100)));
				System.out.println("1. 결제 2. 취소");
				int ch2 = scanner.nextInt();
				if(ch2 == 1){
					System.out.println("금액을 입력해주세요");
					int ch3 = scanner.nextInt();
					if(ch3 >= ((Integer.parseInt(재고관리.split(",")[3].split(":")[0])*300)+(Integer.parseInt(재고관리.split(",")[3].split(":")[1])*200)+(Integer.parseInt(재고관리.split(",")[3].split(":")[2])*100))){
						System.out.println("잔돈"+(ch3-((Integer.parseInt(재고관리.split(",")[3].split(":")[0])*300)+(Integer.parseInt(재고관리.split(",")[3].split(":")[1])*200)+(Integer.parseInt(재고관리.split(",")[3].split(":")[2])*100))));
						str = 재고관리.substring(0, 22);
						str += String.valueOf(Integer.parseInt(재고관리.split(",")[2].split(":")[0]))+":";
						str += String.valueOf(Integer.parseInt(재고관리.split(",")[2].split(":")[1]))+":";
						str += String.valueOf(Integer.parseInt(재고관리.split(",")[2].split(":")[2]))+",";
						str += "0:";
						str += "0:";
						str += "0";
						재고관리 = str;
						str = "";
					} else {
						System.out.println("결제취소");
						str = 재고관리.substring(0, 22);
						str += String.valueOf((Integer.parseInt(재고관리.split(",")[2].split(":")[0]))+Integer.parseInt(재고관리.split(",")[3].split(":")[0]))+":";
						str += String.valueOf((Integer.parseInt(재고관리.split(",")[2].split(":")[1]))+Integer.parseInt(재고관리.split(",")[3].split(":")[1]))+":";
						str += String.valueOf((Integer.parseInt(재고관리.split(",")[2].split(":")[2]))+Integer.parseInt(재고관리.split(",")[3].split(":")[2]))+",";
						str += "0:";
						str += "0:";
						str += "0";
						재고관리 = str;
						str = "";
					}
				} else if(ch2 == 2){
					System.out.println("결제취소");
						str = 재고관리.substring(0, 22);
						str += String.valueOf((Integer.parseInt(재고관리.split(",")[2].split(":")[0]))+Integer.parseInt(재고관리.split(",")[3].split(":")[0]))+":";
						str += String.valueOf((Integer.parseInt(재고관리.split(",")[2].split(":")[1]))+Integer.parseInt(재고관리.split(",")[3].split(":")[1]))+":";
						str += String.valueOf((Integer.parseInt(재고관리.split(",")[2].split(":")[2]))+Integer.parseInt(재고관리.split(",")[3].split(":")[2]))+",";
						str += "0:";
						str += "0:";
						str += "0";
						재고관리 = str;
						str = "";
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







