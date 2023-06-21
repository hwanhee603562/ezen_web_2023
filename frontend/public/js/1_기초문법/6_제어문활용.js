/*//문제1
let num1 = Number(prompt('정수1'))
let num2 = Number(prompt('정수2'))
if(num1>num2){
	console.log(num1)
}else{
	console.log(num2)
}
*/
//문제2
/*let num1 = Number(prompt('정수1'))
let num2 = Number(prompt('정수2'))
let num3 = Number(prompt('정수3'))
if(num1>num2&&num1>num3){
	console.log(num1)
}else if(num2>num1&&num2>num3){
	console.log(num2)
}else{
	console.log(num3)
}*/
//문제3
/*let num1 = Number(prompt('정수1'))
let num2 = Number(prompt('정수2'))
let num3 = Number(prompt('정수3'))
let num4 = Number(prompt('정수4'))
if(num1>num2&&num1>num3&&num1>num4){
	console.log(num1)
}else if(num2>num1&&num2>num3&&num2>num4){
	console.log(num2)
}else if(num3>num1&&num3>num2&&num3>num4){
	console.log(num3)
}else{
	console.log(num4)
}*/
//문제4
/*
let num1 = Number(prompt('정수1'))
let num2 = Number(prompt('정수2'))
let num3 = Number(prompt('정수3'))
let answer1
let answer2
let answer3
if(num1>num2&&num1>num3){
	answer3 = num1
}else if(num2>num1&&num2>num3){
	answer3 = num2
}else{
	answer3 = num3
}

if(num1>num2&&num1<num3||num1<num2&&num1>num3){
	answer2 = num1
}else if(num2>num1&&num2<num3||num2<num1&&num2>num3){
	answer2 = num2
}else{
	answer2 = num3
}

if(num1<num2&&num1<num3){
	answer1 = num1
}else if(num2<num1&&num2<num3){
	answer1 = num2
}else{
	answer1 = num3
}
console.log(answer1+" "+answer2+" "+answer3)
*/

//문제5
/*
let number = [Number(prompt('정수1')), Number(prompt('정수2')), Number(prompt('정수3')), Number(prompt('정수4'))]

number.sort();

console.log(number[0]+' '+number[1]+' '+number[2]+' '+number[3]);
*/

//문제6
let score = Number(prompt('점수'))

if(score>=90){
	console.log('합격')
}else{
	console.log('탈락')
}

















