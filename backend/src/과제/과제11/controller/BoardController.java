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
		// bno		: 수정할 게시물의 식별[누구를 수정할 것인지]
		// mno		: 작성요청회원과 작성자가 일치할 경우에만 수정 가능하도록 유효성검사
		// title	: 수정할 제목
		// content	: 수정할 내용
	public int boardUpdate( int bno, int mno, String title, String content ) {
		// 1. 유효성 검사
			// 1 게시물의 작성자회원번호와 로그인된 회원의 번호와 일치하지 않으면
		if( mno != MemberController.getInstance().getLoginSession() ) return 3;
			// 2 제목 글자 수 체크
		if( title.length()<1 || title.length()>50 ) return 4;

		// 2. 
		boolean result = BoardDao.getInstance().boardUpdate( new BoardDto(bno, title, content));
		
		if( result ) return 1;
		else return 2;
		
	}
	// 13 boardDelete	게시물 삭제	
		// bno		: 삭제할 게시물의 식별[누구를 삭제할 것인지]
		// mno		: 삭제요청한 회원과 게시물의 작성자가 일치한 경우에만 삭제하도록 유효성검사
	public int boardDelete(int bno, int mno) {
		// 현재 로그인한 회원과 게시물 작성자 일치 여부확인
		if( mno != MemberController.getInstance().getLoginSession() ) { return 3; }
		
		boolean result = BoardDao.getInstance().boardDelete( bno ) ;
		if( result ) return 1;
		else return 2;
		

	}
}














