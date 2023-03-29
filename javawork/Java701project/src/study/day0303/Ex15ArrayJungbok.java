package study.day0303;

import java.util.Random;

public class Ex15ArrayJungbok {
	public static void main(String[] args) {
		/*
		 * 10개의 데이터를 저장할 배열을 생성 후 1 ~ 30사이의
		 * 중복없는 숫자를 배열에 넣어보자
		 */
		Random r = new Random();
		int[] data = new int[10];
		
		for(int i = 0; i < data.length; i++) {
			data[i] = r.nextInt(30) + 1;
			// 중복 숫자가 i 이전번지에 있을경우 다시 구하기
			for(int j = 0; j < i; j++) {
				if(data[i] == data[j]) {
					i--; // i++ 로 이동하므로 i에서 1 을 빼서 전에 연산을 다시한다
					break;
				}
			}
		}
		// 출력
		for(int a : data) {
			System.out.printf("%4d", a);
		}
	}

}
