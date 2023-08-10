package 과제.과제11.model.dao;

import java.util.ArrayList;

import 과제.과제11.model.dto.BoardDto;

public class BoardDao extends Dao {
	
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() {
		return boardDao;
	}
	private BoardDao() {}
	
	
	// 9 boardWrite		게시물쓰기 페이지
	public boolean boardWrite(BoardDto boardDto) {
		
		try {
			// 1
			String sql = "insert into board( btitle, bcontent, mno ) values(?, ?, ?)";
			
			// 2
			ps = conn.prepareStatement(sql);
			
			// 3
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3, boardDto.getMno());
			
			
			// 4 sql 실행 / 실행 후 저장된 레코드 개수 반환
			int row = ps.executeUpdate();
			
			// 5 만일 저장된 레코드 수가 1개이면 성공
			if(row == 1) return true;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return false;
	}
	// 10 boardPrint		모든 게시물 출력
	public ArrayList<BoardDto> boardPrint() {
		ArrayList<BoardDto> list = new ArrayList<>();
		
		try {


			// 1. 최신순으로 게시판 출력해야하기 때문에 bdate 기준 order by 내림차순 사용
			
				// sql문 조인 전
			//String sql = "select * from board order by bdate desc";
				// sql문 조인 후
			String sql = "select b.*, m.mid from member m natural join board b order by b.bdate desc";
			// 2. 
			ps = conn.prepareStatement(sql);
			
			// 3. 조작
			// 4. 검색결과의 레코드를 여러 개 조작하기 위해 resultSet 객체 반환
			rs = ps.executeQuery();

			
			// 5. 여러 개의 레코드 조회 [rs.next() : 다음 레코드 이동(존재하면 true, 존재하지않으면 false)]
			while( rs.next() ) {
				// 레코드 1개마다 1개의 DTO반환
				
				BoardDto boardDto = new BoardDto(
					rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
				
				
				list.add(boardDto);
				
			}
			
			
		} catch (Exception e) {
			
		}
		
		return list;
		
	}
	// 11 boardView		개별 게시물 출력
	public BoardDto boardView(int bno) {
		
		try {
			
			String sql = "select b.*, m.mid from board b natural join member m where b.bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				BoardDto boardDto = new BoardDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
				return boardDto;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
		
	}
	// 11-2 조회수 증가함수
	public boolean boardViewCount() {
		return false;
	}
	
	
	
	
	// 12 boardUpdate	게시물 수정
	public void boardUpdate() {
		
	}
	// 13 boardDelete	게시물 삭제
	public void boardDelete() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}