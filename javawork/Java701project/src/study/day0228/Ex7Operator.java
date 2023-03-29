package study.day0228;

import java.util.Scanner;

public class Ex7Operator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money;
		System.out.println("당신의 월 급여는?");
		money = sc.nextInt();
		
		/*
		 * 	예) 2345678
		 *		만원 : 234장
		 *		천원 : 5장
		 *		백원 : 6개
		 *		십원 : 7개
		 *		일원 : 8개
		 */
		System.out.printf("만원 : %d장\n", money / 10000);
		System.out.printf("천원 : %d장\n", money % 10000 / 1000);
		System.out.printf("백원 : %d개\n", money % 10000 % 1000 / 100);
		System.out.printf("십원 : %d개\n", money % 10000 % 1000 % 100 / 10);
		System.out.printf("일원 : %d개\n", money % 10);
		sc.close();
	}
}
