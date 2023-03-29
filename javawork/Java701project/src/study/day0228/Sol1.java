package study.day0228;

import java.util.Scanner;

public class Sol1 {
	public static void main(String[] args) {
//		[문제1]
//		점수를 반복적으로 입력받아 총 몇개 입력인지 출력하고
//		그 점수들의 합계를 출력하시오
//		(점수를 0 입력시 while문 빠져나와서 합계와 갯수 출력)
//		(while,Scanner)
		Scanner sc = new Scanner(System.in);
		
		int n, sum = 0, cnt = 0;
		
		while(true) {
			System.out.print("숫자 입력 >>");
			n = sc.nextInt();
			if(n == 0) {break;}
			sum += n;
			cnt++;
		}
		System.out.printf("숫자의 갯수: %d, 합계: %d", cnt, sum);
		sc.close();
	}

}
