package java1.day13.Ex2.model.dao;

import java.util.ArrayList;

import java1.day13.Ex2.model.dto.BoardDto;

public class BoardDao {
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() {
		return boardDao;
	}
	private BoardDao() {}
	
	// 배열
	public BoardDto[] boardDtoArray = new BoardDto[100];
	// ArrayList
	public ArrayList<BoardDto> boardDtoList = new ArrayList<>();
	
	
	
	
	
}
