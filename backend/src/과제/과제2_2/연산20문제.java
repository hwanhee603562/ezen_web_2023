package 과제.과제2_2;

import java.util.Scanner;

public class 연산20문제 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//------ 문제1 여기에 풀이-------//
		System.out.println("|\\_/|\r" );
		System.out.println("|q p|   /}\r");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
		
		------ 문제2 여기에 풀이-------//
		
		String member = sc.nextLine();
		String content = sc.nextLine();
		String wd = sc.nextLine();
		
		System.out.println("------------방문록-------------");
		System.out.println("| 순번\t| 작성자\t|내용\t|날짜");
		System.out.println("1\t|"+member+"\t|"+content+"\t|"+wd);
		System.out.println("-----------------------------");

	  
		//------ 문제3 여기에 풀이-------//
		
		
		int 기본급 = sc.nextInt();
		int 수당 = sc.nextInt();
		
		double 세금 = 기본급*0.1;
		double 실수령액 = 기본급 + 수당 - 세금;
		
		System.out.println("실수령액 : "+실수령액);
		
		
		
		
		//------ 문제4 여기에 풀이-------//
		
		int 금액 = sc.nextInt();
		
		int 십만원 = 금액/100000;
		int 만원 = (금액%100000)/10000;
		int 천원 = (금액%10000)/1000;
		int 백원 = (금액%1000)/100;
		
		System.out.println("십만원 : "+십만원);
		System.out.println("만원 : "+만원);
		System.out.println("천원 : "+천원);
		System.out.println("백원 : "+백원);
		
		
		//------ 문제5 여기에 풀이-------//
		
		int 배수 = sc.nextInt();
		
		System.out.println( 배수%7==0 ? 'O' : 'X');
		
		
		//------ 문제6 여기에 풀이-------//
		
		
		int 홀수 = sc.nextInt();
		
		System.out.println( 홀수%2==1 ? 'O' : 'X');
		
		
		
		//------ 문제7 여기에 풀이-------//
		
		
		int 하나의정수 = sc.nextInt();
		
		System.out.println( 하나의정수%7==0 && 하나의정수%2==0 ? 'O' : 'X');
		
		
		
		//------ 문제8 여기에 풀이-------//
		
		
		int 두개의정수 = sc.nextInt();
		
		System.out.println( 두개의정수%7==0 || 두개의정수%2==1 ? 'O' : 'X');
		
		
		
		//------ 문제9 여기에 풀이-------//
		
		
		int 종수1 = sc.nextInt();
		int 종수2 = sc.nextInt();
		
		System.out.println( 종수1>종수2 ? 종수1 : 종수2);
		
		
		//------ 문제10 여기에 풀이-------//
		
		
		
		int 반지름 = sc.nextInt();
		
		System.out.println("반지름 : "+반지름*반지름*3.14);
		
		
		
		//------ 문제11 여기에 풀이-------//
		
		
		float 설수1 = sc.nextFloat();
		float 설수2 = sc.nextFloat();
		
		System.out.println(설수1/설수2*100);
		
		
		//------ 문제12 여기에 풀이-------//
		
		
		int 윗변 = sc.nextInt();
		int 밑변 = sc.nextInt();
		int 높이 = sc.nextInt();
		
		System.out.println("사다리꼴 계산식 : "+(윗변 + 밑변)*높이);
		
		
		
		
		//------ 문제13 여기에 풀이-------//
		
		int 키 = sc.nextInt();
		
		System.out.println((키-100)*0.9);
		
		
		
		//------ 문제14 여기에 풀이-------//
		
		
		int 키2 = sc.nextInt();
		int 몸무게 =  sc.nextInt();
		
		System.out.println(몸무게/((키2/100)*(키2/100)));
		
		
		
		//------ 문제15 여기에 풀이-------//
		
		
		float inch1 = sc.nextFloat();
		float cm = inch1*2.54f;
		
		System.out.println(cm);
		
		
		//------ 문제16 여기에 풀이-------//
		
		int 중간고사 = sc.nextInt();
		int 기말고사 = sc.nextInt();
		int 수행평가 = sc.nextInt();
		
		int 합계 = 중간고사+기말고사+수행평가;
		
		float 반영비율1 = 합계*0.3f;
		float 반영비율2 = 합계*0.3f;
		float 반영비율3 = 합계*0.4f;
		
		System.out.printf("%.2f %.2f %.2f", 반영비율1, 반영비율2, 반영비율3);
		
		
		//------ 문제17 여기에 풀이-------//
		
		
		int x = 10;
	    int y = x-- + 5 + --x;
	    System.out.printf(" x의 값 : %d , y의값 :  %d ", x, y);
		// x가 출력되는 값은 178번줄 후위1감소, 선위1감소로 인한 기본 초기화값 10에서 -2를 뺀 8이 출력
	    // y가 출력되는 값은 178번줄 x의 후위감소 및 x의 선위 감소로 인한 (10) + 5 + (10-1-1)로 23을 출력  
		
		//------ 문제18 여기에 풀이-------//
		
		int age = sc.nextInt();
		
		String answer = age>=10 && age<20 ? "학생" : age >=20&& age<40 ? "성인" : "중년";
		
		System.out.println(answer);
		
		//------ 문제19 여기에 풀이-------//
		
		int 국어 = sc.nextInt();
		int 영어 = sc.nextInt();
		int 수학 = sc.nextInt();
		
		float 평균 = (국어+영어+수학)/3;
		
		System.out.println("총점 : "+국어+영어+수학);
		System.out.printf("%.2f", 평균);
		
		
		
		
		//------ 문제20 여기에 풀이-------//
		
		String id = sc.nextLine();
		String pwd = sc.nextLine();
		
		System.out.println(id.equals("admin") && pwd.equals("1234") ? "로그인성공" : "로그인실패");
		
		//------ 문제21 여기에 풀이-------//
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		
		System.out.println(n1>n2 && n1>n3 ? n1 : n2>n3 ? n2 : n3);
		
		
	}

}


