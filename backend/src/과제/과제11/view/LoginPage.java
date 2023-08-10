package 과제.과제11.view;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제11.controller.BoardController;
import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.BoardDto;
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
			
			// 모든 게시물 보기 실행
			boardPrint();
			
			System.out.println("\n\n======= 회원제 커뮤니티 =======");
			System.out.print("1.로그아웃 2.회원정보 3.글쓰기 선택 4.글조회 선택>");
			
			try {
				
				int ch = sc.nextInt();
				// 만약에 타입과 일치하지 않는 값을 입력하면 
				// java.util.InputMismatchException 발생
				sc.nextLine();
				if(ch==1) MemberController.getInstance().logOut();
				
				if(ch==2) info();
				
				if(ch==3) boardWrite();
				
				if(ch==4) boardView();

			} catch(Exception e) {
				System.out.println("경고] 잘못 입력했습니다"+e);
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
	
	
	// 9 boardWrite		게시물쓰기 페이지
	public void boardWrite(  ) {
		System.out.println("----- post write -----");

		System.out.println("제목 > ");
		String title = sc.next();
		System.out.println("내용 > ");
		String content = sc.next();

		boolean result =
		BoardController.getInstance().boardWrite(title, content);
		
		if(result) {
			System.out.println("안내] 글쓰기 등록");
		} else {
			System.out.println("안내] 글쓰기 실패 : 제목 필수 입력");
		}	
	}
	// 10 boardPrint		모든 게시물 출력
	public void boardPrint() {
		System.out.println("----- post LIST -----");
		// 1. 여러 개의 게시물을 요청해서 반환된 결과 저장
		ArrayList<BoardDto> result = 
			BoardController.getInstance().boardPrint();
		
		// 2. 출력
		System.out.printf("%-3s %-4s %-15s %-10s %s \n", "no", "view", "date", "mid", "title");
		for(int i=0; i<result.size(); i++) {
			BoardDto dto = result.get(i);
			
			System.out.printf("%-3s %-4s %-15s %-10s %s \n", dto.getBno(), dto.getBview(), dto.getBdate(), dto.getMid(), dto.getBtitle());
		}
	}
	// 11 boardView		개별 게시물 출력(회원정보 출력과 방식은 동일)
	public void boardView() {
		System.out.println("----- post VIEW -----");
		
		// 1 보고자하는 게시물의 게시물번호를 입력받기 [식별번호]
		System.out.println("게시물번호 : ");
		int bno = sc.nextInt();
		sc.nextLine();
		// 2
		BoardDto result = BoardController.getInstance().boardView(bno);
		// 3 출력
		System.out.printf("bno : %-3s view : %-3s mid : %-10s date : %-19s \n",
				result.getBno(), result.getBview(), result.getMid(), result.getBdate());
		System.out.printf("title : %s, \n", result.getBtitle());
		System.out.printf("content : %s, \n", result.getBcontent());
		
		System.out.println("1.뒤로가기 2.수정 3.삭제 선택>");
		int ch = sc.nextInt();
		
		if(ch == 1) {}
		if(ch == 2) boardUpdate();
		if(ch == 3) boardDelete();
		
	}
	// 12 boardUpdate	게시물 수정
	public void boardUpdate() {
		
	}
	// 13 boardDelete	게시물 삭제
	public void boardDelete() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
