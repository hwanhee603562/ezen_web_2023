package java1.day01;	// 현재 클래스 패키지

public class Ex2_타입 {

	public static void main(String[] args) {
		
		//1. 진수를 표현하는 방법
			// 진수 	: 데이터 표현하는 수의 형식		// 기계어[2진수/이진코드] 표현하는데 한계 극복
			// 0,1	: 2진수, 0~7	: 8진수,	0~9	: 10진수,	0~9ABCDEF : 16진수
		
		int val1 = 0b1011;	//	데이터 앞에 0b		1011 [2] -> 11 [10]
		System.out.println("val1 : "+ val1);
		int val2 = 0206;	// 	데이터 앞에 0		206 [8]	-> 136 [10]
		System.out.println("val1 : "+ val2);
		int val3 = 365;		// 	10진수		
		System.out.println("val1 : "+ val3);
		int val4 = 0xB3;	// 	데이터 앞에 0x		B3 [16]	->	179 [10]
		System.out.println("val1 : "+ val4);
		
		
		// byte 타입 [ -128 ~ 127 ]
		byte b1 = -128;
		System.out.println("b1 : "+b1);
		byte b2 = 127;
		System.out.println("b2 : "+b2);
		//byte b3 = 200;
		//System.out.println("b3 : "+b3);
		//Type mismatch 범위 벗어남
		
		// short 타입 [ -32,000 ~ 32,000 ]
		short s1 = 3200;
		System.out.println("s1 : "+s1);
		//short s2 = -50000;
		//System.out.println("s2 : "+s2);
		//Type mismatch 범위 벗어남
		
		// int 타입 [ 대략 +-21억 ]		* 정수 기본타입 : 1. 우리 코드로 적은 숫자
		int i1 = 2000000000;
		System.out.println(i1);
		//int i2 = 3000000000;
		//System.out.println(i2);
		
		// long 타입 [ 대략 +-21억 이상 자동 ]
		//* 우리가 코드로 작성한 숫자는 int형이기 때문에 long의 숫자가 약21억이 넘을 경우 숫자 뒤에 'L'을 붙여야 함
		long l1 = 10;
		System.out.println("l1 : "+l1);
		//long l2 = 3000000000000;
		long l2 = 3000000000000L;
		
		
		//char타입
		char c1 = 'A';
		System.out.println("c1 : "+c1);
		char c2 = 65;					// 아스키코드 이용
		System.out.println("c2 : "+c2);
		char c3 = '가';
		System.out.println("c3 : "+c3);
		char c4 = 44032;				// 유니코드 이용
		System.out.println("c4 : "+c4);
		
		
		//String클래스
		String str1 = "안녕하세요";
		System.out.println("str1 : "+str1);
		
		
		//float타입				
		//* 우리가 코드로 작성한 숫자는 double형이기 때문에 float의 숫자 뒤에 'f'을 붙여야 함
		float f1 = 0.1351316165153f;
		System.out.println("f1 : "+f1);
		
		
		//double		* 실수 기본타입 : 1. 우리 코드로 적은 숫자
		double d1 = 0.1651651651651651;
		System.out.println("d1 : "+d1);
		
		
		//boolean
		boolean bool1 = true;
		System.out.println("bool1 : "+bool1);
		
		
		// 제어/이스케이프(기능) 문자
			// 		\"	: "출력
		System.out.println("\"");
		
			// 		\'	: '출력
		System.out.println("\'");
		
		// 			\\	: \출력
		System.out.println("\\");
		
		// 			\t	: 들여쓰기
		System.out.println("\t");
		
		// 			\n	: 줄바꿈
		System.out.println("\n");
		
		// 			\r	: 캐리지리턴
		System.out.println("\r");
		
		
		
		
		
		
		
	}
	
}

/*
 	타입/자료형 : 데이터 저장할 때 사용되는 메모리 크기
 		1. 메모리 효율성을 높일 수 있다
 		2. 가독성이 높다
 					
 					메모리크기		허용범위
 	 		
 	 	논리타입
 	 		boolean	1비트			true[1] / false[0]
 	 			
 		문자타입
 			String	클래스[글자수다름]제한없음		String은 유니코드로 변환되지 않음
 			char	2바이트		[0 ~ 65535] 유니코드
 			
 		정수형타입
 			byte	1바이트		[ -128 ~ 127 ]
 			short	2바이트		[ -32,768 ~ 32,767 ]
 			*int	4바이트		[ +-21억 ]
 			long	8바이트		[ +-21억 이상 ]
 			
 		실수형타입
 			float	4바이트		소숫점 7자리 표현
 			*double	8바이트		소숫점 15자리 표현
 		
 	
 	                                                                                                                                                                                                                                                                                          
 	// 용량단위 :
		(처리최소단위)비트 	:	0,1 -> 1bit	-> 01010101	-> 8자리	-> 8bit	-> 1byte
		(저장최소단위)바이트 	:	1byte	->	1024byte	-> 1Kbyte
 		킬로바이트			:	1kb		->	1024kb		-> 1Mb
 		메가바이트			:	1Mb		->	1024Mb		-> 1Gb
 		
 	// 인코딩	:
 	 	컴퓨터	: 01010010101	-> 사람 : ???????????
 	 	컴퓨터	: 10000001	-> 규칙/패턴/해독 (인코딩) -> A
 	 	
 	 	
 	 	아스키코드 : 7비트(확장8비트) 		-> 128문자표현		1바이트 = 
 	 	유니코드	: 전세계 공용어 문자 표현	-> 2바이트		2바이트 = 
 	 	
 		
 		
 		
*/





















