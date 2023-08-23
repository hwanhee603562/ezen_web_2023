package accountBook.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import accountBook.model.dao.AccountBookDao;
import accountBook.model.dto.AccountBookDto;
import model.dao.VisitDao;

/**
 * Servlet implementation class accountBookController
 */
@WebServlet("/accountBookController")
public class AccountBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AccountBookController() {
        super();
        
    }
    
    
    // 1. 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acontent = request.getParameter("acontent");
		int aprice = Integer.parseInt( request.getParameter("aprice") );
		String adate = request.getParameter("adate");
		System.out.println(adate);
		AccountBookDto accountBookDto = new AccountBookDto(acontent, aprice, adate);
		
		boolean result = AccountBookDao.getInstance().awrite( accountBookDto );
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
	}
	
	
    // 2. 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AccountBookDto> result = AccountBookDao.getInstance().aread();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString( result );
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print( jsonArray );
	}

	// 3. 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ano = Integer.parseInt( request.getParameter("ano") );
		String acontent = request.getParameter("acontent");
		int aprice = Integer.parseInt( request.getParameter("aprice") );
		String adate = request.getParameter("adate");
		boolean result = AccountBookDao.getInstance().aupdate( ano, acontent, aprice, adate );

		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}

	// 4. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ano = Integer.parseInt( request.getParameter("ano") );
		
		boolean result = AccountBookDao.getInstance().adelete( ano );
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
		
	}

}
















