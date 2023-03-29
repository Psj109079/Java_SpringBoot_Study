package study.day0228;

import java.util.Scanner;

public class Ex18Book77 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int menu;
		double c_degree, f_degree;
		
		System.out.println("1. 화씨 -> 섭씨");
		System.out.println("2. 섭씨 -> 화씨");
		
		menu = sc.nextInt();
		switch(menu) {
		case 1:
			System.out.println("화씨 온도를 입력해주세요");
			f_degree = sc.nextInt();
			// 섭씨온도로 변환
			c_degree = (f_degree - 32) / 1.8;
			System.out.println("화씨 " + f_degree + "도는 섭씨" + c_degree + "도 입니다");
			break;
		case 2:
			System.out.println("섭씨 온도를 입력해주세요");
			c_degree = sc.nextInt();
			// 화씨온도로 변환
			f_degree = (c_degree * 1.8) + 32;
			System.out.println("섭씨 " + c_degree + "도는 화씨" + f_degree + "도 입니다");
			break;
		}
		sc.close();
	}

}
