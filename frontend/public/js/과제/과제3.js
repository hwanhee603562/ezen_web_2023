let dateinput = document.querySelector(".dateinput")
let date = dateinput.value
let menuinput = document.querySelector(".menuinput")
let menu = menuinput.value
let priceinput = document.querySelector(".priceinput")
let price = Number(priceinput.value)


let count = 0;
let sum = 0;
let i = 0;

let buttonHTML = `<tr><th>날짜</th><th>항목</th><th>금액</th><th>비고</th></tr>`

function input(){
	
	sum += Number(priceinput.value)

	buttonHTML[i] += `<tr class="cli"><td>${dateinput.value}</td><td>${menuinput.value}</td><td>${Number(priceinput.value)}</td><td><button onclick="inputdelete()" class="DeleteBtn" class="btn btn-danger pull-right">삭제</button></td></tr>`
	i++;

	document.querySelector(".출력구역").innerHTML = buttonHTML
	
	document.querySelector(".출력구역").innerHTML += `<tr><th colspan="2">-총합계-</th><th colspan="2">${sum.toLocaleString( )}</th></tr>`

	
	dateinput.value = ''
	menuinput.value = ''
	priceinput.value = ''

	
}

function inputdelete(){

}


