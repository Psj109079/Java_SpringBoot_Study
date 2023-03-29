package study.day0308;

public class Student extends School {
	private String stuName;
	private String stuaddr;
	private int score;
	
	public Student() {
		super();
	}

	public Student(String schoolName, String schoolLoc, String stuName, String stuaddr, int score) {
		super(schoolName, schoolLoc);
		this.stuName = stuName;
		this.stuaddr = stuaddr;
		this.score = score;
	}

	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuaddr() {
		return stuaddr;
	}
	public void setStuaddr(String stuaddr) {
		this.stuaddr = stuaddr;
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuaddr=" + stuaddr + "\nscore=" + score + "\ntoString()="
				+ super.toString() + "]";
	}
	
	
	
	
	
	
}
