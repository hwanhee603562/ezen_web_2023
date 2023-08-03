package 복습.part6;

import java.util.Scanner;

public class MemberSys {

	static Member[] list = new Member[100];
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("-------회원 시스템-------");
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			System.out.println("선택>");
			int ch = sc.nextInt();
			
			if(ch == 1) {
				join();
			} else if (ch == 2) {
				log();
			} else if (ch == 3) {
				searchId();
			} else if (ch == 4) {
				searchPw();
			}

		}
	}
	
	public static void join() {
		System.out.println("-------회원가입-------");
		sc.nextLine();
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String pw = sc.nextLine();
		
		System.out.println("이름 : ");
		String na = sc.nextLine();
		
		System.out.println("전화번호 : ");
		String ph = sc.nextLine();
		
		System.out.println("나이 : ");
		int age = sc.nextInt();
	
		Member m = new Member(id, pw, na, ph, age);
		
		for(int i=0; i<list.length; i++) {
			if(list[i]==null) {
				list[i] = m;
				System.out.println("안내)회원가입 성공");
				return;
			}
		}
	}
	
	public static void log() {
		System.out.println("-------로그인-------");
		sc.nextLine();
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String pw = sc.nextLine();
		
		for(int i=0; i<list.length; i++) {
			if(list[i]!=null && id.equals(list[i].id) && pw.equals(list[i].pw) ) {
				System.out.println("안내)로그인 성공");
				return;
			}
		}
		System.out.println("로그인 실패");
	}
	
	public static void searchId() {
		System.out.println("-------아이디 찾기-------");
		System.out.println("이름 : ");
		String na = sc.nextLine();
		
		System.out.println("전화번호 : ");
		String ph = sc.nextLine();
		
		for(int i=0; i<list.length; i++) {
			if(list[i]!=null && na.equals(list[i].na) && ph.equals(list[i].ph) ) {
				System.out.println("안내)회원님의 아이디 : "+list[i].id);
				return;
			}
		}
		System.out.println("안내) 이름 혹은 전화번호가 일치하는 아이디가 없습니다");
		
	}
	public static void searchPw() {
		System.out.println("-------비밀번호 찾기-------");
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		
		System.out.println("전화번호 : ");
		String ph = sc.nextLine();
		
		for(int i=0; i<list.length; i++) {
			if(list[i]!=null && id.equals(list[i].id) && ph.equals(list[i].ph) ) {
				System.out.println("안내)회원님의 비밀번호 : "+list[i].pw);
				return;
			}
		}
		System.out.println("안내) 아이디 혹은 전화번호가 일치하는 비밀번호가 없습니다");
		
		
	}
	
	
}



















