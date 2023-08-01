package java1.day14.Ex2_오버라이딩;

public class Ex2_실행 {
	public static void main(String[] args) {
		
		int r = 10;
		
		Calculator calculator = new Calculator();
		
		System.out.println("원 면적 : "+ calculator.areaCircle(r));
		
		Computer computer = new Computer();
		
		System.out.println("원 면적 : "+ computer.areaCircle(r));
	}
}
