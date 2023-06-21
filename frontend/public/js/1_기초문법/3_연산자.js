/*



*/

/*//1. 산술연산자
console.log('더하기 : '+10+3 )	// 103
console.log('더하기 : '+(10+3))	// 13
console.log('빼기 : '+(10-3))	// 7
console.log('곱하기 : '+(10*3))	// 30
console.log('더하기 : '+(10/3))	// 3.33333~
console.log('더하기 : '+(10%3))	// 1*/

/*//문제1
let 국어 = prompt('국어')
let 영어 = prompt('영어')
let 수학 = prompt('수학')
let 총점 = parseInt(국어)+parseInt(영어)+parseInt(수학)
let 평균 = 총점/3
console.log('총점 : '+총점)
console.log('평균 : '+평균)

//문제2
let 반지름 = prompt('반지름')
let 원넓이 = parseInt(반지름)*parseInt(반지름)*3.14
console.log(원넓이)

//문제3
let 실수1 = prompt('실수1')
let 실수2 = prompt('실수2')
let answer = parseFloat(실수1)/parseFloat(실수2)*100
console.log(answer+'%')*/

/*//2. 비교연산자
console.log('초과 : '+ (10>3))		// true
console.log('미만 : '+ (10<3))		// false
console.log('이상 : '+ (10>=3))		// true
console.log('이하 : '+ (10<=3))		// false
console.log('같다 : '+ (10==3))		// false
console.log('같지않다 : '+ (10!=3))	// false

//3. 관계연산자
console.log('이면서 : '+(10>3 $$ 20>15))
console.log('이면서 : '+(10>3 $$ 20>30))
console.log('이거나 : '+(10>3 || 20>15))
console.log('이거나 : '+(10>3 || 20>30))
console.log('부정 : '+!(10>3))
console.log()
*/
/*//문제4
let 홀짝 = Number(prompt('홀짝'))
console.log(홀짝%2==0 ? '짝수' : '홀수' )
//문제5
let 배수 = Number(prompt('배수'))
console.log(배수%7==0 ? 'true' : 'false' )
//문제6
let 금액 = Number(prompt('금액'))
console.log('십만원 : '+Math.floor(금액/100000)+'장')
console.log('만원 : '+Math.floor(금액%100000/10000)+'장')
console.log('천원 : '+Math.floor(금액%10000/1000)+'장')
console.log('백원 : '+Math.floor(금액%1000/100)+'개')
console.log('십원 : '+Math.floor(금액%100/10)+'개')
console.log('원 : '+Math.floor(금액%10)+'개')
//문제7
let 아이디 = prompt('아이디')
let 비밀번호 = Number(prompt('비밀번호'))
console.log(아이디=="admin" && 비밀번호=="1234" ? 'true' : 'false' )
//문제8
let 입력정수 = Number(prompt('입력정수'))
console.log(입력정수%7==0 && 입력정수%2==1 ? 'true' : 'false' )*/

/*//4. 대입연산자
let 데이터1 = 10
console.log( 데이터1 )
데이터1 +=10
console.log( 데이터1 )
데이터1 -=5
console.log( 데이터1 )
데이터1 *=2
console.log( 데이터1 )

	//예제1
	let html = '<h3> JS에서 작성된 HTML입니다. </h3>'
	html += '<p> 문단 추가 했습니다. </p>'

	document.write(html)
	//html문서에 글을 쓰는 기능*/

/*//5. 증감연산자
let 데이터2 = 10
console.log( 'data : '+데이터2 )
console.log( 'data : '+(데이터2++) )
console.log( 'data : '+(++데이터2) )

console.log('data : '+(데이터2--))
console.log('data : '+(데이터2))
console.log('data : '+(--데이터2))

//6. 삼항연산자 [ 조건 ? 참 : 거짓 ]
let age = 38
let ageline = (age<=19 ? '청소년' : '성인' )
console.log('연령구간 : '+ageline)

let score = 78
let rating = ( score>=90 ? 'A등급' : score>=80 ? 'B등급' : score>=70 ? 'C등급' : '탈락' )
console.log('등급 : '+rating)*/

//문제9
let num1 = Number(prompt('정수1'))
let num2 = Number(prompt('정수2'))
let answer1 = (num1>num2 ? num1 : num2)
console.log('큰 수 : '+answer1)

//문제10
let num3 = Number(prompt('정수1'))
let num4 = Number(prompt('정수2'))
let num5 = Number(prompt('정수3'))
let answer2 = (num3>num4&&num3>num5 ? num3 : num4>num5&&num4>num3 ? num4 : num5)
math.Max

console.log('큰 수 : '+answer2)

//문제11
let numa = Number(prompt('정수1'))
let numb = Number(prompt('정수2'))
let numc = Number(prompt('정수3'))
let answer3 = ( numa<numb&&numa<numc ? numa : numb<numa&&numb<numc ? numb : numc)
let answer4 = ( (numa<numb&&numa>numc)||(numa<numc&&numa>numb) ? numa : (numb<numa&&numb>numc)||(numb<numc&&numb>numa) ? numb : numc )
let answer5 = ( numa>numb&&numa>numc ? numa : numb>numa&&numb>numc ? numb : numc )
console.log('오름차순 : '+answer3+' '+answer4+' '+answer5)

//문제12
let player1 = Number(prompt('플레이어1'))
let player2 = Number(prompt('플레이어2'))
let answer = ( player1==player2 ? '무승부' : player1==(player2+1)%3 ? '플레이어1 승리' : '플레이어2 승리')
console.log('결과 : '+answer)














