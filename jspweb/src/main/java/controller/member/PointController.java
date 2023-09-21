package controller.member;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dto.MemberDto;
import model.dto.MpointDto;

/**
 * Servlet implementation class PointController
 */
@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PointController() {
        super();
        // TODO Auto-generated constructor stub
    }

	// 포인트 사용[증감/차감]
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. UUID 만들어서 포인트내역 식별자로 사용
		String mpno = UUID.randomUUID().toString();
		
		// 2. 로그인된[세션에저장된] 회원정보에서 회원번호만 출력
		int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		
		// 3. 포인트 수량 / 지급내역은 JS에서 전달받음
		Long mpamount = Long.parseLong( request.getParameter("mpamount") );
		String mpcomment = request.getParameter("mpcomment");
		
		// ------- Dto
		MpointDto mpointDto = new MpointDto( mpno, mno, mpamount, mpcomment, null );
		// ------- Dao
		boolean result = MemberDao.getInstance().setPoint( mpointDto );
		// ------- 응답
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print( result );
		
		
	}
    
    
    // 내 포인트 사용내역 / 내 포인트 확인
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 서로 다른 함수/기능을 실행하기 위한 분류
		String type = request.getParameter("type");
		
		
		int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		
		// 2. 분류
			// 2-1 내 포인트 확인
		if( type.equals("findByPoint") ) {
		
			long result = MemberDao.getInstance().getPoint(mno);
			json = mapper.writeValueAsString(result);
			
		}	// 2-2 내 포인트 내역 전체 출력
		else if ( type.equals("findByAll") ) {
			List< MpointDto> result =  MemberDao.getInstance().getPointList(mno);
			json = mapper.writeValueAsString(result);
		}
		
		// ------- 응답
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print( json );
		
		
		
		
		
		
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}































