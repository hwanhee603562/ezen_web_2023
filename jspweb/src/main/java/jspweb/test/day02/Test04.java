package jspweb.test.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Test04")
public class Test04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Test04() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. JSON 타입모양의 문자열 [ - 자바는 JSON 없음 ]
		String jsonData = "{ \"title\" : \"제목1\", \"content\" : \"안녕하세요\" }";
			// " " 문자처리 안에 "문자인식 => \"
		System.out.println("자바[String타입]에서의 JSON 모양 만들기" + jsonData);
		
		
		
		// 1. JSON 타입
		
			// 1-1 JSON 타입으로 할 경우
		response.setContentType("application/json;charset=UTF-8");
				// 콘솔창		{title: '제목1', content: '안녕하세요'}
		
		
			// 1-2 문자열 타입으로 할 경우	: 객체로서 속성 사용불가
		//response.setContentType("text/html;charset=UTF-8");
				// 콘솔창		{ "title" : "제목1", "content" : "안녕하세요" }
		

		// 2. 전송/응답 할 데이터
		response.getWriter().print( jsonData );
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
