package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {

	private static MemberController memberController = new MemberController();
	public static MemberController getInstance() {
		return memberController;
	};
	private MemberController() {}
	
	
	// 회원가입 처리
	public void signupLogic(String id, String pw, String name, String phone) {
		System.out.println("--- signupLogic컨트롤 도착");
		System.out.println(id + pw + name + phone);
		// 유효성검사를 했다고 가정함
		// 1. 객체화 : 5개 변수들이 이동할때마다 매개변수의 개수로 인해 코드가 길어지기에 패키지화
		MemberDto dto = new MemberDto(0, id, pw, name, phone);
			// 회원가입시 회원번호는 자동[auto_increment]이므로 필요없음
		MemberDao.getInstance().signupSQL( dto );
	}
	// 로그인 처리
	public void loginLogic(String id, String pw) {
		System.out.println("--- loginLogic컨트롤 도착");
		System.out.println(id + pw);
		// 유효성검사를 했다고 가정함
		// 1. 매개변수가 2개라서 객체화를 안하였지만 해도 무방
		// 2. Dao에게 전달
		MemberDao.getInstance().loginSQL( id, pw );
		
		
	}
	
	
}
