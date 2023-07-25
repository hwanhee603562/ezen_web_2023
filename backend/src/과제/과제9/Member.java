package 과제.과제9;

// 목적 : 설계도, 객체의 모델
public class Member {

	// 1. 멤버변수
	String id;
	String password;
	String name;
	String phone;
	int age;
	
	// 이클립스 생성자 자동생성 기능
	// 빈공간에 마우스우클릭 - source 클릭 - Generate constructor using fields - 사용할 매개변수 개수 선택 - 접근제어선택

	// 2. 생성자
		// 0. 빈[매개변수 없는] 생성자
	public Member() {
		
	}
		// 1. 매개변수 5개 정의한 생성자
	public Member(String id, String password, String name, String phone, int age) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	/*
	// 1. 매개변수 4개 정의한 생성자
	public Member(String id, String password, String Name, String phone) {
		
	}
	// 1. 매개변수 3개 정의한 생성자
	public Member(String id, String password, String Name) {
		
	}
	// 1. 매개변수 2개 정의한 생성자
	public Member(String id, String password) {
		
	}
	// 1. 매개변수 1개 정의한 생성자
	public Member(String id) {
		
	}
	// 1. 매개변수 1개 정의한 생성자
	public Member(int age) {
		
	}
	*/
	
	
	
	
	// 3. 메서드
	
	
}
