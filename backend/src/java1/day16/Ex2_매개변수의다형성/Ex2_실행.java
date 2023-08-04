package java1.day16.Ex2_매개변수의다형성;

public class Ex2_실행 {
	public static void main(String[] args) {
		
		
		// 0. 
		Driver driver = new Driver();
		
		// 1. 부모객체
			// Driver클래스의 drive메서드와 타입이 동일하기에 당연히 가능하다
		Vehicle vehicle = new Vehicle();
		System.out.println("---------------->1.차량대입");
		driver.drive(3, vehicle);
		
		// 2. 자식객체
			// Driver클래스의 drive메서드와 타입이 동일하지는 않지만 
			// 자식타입도 해당 메서드의 매개변수도 가능하다
		Bus bus = new Bus();
		System.out.println("---------------->2.버스대입");
		driver.drive(3, bus);
		
		// 2. 자식객체
			// Driver클래스의 drive메서드와 타입이 동일하지는 않지만 
			// 자식타입도 해당 메서드의 매개변수도 가능하다
		Taxi taxi = new Taxi();
		System.out.println("---------------->3.택시대입");
		driver.drive(3, taxi);
		
		// 하지만 상위 객체는 불가하다
		//Object o = new Object();
		//driver.drive(3, o);
		
	}
}
