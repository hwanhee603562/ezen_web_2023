package 복습.part5;

import java.util.Scanner;

public class Member {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MemberSys[] list = new MemberSys[100];
		
		
		while(true) {
			System.out.println("---------- 회원 시스템 ---------");
			System.out.println("1.회원가입 2.로그인		선택>");
			int ch = sc.nextInt();
			
			if(ch==1) {
				sc.nextLine();
				System.out.println("---------- 회원 시스템 ---------");
				System.out.println("아이디 : ");
				String sid = sc.nextLine();
				System.out.println("비밀번호 : ");
				String spw = sc.nextLine();
				System.out.println("이름 : ");
				String sname = sc.nextLine();
				System.out.println("전화번호 : ");
				String sphone = sc.nextLine();
				System.out.println("나이 : ");
				int age = sc.nextInt();
				
				MemberSys member = new MemberSys(sid, spw, sname, sphone, age);

				
				for(int i=0; i<list.length; i++) {
					if(list[i]==null) {
						
						list[i] = member;
						break;
					}
				}
				
				System.out.println("회원가입 성공");
				
			}
			else if(ch==2) {
				sc.nextLine();
				System.out.println("아이디 : ");
				String sid = sc.nextLine();
				System.out.println("비밀번호 : ");
				String spw = sc.nextLine();
				
				for(int i=0; i<list.length; i++) {
					
					if(list[i] != null && list[i].id.equals(sid) && list[i].pw.equals(spw) ) {
						System.out.println("로그인 성공");
						return;
					}
					
				}
				System.out.println("로그인 실패");
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
	}
	
}
