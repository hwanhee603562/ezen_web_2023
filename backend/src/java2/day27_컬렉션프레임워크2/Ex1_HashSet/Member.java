package java2.day27_컬렉션프레임워크2.Ex1_HashSet;

public class Member {
	
	// 필드
	public String name;
	public int age;
	
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	
	
	// ★☆★☆--------------- 해당 객체의 중복 기준 만들기 -------------
	
	// 오버라이딩(hashCode)을 사용한 폭넓은 활용
	// Object(모든 클래스는 Object로부터 자동으로 상속받음)의 메서드를 재정의
		// name과 age값이 같으면 동일한 hashCode가 리턴됨
	@Override
	public int hashCode() {
		return name.hashCode()+age;
	}
	
	// 오버라이딩(equals)을 사용한 폭넓은 활용
		// name과 age값이 같으면 true가 리턴됨
	@Override
	public boolean equals(Object obj) {
		
		// ??? 타입이 Member 클래스이면 오버라이딩하는 대상에 해당된다? 
		if( obj instanceof Member target ) { // 변경된 버전 16에서 사용가능
			// 만약에 해당 객체가 이름과 나이가 일치하면 [ true 중복가능 ]
			return target.name.equals(this.name) && (target.age == this.age);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	
	
}
