package java1.day13.Ex2.model.dto;

public class BoardDto {
	// 싱글톤X : 게시물1개당 DTO 1개이기 때문에 여러 DTO 필요
	
	// 1. 필드
	private String writer;	// 작성자
	private String content;	// 내용
	private int view;		// 조회수
	
	
	// 2. 생성자
	
		// 1 빈생성자
		//ctrl + 스페이스바
	public BoardDto() {
	}
	
		// 2 풀생성자
	public BoardDto(String writer, String content, int viewCount) {
		super();
		this.writer = writer;
		this.content = content;
		this.view = viewCount;
	}

		// 3 게시물 등록시 사용되는 생성자
	public BoardDto(String writer, String content) {
		super();
		this.writer = writer;
		this.content = content;
	}
	
	
	// 3. 메소드
		// 1 getter setter
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

		// 2 toString
	@Override
	public String toString() {
		return "BoardDto [writer=" + writer + ", content=" + content + ", view=" + view + "]";
	}
	
		
	
	
	
	/*
		 1 (권장) setter getter 	: 외부로부터 인스턴스에 접근 불가
			 set필드명() 			: 필드에 값을 대입할 때 사용되는 메소드
			 get필드명() 			: 필드에 값을 호출할 때 사용되는 메소드
		 2 toString()			: 원래는 객체호출시 주소값이 반환되지만 객체내 필드의 값을 반환

	*/
	
	
	
	
	

	
	
		
}