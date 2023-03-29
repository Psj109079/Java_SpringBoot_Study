package study.day0307;

import java.util.Scanner;

class Student {
	
	String name;
	int score;
	char grade;
}
public class Ex6CallBy {
	
	public static void changeStudent(Student s) {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름과 점수를 입력해주세요");
		s.name = sc.nextLine();
		s.score = sc.nextInt();
		// 등급 구하기
		s.grade = s.score >= 90? 'A' : s.score >= 80? 'B' : 'F';
	}
	
	public static void writeStudent(Student s) {
		System.out.println("** 학생 정보 출력 **");
		System.out.println("이름: " + s.name);
		System.out.println("점수: " + s.score);
		System.out.println("등급: " + s.grade);
	}
	public static void main(String[] args) {
		Student stu = new Student();
		// 클래스는 주소가 전달되기 때문에 기능별로 나눠서 작업이 가능하다
		
		changeStudent(stu); // 입력
		writeStudent(stu);	// 출력
	}

}
