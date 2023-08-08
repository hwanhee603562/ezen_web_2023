package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.MemberDto;

// 로그인이 완료된 이후의 화면
public class LoginPage {
	
	// 0 싱글톤
	private static LoginPage loginPage = new LoginPage();
	public static LoginPage getInstance() {
		return loginPage;
	}
	private LoginPage() {}
	
	// 0 입력객체
	Scanner sc = new Scanner(System.in);
	
	// 1 loginMenu		로그인했을 때 메뉴 페이지
	public void loginMenu() {
		
		while(MemberController.getInstance().getLoginSession() != 0) {
			System.out.println("\n\n======= 회원제 커뮤니티 =======");
			System.out.print("1.로그아웃 2.회원정보 3.글쓰기 선택");
			
			try {
				
				int ch = sc.nextInt();
				// 만약에 타입과 일치하지 않는 값을 입력하면 
				// java.util.InputMismatchException 발생
				
				if(ch==1) MemberController.getInstance().logOut();
				
				if(ch==2) info();
				
				if(ch==3) boardWrite();

			} catch(Exception e) {
				System.out.println("경고] 잘못 입력했습니다");
				sc =  new Scanner(System.in);
				// 입력객체의 메모리를 새롭게 만들어줘야함
			}
		}
		
		
		
	}
	// 2 info			로그인된 회원정보 페이지
	public void info() {
		
		System.out.println("\n\n===== info =====");
		// 1. 컨트롤에게 회원정보 요청해서 로그인된 회원정보[DTO] 반환 받기
			// 로그인된 후 식별키는 세션에 저장된 회원번호가 되므로  
			// 매개변수가 없다
		MemberDto result = MemberController.getInstance().info();
		
		/*
		 	null값을 반환하여 해당 메서드를 호출한 곳으로 반환시킬 경우 에러 발생
		 */
		
		// 2. 반환받은 회원정보객체[memberDto]의 각 회원정보를 출력 
		System.out.println(">ID : "+ result.getMid());
		System.out.println(">NAME : "+ result.getMname());
		System.out.println(">PHONE : "+ result.getMphone());
		
		// 2. 서브메뉴
		System.out.println("1.비밀번호수정 2.회원탈퇴 3.뒤로가기 선택 : ");
		int ch = sc.nextInt();
		if(ch==1) {
			infoUpdate();
		}
		if(ch==2) {
			infoDelete();
		}
		if(ch==3) {	// 생략가능
			return;	
		}
		
		
		
		
	}
	// 3 infoUpdate		회원수정 페이지
	public void infoUpdate() {
		
		System.out.println("\n\n===== password Update =====");
		System.out.println("새로운 비밀번호 : ");
		String newPw = sc.next();
		
		boolean result = MemberController.getInstance().infoUpdate(newPw);
		if(result) {
			System.out.println("안내] 비밀번호수정완료 : 로그아웃입니다");
			MemberController.getInstance().logOut();
		} else {
			System.out.println("경고] 비밀번호수정실패 : 관리자에게 문의");
		}
		
		
	}
	// 4 infoDelete		회원탈퇴 페이지
	public void infoDelete() {
		
		System.out.println("\n\n===== password Delete =====");
		System.out.println("정말 탈퇴하시겠습니까? 1.예 2.아니오 : ");
		int ch = sc.nextInt();
		if( ch == 1 ) {
			boolean result = MemberController.getInstance().infoDelete();
			if( result ) {
				System.out.println("안내] 회원탈퇴성공 : 로그아웃됩니다");
				MemberController.getInstance().logOut();
			} else {
				System.out.println("경고] 회원탈퇴실패 : 관리자에게 문의");
			}
		}
		
	}
	// 5 boardWrite		게시물쓰기 페이지
	public void boardWrite() {
		
	}
	// 6 boardPrint		모든 게시물 출력
	public void boardPrint() {
		
	}
	// 7 boardView		개별 게시물 출력
	public void boardView() {
		
	}
	// 8 boardUpdate	게시물 수정
	public void boardUpdate() {
		
	}
	// 9 boardDelete	게시물 삭제
	public void boardDelete() {
		
	}
	
	
}
