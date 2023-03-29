package study.day0303;

import java.util.Random;
import java.util.Scanner;

public class Ex16Lotto {
	public static void main(String[] args) {
		
		// 금액을 입력 후 금액만큼 로또 출력 (1 ~ 45 사이 중복없는 숫자로 오름차순 정렬로 출력)
		// 단 금액이 1000원 미만이면 "금액이 부족합니다" 출력 후 메인 종료
		// 단 입력한 금액만큼(천원당 1회) 반복해서 로또 숫자 구한 후 정렬 후 출력
		/*
		 * 예) 로또구입금액 : 5000
		 * 
		 * 		1회 : 5 12 25 34 41 45
		 * 		2회 : ...
		 * 		3회 : ...
		 * 		4회 : ...
		 * 		5회 : ...
		 */
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		int money;
		int temp = 0;
		int[] lotto = new int[6];
		
		System.out.print("1회에 1000원 >> ");
		money = sc.nextInt();
		
		if(money < 1000) {
			System.out.println("금액이 부족합니다");
			sc.close();
			return;
		} else if(money % 1000 != 0) {
			System.out.println("잔돈 " + money % 1000);
		}
		
		// n회 만큼 반복
		for(int i = 0; i < money / 1000; i++) {
			
			// 중복이 제거된 랜덤숫자 6개
			for(int n = 0; n < lotto.length; n++) {
				lotto[n] = r.nextInt(45) + 1;
				for(int j = 0; j < n; j ++) {
					if(lotto[n] == lotto[j]) {
						n--;
						break;
					}
				}
			}
			
			// 로또 정렬
			for(int n = 0; n < lotto.length - 1; n++) {
				for(int j = n + 1; j < lotto.length; j++) {
					if(lotto[n] > lotto[j]) {
						temp = lotto[n];
						lotto[n] = lotto[j];
						lotto[j] = temp;
					}
				}
			}
			
			// 로또 n 회차 출력
			System.out.printf("%d회 :",i + 1);
			for(int j = 0; j < lotto.length; j++) {
				System.out.printf("%4d", lotto[j]);
			}
			System.out.println();
			
			// 로또 배열 초기화
			for(int j = 0; j < lotto.length; j++) {
				lotto[i] = 0;
			}
			
		}
		sc.close();
		
	}

}
