/*console.log('------------예제3------------')
//예제3
let n = Number(prompt("횟수"))
for(let i=1; i<=n; i++){
	let num = ``
	for(let j=1; j<=i; j++){
		num += `*`
	}
	console.log(`${num}`)
}
console.log('------------예제4------------')
//예제4
for(let i=n; i>=1; i--){
	let num = ``
	for(let j=1; j<=i; j++){
		num += `*`
	}
	console.log(`${num}`)
}
console.log('------------예제5------------')
//예제5
for(let i=1; i<=n; i++){
	let num = ``
	for(let j=i; j<=n; j++){
		num += ' '
	}
	for(let k=1; k<=i; k++){
		num += `*`
	}
	console.log(`${num}`)
}
console.log('------------예제6------------')
//예제6
for(let i=1; i<=n; i++){
	let num = ``
	for(let k=1; k<=i; k++){
		num += ' '
	}
	for(let j=i; j<=n; j++){
		num += '*'
	}
	console.log(`${num}`)
}
console.log('------------예제7------------')
//예제7
for(let i=1; i<=n; i++){
	let num = ``
	for(let k=i; k<n; k++){
		num += ' '
	}
	for(let j=1; j<=(i*2)-1; j++){
		num += '*'
	}
	console.log(`${num}`)
}
console.log('------------예제8------------')
//예제8
for(let i=n; i>=1; i--){
	let num = ``
	for(let k=i; k<n; k++){
		num += ' '
	}
	for(let j=i*2-1; j>=1; j--){
		num += '*'
	}
	console.log(`${num}`)
}
console.log('------------예제9------------')
//예제9
for(let i=1; i<=n; i++){
	let num = ``
	for(let k=i; k<n; k++){
		num += ' '
	}
	for(let j=1; j<=(i*2)-1; j++){
		num += '*'
	}
	console.log(`${num}`)
}
for(let i=n; i>=1; i--){
	let num = ``
	for(let k=i; k<n; k++){
		num += ' '
	}
	for(let j=i*2-1; j>=1; j--){
		num += '*'
	}
	console.log(`${num}`)
}
console.log('------------예제10------------')
//예제10
n = Number(prompt("횟수"))
isReverse = true
let max = n-2+1
adsub = 1

for(let x=0;x<max;x+= adsub)
{
   _str = ""
   for(let z = 0;z<x;z++)
   {
      _str +=" "
   }
   _str +="*"
   if(x==parseInt(n/2)+1&&isReverse) // 가운데
   {

      console.log(_str)
      
      adsub = -1
      isReverse = false
      continue
   }
   else if(!isReverse)
   {
      if(x==-1)
      {break}
   }
   for(let i=n-(x*2); i>0;i--)
   {
      _str += " "
   }

   _str += "*"
   console.log(`${_str}`)
}*/
console.log('------------예제11------------')
//예제11 n == 7
let m = Number(prompt("횟수(11번 부터)"))
for(let i=1; i<=m/2; i++){
	let num = ``
	for(let k=1; k<=i; k++){
		num += '*'
	}
	for(let j=i*2+1; j<=m; j++){ 
		num += ` `
	}
	for(let r=1; r<=i; r++){
		num += '*'
	}
	console.log(`${num}`)
}
let number = ``
for(let i=1; i<=m; i++){
	number += '*'
}
console.log(`${number}`)
for(let i=1; i<=m/2; i++){
	let num = ``
	for(let k=i; k<=m/2; k++){
		num += '*'
	}
	for(let j=1; j<=i*2-1; j++){
		num += ` `
	}
	for(let r=i; r<=m/2; r++){
		num += '*'
	}
	console.log(`${num}`)
}
console.log('------------예제12------------')
//예제12 n == 7
for(let i=1; i<=m/2; i++){
	let num = ``
	for(let k=1; k<i; k++){
		num += ' '
	}
	for(let j=i*2-1; j<=m; j++){
		num += `*`
	}
	for(let r=1; r<i; r++){
		num += ' '
	}
	console.log(`${num}`)
}
number = ``
for(let i=1; i<=m/2; i++){
	number += ' '
}
console.log(`${number}*`)
for(let i=1; i<=m/2; i++){
	let num = ``
	for(let k=i+1; k<m/2; k++){
		num += ' '
	}
	for(let j=1; j<=i*2+1; j++){
		num += `*`
	}
	for(let r=i+1; r<m/2; r++){
		num += ' '
	}
	console.log(`${num}`)
}









