package java2.day25_제네릭2.Ex2;

public class Ex2_와일드카드제네릭타입 {
	
	public static void main(String[] args) {
		// 1. 모든 사람이 신청 가능
			// 1. 사람 객체
		Person person = new Person();
			// 2. 지원자 객체 [ 지원자객체에 사람 객체를 생성자 대입 ]
		Applicant<Person> applicant = new Applicant<>( person );
			// 3. 모든 객체 지원 가능한 코스 등록 함수
		Course.registerCourse1( applicant );
		
	// 위 1~3번은 아래와 같이 수정할 수 있음
		
		// -----코스1 : ( 모든 지원서(사람, 직장인, 학생) ) 누구나 등록 가능한 코스
		Course.registerCourse1( new Applicant<Person>(new Person()) );
		Course.registerCourse1( new Applicant<Worker>(new Worker()) );
		Course.registerCourse1( new Applicant<Student>(new Student()) );
		Course.registerCourse1( new Applicant<HighStudent>(new HighStudent()) );
		Course.registerCourse1( new Applicant<MiddleStudent>(new MiddleStudent()) );
		
		// -----코스2 : ( 모든 지원서(사람, 직장인, 학생) ) student 클래스와 자손 클래스의 타입 가능
		// 에러 Student와 자손 클래스만 가능 
		// Course.registerCourse2( new Applicant<Person>(new Person()) );
		// 에러 Student와 자손 클래스만 가능 
		// Course.registerCourse2( new Applicant<Worker>(new Worker()) );
		Course.registerCourse2( new Applicant<Student>(new Student()) );
		Course.registerCourse2( new Applicant<HighStudent>(new HighStudent()) );
		Course.registerCourse2( new Applicant<MiddleStudent>(new MiddleStudent()) );
		
		// -----코스3 : ( 모든 지원서(사람, 직장인, 학생) ) Worker 클래스와 부모 클래스 타입 가능
		Course.registerCourse3( new Applicant<Person>(new Person()) );
		Course.registerCourse3( new Applicant<Worker>(new Worker()) );
		// 에러 Worker 클래스와 부모 클래스 타입만 가능
		// Course.registerCourse3( new Applicant<Student>(new Student()) );
		// 에러 Worker 클래스와 부모 클래스 타입만 가능
		// Course.registerCourse3( new Applicant<HighStudent>(new HighStudent()) );
		// 에러 Worker 클래스와 부모 클래스 타입만 가능
		// Course.registerCourse3( new Applicant<MiddleStudent>(new MiddleStudent()) );
		
		
		
	}
}
