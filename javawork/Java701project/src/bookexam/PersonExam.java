package bookexam;

class Person {
	// page 187
	String name;
	private String mobile, office, email;
	
	Person(String name, String mobile, String office, String email) {
		this.name = name;
		this.mobile = mobile;
		this.office = office;
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", mobile=" + mobile + ", office=" + office + ", email=" + email + "]";
	}
	
	
}

public class PersonExam {
	public static void main(String[] args) {
		Person p = new Person("Kim", "010-1234-8756", "02-555-7777", "xxxxx@naver.com");
		System.out.println(p.toString());
		p.setMobile("010-9874-6541");
		System.out.println(p.toString());
		System.out.println(p.getMobile());
	}
}
