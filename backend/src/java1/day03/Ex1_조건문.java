package java1.day03;

import java.util.Random;

public class Ex1_조건문 {
	
	public static void main(String[] args) {
		
		int score = 93;
		if( score >= 90 ) System.out.println("합격1");
		
		if( score >= 90 ) {
			System.out.println("2점수가 90점보다 큽니다");
			System.out.println("2등급은 A등급입니다");
		}
		
		if( score < 90 ) {
			System.out.println("3점수가 90보다 작습니다");
			System.out.println("3등급은 B등급입니다");
		} else {
			System.out.println("3점수가 80점보다 큽니다");
			System.out.println("3등급은 B등급입니다");
		}
		
		if( score >= 90 ) {
			System.out.println("4점수가 100~90입니다");
			System.out.println("4등급은 A등급입니다");
		} else if( score >= 80 ) {
			System.out.println("4점수가 80~89입니다");
			System.out.println("4등급은 B등급입니다");
		} else if( score >= 70 ) {
			System.out.println("4점수가 70~79입니다");
			System.out.println("4등급은 C등급입니다");
		} else if( score >= 60 ) {
			System.out.println("4점수가 60~69입니다");
			System.out.println("4등급은 D등급입니다");
		}
		
		if( score >= 90 ) {
			System.out.println("5점수가 100~90입니다");
			System.out.println("5등급은 A등급입니다");
		} 
		if( score >= 80 ) {
			System.out.println("5점수가 80~89입니다");
			System.out.println("5등급은 B등급입니다");
		} 
		if( score >= 70 ) {
			System.out.println("5점수가 70~79입니다");
			System.out.println("5등급은 C등급입니다");
		} 
		if( score >= 60 ) {
			System.out.println("5점수가 60~69입니다");
			System.out.println("5등급은 D등급입니다");
		}
		
		
		
		// 난수생성
		System.out.println(Math.random()); //0.0<= ~ <1.0
		System.out.println(Math.random()*6); //0.0<= ~ <6.0
		System.out.println( (int)Math.random()*6 ); //0<= ~ <6
		System.out.println( (int)Math.random()*6+1 ); // 1<= ~ <7
		
		
		// 난수 생성 클래스 : Random 클래스
			// 1. Random 객체 생성
			// 2. Random 값 호출
		Random random = new Random();
		System.out.println(random.nextInt());
		System.out.println(random.nextInt(3));	// 0~2
		System.out.println(random.nextInt(6));	// 0~5
		System.out.println(random.nextInt(45)+1);	// 1~45
		
		System.out.println(random.nextInt(26)+97);	// 97~122
		
		int num = (int)(Math.random()*6)+1;	// 1~6
		int num2 = random.nextInt(6)+1;
		
		if(num==1) System.out.println("1나왔습니다");
		else if(num==2) System.out.println("2나왔습니다");
		else if(num==3) System.out.println("3나왔습니다");
		else if(num==4) System.out.println("4나왔습니다");
		else if(num==5) System.out.println("5나왔습니다");
		else System.out.println("6나왔습니다");
		
		
		int score3 = (int)(Math.random() * 20) + 81;	// 81~100
		String grade;
		
		  if ( score3 >= 90) { // 점수가 90점 이상이면
		         
	            if(score >= 95) { grade = "A+"; } // 100~95
	            else { grade = "A"; } // 90~94
	      } else { // 90 미만
	         
	         if(score3 >= 85) {grade = "B+";} // 89~85
	         else { grade = "B";} // 84 ~ 85 미만이면 B
	      }
	      
	      
	      char grade2 ='B';
	      
	      switch( grade2) {  
	         case 'A' :
	         case 'a' :
	            System.out.println("A등급 우수회원");
	            break;
	         case 'B' :
	         case 'b' :
	            System.out.println("B등급 우수회원");
	            break;
	         default :
	      }

		
		
	}
}
