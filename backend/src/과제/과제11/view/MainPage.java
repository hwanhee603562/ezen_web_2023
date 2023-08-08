package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;

public class MainPage {
	
	private static MainPage mainPage = new MainPage();
	public static MainPage getInstance() {
		return mainPage;
	}
	private MainPage() {}
	
	
	private Scanner sc = new Scanner(System.in);
	
	
		
	// 메인메뉴
	public void mainView() {
		
		while(true) {
			System.out.println("\n\n======= 회원제 커뮤니티 =======");
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			
			try {
				
				int ch = sc.nextInt();
				// 만약에 타입과 일치하지 않는 값을 입력하면 
				// java.util.InputMismatchException 발생
				
				if(ch==1) signupView();
				
				if(ch==2) loginView();
				
				if(ch==3) findById();
			
				if(ch==4) findByPw();
				
			
			} catch(Exception e) {
				System.out.println("경고] 잘못 입력했습니다");
				sc =  new Scanner(System.in);
				// 입력객체의 메모리를 새롭게 만들어줘야함
			}
		}
		
	}
	// 1 회원가입 화면
	public void signupView() {
		
		System.out.println("----- 회원가입 페이지 -----");
		System.out.println("아이디 > ");
		String id = sc.next();
		System.out.println("비밀번호 > ");
		String pw = sc.next();
		System.out.println("이름 > ");
		String name = sc.next();
		System.out.println("전화번호[-포함] > ");
		String phone = sc.next();
		
		int result = MemberController.getInstance().signupLogic(id, pw, name, phone);
		
		if(result == 1) {
			System.out.println("회원가입이 완료되었습니다");
		} else if(result == 2) {
			System.out.println("회원가입이 불가합니다. 관리자에게 문의");
		} else if(result == 3) {
			System.out.println("회원가입이 불가합니다. 아이디 중복");
		} else if(result == 4) {
			System.out.println("회원가입이 불가합니다. 전화번호 중복");
		}
	}
	// 2 로그인 화면
	public void loginView() {
		System.out.println("아이디 > ");
		String id = sc.next();
		System.out.println("비밀번호 > ");
		String pw = sc.next();
		
		boolean result = MemberController.getInstance().loginLogic(id, pw);
		
		if(result) {
			System.out.println("로그인이 완료되었습니다");
			LoginPage.getInstance().loginMenu();
		} else {
			System.out.println("로그인이 불가합니다");
		}
	}
	// 3 아이디 찾기
	public void findById() {
		
		System.out.println("----- 아이디 찾기 페이지 -----");
		System.out.println("이름 >");
		String name = sc.next();
		System.out.println("전화번호 >");
		String phone = sc.next();
		
		String result = MemberController.getInstance().findId(name, phone);
		
		if(result != null) {
			System.out.println("회원님의 아이디 : "+result);
		} else {
			System.out.println("경고] 정보가 일치한 아이디가 없습니다");
		}
		
	}
	// 4 비밀번호 찾기
	public void findByPw() {
		
		System.out.println("----- 비밀번호 찾기 페이지 -----");
		System.out.println("아이디 >");
		String id = sc.next();
		System.out.println("전화번호 >");
		String phone = sc.next();
		
		String result = MemberController.getInstance().findPw(id, phone);
		
		if(result != null) {
			System.out.println("회원님의 비밀번호 : "+result);
		} else {
			System.out.println("경고] 정보가 일치한 비밀번호가 없습니다");
		}
		
		
	}
	
	
}











































