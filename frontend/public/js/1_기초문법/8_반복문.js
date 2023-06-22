//예제1 i는 1부터 10이하까지 1씩 증가 반복
console.log("---------ex3---------")
for(let i=1; i<=10; i++){
	console.log(i)
}

//예제2 i는 1부터 10이하까지 1씩 증가 반복 [줄바꿈x]
console.log("---------ex2---------")
let output = ``
for(let i=1; i<=10; i++){
	output += `${i} `
}
console.log(output)

//예제3 i는 1부터 10이하까지 1씩 증가 반복 [HTML표시]
console.log("---------ex3---------")
output = ``
console.log(output)
for(let i=1; i<=10; i++){
	output += `<p>${i}</p>`
}
document.write(output)

//예제4 i는 1부터 10이하까지 1씩 증가 반복 (누적합계)
console.log("---------ex4---------")
let sum = 0;
for(let i=1; i<=10; i++){
	sum += i
}
console.log( sum )

//예제5 i는 1부터 100까지 7배수 누적합계
console.log("---------ex5---------")
let num = 0
for(let i=0; i<=100; i +=7){
	num += i
}
console.log(num)

//예제6 구구단 2단
console.log("---------ex6---------")
const 단 =2;
for(let i=1; i<=9; i++){
	console.log(`${단} x ${i} = ${단*i}`)
}

//예제7 구구단 9단
console.log("---------ex7---------")
for(let i=2; i<=9; i++){
	console.log(`${i}단`)
	for(let j=1; j<=9; j++){
		console.log(`${i} x ${j} = ${i*j}`)
	}
}



















