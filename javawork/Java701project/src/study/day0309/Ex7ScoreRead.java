package study.day0309;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex7ScoreRead {

	static final String FILENAME = "d:/bit701naver/score.txt";

	/*
	 * 총 10개의 점수 읽음 90 67 100.......(한줄에 5개씩 출력) 총점: xxx 평균: xxx
	 */
	
	public static void scoreRead() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String score = "1";
			int sum = 0;
			double avg = 0;
			int cnt = 0;
			String message = "";
//		Exit :while (score != null || score.length() != 0) {
//				for (int i = 0; i < 5; i++) {
//					score = br.readLine();
//					if (score == null || score.length() == 0) {
//						break Exit;
//					}
//					cnt++;
//					sum += Integer.parseInt(score);
//					System.out.print(score + "\t");						
//				}
//				System.out.println();
//			}
		
			while(true) {
				score = br.readLine();
				if(score == null || score.length() == 0) {
					break;
				}
				try {
					sum += Integer.parseInt(score);
					cnt++;
					System.out.print(score + "\t");						
					if(cnt % 5 == 0) {
						System.out.println();
					}					
				} catch(NumberFormatException e) {
					message += String.valueOf(cnt) + "번 예외발생 " + e.getMessage();
				}
			}
			
			System.out.println();
			avg = (double) sum / cnt;
			System.out.println("총점: " + sum + ", 평균: " + avg);
			System.out.println(message);

		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		scoreRead();
	}

}
