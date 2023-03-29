package study.day0306;

class Orange{
	private String stuName;
	private String stuNum;
	private int javaScore;
	private int springScore;
	
	// setter method
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	}
	public void setSpringScore(int springScore) {
		this.springScore = springScore;
	}
	// getter method
	public String getStuName() {
		return this.stuName; // this. 생략가능
	}
	public String getStuNum() {
		return stuNum;
	}
	public int getJavaScore() {
		return this.javaScore;
	}
	public int getSpringScore() {
		return springScore;
	}
	// java와 spring 점수를 한꺼번에 변경하고 싶을 때
	public void setScore(int javaScore, int springScore) {
		this.javaScore = javaScore;
		this.springScore = springScore;
	}
	
	// 두 과목의 합계를 반환하는 메서드
	public int getTotal() {
		return javaScore + springScore;
	}
	
	// 두 과목의 평균을 반환하는 메서드
	public double getAverage() {
		return getTotal() / 2.0;
	}
	
	public String getGrade() {
		if(getAverage() >= 90) {
			return "Very Good"; 
		} else if(getAverage() >= 80) {
			return "Good";
		} else {
			return "Try";
		}
	}
}
public class Ex5Object {
	public static void orangeWrite(Orange o) {
		System.out.println(o.getStuName() + "님의 정보");
		System.out.println("학번: " + o.getStuNum());
		System.out.println("자바점수: " + o.getJavaScore());
		System.out.println("스프링점수: " + o.getSpringScore());
		System.out.println("두 과목의 합계: " + o.getTotal());
		System.out.println("두 과목의 평균: " + o.getAverage());
		// 평균이 90이상이면 "Very Good", 80이상이면 "Good", 나머지는 "Try"
		System.out.println("해당학생 등급: " + o.getGrade());
		System.out.println("=".repeat(20));
	}
	public static void main(String[] args) {
		Orange or1 = new Orange();
		or1.setStuName("홍길동");
		or1.setStuNum("s12345");
		or1.setJavaScore(90);
		or1.setSpringScore(77);
		
		Orange or2 = new Orange();
		or2.setStuName("강호동");
		or2.setStuNum("s23232");
		or2.setScore(100, 98);
		
		
		orangeWrite(or1);
		orangeWrite(or2);
	}
}
