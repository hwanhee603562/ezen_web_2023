package java1.day09.Ex1;

public class Ex1_생성자 {
	public static void main(String[] args) {
		//1. 객체생성 : 클래스명 객체변수명 = new 생성자명();
			// 1개 이상의 생성자(기본생성자 제외)를 선언했을 때 기본생성자는 자동생성 불가
		
		// 생성자 2개 선언하여 사용가능
		Car myCar1 = new Car();
		Car myCar2 = new Car("그랜저", "검정", 20);
	}
}
