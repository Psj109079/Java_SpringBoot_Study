package study.day0306;

import java.util.Scanner;

public class Ex1Array2Cha {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 이름 저장할 배열
		String[] names = new String[3];
		// 3과목의 점수와 총점을 구할 2차원 배열 선언
		int[][] score = new int[3][5]; // 3행 5열(3과목 점수, 총점, 등수
		
		// 입력
		for(int i = 0; i < names.length; i++) {
			System.out.print(i + 1 + "번의 이름 >>");
			names[i] = sc.nextLine();
			
			System.out.print("3과목의 점수를 입력해주세요 >>");
			for(int j = 0; j < 3; j++) {
				score[i][j] = sc.nextInt();
				score[i][3] += score[i][j];
			}
			// 마지막 점수 입력후 버퍼에 저장된 엔터를 따로 읽어서 처리한다
			sc.nextLine();
		}
		
		// 총점구하기
//		for(int i = 0; i < score.length; i++) {
//			for(int j = 0; j < 3; j++) {
//				score[i][3] += score[i][j];
//			}
//		}
		
		for(int i = 0; i < score.length; i++) {
			
			// 등수가 들어갈 열을 1로 초기화
			score[i][4] = 1;
			for(int j = 0; j < score.length; j++) {
				// 상대방(j)의 총점이 기준(i)보다 더 높을경우
				// i번지의 등수를 1 증가한다
				if(score[i][3] < score[j][3]) {
					score[i][4]++;
				}
				
			}
		}
		
		// 출력
		System.out.println("이름\t국어\t영어\t수학\t총점\t등수");
		System.out.println("=".repeat(30));
		for(int i = 0; i < names.length; i++) {
			System.out.printf("%-5s", names[i]);
			for(int j = 0; j < score[i].length; j++) {
				System.out.printf("%5d", score[i][j]);
			}
			System.out.println();
		}
		sc.close();
	}

}
