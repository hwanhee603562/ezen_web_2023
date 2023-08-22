package controller.visitlog;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.VisitDao;
import model.dto.VisitDto;


@WebServlet("/visitlogController")
// 해당 서블릿(자바) / 컨트롤러 클래스를 호출하는 http 매핑주소

public class visitlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public visitlogController() {
        super();

    }
    
    // 1. 저장
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. AJAX의 DATA 속성에 있는 객체 정보(속성명이용)를 호출하기
		// request.getParameter("객체의 속성명")
		String vwriter = request.getParameter("vwriter");
		System.out.println("vwriter : "+vwriter);
		String vpwd = request.getParameter("vpwd");
		System.out.println("vpwd : "+vpwd);
		String vcontent = request.getParameter("vcontent");
		System.out.println("vcontent : "+vcontent);
		
		// 2. 객체화
		VisitDto visitDto = new VisitDto( vwriter, vpwd, vcontent );
		System.out.println( "visitDto : "+visitDto );
		
		// 3. DAO 객체 전달 후 결과 응답받고
		boolean result = VisitDao.getInstance().vwrite(visitDto);
		
		
		// 4. 결과를 AJAX에게 응답한다
		// response.getWriter().print("응답할데이터")
		// 		response.setContentType("text/html; charset=UTF-8"); -> (생략시 기본값)해당 방법으로 사용가능
		response.setContentType("application/json; charset=UTF-8"); //-> js에서 true
		response.getWriter().print(result);
	}
	
	// 2. 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 [x] : 모든 글 출력은 조건이 없으므로 요청값이 없음. (단, 개별글을 출력할 시 조건사용)
		// 2. 객체화 [x]
		// 3. DAO
		ArrayList<VisitDto> result = VisitDao.getInstance().vread();
			// * JS는 ArrayList타입을 사용할 수 없으므로 ArrayList타입 JSON 배열로 변환해서 전달하자 [라이브러리 : jackson ]
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString( result );		// json타입으로 변환은 불가능하지만 json형식의 문자열로 변환
		
		// 4. 응답
		// response.getWriter().print( result );	// 응답은 가능하나... js가 ArrayList타입 사용이 불가
		System.out.println("호출 : "+jsonArray);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print( jsonArray );
	}

	// 3. 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	// 4. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}







