/*



*/

//1. 산술연산자
console.log('더하기 : '+10+3 )	// 103
console.log('더하기 : '+(10+3))	// 13
console.log('빼기 : '+(10-3))	// 7
console.log('곱하기 : '+(10*3))	// 30
console.log('더하기 : '+(10/3))	// 3.33333~
console.log('더하기 : '+(10%3))	// 1

//문제1
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
console.log(answer+'%')