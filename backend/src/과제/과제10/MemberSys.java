package 과제.과제10;

import java.util.Arrays;
import java.util.Scanner;

public class MemberSys {
	

	static Member[] memberList = new Member[100];
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(true) {
			
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    선택> ");
			int ch = sc.nextInt(); 
			
			if( ch == 1 ) {
				회원가입 ();
			} else if( ch == 2 ) {
				로그인 (); 
			} else if( ch == 3 ) { 
				아이디찾기 (); 
			} else if( ch == 4 ) { 
				비밀번호찾기 (); 
			} 
			
		} // w e 
	}
	
	static void 회원가입 () { 
		
		System.out.println("아이디 입력");
		String mId = sc.next();
		System.out.println("비밀번호 입력");
		String mPassword = sc.next();
		System.out.println("이름 입력");
		String mName = sc.next();
		System.out.println("휴대폰번호 입력");
		String mPhone = sc.next();
		System.out.println("나이 입력");
		int mAge = sc.nextInt();
		
		Member m = new Member(mId, mPassword, mName, mPhone, mAge);
		
		for(int i=0; i<memberList.length; i++) {
			if(memberList[i] == null) {
				memberList[i] = m;
				break;
			}
		}
	}
	
	static void 로그인 () { 
		
		System.out.println("아이디를 입력해주세요");
		String lId = sc.next();
		System.out.println("비밀번호를 입력해주세요");
		String lPassword = sc.next();
		
		
		int login = -1;
		
		for(int i=0; i<memberList.length; i++) {
			if( memberList[i] != null && memberList[i].id.equals(lId) && memberList[i].password.equals(lPassword)) {
				login = i;
				break;
			}
		}
		
		if(login != -1) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		
	}
	
	static void 아이디찾기 () {
		System.out.println("이름을 입력해주세요");
		String myName = sc.next();
		System.out.println("전화번호를 입력해주세요");
		String myPhone = sc.next();
		
		for(int i=0; i<memberList.length; i++) {
			if( memberList[i] != null && memberList[i].name.equals(myName) && memberList[i].phone.equals(myPhone)) {
				System.out.println("아이디 : "+ memberList[i].id);
				return;
			}
		}
		System.out.println("해당되는 아이디가 없습니다");
		
	}
	static void 비밀번호찾기 () {
		System.out.println("아이디를 입력해주세요");
		String myId = sc.next();
		System.out.println("전화번호를 입력해주세요");
		String myPhone = sc.next();
		
		for(int i=0; i<memberList.length; i++) {
			if( memberList[i] != null && memberList[i].id.equals(myId) && memberList[i].phone.equals(myPhone)) {
				System.out.print("임시비밀번호 : ");
				for(int j=0; j<4; j++) {
					System.out.print((int)(Math.random() * 10));
				}
				return;
			}
		}
		System.out.println("해당되는 회원정보가 없습니다");
		
		
	}
	
}
/*
	주제 : 회원제 시스템 
		0. 회원클래스 설계 = Member
			아이디 , 비밀번호 , 이름 , 전화번호 , 나이
		0. Member 객체를 여러개 저장하는 배열 
			Member[] 객체배열 = new Member[100];
		
		1. 초기 메뉴 [ 24시간 ]
			1. 회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기

					 
			3. 아이디찾기 메소드
				1. 이름 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 찾은 아이디 출력 
					- 아니면 없다.
					 
			4. 비밀번호찾기 메소드 
				1. 아이디 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 *임시 비밀번호(문자4자리 난수생성 ) 업데이트후 출력 
					- 아니면 없다.
*/