package study.day0228;

import java.util.Scanner;

public class Ex11Operator {
	public static void main(String[] args) {
		// 조건 연산자(삼항연산자)
//		조건식? 참일때값 : 거짓일때값;
//		조건식1? 참일때값: 조건식2? 참일때값:조건식3? 참일때값:거짓일때값....
		Scanner sc = new Scanner(System.in);
		int score;
		String msg;
		// 점수 입력
		System.out.println("점수 입력");
		score = sc.nextInt();
		// 90이상 : "참 잘했어요", 90미만 : "노력하세요"
		msg = score >=90? "참 잘했어요" : "노력하세요";
		System.out.println(score + "점 => " + msg);
		
		// msg에 90이상이면 "A그룹" 80이상이면 "B그룹" 나머지는 "C그룹" 저장
		// 90점은 A그룹입니다 => 출력
		msg = score >= 90? "A그룹" : score >= 80? "B그룹" : "C그룹";
		
		System.out.printf("%d점은 %s입니다\n", score, msg);
		
		// 90이상 "A", 80이상 "B", 70이상 "C", 60이상 "D", 60미만 "F"
		// 78점은 C학점입니다 => 출력
		
		msg = score >= 90? "A" : score >= 80? "B" : score >= 70? "C" : score >= 60? "D" : "F";
		System.out.printf("%d점은 %s학점입니다\n", score, msg);
		sc.close();
	}
}
