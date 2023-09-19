/* 
	https://apis.map.kakao.com/web/sample/
*/


/* 카카오맵 옵션 */
var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
    center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
    level : 12 // 지도의 확대 레벨
});

/* 카카오맵 클러스터 [ 마커 여러개일때 집합모양 ] */
var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
    minLevel: 10, // 클러스터 할 최소 지도 레벨
    disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
});



kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {
    var level = map.getLevel()-1;
    map.setLevel(level, {anchor: cluster.getCenter()});
});

// 1. 현재 보고있는 지도의 동서남북 좌표 얻기
getInfo()
function getInfo() {
    
    // 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds();	// 남, 서, 북, 동 순으로 필드가 저장
    
    
    // 영역의 남서쪽 좌표를 얻어옵니다 
    var swLatLng = bounds.getSouthWest();	// 남서쪽 
    
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast(); 	// 북동쪽
    
    let 북 = neLatLng.getLat();
    let 남 = swLatLng.getLat();
    let 서 = swLatLng.getLng();
    let 동 = neLatLng.getLng();
	

	findByLatLng(동, 서, 남, 북);

}

// 2. 해당 동서남북 좌표에 범위 내 제품만 출력하기
function findByLatLng( east, west, south, north ){
	
	// --------------- 1. 마커를 생성해서 클러스터에 저장 ---------------- //
	// 클러스터 내 모든 마커들을 초기화
	clusterer.clear();
	
	$.ajax({
		url : "/jspweb/ProductInfoController", 
		method : "get" ,
		async : false,	// ajax통신은 기본적으로 비동기 통신이므로 동기화
		data : { 	
			type : "findByLatLng", 
			east : east,
			west : west,
			south : south,
			north : north
		},
		success : jsonArray => { 
			console.log( 'jsonArray' ); 
			console.log( jsonArray ); 
			var markers = jsonArray.map( (p) => {
		        return new kakao.maps.Marker({
		            position : new kakao.maps.LatLng( p.plat, p.plng )
		        });
		    });
			clusterer.addMarkers(markers);
			
	// --------------- 2. 사이드바에 제품 출력 ---------------- //
			let sidebar = document.querySelector('.sidebar')
			let html = ``;
			
			jsonArray.forEach( p => {
				html += `
					<div class="card mb-3" style="max-width: 540px;">	<!-- mb-3 : 아래마진 / m : 마진  p : 패딩 -->
					  <div class="row g-0">		<!-- row : flex 역할 -->
					    <div class="col-md-4">
					    	<a href="/jspweb/product/view.jsp?pno=${p.pno}">	
					      		<img src="/jspweb/product/img/${ Object.values(p.imgList)[0] }" class="img-fluid rounded-start" alt="..."">
					    	</a>
					    </div>
					    <div class="col-md-8">
					      <div class="card-body">
					        <h5 class="card-title"> ${p.pname} </h5>
					        <p class="card-text"> 
					           <div> ${p.pcontent} </div>
					           <div> ${p.pprice.toLocaleString()} </div>
					        </p>
					      </div>
					    </div>
					  </div>
					</div>	<!-- 카드 end -->
				`
			});
			sidebar.innerHTML = html;
		}
	})
}

// 3. 카카오지도에서 드래그를 하고 끝났을 때 1번 함수 재실행
kakao.maps.event.addListener(map, 'dragend', function(){
	getInfo()
 });





















