package study.day0228;

import java.util.Scanner;

public class sol4 {
	public static void main(String[] args) {
//		[문제4]
//				 
//		** 메뉴 **
//		원의 넓이 구하기
//		사각형의 넓이 구하기
//
//		1번 선택시 원의 반지름을 입력받아 원의 넓이를 구해서 출력하고
//		2번 선택시 가로와 세로길이를 입력받아 사각형의 넓이를 구해서 출력하시오
//		(switch 문 사용)
		
		Scanner sc = new Scanner(System.in);
		int select,radius, width, height;
		
		System.out.print("1: 원의넓이, 2: 사각형의넓이 >>");
		select = sc.nextInt();
		
		switch(select) {
		case 1:
			System.out.print("반지름 입력 >>");
			radius = sc.nextInt();
			System.out.println("원의 넓이: " + Math.round(radius * radius * Math.PI));
			break;
		case 2:
			System.out.print("가로길이 입력 >>");
			width = sc.nextInt();
			System.out.print("세로길이 입력 >>");
			height = sc.nextInt();
			System.out.println("사각형의 넓이: " + width * height);
			break;
		default : System.out.println("다시 입력");break;
		}
		sc.close();
	}

}
