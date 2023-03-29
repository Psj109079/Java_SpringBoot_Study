package study.day0306;

class Person{
	static final String CITY = "Seoul";
	
	private String name;
	private String hp;
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	
	// getter
	public String getName() {
		return name;
	}
	public String getHp() {
		return hp;
	}
	// name,hp 동시에 수정할 메서드 setInfo(String name, String hp)
	public void setInfo(String name, String hp) {
		setName(name);
		setHp(hp);
	}
}

public class Ex6Object {
	public static void main(String[] args) {
		Person[] per = new Person[3]; // 메모리 할당, 생성X
		
		for(int i = 0; i < per.length; i++) {
			per[i] = new Person();
		}
		
		per[0].setName("캐서린");
		per[0].setHp("010-2222-3333");
		
		per[1].setName("마이클");
		per[1].setHp("010-3434-1212");
		
		per[2].setName("수지");
		per[2].setHp("010-7878-7676");
		
		// 출력 방법1
		System.out.println("City\tName\tHP");
		for(int i = 0; i < per.length; i++) {
			System.out.println(Person.CITY + "\t" + per[i].getName() + "\t" + per[i].getHp());
		}
		System.out.println("=".repeat(30));
		
		// 출력 방법2
		for(Person p : per) {
			System.out.println(Person.CITY + "\t" + p.getName() + "\t" + p.getHp());
			
		}
	}

}
