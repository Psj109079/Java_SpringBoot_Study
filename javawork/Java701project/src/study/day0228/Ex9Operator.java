package study.day0228;

import java.util.Scanner;

public class Ex9Operator {
	public static void main(String[] args) {
		// 관계연산자: >, <, >=, <=, ==, !=
		// 논리연산자: &&(and), ||(or), !(not)
//		int kor = 100, eng = 80, mat = 100;
//		System.out.println(kor > eng);		// true
//		System.out.println(kor == mat);		// true
//		System.out.println(!(kor == mat));	// false
//		System.out.println(kor > eng && kor > mat); // false
//		System.out.println(kor > eng || kor > mat); // true
		
		Scanner sc = new Scanner(System.in);
		int kor, eng, mat;
		
		/*
		 * 3과목의 점수가 40 이상이고 평균이 60이상이면 "합격"
		 * 그렇지 않을경우 "불합격"
		 */
		
		double avg;
		System.out.println("3과목의 점수 입력");
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		avg = (kor + eng + mat) / 3.0;
		System.out.printf("3과목의 평균: %5.1f\n", avg);
		
		if(kor >= 40 && eng >= 40 && mat >= 40 && avg >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
			
		}
		
		sc.close();
		
	}

}
