package jspweb.test.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test2
 */
@WebServlet("/Test2")	// @ : 어노테이션 : 해당클래스의 URL 매핑을 연결해주는 어노테이션
public class Test02 extends HttpServlet { // HttpServlet 클래스로부터 상속을 받으면 해당 웹 관련 기능 제공 [1. 멀티 스레드 제공 2. 예외처리 3. HTTP get,post 등 CRUD기능 제공]
	
	/*
	 	HTTP : HYPERTEXT TRANSFER PROTOCOL : 문서 교환 규약
		 	HTTP 메소드
			 	get : 호출  /  post : 저장  /  put :수정  /  delete : 삭제
	
	*/
	
	// 브라우저[크롬, 엣지 등] 에서 주소 입력해서 웹사이트 접속하는 방식
		// 주소창 www.naver.com => get방식
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test02() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 콘솔 출력
		System.out.println("안녕자바스크립트1");
		// 2. 웹 출력
		response.getWriter().append("Hello JS 안녕하세요");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
