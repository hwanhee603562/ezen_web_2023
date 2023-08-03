package java1.day16.Ex2_매개변수의다형성;

public class Driver {
	// 매개변수의 다형성 예제의 메소드 선언
	public void drive(int value, Vehicle vehicle) {
		/*
		 	객체명 instanceof 클래스명
		 	: 해당 객체가 해당 클래스의 타입이면 true/ or not false
		 */
		
		System.out.println("vehicle 타입확인 : "+(vehicle instanceof Bus));
		System.out.println("vehicle 타입확인 : "+(vehicle instanceof Taxi));
		
		if(vehicle instanceof Bus) {
			System.out.println("버스전진");
			Bus bus = (Bus)vehicle;
		}
		if(vehicle instanceof Taxi) {
			System.out.println("택시전진");
			Taxi bus = (Taxi)vehicle;
		}
		
		vehicle.run();
	}
}
