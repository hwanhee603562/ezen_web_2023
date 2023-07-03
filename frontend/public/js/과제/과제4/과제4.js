let mname = []
let pwd = []
let title = []
let content = []
let mcount = []

const date = new Date();	// 현재 날짜 및 시간
let a = date.toLocaleString('ko-kr')

function clickUpload(){

	mname.push(document.querySelector(".mname").value)
	pwd.push(document.querySelector(".pwd").value)
	title.push(document.querySelector(".title").value)
	content.push(document.querySelector(".contentbox").value)

	// 여기 지점 글쓰기 페이지 입력 모두 안될시 접근 제어 문구입력
	
	if(document.querySelector(".mname").value==''){
		alert('이름을 입력하세요')
		return
	}
	if(document.querySelector(".pwd").value==''){
		alert('비밀번호를 입력하세요')
		return
	}
	if(document.querySelector(".title").value==''){
		alert('제목을 입력하세요')
		return
	}
	if(document.querySelector(".contentbox").value==''){
		alert('내용을 입력하세요')
		return
	}
	
	for(let i=mcount.length; i<mname.length; i++){
		mcount.push(0)
	}

	document.querySelector(".mainPage").innerHTML = `<tr><th> 번호 </th><th> 제목 </th><th> 작성자 </th><th> 작성일 </th><th> 조회수 </th></tr>`
	
	for(let i=0; i<mname.length; i++){
		document.querySelector(".mainPage").innerHTML += `<tr onclick="clickTable(${i})" class="content"> <td>${i+1}</td><td>${title[i]}</td><td>${mname[i]}</td><td>${a}</td><td>${mcount[i]}</td></tr>`
	}

	document.querySelector(".mname").value = ''
	document.querySelector(".pwd").value = ''
	document.querySelector(".title").value = ''
	document.querySelector(".contentbox").value = ''
}

function clickTable(num){
	mcount[num]++
	document.querySelector(".mainPage").innerHTML = `<tr><th> 번호 </th><th> 제목 </th><th> 작성자 </th><th> 작성일 </th><th> 조회수 </th></tr>`
	
	for(let i=0; i<mname.length; i++){
		document.querySelector(".mainPage").innerHTML += `<tr onclick="clickTable(${i})" class="content"> <td>${i+1}</td><td>${title[i]}</td><td>${mname[i]}</td><td>${a}</td><td>${mcount[i]}</td></tr>`
	}
	
	lookpage(num)
}

function lookpage(num){
	document.querySelector(".writemainpage").innerHTML =
		`<h5>제목 : ${title[num]}</h5><h5>내용 : ${content[num]}</h5><h5>작성자 : ${mname[num]}</h5><button onclick="delbutton(${num})">삭제</button><button onclick="correctionbutton(${num})">수정</button>`
}

function delbutton(num){
	
	let checkPasswordprompt = prompt('비밀번호를 입력해주세요')
	if(checkPasswordprompt!=pwd[num]){
			alert('비밀번호가 일치하지않습니다')
			return
	}

	mname.splice(num, 1)
	pwd.splice(num, 1)
	title.splice(num, 1)
	content.splice(num, 1)
	mcount.splice(num, 1)
	
	document.querySelector(".writemainpage").innerHTML =
		`<h5>제목 : </h5><h5>내용 : </h5><h5>작성자 : </h5><button>삭제</button>`
	
	document.querySelector(".mainPage").innerHTML = `<tr><th> 번호 </th><th> 제목 </th><th> 작성자 </th><th> 작성일 </th><th> 조회수 </th></tr>`
	
	for(let i=0; i<mname.length; i++){
		document.querySelector(".mainPage").innerHTML += `<tr onclick="clickTable(${i})" class="content"> <td>${i+1}</td><td>${title[i]}</td><td>${mname[i]}</td><td>${a}</td><td>${mcount[i]}</td></tr>`
	}
}

function correctionbutton(num){
	
	let checkPasswordprompt = prompt('비밀번호를 입력해주세요')
	if(checkPasswordprompt!=pwd[num]){
			alert('비밀번호가 일치하지않습니다')
			return
	}
	
	document.querySelector(".writemainpage").innerHTML = 
	`제목 : <input class="correctionTitle" type="text"> <br/>내용 : <input class="correctionContent" type="text">  <br/><h5>작성자 : ${mname[num]}</h5><button onclick="savefield(${num})">저장</button> <br/>`
	
	
}

function savefield(num){
	title[num] = document.querySelector('.correctionTitle').value
	content[num] = document.querySelector('.correctionContent').value
	
	document.querySelector(".mainPage").innerHTML = `<tr><th> 번호 </th><th> 제목 </th><th> 작성자 </th><th> 작성일 </th><th> 조회수 </th></tr>`
	
	for(let i=0; i<mname.length; i++){
		document.querySelector(".mainPage").innerHTML += `<tr onclick="clickTable(${i})" class="content"> <td>${i+1}</td><td>${title[i]}</td><td>${mname[i]}</td><td>${a}</td><td>${mcount[i]}</td></tr>`
	}
	
	document.querySelector(".writemainpage").innerHTML = 
	`<h5>제목 : </h5><h5>내용 : </h5><h5>작성자 : </h5><button>삭제</button><button>수정</button>`
}


