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
import model.dto.PageDto;
import service.FileService;


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
			
			// ---------------------- 7. 검색처리
			String key = request.getParameter("key");
			String keyword = request.getParameter("keyword");
			
			// ---------------------- 1. 카테고리
			int bcno = Integer.parseInt( request.getParameter("bcno") );
			// ---------------------- 2. 출력할 게시물 수/ 하나의 페이지의 최대 게시물 수
			int listsize = Integer.parseInt( request.getParameter("listsize") );
			// ---------------------- 3. 페이징 처리 하기
			int page = Integer.parseInt( request.getParameter("page") );
				// 1. 페이지별 레코드의 시작 번호
			int startrow = (page-1) * listsize;	// 페이지번호 * 최대게시물수
			// ---------------------- 4. 마지막 페이지번호
				// 1. 마지막 페이지번호/총페이지수 = 전체게시물수 / 페이지별최대게시물수(listsize)
				// 2. 전체 게시물 수
			int totalsize = BoardDao.getInstance().getTotalSize(bcno, key, keyword);
				// 3. 마지막 페이지번호 / 총페이지수
			int totalpage = totalsize%listsize == 0 ? totalsize/listsize : totalsize/listsize+1;
					// 게시물수 : 10, 페이지별 2개씩 출력 => 총페이지수 5[몫]
					// 게시물수 : 20, 페이지별 3개씩 출력 => 총페이지수 6[몫] + 1(나머지)
			// ---------------------- 5. 페이지번호버튼 시작번호, 마지막 번호
				/*
					페이지	시작		마지막		시작계산시[ int btnsize = 5; ]
					1페이지	1		5			page*btnsize	1*5	=>	5
					2		1		5			page*btnsize	2*5	=>	10
					3		1		5			page*btnsize	3*5	=>	15
					4		1		5			page*btnsize	4*5	=>	20
					5		1		5			page*btnsize	5*5	=>	25
					6		6		10			page*btnsize	6*5	=>	30
				 */
			
				// 1. 페이지버튼 번호의 최대개수
			int btnsize = 5;
				// 2. 페이지버튼 번호의 시작번호
			int startbtn = ((page-1)/btnsize)*btnsize+1;
				// 3. 페이지버튼 번호의 마지막 번호
			int endbtn = startbtn+btnsize;
					// * 단 마지막번호는 총 페이지수 보다 커질 수 없음
					// 만일 마지막번호가 총 페이지수보다 크면 총 페이지 수로 제한두기
			if( endbtn >= totalpage ) endbtn = totalpage;
			
			// ---------------------- 6. pageDto 구성
			ArrayList<BoardDto> result = BoardDao.getInstance().getList( bcno, listsize, startrow, key, keyword );

			PageDto pageDto = new PageDto(
				page, listsize, startrow, totalsize, totalpage, startbtn, endbtn, result); 
			
			// * java객체 --> js객체[JSON] 형식의 문자열로 변환
			json = objectMapper.writeValueAsString( pageDto );

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
		} else {	// 만약에 수정할 첨부파일 있으면 기존 첨부파일은 서버업로드폴더에서 삭제
			
			String filename = BoardDao.getInstance().getBoard(bno).getBfile();
			filename = request.getServletContext().getRealPath("/board/upload")+"/"+filename;
			FileService.fileDelete(filename);
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
			// 레코드 삭제 전 파일이름 꺼내기 [ 삭제 후 파일이름 호출이 불가능 ]
		String filename = BoardDao.getInstance().getBoard(bno).getBfile();
		
		// 2. DAO
		boolean result = BoardDao.getInstance().ondelete( bno );
		
			// 만일 게시물 삭제가 성공되면.. 서버에 업로드된 파일도 같이 삭제
				// 즉, 게시물 삭제시 삭제된 게시물의 업로드파일도 같이 삭제
		if( result ) {	// 게시물 삭제를 성공할 시
			filename = request.getServletContext().getRealPath("/board/upload")+"/"+filename;
			System.out.println("filename : "+filename);
			FileService.fileDelete(filename);
		}
		
		
		// 3. 응답
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
	}

	// 5. 파일 삭제
	
	
	
	
}





























