package java1.day05;

public class Ex2_문자열 {
	public static void main(String[] args) {
		
		/* 1. 문자열 비교 */
		
		String name1 = "홍길동";
		String name2 = "홍길동";
		
		System.out.println( name1 == name2 );
		//true 출력
		//문자열의 특수성으로
		//리터럴로 입력받은 문자열은 상수로서 효율적인 메모리관리를 위해
		//힙영역에 메모리를 할당하여 동일한 객체를 공유하기에 '==' 사용하여도 true 출력
		//즉, 동일한 리터럴 문자열을 저장하는 변수는 동일한 주소값을 가리키게 됨
		
		// 추가로 scan으로 입력받은 문자열은 또 다른 객체로 생성되는 것이기에 리터럴이 아니다
		
		String name3 = new String("홍길동");
		String name4 = new String("홍길동");
		
		System.out.println( name3 == name4 );
		//false 출력
		//new 연산자를 통한 메모리 생성, 주소값 할당은 새로운 주소값을 가지기에 다른 번지를 가리키게 됨
		
		
		
		if( name1 == name2 ) {
			System.out.println("name1 == name2 : 두 문자열 같습니다");
		} else {
			System.out.println("name1 == name2 : 두 문자열 다릅니다");
		}
		
		if( name3 == name4 ) {
			System.out.println("name3 == name4 : 두 문자열 같습니다");
		} else {
			System.out.println("name3 == name4 : 두 문자열 다릅니다");
		}
		
		
		
		/* 2. 문자열 내 특정문자 추출 */
		
		String ssn = "9506241230123";
		char sex = ssn.charAt(6);
		
		if( sex=='1' || sex=='3' ) {
			System.out.println("남자입니다");
		} else {
			System.out.println("여자입니다");
		}
		
		
		
		/* 3. .length() 문자열의 길이구하기 */
		
		System.out.println("주민등록번호 길이 : "+ssn.length());
		
		
		
		/* 4. .replace() 문자열 내 특정 문자열 교체/치환/대체 */
		
		String oldStr = "자바 문자열은 불변입니다. 자바 문자열은 String입니다";
		// 문자열내 "자바" --> "JAVA"로 교체 후 교체된 문자열 반환
		String newStr = oldStr.replace("자바", "JAVA");
		System.out.println("치환 전 : "+oldStr);
		System.out.println("치환 후 : "+newStr);
		
		
		
		/* 5. .substring() : 문자열 자르기 */
		
		String ssn2 = "880815-1234567";
		System.out.println("substring1 전부자르기 : "+ssn2.substring(7));
		//인덱스 7 부터 마지막까지 반환
		System.out.println("substring2 부분자르기 : "+ssn2.substring(7, 10));
		//인덱스 7 부터 인덱스 10까지 반환
		
		
		
		/* 6. .split()		: 문자열 분리 */
		
		System.out.println( ssn2.split("-")[0] );
		System.out.println( ssn2.split("-")[1] );
		// { 880815, 1234567 }
		
		
		
		/* 7. .indexOf() 	: 문자 찾기 */
		String subject = "자바 프로그래밍";
		
		int location = subject.indexOf("프로그래밍");
		if(location == -1) {
			System.out.println("indexOf : 프로그래밍 책이 아닙니다");
		} else {
			System.out.println("indexOf : 프로그래밍 책이 맞습니다");
		}
		
		
		
		
	}
}

/*

자바 문자열 사용하는 방법
	1. String 변수명 = "문자열"
	2. String 변수명 = new String("문자열")

자바 문자열에서 제공해주는 라이브러리
	- 객체.메소드명()
		1. 문자열객체1.equals( 문자열객체2 )	: 두 문자열객체 내 문자열이 동일하면 true 아니면 false 반환
		2. 문자열객체.charAt( 인덱스 )		: 문자열 내 해당 인덱스의 문자 1개 추출
		3. 문자열객체.length()				: 문자열에서 문자의 길이 반환
		4. 문자열객체.replace("기존문자열", "새로운문자열")	: 문자열 내 기존문자열이 존재하면 새로운문자열로 치환해서 반환
		5. 문자열객체.substring( 인덱스 )				: 해당 인덱스부터 마지막인덱스까지 반환
		   문자열객체.substring( 시작인덱스, 끝인덱스 )	: 시작 인덱스부터 끝 인덱전까지 문자열 반환
		6. 문자열객체.split("분리기준문자")				: 문자열 내 분리기준문자로 분리해서 '배열'로 반환
		7. 문자열객체.indexOf("찾고싶은문자열")			: 문자열 내 찾을 문자열이 존재하면 찾은 인덱스 반환 / 없으면 -1

 */










