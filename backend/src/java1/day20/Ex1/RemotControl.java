package java1.day20.Ex1;

public interface RemotControl {	// 인터페이스 선언
	// 인터페이스 : 다른 클래스 사이의 중간 매개역할을 담당하는 추상 클래스의 일종
	// 구성멤버	
		// 1. public 상수 필드			[public static final]
	int MAX_VOLUME = 10;
	public static final int MIN_VOLUME = 0;
	
		// 2. public 추상 메서드		[public abstract]
	void turnOn();
	public abstract void turnOff();
	void setVolume( int volume );
	
		// 3. public 디폴트 메서드		[public] default
	default void setMute ( boolean mute ) {
		if(mute) {
			System.out.println("무음 처리합니다");
			setVolume( MIN_VOLUME );
		} else {
			System.out.println("무음 해제합니다");
		}
	}
	public default void getMute() {
		System.out.println("");
	}
	
		// 4. public 정적 메서드		[public] static
	static void changeBattery() {
		System.out.println("리모콘 건전지를 교환합니다");
	}
	public static void chackBattery() {
		System.out.println("건전지 확인합니다");
	}
	
	/*
	// 자바 1.9버전 부터 가능
		// 5. private 메서드		: 디폴트메서드 안에서만 호출 가능
	private void defualtCommon() {
		System.out.println("디폴트 메서드");
	}
	
		// 6. private 정적 메서드	: 디폴트메서드, 정적 메서드 호출가능
	private static void staticCommon() {
		System.out.println("정적메서드");
	}
	*/
}

/*
	인스턴스멤버	: 객체 생성시 static이 없는 메모리 할당되는 필드, 메서드
	정적멤버		: 객체가 없어도 static이 있는 메모리 우선할당되는 필드, 메서드
		- 정적멤버는 인스턴스멤버에 접근할 수 없다
	



 */










