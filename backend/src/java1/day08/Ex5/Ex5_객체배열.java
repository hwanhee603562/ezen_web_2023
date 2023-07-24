package java1.day08.Ex5;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5_객체배열 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		
		// member 객체 100개를 저장할 수 있는 배열
		Member[] memberList = new Member[100];
	
		while(true) {
			System.out.println();
			System.out.println("1. 회원가입 : ");
			
			int ch = sc.nextInt();
			if(ch == 1) {
				System.out.println(Arrays.toString(memberList));
				
				System.out.println("아이디 : ");
				String id = sc.next();
				System.out.println("비밀번호 : ");
				String pw = sc.next();
				System.out.println("이름 : ");
				String name = sc.next();
				
				
				//1. 객체 선언 = 클래스명 객체변수명 = new 생성자명();
				Member m = new Member();
				
				//2. 생성된 객체로부터 .접근연산자를 이용한 필드 수정
				m.id = id;
				m.pw = pw;
				m.name = name;
								
				//3. 배열에 저장
				for(int i=0; i<memberList.length; i++) {
					if( memberList[i] == null ) {
						// i번째 인덱스에 생성된 객체 대입
						memberList[i] = m;
						m.showPrice();
						break;
					}
				}
			}
		}
		
		
	}
}
