package java2.day24.Ex2;

public class Ex_제네릭 {
	public static void main(String[] args) {
		
		// 1. Product 객체 만드는데.. tv 객체를 가지고
			// 1. Product 객체 만들 때 필드에 사용할 타입을 구체적으로 대입
		Product< Tv, String > product1 = new Product<>();
			// 2. product객체 [ Tv kind = null, String model = null; ]
		product1.setKind( new Tv() );
		product1.setModel( "스마트Tv" );
			// 3. product객체 [ Tv kind = new Tv(); String model = "스마트Tv"; ]
		Tv tv = product1.getKind();
		String tvModel = product1.getModel();
		
		
		System.out.println( tv );
		System.out.println( tvModel );
		
		
		// 2. Product 객체 만드는데.. Car 객체를 가지고

		
	}
}
