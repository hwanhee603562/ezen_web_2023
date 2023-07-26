package 복습.part3;

import java.util.Scanner;

public class part3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] 재고관리 = { "10,0,300,콜라" , "3,0,200,환타" , "2,0,100,사이다"};
		
		while(true) {
			
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			
			int ch = sc.nextInt();
			if(ch==1||ch==2||ch==3) {
				
				String n = 재고관리[ch-1];
				
				int 재고 = Integer.parseInt(n.split(",")[0]);
				int 바구니 = Integer.parseInt(n.split(",")[1]);
				int 가격 = Integer.parseInt(n.split(",")[2]);
				String 이름 = n.split(",")[3];
				
				if(재고<=0) {
					System.out.println("재고부족");
				} else {
					재고--;
					바구니++;
					System.out.println(이름+" 담았습니다");
				}
				재고관리[ch-1] = 재고+","+바구니+","+가격+","+이름;
				
			} else if(ch==4) {
				System.out.println("제품명\t수량\t가격");
				int sum = 0;
				
				for(int i=0; i<재고관리.length; i++) {
					
					int 바구니1 = Integer.parseInt(재고관리[i].split(",")[1]);
					int 가격1 = Integer.parseInt(재고관리[i].split(",")[2]);
					String 이름1 = 재고관리[i].split(",")[3];
					
					if(바구니1>0) {
						System.out.println(이름1+"\t"+바구니1+"\t"+(바구니1*가격1));
						sum += 바구니1*가격1;
					}
				}
				System.out.println("총가격 : "+sum);
				
			}
		}
		
	}
}
