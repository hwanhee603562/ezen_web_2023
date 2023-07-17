package java1.day02;

public class Ex2_연산자 {
	public static void main(String[] args) {
		
		int x = 10;
		int y = -10;
		
		System.out.println(" x : "+ x);
		System.out.println(" y : "+ y);
		
		//1. 산술연산자
		System.out.println(" x + y : "+(x+y));	// 더하기
		System.out.println(" x - y : "+(x-y));	// 빼기
		System.out.println(" x * y : "+(x*y));	// 곱하기
		System.out.println(" x / y : "+(x/3));	// 나누기 몫
		System.out.println(" x + y : "+(x%3));	// 나누기 나머지
		
		//2. 비교연산자		: 연산후 boolean값 반환
		System.out.println(" x == y : "+(x==y));	// 같다
		System.out.println(" x != y : "+(x!=y));	// 같지않다
		System.out.println(" x > y : "+(x>y));		// x는 y보다 초과
		System.out.println(" x < y : "+(x<y));		// x는 y보다 미만
		System.out.println(" x >= y : "+(x>=y));	// x는 y보다 이상
		System.out.println(" x <= y : "+(x<=y));	// x는 y보다 이하
		
		//3. 관계(논리)연산자
		System.out.println(" x >= 10 and y >= 10 : "+ ( x>=10 && y>=10 ));	//조건이 모두 true이면 true / true and false => false 
		System.out.println(" x >= 10 or y >= 10 : "+ ( x>=10 || y>=10 ));	//조건이 하나라도 true이면 true / true or false => true
		System.out.println(" 부정 : = "+ ( !true ));
		
		//4. 대입연산자
		int a = 30;	//대입연산자[ 기존 데이터 사라짐 ]
		a += x;		//오른쪽 대이터를 왼쪽데이터에 더한 후에 대입[ 누적합계 ]
			System.out.println(a);
		a -= x;a *= x;a /= x;a %= x;
		
		//5. 삼항연산자		조건 ? 참 : 거짓
		String result = (x >= 20) ? "합격" : "불합격";
		System.out.println(result);
		String result2 = ( x>=10) ? "1차합격" : (y>=10) ? "2차합격" : "최종탈락";
		
		//6. 증감연산자
		System.out.println(" ++x : "+ ( ++x ));		// 선위증가
		System.out.println(" x++ : "+ ( x++ )); 	// 후위증가
		System.out.println(" x: "+ x);
		
		System.out.println(" --x : "+ ( --x ));
		System.out.println(" x-- : "+ ( x-- ));
		System.out.println(" x : "+ ( x ));
		
		//7. 연결연산자
		System.out.println( 3 + 3 ); 	// 더하기
		System.out.println("연결"+ 3 + 3); 	//연결	//응용
		
		
		
		
		
		
		
	}
}






















