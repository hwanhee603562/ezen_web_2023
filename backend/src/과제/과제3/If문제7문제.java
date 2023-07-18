package 과제.과제3;

import java.util.Scanner;

public class If문제7문제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/* -------문제1----- */
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a==b) {
			System.out.println("같다");
		} else if (a>b) {
			System.out.println("크다");
		} else if (a<b) {
			System.out.println("작다");
		}
		
		
		/* -------문제2----- */
		
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		
		if(c>d && c>e) {
			System.out.println(c);
		} else if(d>c && d>e) {
			System.out.println(d);
		} else if(e>c && e>d){
			System.out.println(e);
		}
		
		
		
		/* -------문제3----- */
		
		int f = sc.nextInt();
		int g = sc.nextInt();
		int h = sc.nextInt();
		
		int max = 0;
		
		if(f>g && f>h) {
			max = f;
		} else if(g>f && g>h) {
			max = g;
		} else if(h>f && h>g){
			max = h;
		}
		
		int min = 0;
		if(f<g && f<h) {
			min = f;
			
		} else if(g<f && g<h) {
			min = g;
			
		} else if(h<f && h<g){
			min = h;
		}
		
		int mid = 0;
		if(max==g && min==h || max==h && min==g ) {
			mid = f;
		} else if (max==f && min==h || max==h && min==f ) {
			mid = g;
		} else {
			mid = h;
		}
		
		System.out.println(min+" "+mid+" "+max);
		
		
		/* -------문제4----- */
		
		int rang = sc.nextInt();
		
		if(rang>=90) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		
		/* -------문제5----- */
		
		int rae = sc.nextInt();
		
		if(rae>=90) {
			System.out.println("A등급");
		} else if(rae >= 80) {
			System.out.println("B등급");
		} else if(rae >= 70) {
			System.out.println("C등급");
		} else {
			System.out.println("재시험");
		}
		
		/* -------문제6----- */
		
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		int p = (kor+eng+math)/3;
		
		if(p>=90) {
			if(kor==100) System.out.println("국어우수");
			else if(eng==100) System.out.println("영어우수");
			else if(math==100) System.out.println("수학우수");
		} else if (p>=80) {
			if(kor==90) System.out.println("국어장려");
			else if(eng==90) System.out.println("영어장려");
			else if(math==90) System.out.println("수학장려");
		} else {
			System.out.println("재시험");
		}
		
		
		/* -------문제7----- */
		
		String id = sc.nextLine();
		String pwd = sc.nextLine();
		
		String adminid = "admin";
		String adminpwd = "1234";
		
		if(id.equals(adminid) && pwd.equals(adminpwd)) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		
		
	}
	
}

/*

		 
	문제7 로그인페이지
	 		[ 입력 ] : 아이디와 비밀번호를 입력받기
	 		[ 조건 ] : 회원아이디가 admin 이고 
	           			비밀번호가 1234 일 경우에는 
	          			로그인 성공 아니면 로그인 실패 출력
 */
