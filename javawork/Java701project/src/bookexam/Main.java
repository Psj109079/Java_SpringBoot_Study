package bookexam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static boolean[][] islandChk;
	static List<List<Integer[]>> seaside = new ArrayList<>();
	static final int[] x = {0, -1, 1, 0};
	static final int[] y = {-1, 0, 0, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		StringTokenizer st;
		for(int i = 0, j = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				map[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
			j = 0;
		}
		
		islandChk = new boolean[n][n];
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 1 && !islandChk[i][j] ) {
					islandChk[i][j] = true;
					island(i, j);
				}
			}
		}
		
				
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i = 0; i < seaside.size(); i++) {
			for(int j = 0; j < seaside.get(i).size(); j++) {
				System.out.print(seaside.get(i).get(j)[0] + ", " + seaside.get(i).get(j)[1] + "| ");
			}
			System.out.println();
		}
		
		
		

		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void island(int ix, int iy) {
		Queue<Integer[]> q = new LinkedList<>();
		List<Integer[]> list = new ArrayList<>();
		q.add(new Integer[] {ix, iy});
		int seaSideX = 0;
		int seaSideY = 0;
		Integer[] element;
		
		while(! q.isEmpty()) {
			element = q.poll();
			
			for(int i = 0; i < 4; i++) {
				seaSideX = element[1] + x[i];
				seaSideY = element[0] + y[i];
				if(seaSideX >= 0 && seaSideX < n && seaSideY >= 0 && seaSideY < n && !islandChk[seaSideY][seaSideX] && map[seaSideY][seaSideX] == 1) {
					for(int j = 0; j < 4; j++) {
						if((seaSideX + x[j]) >= 0 && (seaSideX + x[j]) < n && (seaSideY + y[j]) >= 0 && (seaSideY + y[j]) < n && map[seaSideY + y[j]][seaSideX + x[j]] == 0 ) {
							q.add(new Integer[] {seaSideY, seaSideX});
							list.add(new Integer[] {seaSideY, seaSideX});
							islandChk[seaSideY][seaSideX] = true;
							break;
						}
					}
				}
			}
		}
		seaside.add(list);
	}
}
