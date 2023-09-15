
// 1. n개의 제품들을 최신순으로 출력하는 함수
function findByTop(){
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method : "get",
		data : {
			type : "findByTop",
			count : count,
		},
		success : jsonArray =>{
			console.log(jsonArray)
		}
		
		
	})
}

// 2. 현재 카카오지도 내 보고있는 동서남북 기준 내 제품들을 출력하는 함수
function findByLatLng( east, west, south, north ){
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method : "get",
		data : {
			type : "findByLatLng",
			east : east,
			west : west,
			south : south,
			north : north
		},
		success : jsonArray =>{
			console.log(jsonArray)
		}
		
		
	})
}


// 3. 선택된 제품번호에 해당하는 제품 출력하는 함수
function findByPno( pno ){
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method : "get",
		data : {
			type : "findByPno",
			pno : pno,
		},
		success : jsonArray =>{
			console.log(jsonArray)
		}
		
		
	})
}

// 4. 모든 제품들을 출력하는 함수
function findByAll(){
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method : "get",
		data : {
			type : "findByAll"
		},
		success : jsonArray =>{
			console.log(jsonArray)
		}
		
		
	})
}


















