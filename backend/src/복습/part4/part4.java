package 복습.part4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class part4 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
	// 파일 내 재고

	
	//byte[] byteArr = new byte[ (int)file.length() ]; 	// 파일의 용량만큼의 배열 선언 
	//fileInputStream.read( byteArr ); 		// 파일 문자 바이트배열에 저장 
	//String fileName = new String( byteArr ); 		// 문자열로 형변환

		
		while(true) {
			String fileName = "./src/복습/part4/재고.txt";
			FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
			FileInputStream fileInputStream = new FileInputStream(fileName);
			
			File file = new File( fileName );
			
			byte[] byteArr = new byte[ (int)file.length() ];
			fileInputStream.read( byteArr );
			String fileStr = new String( byteArr );
		
			String[] 재고관리 = fileStr.split("z"); 
		
			System.out.println("-------------메뉴-------------");
			System.out.print("-1:제품등록 0:결제 ");

			
			for(int i=0; i<재고관리.length; i++) {
				if(!재고관리[i].equals("")) {
					
					// "콜라,10,300,0 :" :로 제품 구분
					String name = 재고관리[i].split(",")[0];
					int stock = Integer.parseInt(재고관리[i].split(",")[1]);
					int price = Integer.parseInt(재고관리[i].split(",")[2]);
					int basket = Integer.parseInt(재고관리[i].split(",")[3]);
					
					if(stock <= 0) {
						System.out.print( (i+1)+":"+name+"[재고없음] " );
					} else {
						System.out.print( (i+1)+":"+name+"["+price+"] " );
					}

				}
				
				
			}
			System.out.print("\n>>>>>>선택");
			

			int ch = sc.nextInt();
			
			if(ch==-1) {
				System.out.println("제품명 : ");
				String name = sc.next();
				System.out.println("초기재고 : ");
				int stock = sc.nextInt();
				System.out.println("가격 : ");
				int price = sc.nextInt();
				int basket = 0;
				
				String str = name+","+stock+","+price+","+basket+"z";
				
				fileOutputStream.write(str.getBytes());
				System.out.println("안내) 제품이 등록되었습니다");
				
			} else if(ch>0 && ch<=재고관리.length) {
				
				String name = 재고관리[ch-1].split(",")[0];
				int stock = Integer.parseInt(재고관리[ch-1].split(",")[1]);
				int price = Integer.parseInt(재고관리[ch-1].split(",")[2]);
				int basket = Integer.parseInt(재고관리[ch-1].split(",")[3]);
				
				if(stock <= 0) {
					System.out.println(name+"제품의 재고가 부족합니다");
				} else {
					stock--;
					basket++;
					
					// "콜라,10,300,0:" :로 제품 구분
					재고관리[ch-1] = name+","+stock+","+price+","+basket;
					
					FileOutputStream fileOutputStream1 = new FileOutputStream(fileName);
					String str = "";
					for(int i=0; i<재고관리.length; i++) {
						str += 재고관리[i]+"z";
					}
					
					
					
					fileOutputStream1.write(str.getBytes());
					
					System.out.println(name+" 제품을 담았습니다");
				}
			} else if(ch==0) {
				System.out.println("\t제품명\t수량\t가격");
				
				for(int i=0; i<재고관리.length; i++) {
					if(Integer.parseInt(재고관리[i].split(",")[3])>0) {
						System.out.print("\t"+재고관리[i].split(",")[0]+"\t");
						System.out.print(재고관리[i].split(",")[3]+"\t");
						
						int a = Integer.parseInt(재고관리[i].split(",")[2]);
						int b = Integer.parseInt(재고관리[i].split(",")[3]);
						System.out.print((a*b)+"\n");
						
					}
				}
				int n = sc.nextInt();
			}
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
	}
	
}
