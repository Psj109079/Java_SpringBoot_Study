package study.day0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] yeon = br.readLine().split("");
		int n = Integer.parseInt(br.readLine());
		int[] cnt = new int[4];
		
		for(int i = 0; i < yeon.length; i++) {
			if(yeon[i].equals("L")) {
				cnt[0]++;
			} else if(yeon[i].equals("O")) {
				cnt[1]++;
			} else if(yeon[i].equals("V")) {				
				cnt[2]++;
			} else if(yeon[i].equals("E")) {
				cnt[3]++;				
			}
		}
		
		String[][] team = new String[n][];
		String[] sumStr = new String[n];
		int[][] sumCnt = new int[n][4];
		int[] calc = new int[n];
		int max = -1;
		String result = "";
		
		for(int i = 0; i < team.length; i++) {
			team[i] = br.readLine().split("");
			sumCnt[i][0] += cnt[0];			
			sumCnt[i][1] += cnt[1];			
			sumCnt[i][2] += cnt[2];			
			sumCnt[i][3] += cnt[3];		
			sumStr[i] = "";
			for(int j = 0; j < team[i].length; j++) {
				if(team[i][j].equals("L")) {
					sumCnt[i][0]++;
				} else if(team[i][j].equals("O")) {
					sumCnt[i][1]++;
				} else if(team[i][j].equals("V")) {
					sumCnt[i][2]++;
				} else if(team[i][j].equals("E")) {
					sumCnt[i][3]++;					
				}
				sumStr[i] += team[i][j];
			}
			calc[i] = ((sumCnt[i][0] + sumCnt[i][1]) * 
					(sumCnt[i][0] + sumCnt[i][2]) * 
					(sumCnt[i][0] + sumCnt[i][3]) * 
					(sumCnt[i][1] + sumCnt[i][2]) *
					(sumCnt[i][1] + sumCnt[i][3]) *
					(sumCnt[i][2] + sumCnt[i][3])) % 100;
		}
		
		String temp = "";
		int intTemp = 0;
		for(int i = 0; i < sumStr.length; i++) {
			for(int j = i + 1; j < sumStr.length; j++) {
				if(sumStr[i].compareTo(sumStr[j]) > 0) {
					temp = sumStr[i];
					sumStr[i] = sumStr[j];
					sumStr[j] = temp;
					intTemp = calc[i];
					calc[i] = calc[j];
					calc[j] = intTemp;
				}
			}
		}
		
		for(int i = 0; i < calc.length; i++) {
			if(max < calc[i]) {
				max = calc[i];
				result = sumStr[i];
			}
		}
		System.out.println(result);		
	}
}
