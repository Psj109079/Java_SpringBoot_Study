package study.day0303;

public class Ex11ArrayRank {
	public static void main(String[] args) {
		int[] score = {90, 89, 67, 89, 100};
		int[] rank = new int[5];
		
		// 등수구하기, 동점인경우 동순위
		for(int i = 0; i < score.length; i++) {
			rank[i] = 1;
			// i(기준)번지 점수보다 j(비교)번지 점수가 더 높을경우
			for(int j = 0; j < score.length; j++) {
				if(score[i] < score[j]) {
					rank[i]++;
				}
			}
		}
		
		//출력
		System.out.println("점수 \t 등수");
		System.out.println("-".repeat(20));
		for(int i = 0; i < score.length; i++) {
			System.out.println(score[i] + "점\t" + rank[i] + "등");
		}
	}
}
