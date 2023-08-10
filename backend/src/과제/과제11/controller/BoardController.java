package 과제.과제11.controller;

import java.util.ArrayList;

import 과제.과제11.model.dao.BoardDao;
import 과제.과제11.model.dto.BoardDto;

public class BoardController {
	
	private static BoardController boardController = new BoardController();
	public static BoardController getInstance() {
		return boardController;
	}
	private BoardController() {}
	
	// 9 boardWrite		게시물쓰기 페이지
	public boolean boardWrite( String title, String content ) {
		
		// 1. 유효성 검사
		if( title.length() == 0 || title.length() > 50) return false;
		// 2. Dto [ 입력받은제목, 입력받은내용, 로그인 회원번호 ]
		// 위 생성자를 Dto에 생성자를 새롭게 생성하였음
			// 로그인 회원번호는 세션에 현재 로그인 중인 회원번호를 가져옴 
		BoardDto boardDto = new BoardDto(title, content, MemberController.getInstance().getLoginSession());
		
		// 3. DAO에게 전달 후 결과를 받아 반환
		return BoardDao.getInstance().boardWrite(boardDto);
	}
	// 10 boardPrint		모든 게시물 출력
	public ArrayList<BoardDto> boardPrint() {

		return BoardDao.getInstance().boardPrint();
	}
	// 11 boardView		개별 게시물 출력
	public BoardDto boardView(int bno) {
		
		
		return BoardDao.getInstance().boardView(bno);
		
	}
	// 12 boardUpdate	게시물 수정
	public void boardUpdate() {
		
	}
	// 13 boardDelete	게시물 삭제
	public void boardDelete() {
		
	}
}














