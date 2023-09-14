package model.dao;

import java.sql.Statement;

import model.dto.ProductDto;

public class ProductDao extends Dao {
	
	private static ProductDao productDao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() {
		return productDao;
	}
	
	
	// 1. 제품등록
	public boolean register( ProductDto dto ) {
		
		try {
			
			String sql = "insert "
					+" into product(pcno, pname, pcontent, pprice, plat, plng, mno) "
					+" values(?, ?, ?, ?, ?, ?, ? )";
			
			// * sql insert 후 자동생성[auto_increment]된 pk번호를 반환하는 방법
				// .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					// 	생성된 식별키 반환
				// rs = ps.getGeneratedKeys();
					//	식별키 반환하는 함수
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt( 1, dto.getPcno() );
			ps.setString( 2, dto.getPname() );
			ps.setString( 3, dto.getPcontent() );
			ps.setInt( 4, dto.getPprice() );
			ps.setString( 5, dto.getPlat() );
			ps.setString( 6, dto.getPlng() );
			ps.setInt( 7, dto.getMno() );
			
			int count = ps.executeUpdate();		// 제품 등록
			rs = ps.getGeneratedKeys();	// 제품 등록시 생성된 식별키[pk] 반환해서 resultset[ps]에 대입
			rs.next();	// 반환된 식별키들 중에서 다음으로 이동
						// rs에 저장될 때 맨 처음 값은 null이기 때문
			
			// 만약에 제품 1개 등록했으면
			if( count == 1 ) {
				
				// 1-2 제품 등록 후 새성된 제품 pk를 가지고 [이미지 등록]
					// 1. dto에 저장된 이미지 개수 만큼
						// values : map 객체 내 모든 '값' 호출
				for( String img : dto.getImgList().values() ) {
					sql = "insert into productimg( pimg, pno ) values( ?, ? )";
					ps = conn.prepareStatement(sql);
					ps.setString( 1, img );
					ps.setInt( 2, rs.getInt(1) );
					ps.executeUpdate();
					
				}
				return true;
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
	// 2. 제품 전체 출력
	
	// 3. 제품 개별 조회
	
	// 4. 제품 수정
	
	// 5. 제품 삭제
	
}
