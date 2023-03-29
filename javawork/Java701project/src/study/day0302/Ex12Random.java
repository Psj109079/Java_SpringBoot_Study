package study.day0302;

import java.util.Random;

public class Ex12Random {
	public static void main(String[] args) {
		// 자바에서는 난수를 구하는 방법이 두가지가 있다
		//1. Math.rangom()
		for(int i = 1; i <= 5; i++) {
//			double r = Math.random(); // 0.00000.......~ 0.9999........까지의 난수 발생
//			System.out.println(r);
			
			// 0 ~ 9 까지의 난수
			int r = (int)(Math.random() * 10);
			System.out.println(r);
		}
		
		System.out.println("=".repeat(20));
		
		//2. Random 클래스
		Random random = new Random();
		for(int i = 1; i <= 5; i++) {
			int r = random.nextInt(10); // 0 ~ 9 사이의 난수
			System.out.println(r);
		}
		System.out.println("=".repeat(20));
		
		for(int i = 1; i <= 5; i++) {
//			int r = random.nextInt(26) + 65; // A ~ Z (65 ~ 90) (0 ~ 25) + 65
			int r = random.nextInt(26) + 65; // 97 ~ 122 a ~ z (0 ~ 25) + 97
			System.out.println((char)r);
		}
		
	}

}
