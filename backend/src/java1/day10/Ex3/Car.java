package java1.day10.Ex3;

// 설계
public class Car {
	
	// 멤버
		/*	관례적으로 멤버변수는 접근제어를 'private'으로 함
		 *	관례적으로 해당 클래스에서 멤버변수의 사용은 'this.변수명'을 사용 
		 * */
	
	int gas;
	
	// 생성자
	
	
	// 메소드	
		/*	관례적인 메소드명명
		 *	1. 멤버변수에 저장하는 용도 = 'set필드명' (setter)
		 *  2. 멤버변수에 값을 호출하는 용도 = 'get필드명' (getter)
		 *  3. 멤버변수의 값 존재여부(boolean)를 확인하는 용도 = 'is필드명'
		 * */
	
	
		// 1. 리턴x 매개변수1개 : 매개변수로부터 전달받은 gas값을 필드gas 저장하는 함수
	void setGas(int gas) {
		this.gas = gas;
		// this : 현재객체 [ 매개변수와 필드와 이름이 동일할 때 식별하기위해 사용 ]
	}
	
		// 2. 리턴o 매개변수x	현재 객체의 gas필드가 0이면  false 리턴 아니면 true 리턴
	boolean isLeftGas() {
		if(this.gas == 0) {
			System.out.println("gas가 없습니다");
			return false;
		}
		System.out.println("gas가 있습니다");
		return true;
	}
	
		// 3. 리턴x 매개변수x	: 필드의 gas가 0이 될때까지 gas를 1씩 차감
	void run() {
		while(true) {
			if(this.gas > 0) {
				System.out.println("달립니다. 가스 잔량 : "+this.gas);
				this.gas--;
			} else {
				System.out.println("멈춥니다. 가스 잔량 : "+this.gas);
				return;
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
