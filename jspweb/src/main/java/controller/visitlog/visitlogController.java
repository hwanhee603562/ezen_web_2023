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
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print( jsonArray );
	}

	// 3. 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 데이터를 요청한다
			// request.getParameter("객체의 속성명")
		int vno = Integer.parseInt( request.getParameter("vno") );
		String vcontent = request.getParameter("vcontent");
		String vpwd = request.getParameter("vpwd");

		// 반드시 server.xml 에서 63번째줄, 코드에 기능을 추가하여야만 js와 통신이 가능하다
		
		// 2. (데이터가 많으면)객체화
		// 3. Dao에게 전달 후 SQL결과를 받는다
		boolean result = VisitDao.getInstance().vupdate(vno, vcontent, vpwd);
		// 4. 결과를 AJAX에게 전달한다
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	
	// 4. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 데이터를 요청한다
		// request.getParameter("객체의 속성명")
		int vno = Integer.parseInt( request.getParameter("vno") );
		String vpwd = request.getParameter("vpwd");
		
		// 2. (데이터가 많으면)객체화
		
		// 3. Dao에게 전달 후 SQL결과를 받는다
		boolean result = VisitDao.getInstance().vdelete(vno, vpwd);
		
		// 4. 결과를 AJAX에게 전달한다
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}
	/* 
	 	- HTTP서블릿클래스는 기본적으로 get, post, put, delete 함수 제공 
	 	- 기본 톰캣서버는 get, post만 매개변수(데이터) 전달 가능
	 	- put, delete 함수도 매개변수 전달 가능하도록 설정 [ 서버마다 설정 ] 
	 	server.xml
	 		63번줄 코드
	 			<Connector connectionTimeout="20000" maxParameterCount="1000" port="80" protocol="HTTP/1.1" parseBodyMethods="POST,PUT,DELETE" URIEncoding="UTF-8"/>
	 		put,delete에도 매개변수를 전달가능하도록  "parseBodyMethods="POST, PUT, DELETE" URIEncoding="UTF-8"추가
	 */
	
}























