/*
 
 	- 변수 : 데이터1개 저장하는 메모리공간
 		- 저장된 데이터는 변경이 가능하다.
 		- let 변수 선언시 사용되는 키워드
 			[ var키워드 : 변수명 중복가능(사용권장x) ]
 		- 변하는값, [ 임시 저장 ]
 		
 	- 상수 : 데이터1개 저장하는 메모리공간
  		- 저장된 데이터는 변경이 불가능하다.
  		- const 상수 선언시 사용되는 키워드
  		- 고정된값, 변하지 않는값, 일정한값 [ 파이(3.14) 등등 ]
  	
  	- 변수/상수 선언/만들기 형태
  		1. 키워드 키워드 [ let vs const ]
  		2. 변수/상수 이름 [영문, 띄어쓰기x, 숫자시작x, 카멜표기법]
			카멜표기법 classname --> className
		3. 대입연산자 =
			오른쪽 데이터가 왼쪽에 대입/저장
		4. 데이터
		
	- 변수/상수 사용
		1. 출력 : 호출할 변수명
		2. 수정 : 수정할 변수명
		
	- 연산자
		1. 산술연산자 : +더하기  -빼기  *곱하기  /나누기  %나머지
		
		2. 연결연산자 : +연결연산자
		
		3. 비교연산자 :
				> 초과/크다		< 미만/작다
				>=이상/크거나 같다	<=이하/작거나같다
				==같다[데이터비교]	===같다[데이터형/데이터 비교]
				!=같지않다/아니다 	!===같지않다/아니다
		
		4. 관계연산자 : 
				&& 이면서 면서 이고 모두 그리고 and조건
				|| 이거나 거나 또는 하나라도 or조건
				! 반대 부정 not조건	!true => false
		
		5. 대입연산자 :
				= 대입 [ 오른쪽 데이터를 왼쪽 대입 ]
				+= [오른쪽 데이터를 왼쪽에 더한 후에 왼쪽에 대입]
				(-=  *=  /=  %=)
		
		6. 증감연산자 :
				++ 1증가 [ 선위증가 : ++변수 / 후위증가 : 변수++]
				-- 1감소 [ 선위감소 : --변수 / 후위감소 : 변소--]
				
		7. 삼항연산자 :
				조건 ? 참 : 거짓
		
		
*/
// 1. 변수 선언 (1. let) (2. 변수명) (3. 대입) (4. 데이터)
let 변수1 = 10	// '변수1' 변수에 10 데이터를 저장했다.

// 2. 변수 출력
console.log( 변수1 )

// 3. 변수의 수정
변수1=20			// 변수는 1개의 데이터만 저장하므로 기존 데이터는 사라짐
console.log( 변수1 )

// 4. 변수의 연산
let 변수2 = 변수1 + 10 
console.log( 변수2 )
console.log( 변수2 + 10 )

// 5. 입력받은 값 저장
let 입력 = prompt('숫자 입력해주세요')
console.log('입력받은 숫자 : '+입력)

let 상태 = confirm('삭제하시겠습니까?')
// confirm() : 확인(true) or 취소(flase) 
console.log('버튼 상태 : '+상태)


//--------------------------------------------------
//1. 상수 선언
const 상수1 = 10 
//2. 상수 출력
console.log( 상수1 )
//3. 상수 수정
//상수1 = 20
//console.log( 상수1 )	// 오류발생 : Assignment to constant variable.
//4. 상수 연산
const 상수2 = 상수1 + 20
console.log( 상수2 )
//5. 입력받은 값을 상수에 저장
const 입력2 = prompt('문자 입력')
console.log('입력받은 문자 : '+ 입력2)