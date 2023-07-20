package java1.day06;

import java.util.Scanner;

public class Ex2_확인문제9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {};
		
		while(true) {
			System.out.println("-------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("-------------------------------------------------");
			System.out.println("선택>");
			int n = sc.nextInt();
			
			if(n==1) {
				System.out.println("선택>1");
				System.out.println("학생수>");
				int m = sc.nextInt();
				arr = new int[m];
				
			} else if(n==2) {
				System.out.println("선택>2");
				for(int i=0; i<arr.length; i++) {
					System.out.printf("scores[%d]", i);
					System.out.println("");
					int a = sc.nextInt();
					
					arr[i] = a;
				}
			} else if(n==3) {
				System.out.println("선택>3");
				for(int i=0; i<arr.length; i++) {
					System.out.printf("scores[%d] : ", i);
					System.out.println(arr[i]);
				}
			} else if(n==4) {
				System.out.println("선택>4");
				int b=0;
				int sum = 0;
				float c = arr.length;
				for(int i=0; i<arr.length; i++) {
					if(b<arr[i]) {
						b=arr[i];
					}
					sum += arr[i];
				}
				System.out.println("최고 점수 : "+b);
				System.out.println("평균 점수 : "+(sum/c));
			} else if(n==5) {
				System.out.println("선택>5");
				System.out.println("프로그램종료");
				break;
			}
			
			
			
			
			
			
		}
	}
}
