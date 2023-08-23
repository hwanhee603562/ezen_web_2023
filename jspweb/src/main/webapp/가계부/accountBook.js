
// 1. awrite
function awrite(){
	console.log('등록실행');
	
	let acontentInput = document.querySelector('.acontent');
	let apriceInput = document.querySelector('.aprice');
	let adateInput = document.querySelector('.adate');
	
	let book = {
		acontent : acontentInput.value,
		aprice : apriceInput.value,
		adate : adateInput.value,
	};
	console.log('book : '+book);
	
	$.ajax({
		url : "/jspweb/accountBookController",
		method : "post",
		data : book,
		success : function f(r){
			console.log('통신성공');
			if(r == true){
				alert('등록성공');	
				aread();
				acontentInput.value = '';
				apriceInput.value = '';
				adateInput.value = '';
			} else {
				alert('등록실패');
			}
		},
		error : function f(r){
			console.log('통신실패');
		}
	});
	
}

// 2. aread()
aread();
function aread(){
	
	$.ajax({
		url : "/jspweb/accountBookController",
		method : "get",
		data : "",
		success : function f(r){
			console.log(r);
			
			let output = document.querySelector('.accountBook_Bottom'); 
			let html = ``;
			
			for(let i=0; i<r.length; i++){
				html += `
				<div class="comView">
					<div class="acontentView"> ${ r[i].acontent } </div>
					<div class="apriceView"> ${ r[i].aprice } </div>
					<div class="adateView"> ${ r[i].adate } </div>
					<div class="abutton">
						<button onclick="aupdate( ${ r[i].ano } )" type="button">수정</button>
						<button onclick="adelete( ${ r[i].ano } )" type="button">삭제</button>
					</div>
				</div>
				`
			}
			output.innerHTML = html;
			
		},
		error : function f(r){
			console.log('불러오기실패');
		}
	});
	
	
}

// 3. aupdate
function aupdate( ano ){
	console.log('수정실행');
	
	let acontent = prompt('수정할 내용 : ');
	let aprice = prompt('수정할 가격 : ');
	let adate = prompt('수정할 일자 : ');
	
	$.ajax({
		url : "/jspweb/accountBookController",
		method : "put",
		data : { ano : ano, acontent : acontent, aprice : aprice, adate : adate },
		success : function f(r){
			console.log('update통신성공');
			if(r == true){
				alert('수정성공');
				aread();
			} else {
				alert('수정실패');
			}
		},
		error : function f(r){
			console.log(r);
		}
	})
	
	
	
}

// 4. adelete
function adelete( ano ){
	console.log('삭제실행');
	
	$.ajax({
		url : "/jspweb/accountBookController",
		method : "delete",
		data : { ano : ano },
		success : function f(r){
			console.log('update통신성공');
			if(r == true){
				alert('삭제성공');
				aread();
			} else {
				alert('삭제실패');
			}
		},
		error : function f(r){
			console.log(r);
		}
	})
	
	
	
	
	
	
}









