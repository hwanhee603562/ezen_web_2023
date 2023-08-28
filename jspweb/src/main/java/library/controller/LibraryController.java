package library.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import library.model.dao.LibraryDao;
import library.model.dto.LibraryDto;

/**
 * Servlet implementation class LibraryController
 */
@WebServlet("/LibraryController")
public class LibraryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
        

    public LibraryController() {
        super();
 
    }

    // 좌석 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println();
		ArrayList<Integer> list = new ArrayList<>();
		list = LibraryDao.getInstance().serchSeat();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString( list );
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print( jsonArray );
	}

	// 좌석 입실
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lname = request.getParameter("lname");
		String lphone = request.getParameter("lphone");
		int lseat = Integer.parseInt( request.getParameter("lseat") );
		
		LibraryDto libraryDto = new LibraryDto(lname, lphone, lseat);
		int result = LibraryDao.getInstance().inSeat( libraryDto );
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
		
	}

	// 좌석 퇴실
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String lphone = request.getParameter("lphone");
		int lseat = Integer.parseInt( request.getParameter("lseat") );

		int result = LibraryDao.getInstance().deleteSeat( lphone, lseat );
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
		
	}

}



















