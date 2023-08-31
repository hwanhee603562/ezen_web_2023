package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class MemberinfoController
 */
@WebServlet("/MemberinfoController")
public class MemberinfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberinfoController() {
        super();
    }

    // 1. [C] 회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// -----------------------------파일 업로드 : 서버폴더에------------------------------
	//※	실제로는 서버용pc, 개발자용pc로 나누어져있는데, 현재는 한 대로 서버,개발용 모두 사용하고 있기 때문에
	//	서버경로가 개발자용pc에 있다고 오해해선 안된다
	//	* 실제로 클라이언트용, 서버용,
		
		// 첨부파일 저장할 경로
			// 1. 개발자 pc경로 업로드 [문제발생 : 개발자pc에 업로드하면 업로드파일을 서버로 빌드]
		//String uploadpath = "C:\\Users\\504\\git\\ezen_web_2023\\jspweb\\src\\main\\webapp\\member\\img";
			// 2. 서버 pc경로 업로드 [사용자가 바로 서버pc 업로드]
		//String uploadpath = "C:\\Users\\504\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps";
			// 3. 서버 pc경로 ( 상대경로 = 서버경로 찾아주는 함수 )
				// 서버에 build(배포)된 파일/폴더의 경로 찾기
				// request.getSession().getServletContext().getRealPath("프로젝트명 이하 경로");
		String uploadpath = request.getSession().getServletContext().getRealPath("/member/img");
		
		// 첨부파일 전송 했을 때
			// 1. 첨부파일 서버 PC에 업로드( cos 라이브러리 )
				// MultipartRequest : 파일 업로드 클래스
		MultipartRequest multi = new MultipartRequest(
				request,			// 1. 요청방식
				uploadpath,			// 2. 첨부파일을 저장할 폴더 경로
				1024 * 1024 * 10, 	// 3. 첨부파일 용량 허용 범위 [ 바이트단위 ] 10MB
				"UTF-8",			// 4. 한글 인코딩 타입
				new DefaultFileRenamePolicy()
					// 5. [파일이름중복제거] 만약에 서버내 첨부파일이 동일한 이름이 있을 때 이름 뒤에 숫자를 자동으로 붙이기
			);
		
		// -----------------------------DB처리 : 업로드된 파일명-------------------------------
			// 2. form 안에 있는 각 데이터 호출
		// 일반input 	: multi.getParameter("form객체전송시 input name")
		// 첨부파일input 	: multi.getFilesystemName();
		String mid = multi.getParameter("mid");
		System.out.println(mid);
		
		String mpwd = multi.getParameter("mpwd");
		System.out.println(mpwd);
		
		String memail = multi.getParameter("memail");
		System.out.println(memail);
		
		//String mimg = request.getParameter("mimg");
		String mimg = multi.getFilesystemName("mimg");
		System.out.println(mimg);
		
		
		// * 만약에 사진업로드 안했으면 기본프로필 사용하도록 변경 = default.webp
		if( mimg == null ) mimg = "default.webp";
		
		// 2. (선택) 객체화
		MemberDto memberDto = new MemberDto(mid, mpwd, memail, mimg);		
		
		// 3. Dao 에게 전달하고 결과 받는다
		boolean result = MemberDao.getInstance().signup( memberDto );
		
		// 4. AJAX 통신으로 결과 데이터를 응답을 보낸다	[response]
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
		
	}
	
	// 2. 회원정보(세션호출) / 로그아웃(세션초기화) 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청한다 [ 기능 구분을 위한 요청 ]
		String type = request.getParameter("type");
			// 만약에 type이 info이면
			if( type.equals("info") ) {
				
				response.setContentType("application/json; charset=utf-8");
					// 1. 세션을 호출한다 [세션의 타입은 object]
				Object session = request.getSession().getAttribute("loginDto");
					// 2. 타입변환 [object -> String  (다운캐스팅)]
				MemberDto loginDto = (MemberDto) session;
				
					// - DTO는 JS가 이해할 수 없는 언어이므로 JS가 이해할 수 있게 JS언어로 변환 [jackson 라이브러리]
				ObjectMapper objectMapper = new ObjectMapper();
				String json = objectMapper.writeValueAsString( loginDto );
				
				response.setContentType("application/json; charset=utf-8");
				response.getWriter().print(json);
				
			} else if(type.equals("logout")) {
				
				// * 세션에 저장된 로그인 객체를 없애기/초기화/지우기/삭제
				// 방법1 : 모든 세션 초기화하는 함수
					// request.getSession().invalidate();	// 로그인 정보뿐 아니라 모든 세션 삭제
				
				
				// 방법2 : JVM GC
					// 삭제할 세션 속 성명과 동일하게 null 대입
				request.getSession().setAttribute("loginDto", null);
			}
		
		
		// 2. 유효성/객체화
		
		// 3. Dao처리 - 세션에서 값을 가져오기에 없음
		
		// 4. 응답
		
			// * 세션에 저장된 로그인 객체를 꺼내기
	}
	
	// 3. 회원수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("controller 진입");
		// 파일업로드
			// multipart/form-data 전송 요청 // cos-jar 라이브러리 사용
		MultipartRequest multi = new MultipartRequest(
				request, 
				request.getServletContext().getRealPath("/member/img"),
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
			);
		
		// DB 업데이트
		// * form 전송일때는 input의 데이터 호출시
			// 일반 input : multi.getParameter("input name속성명")
			// 일반 input : multi.getFilesystemName("input name속성명")
		String mimg = multi.getFilesystemName("mimg");
		// Dao [ 로그인된 회원번호, 수정할 값 ]
		Object object = request.getSession().getAttribute("loginDto");
		MemberDto memberDto = (MemberDto)object;
		int loginMno = memberDto.getMno();
		
		// 만약에 수정할 첨부파일 이미지 없으면
		if( mimg == null ) {				// 기존 이미지 그대로 사용 
			mimg = memberDto.getMimg();		// 세션에 있던 이미지 그대로 대입
		}
		
		boolean result = MemberDao.getInstance().mupdate( loginMno, mimg );
		response.setContentType("application/json;charset=utf8");
		response.getWriter().print(result);
		
	}

	// 4. 회원삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청한다
		String mpwd = request.getParameter("mpwd");
		
		// 2. 유효성검사/객체화
		// 3. DAO 처리 [ 현재 로그인된 회원번호[pk], 입력받은 패스워드[mpwd] ]
			// 1. 현재 로그인된 회원정보 => 세션
				// (MemberDto)request.getSession().getAttribute("loginDto").getMno();
		// - 로그인 세션 호출
		Object object = request.getSession().getAttribute("loginDto");
		// - 타입 변환한다
		MemberDto memberDto = (MemberDto)object;
		// - 로그인객체에 회원번호만 호출한다
		int loginMno = memberDto.getMno();
		
		// - Dao 전달해서 결과 받기
		boolean result = MemberDao.getInstance().mdelete(loginMno, mpwd);
		
		// 4. 응답한다
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(result);
		
	}

}

















