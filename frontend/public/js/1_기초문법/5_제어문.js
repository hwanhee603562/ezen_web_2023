/*

	- 제어문 = if = 만약에
	
	1. 제어문 : 흐름에 대한 논리적인 제어
	2. if, switch
	3. if 형태
		* 조건 : true or false 결과를 갖는 변수 혹은 연산
		1. if( 조건 ) 참일경우코드
		2. if( 조건 ){ 참일경우코드; 참일경우코드; }
		3. if( 조건 ){ 참일경우코드}
			else{ 거짓일경우코드 }
*/

//1. if 형태1
if(10>3) console.log('참[1] 10이 3보다 크다.')
// true
if(10>20) console.log('참[1] 10이 3보다 크다.')
// false
if(10>20){
	console.log('참[1] 10이 3보다 크다.')
}

//