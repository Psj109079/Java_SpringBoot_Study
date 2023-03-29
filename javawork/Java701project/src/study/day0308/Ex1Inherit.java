package study.day0308;

public class Ex1Inherit {
	
	public static void main(String[] args) {
		Student s1 = new Student();
		
		System.out.println(s1); // s1.toString() 과 같다
		
		// s1에 값을 넣어보자
		s1.setSchoolName("강남고");
		s1.setSchoolLoc("청담동");
		s1.setStuName("이미자");
		s1.setStuaddr("강남구");
		s1.setScore(99);
		System.out.println(s1);
		
		System.out.println("=".repeat(30));
		
		Student s2 = new Student("역삼고", "역삼동", "강철수", "역삼동", 89);
		System.out.println(s2);
		
	}
}
