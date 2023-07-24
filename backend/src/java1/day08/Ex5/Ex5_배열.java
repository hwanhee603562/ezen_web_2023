package java1.day08.Ex5;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5_배열 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] memberList = new String[100];
		
		while(true) {
			System.out.println(Arrays.toString(memberList));
			System.out.println("1.회원가입 : ");
			
			int ch = sc.nextInt();
			
			if( ch==1 ) {
				System.out.print("아이디 : ");
				String id = sc.next();
				System.out.print("비밀번호 : ");
				String pw = sc.next();
				System.out.print("이름 : ");
				String name = sc.next();
				
				//1. 하나의 문자열로 합치기
				String member = id+","+pw+","+name;
				//2. 배열내 비어있는 인덱스 찾아서 대입
				for(int i=0; i<memberList.length; i++) {
					if(memberList[i] == null) {
						memberList[i] = member;
						break;
					}
				}		
			} 
		}	
	}
}
