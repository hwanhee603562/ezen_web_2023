package java1.day07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex_파일처리 {
	public static void main(String[] args) throws IOException {
		
		/*
		 스택영역 : 함수는 호출시 메모리할당, 종료시 메모리초기화
		
		 파일처리 라이브러리( 미리 만들어진 클래스/메소드 )
			 * 스트림 : 자바 외부와 통신할 때 사용 통로 [ 바이트단위 ]
				 통신 중 오류 발생할 수 있기에 '예외처리/오류처리'를 필수적으로 사용
			 1. FileOutputStream : 파일 내보내기/저장 관련된 메소드를 제공하는 클래스
				 new FileOutputStream("파일경로");	: 해당 파일과 연동/연결
					 파일경로
						 상대경로 : 프로젝트명 생략 -> ./src/패키지명/파일명
						 절대경로 : C:\Users\504\git\ezen_web_2023\backend\src\java1\day07\Ex1_테스트.java
				
				  new FileOutputStream("파일경로" , true );	: 해당파일과 연동/연결
	 				파일경로에 해당 파일이 존재하지 않으면 해당 파일 생성 , 이어쓰기
			 2. FileInputStream : 파일 불러오기 관련된 메소드 제공하는 클래스
				 new FileInputStream("파일경로")

		
		
		
		
		
			 2. 제공하는 함수
				 1	.write(바이트배열) : 해당 객체와 연결된 파일의 바이트 내보내기
						//* 영문:1바이트 / 한글:2바이트
						//여러 글자를 입력해야할 시 바이트 배열을 이용
				 2	.read(바이트배열) : 해당 객체와 연결된 파일의 바이트 읽어와서 바이트배열에 저장
		
		
		
		
			 3. File		: 파일에 정보/제어 관련 메소드 제공
				new file("파일경로")
				메소드
					1. .exists()	: 파일 경로에 파일 존재여부 true / false 반환
					2. .delete()	: 파일 경로에 파일 삭제 실행 
					3. .getPath()	: 파일이 위치한 경로를 문자열 반환 
					4. .length()	: 파일의 용량(바이트)을 long 타입 반환 
		
		*/
		
		
		
		
		Scanner scanner = new Scanner(System.in);
		String instr = scanner.next();  	// 객체에 입력받은 값의 바이트열을 문자열로 반환
		
		// 1. 파일처리 [저장]
			// 1. 파일출력스트림 객체 선언[파일경로]
			// 1-1 해당 파일경로에 파일이 있는 경우만 가능
		//FileOutputStream fileOutputStream = new FileOutputStream("./src/java1/day07/Ex1_테스트.txt");
			// 1-2 해당 파일경로에 파일이 없는 경우 새로운 파일 생성
		FileOutputStream fileOutputStream = new FileOutputStream("./src/java1/day07/Ex2_테스트.txt", true);
				// 이어쓰기 기능추가
			// 2. 파일출력스트림 객체를 이요한 내보내기 메소드 사용 [바이트 단위]
		byte[] outstrArray = instr.getBytes();		// 문자열을 바이트배열로 변환
		fileOutputStream.write(outstrArray);		// 바이트배열을 내보내기
		
		
		
		// 2. 파일처리 [불러오기]
			// 1. 파일입력스트림 객체 선언 [파일경로] 
		FileInputStream fileInputStream = new FileInputStream("./src/java1/day07/Ex2_테스트.txt");
			// 2. 파일입력스트림 객체를 이용한 파일내용 읽어오기 [바이트 단위]
		byte[] instrArray = new byte[1000];
		// 파일의 바이트만큼 배열 선언 (단, 임의로 영문 1000글자, 한글 500글자까지로 설정)
		// 입력값에 따라 파일의 용량은 달라지기 때문에 정확한 파일의 용량은 알 수 없음
		// 물론, 용량을 불러오는 클래스가 존재함
		fileInputStream.read(instrArray);
			// 3. 바이트배열을 문자열 변환
		String str = new String(instrArray);  // 바이트 배열에 공백이 있는 경우 공백으로 채움
		System.out.println( str );
		
		
		
		// 3. 외부파일 불러오기 [ CSV 불러오기 ]
			// 1. 역대 로또 번호 [ CSV ]
		FileInputStream 복권파일 = new FileInputStream("./src/java1/day07/로또.csv");
			// 2. 해당파일의 용량 알기 [ 40,960 바이트 ]
		File file = new File("./src/java1/day07/로또.csv");
			System.out.println("해당 경로에 파일존재여부 : "+file.exists());
			// file.delet();	파일 제거
			System.out.println("해당 파일의 경로 : "+file.getPath());
			System.out.println("해당 파일의 용량 : "+file.length());	// long타입으로 반환
		byte[] 복권파일바이트배열 = new byte[ (int)file.length() ];	// 용량만큼 배열 선언
			// 3. 읽어오기
		복권파일.read(복권파일바이트배열);
			// 4. 바이트배열 --> 문자열 변환
		String 복권파일정보 = new String(복권파일바이트배열);
		System.out.println( 복권파일정보 );
		
		
		// 4. 외부파일 불러오기 [ CSV 불러오기 ]
		String 경로 = "./src/java1/day07/전국관광지정보표준데이터.csv";
		
			// 1. 파일 입력 객체 생성
		FileInputStream 관광지파일 = new FileInputStream(경로);
			// 2. 파일 정보 객체 생성
		File file2 = new File(경로);
			// 3. 파일 용량만큼의 바이트배열 선언
		byte[] 관광지파일바이트배열 = new byte[ (int)file.length() ];
			// 4. 읽어온 바이트를 해당 배열에 저장
		관광지파일.read(관광지파일바이트배열);
			// 5. 바이트배열 --> 문자열 변환
			// 한글이 존재하면 기본값 UTF-8에서 EUC-KR로 인코딩 변경
			// 한글 인코딩(번역) 방법 대표적으로 2가지(UTF-8, EUC-KR)
		String 관광지파일정보 = new String(관광지파일바이트배열, "EUC-KR");
		//System.out.println( 관광지파일정보 );
		
		System.out.println( 관광지파일정보.split("\n")[0]);
		

		
		
	}
}
