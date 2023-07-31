package java1.day13.Ex2.controller;

import java1.day13.Ex2.model.dao.BoardDao;
import java1.day13.Ex2.model.dto.BoardDto;

public class BoardController {

	// 싱글톤O : 게시물마다 가 아닌 모든 게시물이 하나의 객체을 통해 동일한 기능 수행
	private static BoardController boardController = new BoardController();
	public static BoardController getInstance() {
		return boardController;
	}
	private BoardController() {}
	
	/*--------------------------------*/
	
	// 글등록 처리 가능 함수 [C]
	public boolean writeLogic(String content, String writer) {
		
		// 1 매개변수로부터 전달 받은 content, writer을 하나의 객체로 선언
		BoardDto boardDto = new BoardDto(writer, content);
		// 2 객체를 배열에 저장
		for(int i=0; i<BoardDao.getInstance().boardDtoArray.length; i++) {
			if(BoardDao.getInstance().boardDtoArray[i]==null) {
				BoardDao.getInstance().boardDtoArray[i] = boardDto;
				break;
			}
		}
		// 
		BoardDao.getInstance().boardDtoList.add(boardDto);
		
		//성공[true]  실패[true]
		return true;
	}
	
	// 글출력 처리 가능 함수 [R]
	public BoardDto printLogic(int index) {
		
		BoardDto boardDto =  BoardDao.getInstance().boardDtoList.get(index);
				
		BoardDao.getInstance().boardDtoList.get(index).setView(
				BoardDao.getInstance().boardDtoList.get(index).getView()+1 );
		
		return boardDto;
	}
	
	// 글수정 처리 가능 함수 [U]
	public boolean updateLogic(int index, String content, String writer) {
		
		BoardDao.getInstance().boardDtoList.get(index).setContent( content );
		BoardDao.getInstance().boardDtoList.get(index).setWriter( writer );
		
		return true;
	}
	
	// 글삭제 처리 가능 함수 [D]
	public boolean deleteLogic(int index) {
		BoardDao.getInstance().boardDtoList.remove(index);
		return true;
	}
}
