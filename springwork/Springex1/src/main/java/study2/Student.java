package study2;

public class Student {
	String schoolName;
	
	Myinfo myinfo;
	
	public Student(Myinfo myinfo) {
		this.myinfo = myinfo;
	}
	
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public void show() {
		System.out.println(myinfo);
		System.out.println("ÇÐ±³¸í: " + schoolName);
	}
	
}
