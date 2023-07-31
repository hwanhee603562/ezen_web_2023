package java1.day13.Ex2.view;

import java.util.Scanner;

import java1.day13.Ex2.controller.BoardController;
import java1.day13.Ex2.model.dao.BoardDao;
import java1.day13.Ex2.model.dto.BoardDto;

public class MainPage {
	
	

	// 싱글톤O : 게시물마다 가 아닌 모든 게시물이 하나의 객체을 통해 동일한 기능 수행
		// 1. 현재 클래스 안에 현재클래스로 객체 선언
	private static MainPage mainPage = new MainPage();
		// 2. 외부로부터 간접적으로 싱글톤이 호출되도록하는 함수
	public static MainPage getInstance() {
		return mainPage;
	}
		// 3. 외부로부터 객체 생성 차단
	private MainPage() {}
	
	/*--------------------------------*/
	
	Scanner sc = new Scanner(System.in);
	
	
	// 메인페이지 입출력 함수
	public void mainPage() {
		while(true) {
			System.out.println("안내] "+ BoardDao.getInstance().boardDtoList);
			System.out.println("\n\n >>>>>> 방문록 프로그램 >>>>>>");
			System.out.println("1.글등록 2.글보기 3.글수정 4.글삭제 선택> ");
			
			int ch = sc.nextInt();
			if(ch==1) {
				writeView();
			}
			if(ch==2) {
				printView();
			}
			if(ch==3) {
				updateView();
			}
			if(ch==4) {
				deleteView();
			}
			
			
			
		}
	}
	
	// 글등록 페이지 입출력 함수
	public void writeView() {
		System.out.println("방문록 등록 페이지");
		
		// 1 내용(띄어쓰기O)과 작성자(띄어쓰기X)를 입력받아 변수 저장
		sc.nextLine();	// 개행 버림
		System.out.println("방문록 : ");
		String content = sc.nextLine();
		//nextLine() 함수 실행전 nextInt() 실행되므로 오류 발생 방지
		System.out.println("작성자 : ");
		String writer = sc.next();
		
		// 2 입력받은 변수를 컨트롤에게 전달
		// 현재위치 java 컨트롤도 java이므로 메서드를 이용
		boolean result = BoardController.getInstance().writeLogic(content, writer);
		
		// 3 컨트롤에게 전달 받은 내용 제어하기
		if( result ) {
			System.out.println("안내] 글 등록 성공");
		} else {
			System.out.println("안내] 글 등록 삭제");
		}
	}
	 
	// 글출력 페이지 입출력 함수
	public void printView() {
		System.out.println("방문록 조회 페이지");
		
		// 1 보고자하는 게시물의 인덱스 입력받아서 저장
		System.out.println("출력할 게시물의 인덱스 : ");
		int index = sc.nextInt();
		
		// 2 view에서 컨트롤에게 입력받은 인덱스 전달보내기
		BoardDto result = BoardController.getInstance().printLogic(index);
		
		// 3 전달받은 결과를 출력
		System.out.println("안내] 검색한 방문록 정보");
		System.out.println(" [작성자] : "+result.getWriter() + "내용 : "+result.getContent());
	}
	
	// 글수정 페이지 입출력 함수
	public void updateView() {
		System.out.println("방문록 수정 페이지");
		
		System.out.println("수정할 게시물의 인덱스 : ");
		int index = sc.nextInt();
		
		sc.nextLine();	// 개행 버림
		
		System.out.println("수정할 내용");
		String content = sc.nextLine();
		System.out.println("수정할 작성자");
		String writer = sc.next();
		
		boolean result = BoardController.getInstance().updateLogic(index, content, writer);
		
		if(result) {
			System.out.println("안내] 수정 성공");
		} else {
			System.out.println("안내] 수정 실패");
		}
		
	}
	
	// 글삭제 페이지 입출력 함수
	public void deleteView() {
		System.out.println("방문록 삭제 페이지");
		
		System.out.println("삭제할 게시물의 인덱스 : ");
		int index = sc.nextInt();
		boolean result = BoardController.getInstance().deleteLogic(index);
		if(result) {
			System.out.println("안내] 삭제 성공");
		} else {
			System.out.println("안내] 삭제 실패");
		}
	}
}









