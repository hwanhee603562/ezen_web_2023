lread();

// 좌석선택 
function checkIn() {
   let seats =  sessionStorage.getItem('seats');
   if(seats == null) { 
      alert('좌석을 선택해주시길 바랍니다.')
      return;
   }
   let name = document.querySelector('.name');
   let phone = document.querySelector('.phone');
   
   if(name == '' || phone == '') {
      alert('빈칸을 모두 채워주시길 바랍니다.');
   }
   
   let info = {
      'lseat' : seats,
      'lname' : name.value,
      'lphone' : phone.value
   }
   
   $.ajax({
      url : "../LibraryController" ,
      method : 'post' ,
      data :   info  ,
      success: function(result){ 
        
        if(result == 0) console.log('등록 성공');
        else if( result == 1 ){
			console.log('현재 좌석 대여 중');
		} else if( result == 2 ){
			console.log('DB오류');
		} 
        lread();
   }
      
   });
}

// 읽기
function lread() {
   
   $.ajax({
      url : "../LibraryController" ,
      method : 'get' ,
      success: function(result){ 
        let seats_table = document.querySelector('.seats_table');
        seats_table.innerHTML = ''; 
        for(let i = 1 ; i <= 8; i++) {
         if(result[i-1] == 0) {
            seats_table.innerHTML += 
            `
               <button onclick="seatsSave(${i})" class="seat seats_i">${i}</button>
               `;
         }else{
            seats_table.innerHTML += 
            `
               <button onclick="seatsSave(${i})" class="seat seats">${i}</button>
               `;
         }     
         
        }
   },
      error : function(e){
		  console.log(e);
	  }
   });
} 

// 삭제
function checkOut() {
   
   let seats =  sessionStorage.getItem('seats');
   console.log(seats)
      if(seats == null) {
      alert('좌석을 선택해주시길 바랍니다.')
      return;
   }
   let phone = document.querySelector('.phone').value;
   if(phone == '') {
      alert('전화번호를 입력해주시길 바랍니다.');
   }
   
    $.ajax({
      url : "../LibraryController",
      method : "delete",
      data : {'lphone' : phone, 'lseat' : seats} ,
      success :	 function f(r){
        if(r == true)
        console.log('삭제 완료')
        else 
        console.log('삭제 실패')
        lread()
        } ,
      error : function f(r){console.log('삭제 에러'+r)}
   })
}
 
function seatsSave(seats) {
   sessionStorage.setItem('seats', seats);
}

