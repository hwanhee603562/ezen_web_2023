package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.BoardDto;
import model.dto.MemberDto;

/**
 * Servlet implementation class BoardInfoController
 */
@WebServlet("/BoardInfoController")
public class BoardInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardInfoController() {
        super();

    }
    
    // 1. 전체조회 2. 개별조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청
		String type = request.getParameter("type");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		
		// 전체조회
		if( type.equals("1") ) {
			
			ArrayList<BoardDto> result = BoardDao.getInstance().getList();
			// * java객체 --> js객체[JSON] 형식의 문자열로 변환
			
			json =  objectMapper.writeValueAsString( result );

		}	// 개별조회 
		else if( type.equals("2") ) {
			
			// 1. 매개변수 요청
			int bno = Integer.parseInt( request.getParameter("bno") );
			// 2. DAO 처리
			BoardDto result = BoardDao.getInstance().getBoard( bno );
			
			// 3. 만일 (로그인 혹은 비로그인) 요청한사람과 게시물작성한 사람과 동일하면
			Object object = request.getSession().getAttribute("loginDto");
			// 로그인 정보[세션]
			MemberDto login = (MemberDto)request.getSession().getAttribute("loginDto");
			
			if( object == null ) {	// 비로그인
				result.setIshost(false);
			} else {				// 로그인
				if( login.getMno() == result.getMno() ) {	// 내가 쓴 글
					result.setIshost(true);
				} else {									// 남이 쓴 글
					result.setIshost(false);
				}
			}
			
			
			json = objectMapper.writeValueAsString( result );
		}
		
		// 공통로직 - 응답
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print( json );
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. 첨부파일 업로드
		MultipartRequest multi = new MultipartRequest(
				request,
				request.getServletContext().getRealPath("/board/upload"),
				1024*1024*1024,
				"UTF-8",
				new DefaultFileRenamePolicy()
			);
			// * 업로드 서버경로 확인
			//	System.out.println( request.getServletContext().getRealPath("/board/upload") );
		
		
		// 1. (입력받은 매개변수) 요청
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
			// 작성자는 html상 입력하는 것이 아니라 이미 로그인 중이기에 세션에 로그인 회원 정보가 있음
			// --> 세션에서 회원정보 불러오기
		int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		int bcno = Integer.parseInt(multi.getParameter("bcno"));
		
		// 2. 유효성검사/객체화
		BoardDto boardDto = new BoardDto(btitle, bcontent, bfile, mno, bcno);
		
		// 3. Dao 처리
		boolean result = BoardDao.getInstance().bwrite(boardDto);
				
		// 4. (Dao 결과) 응답
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
		
	}

	
	// 3. 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 수정할 첨부파일 업로드
		MultipartRequest multi = new MultipartRequest(
				request,
				request.getServletContext().getRealPath("/board/upload"),
				1024*1024*1024,
				"UTF-8",
				new DefaultFileRenamePolicy()
			);
		
		// 2. 수정할 데이터 요청
		int bcno = Integer.parseInt( multi.getParameter("bcno") );
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		
		// 2* 수정할 게시물 식별키
		int bno = Integer.parseInt( multi.getParameter("bno") );
		BoardDto updateDto = new BoardDto( bno, btitle, bcontent, bfile, bcno );

		// * 만약에 수정할 첨부파일이 없으면 기존 첨부파일 그대로 사용
		if( updateDto.getBfile() == null ) {
			// 기존 첨부파일
			updateDto.setBfile( BoardDao.getInstance().getBoard(bno).getBfile() );
		}
		
		boolean result = BoardDao.getInstance().onUpdate( updateDto );
		
		// 3. 응답
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
		
	}

	// 4. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청
		int bno = Integer.parseInt(request.getParameter("bno"));

		// 2. DAO
		boolean result = BoardDao.getInstance().ondelete( bno );
		
		// 3. 응답
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
	}

}





























