package study.day0310;
//[문제]-파일입출력,컬렉션 
//EmpDto
//    이름,부서,나이,핸드폰
//
// **  메뉴 **
//1. 사원추가
//2. 사원검색 - 이름,부서,나이,핸드폰 모두 출력
//3. 사원삭제
//4. 부서명 검색 - 부서별로 출력
//5. 전체출력
//6. 종료

public class EmpDTO {
	private String name, part, hp;
	private int age;
	
	EmpDTO(){
		
	}
	public EmpDTO(String name, String part, int age, String hp) {
		this.name = name;
		this.part = part;
		this.age = age;
		this.hp = hp;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
