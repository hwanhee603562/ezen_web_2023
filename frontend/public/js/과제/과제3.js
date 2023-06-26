let dateinput = document.querySelector(".dateinput")
let date = dateinput.value
let menuinput = document.querySelector(".menuinput")
let menu = menuinput.value
let priceinput = document.querySelector(".priceinput")
let price = Number(priceinput.value)

let sum = 0;


function input(){
	
	for(let i = 0; i < table.rows.length; i++)  {
    	sum += parseInt(table.rows[i].cells[2].innerHTML);
	}
	let buttonHTML = `<tr><th>날짜</th><th>항목</th><th>금액</th><th>비고</th></tr>`
	buttonHTML += `<tr><td>${dateinput.value}</td><td>${menuinput.value}</td><td>${priceinput.value}</td><td><button class="btn btn-danger pull-right">삭제</button></td></tr>`
	buttonHTML += `<tr><th colspan="2">-총합계-</th><th colspan="2">${sum}</th></tr>`
	
	document.querySelector(".출력구역").innerHTML = buttonHTML
	
	dateinput.value = ''
	menuinput.value = ''
	priceinput.value = ''

	
}

