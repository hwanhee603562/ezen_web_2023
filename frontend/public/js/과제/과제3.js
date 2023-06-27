let dateInput = document.querySelector(".dateInput")
let menuInput = document.querySelector(".menuInput")
let priceInput = document.querySelector(".priceInput")
let price = Number(priceInput.value)

let dateArr = []
let menuInputArr = []
let priceArr = []



function input(){
	console.log('input')
	dateArr.push(dateInput.value)
	menuInputArr.push(menuInput.value)
	priceArr.push(Number(priceInput.value))
	
	document.querySelector(".outPutLine").innerHTML = `<tr><th>날짜</th><th>항목</th><th>금액</th><th>비고</th></tr>`

	for(let index=0; index<priceArr.length; index++){
		document.querySelector(".outPutLine").innerHTML += `<tr><td>${dateArr[index]}</td><td>${menuInputArr[index]}</td><td>${priceArr[index]}</td><td><button onclick="deleteIndex(${index})">삭제하기</button></td></tr>`
	}
	
	dateInput.value = ''
	menuInput.value = ''
	priceInput.value = ''
	
	total()
	
}

function deleteIndex(index){
	console.log('deleteIndex')
	if(dateArr.length<=0){
		dateArr.splice(0)
		menuInputArr.splice(0)
		priceArr.splice(0)
		afterDeleteIndex()
		return
	}
	dateArr.splice(index, 1)
	menuInputArr.splice(index, 1)
	priceArr.splice(index, 1)
	
	afterDeleteIndex()
}

function afterDeleteIndex(){
	console.log('afterDeleteIndex')
	document.querySelector(".outPutLine").innerHTML = `<tr><th>날짜</th><th>항목</th><th>금액</th><th>비고</th></tr>`
	
	for(let i=0; i<priceArr.length; i++){
		document.querySelector(".outPutLine").innerHTML += `<tr><td>${dateArr[i]}</td><td>${menuInputArr[i]}</td><td>${priceArr[i]}</td><td><button onclick="deleteIndex(${i})">삭제하기</button></td></tr>`
	}
	total()
}

function total(){
	console.log('total')
	let sum = 0
	for(let i=0; i<priceArr.length; i++){
		sum += priceArr[i]
	}
	document.querySelector(".outPutLine").innerHTML += `<tr><th colspan="2">총합계</th><th colspan="2">${sum}</th></tr>`
	
}











