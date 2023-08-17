package jspweb.test.day02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test03
 */
@WebServlet("/Test03")
public class Test03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test03() {
        super();

    }

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 콘솔 출력
		//System.out.println("안녕자바스크립트2");
		
		// 2. 웹 출력
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("TEST03 안녕 자바스크립트");
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}












