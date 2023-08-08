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
	public int signupLogic(String id, String pw, String name, String phone) {

		// 유효성검사 진행
			// 아이디 중복체크
		if(MemberDao.getInstance().infoCheck("mid", id)) return 3;
			// 전화번호 중복체크
		if(MemberDao.getInstance().infoCheck("mphone", phone)) return 4;
		
		// 유효성검사 통과 후
		// 1. 객체화 : 5개 변수들이 이동할때마다 매개변수의 개수로 인해 코드가 길어지기에 패키지화
		MemberDto dto = new MemberDto(0, id, pw, name, phone);
			// 회원가입시 회원번호는 자동[auto_increment]이므로 필요없음
		boolean result = MemberDao.getInstance().signupSQL( dto );
		
		// 결과 확인
		if(result) return 1;
		else return 2;
		
		
	}
	
	
	
	// 0 로그인된 회원의 번호를 저장하는 필드 = 웹세션
		// 0 	: 로그인 안한상태
		// 1이상 	: 로그인된 회원의 번호
	// 로그인이된 여부를 확인하는 것을 넘어 로그인이 완료된 회원이 누구인가를 찾아야 한다
	private int loginSession = 0;
	public int getLoginSession() {
		return loginSession;
	}
	
	
	
	// 2-1 로그인 처리
	public boolean loginLogic(String id, String pw) {
		System.out.println("--- loginLogic컨트롤 도착");
	
		
		
		// 유효성검사를 했다고 가정함
		// 1. 매개변수가 2개라서 객체화를 안하였지만 해도 무방
		// 2. Dao에게 전달
		int result = MemberDao.getInstance().loginSQL( id, pw );
		
		// 로그인 성공했을 때 기록하기
		if( result >= 1 ) {
			this.loginSession = result;
			return true;
		} else return false;
		
		
	}
	
	// 2-2 로그아웃 처리
	public void logOut() {
		this.loginSession = 0;
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































