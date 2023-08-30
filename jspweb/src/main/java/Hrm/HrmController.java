package Hrm;

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

import model.dao.MemberDao;
import model.dao.VisitDao;
import model.dto.MemberDto;
import model.dto.VisitDto;

/**
 * Servlet implementation class HrmController
 */
@WebServlet("/HrmController")
public class HrmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HrmController() {
        super();

    }
    
    // 직원 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadpath = request.getSession().getServletContext().getRealPath("/hrm/img");
		System.out.println(uploadpath);
		MultipartRequest multi = new MultipartRequest(
				request,			// 1. 요청방식
				uploadpath,			// 2. 첨부파일을 저장할 폴더 경로
				1024 * 1024 * 10, 	// 3. 첨부파일 용량 허용 범위 [ 바이트단위 ] 10MB
				"UTF-8",			// 4. 한글 인코딩 타입
				new DefaultFileRenamePolicy()
					// 5. [파일이름중복제거] 만약에 서버내 첨부파일이 동일한 이름이 있을 때 이름 뒤에 숫자를 자동으로 붙이기
			);
		
		// -----------------------------DB처리 : 업로드된 파일명-------------------------------

		String himg = multi.getFilesystemName("himg");
		System.out.println(himg);
		
		String hname = multi.getParameter("hname");
		System.out.println(hname);
		
		String hphone = multi.getParameter("hphone");
		System.out.println(hphone);
		
		String hrank = multi.getParameter("hrank");
		System.out.println(hrank);

		
		// * 만약에 사진업로드 안했으면 기본프로필 사용하도록 변경 = default.webp
		if( himg == null ) himg = "default.webp";
		
		// 2. (선택) 객체화
		HrmDto hrmDto = new HrmDto(himg, hname, hphone, hrank);		
		
		System.out.println("객체 중간확인 : "+hrmDto);
		
		// 3. Dao 에게 전달하고 결과 받는다
		boolean result = HrmDao.getInstance().uploadInfo( hrmDto );
		
		// 4. AJAX 통신으로 결과 데이터를 응답을 보낸다	[response]
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
	}

	// 직원리스트 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<HrmDto> result = HrmDao.getInstance().hread();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString( result );
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print( jsonArray );
		
	}


	
}





















