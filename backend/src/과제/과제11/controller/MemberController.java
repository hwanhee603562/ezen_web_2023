package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {

	private static MemberController memberController = new MemberController();
	public static MemberController getInstance() {
		return memberController;
	};
	private MemberController() {}
	
	
	// 1 회원가입 처리
	public boolean signupLogic(String id, String pw, String name, String phone) {

		// 아이디 중복체크
		if(MemberDao.getInstance().infoCheck("mid", id)) return false;
		if(MemberDao.getInstance().infoCheck("mphone", phone)) return false;
		
		
		// 전화번호 중복체크
		
		
		// 유효성검사를 했다고 가정함
		// 1. 객체화 : 5개 변수들이 이동할때마다 매개변수의 개수로 인해 코드가 길어지기에 패키지화
		MemberDto dto = new MemberDto(0, id, pw, name, phone);
			// 회원가입시 회원번호는 자동[auto_increment]이므로 필요없음
		boolean result = MemberDao.getInstance().signupSQL( dto );
		
		return result;
		
	}
	// 2 로그인 처리
	public boolean loginLogic(String id, String pw) {
		System.out.println("--- loginLogic컨트롤 도착");
	
		
		
		// 유효성검사를 했다고 가정함
		// 1. 매개변수가 2개라서 객체화를 안하였지만 해도 무방
		// 2. Dao에게 전달
		boolean result = MemberDao.getInstance().loginSQL( id, pw );
		
		return result;
		
	}
	// 3 아이디 찾기
	public String findId( String name, String phone ) {
		// 권장) 테스트. view에서 전달받은 매개변수 유효성 검사
		System.out.println("view value : "+ name + phone);
		
		String result = MemberDao.getInstance().findById(name, phone);
		
		return result;	//	실패
	}
	// 4 비밀번호 찾기
	public String findPw( String id, String phone ) {
		// 권장) 테스트. view에서 전달받은 매개변수 유효성 검사
		System.out.println("view value : "+ id + phone);
		
		String result = MemberDao.getInstance().findByPw(id, phone);
		
		return result;	//	실패
	}
	
	
}































