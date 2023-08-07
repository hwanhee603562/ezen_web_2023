package java1.day18.Ex1;

public class Ex1_실행 {
	public static void main(String[] args) {
		
		// 1. 인터페이스타입의 변수 선언
		RemoteControl rc;
			// 인터페이스만으로 객체 생성 불가능
		
		// 2. 참조변수 생성
		rc = new Television();
		/*
			 
			구현객체 
			 : 해당 추상메서드가 존재한 인터페이스를 구현해준 클래스로 객체 생성
			 
			 ※ 인터페이스는 생성자를 가질 수 없으므로 생성자는 인터페이스를 구현한 클래스로 한다
			
		*/
		
		// 3. 인터페이스로 메서드 실행
		rc.turnOn();
		
		
		// 4. 리모컨을 오디오로 변경
		rc = new Audio();
		rc.turnOn();
		
		// 5. 리모콘 상수필드 호출
		System.out.println("AUDIO 리모콘의 최대 볼륨 : "+ rc.MAX_VOLUME);
		System.out.println("AUDIO 리모콘의 최소 볼륨 : "+ rc.MIN_VOLUME);
		
		// 6. 메서드 실행 
		
		rc.setVolume(-10);
		
		// 7. 리모콘 교체
		rc = new Television();
		
		
		/*
					인터페이스					상속		 차이점
			사용		implements				extends
			의미		구현하다					연장하다
			★개수		여러개 구현	가능				1개 상속
			메서드종류	추상메서드					메서드
					* 버전[다양한 메서드 제공]
			목적		메서드 통합					빠른 개발과 설계 모듈화
			생성자여부	생성자 사용불가				생성자 사용가능

		*/
		
		
		
		
		
		
		
	}
}
