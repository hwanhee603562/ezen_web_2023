package java1.day14.Ex1_상속;

// 여기서의 Phone은 'extends Object'사용되지는 않았지만
// Object 클래스는 자바에서 최상위클래스로서 Phone은 Object를 상속받았다고 할 수 있다
public class Phone {

	// 필드 
	public String model;
	public String color;
	
	// 메소드
	public void bell() {
		System.out.println("벨이 울립니다");
	}
	
	public void sendVoice(String message) {
		System.out.println("자기 : "+message);
	}
	
	public void receiveVoice( String message ) {
		System.out.println("상대방 : "+message);
	}
	public void hangUp() {
		System.out.println("전화를 끊습니다");
	}
	
}
