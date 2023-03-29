package study.day0307;

class Test2 {
	
	private String name;
	private int age;
	
	Test2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Test2 [name=" + name + ", age=" + age + "]";
	}
	
	
}
public class Ex15ToString {
	public static void main(String[] args) {
		Test2 t2 = new Test2("이미자", 20);
		System.out.println(t2.toString());
		System.out.println(t2); // toString 메서드는 클래스 변수명만 써줘도 자동 호출된다
	}
	//134 ~ 156 157 178 210 238
}
