package java1.day16.Ex1_필드의다형성;

public class Car {
	public Tire tire;
	
	public void run() {
		tire.roll();
	}
}
