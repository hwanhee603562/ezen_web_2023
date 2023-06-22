/*
	문자열내 변수 포함하는방법 [ JS안에서 HTML 작성시 문자처리 ]
		1. 작은따옴표(연결연산자) '<td>'+변수명/배열명+'</td>'
		2. 백틱 (`${}`)	= `<td>${변수명/배열명}</td>`
	
*/



console.log('JS실행');


let 방문록배열 = []
let 방문록배열2 = []

//1. 이벤트 함수 만들기
function 등록(){
	
	//함수작동여부 확인
	console.log('등록함수 실행')
	
	let contentinput = document.querySelector(".content")
	
	//호출여부 확인
	console.log(contentinput)
	
	let value = contentinput.value
	console.log( value )
	
	방문록배열.push( value )
	console.log( 방문록배열 );
	
	//아래 방문록배열2 push문장의 의미는 위 방문록배열1을 push한 과정과 동일함
	방문록배열2.push( document.querySelector(".writer").value )
	
	let contenttable = document.querySelector(".contenttable")
	console.log( contenttable )
	
	//innerHTML 내용 (+=) 추가 방법
		// 방법 1 끝
	let tableHTML = `<tr><th> 내용 </th> <th> 작성자 </th></tr>`
		// tableHTML을 사용하고 입력이 들어갈 시 기존 HTML상 헤더가 공백으로 초기화되어 사라짐
		
	for(let i=0; i<방문록배열.length; i++){
		tableHTML += `<tr><td>${방문록배열[i]}</td><td>${방문록배열2[i]}</td></tr>`
	}

	console.log( tableHTML )
	contenttable.innerHTML = tableHTML
					
	
	
	
}