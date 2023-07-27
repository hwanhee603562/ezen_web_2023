package java1.day11.Ex5디자인패턴2;

import java1.day11.Ex5디자인패턴2.view.MainPage;

public class AppStart {
	public static void main(String[] args) {
		// 다른 클래스에 있는 메소드를 호출하는 방법
		//	1. 메소드가 인스턴스멤버일 경우	=>	객체를 이용한 메소드 호출	=> 객체
			//MainPage mainPage = new MainPage();
			//mainPage.mainPage();
		
		//	2. 메소드가 static멤버일 경우	=>	클래스를 이용한 메소드 호출 => 멤버 공용
			//MainPage.mainPage();
		
		//	3. 메소드가 싱글톤 객체( 정적객체 )일 경우	=>	싱글톤 호출하여 메소드 호출	=> 프로그램 내 1개 객체
		MainPage.getInstance().mainPage();
	}
}
