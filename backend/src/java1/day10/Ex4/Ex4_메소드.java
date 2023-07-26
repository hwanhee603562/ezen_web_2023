package java1.day10.Ex4;

import java.util.Scanner;

public class Ex4_메소드 {
	public static void main(String[] args) {
		
		// 1. 메서드 사용/호출
		Member m = new Member();
		// 2. 객체내 .(도트연산자) 이용한 필드/메소드 호출
			// 1. 리턴x 매개변수x 함수 호출
		m.signUp();
			// 2. 리턴x 매개변수o 함수 호출
		m.login("qwe", 1234);
			// 3. 리턴o 매개변수x 함수 호출
		m.findId();
		String result2 = m.findId();
		
		Scanner sc = new Scanner(System.in);
		
		
	}
}
