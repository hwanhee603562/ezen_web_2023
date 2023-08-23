package java2.day24.Ex3;

public class Ex3_제네릭 {
	
	public static void main(String[] args) {
		// 1. Home 렌탈 조작하는 구현체 [ 안산지점 대리점 ]
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
			// 2. 해당 대리점 렌탈...
		home.turnOnLight();
		
		// 2. 자동차 렌탈 구현체 [ 안산지점 대리점 ]
		CarAgency carAgency = new CarAgency();
		Car car = carAgency.rent();
		car.run();	
	}

	
}
