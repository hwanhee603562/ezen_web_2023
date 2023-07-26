package 과제.과제9;

import java.util.Scanner;

// 목적 : 실행
public class MemberSys {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 0. Member객체 저장배열 선언
			// 참조(String, 직접생성한틀래스 등)타입 배열 선언
		Member[] memberList = new Member[100];
		
		
		while(true) {
			
			// 1. 무한출력
			System.out.println("----------회원 시스템----------");
			System.out.println("1.회원가입 2.로그인    선택> ");
			
			// 2. 무한입력
			int ch = sc.nextInt();
			
			if(ch == 1) {
				System.out.println("----------회원가입----------");
				// 1. 각 입력받아 저장
				
				System.out.println("아이디 : ");
				String inputId = sc.next();
				System.out.println("비밀번호 : ");
				String inputPw = sc.next();
				System.out.println("이름 : ");
				String inputName = sc.next();
				System.out.println("전화번호 : ");
				String inputPhone = sc.next();
				System.out.println("나이 : ");
				int inputAge = sc.nextInt();
				// 2. 기본생성자[과제8] vs 정의한생성자[과제9]
				Member member = new Member(inputId, inputPw, inputName, inputPhone, inputAge);
				
				

				
				// 3. 여러 개의 객체를 저장하기 위해 배열에 저장
					// * 비어있는 인덱스를 찾아서 해당 인덱스에 객체저장
				for(int i=0; i<memberList.length; i++) {
					if(memberList[i] == null) {
						memberList[i] = member;
						break;
					}
				}
				
				
				
			} else if(ch == 2) {
				System.out.println("----------로그인----------");
				// 1. 입력받기
				System.out.println("아이디 : ");
				String inputId = sc.next();
				System.out.println("비밀번호 : ");
				String inputPw = sc.next();
				
				// 2. 입력받은 데이터를 배열내 찾기
				int login = -1;
				for(int i=0; i<memberList.length; i++) {
					
					// memberList 내 기본값은 null이기 때문에 null이 아닌 경우에 확인하도록함
					// and연산 '&&'는 가장 왼쪽부터 비교하기에 null값 판단은 가장 왼쪽이어야함
					if( memberList[i] != null && memberList[i].id.equals(inputId) && memberList[i].password.equals(inputPw) ) {
						
						login = i;
						break;
					}
				}
				
				// 3. 로그인 성공여부 변수에 따른 흐름제어
				if(login != -1) {
					System.out.println("로그인 실패");
				} else {
					System.out.println("로그인 성공");
				}
			}
		}
	}
}

/*

	주제 : 회원제 시스템
		0. 저장
			아이디, 비밀번호, 이름, 전화번호, 나이
			* 위 5가지 데이터를 하나의 묶음방법
			--> 문자열 이용 : "아이디,비밀번호,이름,전화번호"	: ',' 쉼표 이용한 필드 구분 
			--> 클래스(필드) 이용 : 
				1. 클래스 설계 = 새로운 클래스.java 파일 생성
				2. 클래스 멤버 구성 : 멤버변수, 생성자, 메소드
				* 이전에는 동일한 타입을 여러개 저장하였지만 객체배열을 이용하여 다른 타입을 저장가능
			--> 문자열 배열 : String[] 문자열배열 = new String[100];
			--> 클래스 배열 : Member[] 객체배열 = new Member[100];
			
		1. 초기 메뉴
			1. 회원가입	2. 로그인

		2. 조건 기능
			1. 회원가입
				1. 아이디, 비밀번호, 이름, 전화번호, 나이 각 입력받아 저장
				2. Member 객체화
				3. 객체를 배열에 저장
			2. 로그인
				1. 아이디, 비밀번호 입력받아 저장
				2. 배열내 입력받은 값과 동일한 값 찾기
					- 만일 동일한 값이 있으면 로그인 성공
					- 아니면 실패
				


 */























 