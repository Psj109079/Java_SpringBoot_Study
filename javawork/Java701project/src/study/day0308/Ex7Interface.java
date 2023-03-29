package study.day0308;

// 데이터 클래스(data transfer object)
class BoardDTO {
	
	private String writer;
	private String subject;
	
	BoardDTO() {
		
	}

	public BoardDTO(String writer, String subject) {
		super();
		this.writer = writer;
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}

// 데이터 처리에 대한 할 일을 미리 인터페이스로 만든다
interface BoardDAOInter {
	
	public void insert(BoardDTO dto);
	public void delete(String writer);
	public void list();
	public void update(String writer);
}

// dao class(Data Access Object: 데이터 로직 처리를 위한 클래스: CRUD)
class BoardDAO implements BoardDAOInter {

	@Override
	public void insert(BoardDTO dto) {
		System.out.println(dto.getWriter() + "님의 글 " + dto.getSubject() + "를 DB 에 추가함");
	}
	@Override
	public void delete(String writer) {
		System.out.println(writer + "님의 글을 삭제함");
	}
	@Override
	public void list() {
		System.out.println("전체 게시글을 조회합니다");
	}
	@Override
	public void update(String writer) {
		System.out.println(writer + "님의 글을 수정합니다");
	}	
}
public class Ex7Interface {
	public static void main(String[] args) {
		BoardDAOInter dao = new BoardDAO();
		dao.insert(new BoardDTO("이영자", "안녕하세요"));
		dao.delete("이영자");
		dao.list();
		dao.update("이영자");
		BoardDTO d = new BoardDTO();
		BoardDTO t = new BoardDTO("abc", "efg");
		dao.insert(d);
		dao.insert(t);
	}

}
