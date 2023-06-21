let memberlistid = []
let memberlistpassword = []

function fjoin(){
	
	let join = document.querySelector(".id")
	let password = document.querySelector(".pass")
	let joinid = join.value
	let joinpassword = password.value
	
	if(join.value==''){
		alert('학번을 입력해주세요')
	}
	if(password.value==''){
		alert('비밀번호를 입력해주세요')
	}
	
	if(join.value.length>=8 && password.value.length>=8 && memberlistid.indexOf(joinid)==-1 && memberlistpassword.indexOf(joinpassword)==-1){
		memberlistid.push(joinid)
		memberlistpassword.push(joinpassword)
		for(let i=0; i<memberlistid.length; i++){
			console.log("id : "+memberlistid[i]+" "+"password : "+memberlistpassword[i])
		}
		alert('회원가입이 완료되었습니다')
	}else{
		alert('회원가입이 불가합니다')
	}
	
	join.value = ""
	password.value = ""
}
	
function flogin(){
	let logjoin = document.querySelector(".logid")
	let logpassword = document.querySelector(".logpass")
	
	if(logjoin.value==''){
		alert('학번을 입력해주세요')
	}
	if(logpassword.value==''){
		alert('비밀번호를 입력해주세요')
	}
	
	if(logjoin.value.length>=8 && logpassword.value.length>=8 && memberlistid.indexOf(logjoin.value)!=-1 && memberlistpassword.indexOf(logpassword.value)!=-1){
		alert('로그인이 완료되었습니다')
	}else if(logjoin.value.length<8){
		alert('아이디를 8글자 이상 입력하세요')
	}
	else if(logpassword.value.length<8){
		alert('비밀번호를 8글자 이상 입력하세요')
	}else{
		alert('아이디 또는 비밀번호를 확인해주세요')
	}
	
	logjoin.value = ""
	logpassword.value = ""
}
	
	
	
	
	