/*


문제2 : 입력받은 3개 데이터를 이용한 표 만들기 
	[입력변수]
		1. 작성자[문자열] , 내용[문자열] , 날짜[문자열] 입력받아 각 변수에 저장 
	[출력 예]
		   --------------방문록--------------------
		   | 순번  | 작성자  | 	내용 	| 날짜       |
		   |  1   | 강호동  |안녕하세요  |  09-28    |
		  ----------------------------------------
	
문제3 : 급여 계산
	[입력조건]
		기본급[정수] , 수당[정수]
	[ 조건 ] 
		 실수령액 = 기본급 + 수당 - 세금[기본급10%] 
	[출력조건] 
		실수령액 출력[ 소수점 없이  ]

문제4 : 지폐 세기 
	 [입력조건 ] 
		금액 
	 [조건 ] 
		 십만원 부터 백원 까지의 개수 세기 
	[ 출력조건 ]
		예) 356789 입력시 
		 십만원 3장 
		 만원 5장
		 천원 6장 
		 백원 7개

문제5 : 하나의 정수를 입력받아 7의 배수인지 출력[ 'O' 혹은 'X' 로 출력]

문제6 : 하나의 정수를 입력받아 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력]

문제7 : 하나의 정수를 입력받아 7의 배수 이면서 짝수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

문제8 : 하나의 정수를 입력받아 7의 배수 이거나 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

문제9 : 두개의 정수를 입력받아 더 큰수 출력 

문제10 : 반지름을 입력받아 원 넓이 출력하기 
	계산식) 원 넓이 공식 => 반지름 * 반지름 * 원주율[3.14]

문제11 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기 
	예) 54.5   84.3 실수 2개입력시 결과는   64.285714%

문제12 : 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기 
	계산식) 사다리꼴 계산식 = > (윗변 + 밑변) * 높이 / 2

문제13: 키를 정수를 입력받아 표준체중 출력하기 
	계산식) 표준체중 계산식 = > (키 - 100) * 0.9

문제14: 키와 몸무게를 입력받아 BMI 출력하기 
	계산식) BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))

문제15: inch 를 입력받아 cm 로 변환하기 
	계산식) 1 inch -> 2.54cm

문제16:  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하여 소수 둘째자리까지 점수 출력하시오 
	계산식 반영비율)  중간고사 반영비율 => 30 %  / 기말고사 반영비율 => 30 %   / 수행평가 반영비율 => 40 %

문제17 :  연산 순서 나열 하고 printf() 에 출력되는 x 와 y 값을 예측하시오.
	int x = 10;
	int y = x-- + 5 + --x;
	printf(" x의 값 : %d , y의값 :  %d ", x, y)

문제18 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기

문제19 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력

문제20 : 아이디[문자열] 와 비밀번호[문자열] 를 입력받아 아이디가 'admin' 이고 비밀번호가 '1234' 와 일치하면 로그인성공 아니면 로그인실패 출력

문제21 : 세 정수를 입력받아 가장 큰수 출력 

  
 */
