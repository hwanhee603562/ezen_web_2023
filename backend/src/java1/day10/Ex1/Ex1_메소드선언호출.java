package java1.day10.Ex1;

import java.util.Scanner;

// 목적 : 실행
public class Ex1_메소드선언호출 {

	public static void main(String[] args) {
		
		// 1. 메소드를 호출하기 위한 객체 생성
		Calculator myCalc = new Calculator();
		
		// 2. 객체를 통한 메소드 호출 / 매개변수 전달 x / 리턴x
		myCalc.powerOn();
		
		// 3. 객체 통한 메소드 호출 / 매개변수 2개 전달 "리터럴" / 리턴o
		int result1 = myCalc.plus(5, 6);
		System.out.println("result1 : "+ result1);
		
		// 4. 객체 통한 메소드 호출 / 매개변수 2개 전달 (값, 주소) / 리턴o
		int x = 10;
		int y = 4;
		
		double result2 = myCalc.devide( x, y );
		System.out.println("result2 : "+result2);
		
		
		
		myCalc.powerOff();
	}
	
	
}
