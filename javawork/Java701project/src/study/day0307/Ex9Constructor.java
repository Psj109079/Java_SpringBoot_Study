package study.day0307;

class Person {
	private String name;
	private String addr;
	private String hp;
	private String a;
	
	Person() {
//		name = "이영자";
//		addr = "강남구";
//		hp = "010-222-3333";
		// 생성자에서 생성자 호출시 this()
		this("이영자","강남구","010-222-3333");// 인자가 맞는 생성자 호출
	}
	Person(String name) {
//		this.name = name;
//		addr = "강남구";
//		hp = "010-222-3333";
		
		// 위의 코드를 this()로 변경하려면 
		this(name, "강남구","010-222-3333");
		
	}
	Person(String name, String addr, String hp) {
		this.name = name;
		this.addr = addr;
		this.hp = hp;
	}
	public void writePerson() {
		System.out.println("이름: " + name + ", 주소: " + addr + ", 핸드폰: " + hp);
	}
}

public class Ex9Constructor {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.writePerson();
		
		Person p2 = new Person("이제니");
		p2.writePerson();
		
		Person p3 = new Person("수지", "여의도", "010-6767-8989");
		p3.writePerson();
	}

}
