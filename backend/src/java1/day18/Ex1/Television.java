package java1.day18.Ex1;


// 클래스에서 RemoteControl 인터페이스를 구현
// 한 클래스에서 여러 인터페이스를 받는 것도 가능
public class Television implements RemoteControl{
	// 클래스명 implements 인터페이스명
	// 인터페이스가 선언한 추상메서드[abstract]를 해당 클래스가 대신 구현해야함
	
	
	// 멤버변수
	private int volume;
	
	
	
	// implements 키워드를 사용하였으면 추상메서드를 반드시 전부 구현해야함
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다");
	}
	
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다");
	}
	
	@Override
	public void setVolume(int volume) {
		if( volume > RemoteControl.MAX_VOLUME ) {
			
			this.volume = RemoteControl.MAX_VOLUME;
			
		} else if( volume < RemoteControl.MIN_VOLUME ) {
			
			this.volume = RemoteControl.MIN_VOLUME;
			
		} else {
			
			this.volume = volume;
			
		}
		System.out.println("현재 텔레비전 소음 : "+this.volume);
	}
	
	
	
	
}
