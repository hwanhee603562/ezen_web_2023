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