package study2;

public class Myinfo {
	private String name;
	private int age;
	private String hobby;
	
	public Myinfo(String name, int age, String hobby) {
		super();
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Myinfo [name=" + name + ", age=" + age + ", hobby=" + hobby + "]";
	}
		
}
