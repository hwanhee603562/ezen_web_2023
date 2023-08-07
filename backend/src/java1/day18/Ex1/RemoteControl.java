package java1.day18.Ex1;

// 인터페이스 선언
public interface RemoteControl {
	// 멤버 구성
		// 1. 상수필드
	public static final int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
			// static final int MAX_VOLUME = 10;
			// static final을 생략하여 사용가능
		// 2. 추상메소드	: 선언만 하고 {} 구현은 하지않는 함수
		
		// 1. 전원켜기 함수
	public void turnOn();
			// abstract 를 생략하여 사용가능
		// 2. 전원끄기 함수
	void turnOff();
	
		// 3. 볼륨조절 함수
	void setVolume( int volume );
	
	
	
}
