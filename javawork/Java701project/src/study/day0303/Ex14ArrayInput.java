package study.day0303;

import java.util.Scanner;

public class Ex14ArrayInput {
	public static void main(String[] args) {
		
		int count;
		int total = 0;
		double avg;
		
		/*
		 * 입력할 점수의 갯수를 입력받아 그 갯수만큼 배열을 할당받은 후
		 * 점수를 입력받아 합계와 평균을 구해보자
		 */
		
		Scanner sc = new Scanner(System.in);
		// count 입력
		System.out.print("입력할 점수의 갯수 >> ");
		count = sc.nextInt();
		
		// count 갯수만큼 score, rank 할당
		int[] score = new int[count]; 
		int[] rank = new int[count];
		
		// 배열 갯수만큼 점수 입력, 총점, 평균 구하기
		for(int i = 0; i < count; i++) {
			System.out.print((i + 1) + "번점수 >> ");
			score[i] = sc.nextInt();
			total += score[i];
		}
		avg = (double)total / count;
		
		// 등수 구하기 - 다중 for
		for(int i = 0; i < rank.length; i++) {
			for(int j = 0; j < rank.length; j++) {	
				if(score[i] < score[j]) {
					rank[i]++;
				}
			}
		}
		
		// 출력
		for(int i = 0; i < score.length; i++) {
			System.out.printf("점수 %d  ", score[i]);
			System.out.printf("등수 %d  ", (rank[i]) + 1 );
			System.out.println();
		}
		System.out.println("합계: " + total);
		System.out.printf("평균: %5.1f\n", avg);
		
		sc.close();
	}

}
