package study.day0302;

import java.util.Scanner;

public class Ex10Loop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int menu,dan;
		
		while(true) {
			System.out.println("1. 구구단 입력 후 출력2. 전체 구구단 출력3. 종료");
			
			menu = sc.nextInt();
			
			if(menu == 1) {
				// 조건 : 2 ~ 9 사이 숫자 입력 시 해당 구구단 출력
				// 그 값을 벗어날경우 "잘못 입력했어요" 메세지 나온 후 다시 메뉴가 나오도록 하기
				System.out.print("단 입력 >> ");
				dan = sc.nextInt();
				
				if(dan < 2 || dan > 9) {
					System.out.println("잘못입력했어요");
					continue;
				} else {
					System.out.println("** " + dan + "단 **\n");
					for(int i = 1; i <= 9; i++) {
						System.out.printf("%d * %d = %d\n",dan , i, dan * i);
					}
				}
			} else if(menu == 2) {
				// 2 ~ 9 단을 가로 방향으로 출력
				for(int i = 2; i <= 9; i++ ) {
					System.out.printf("%7d 단", i);
				}
				System.out.println();
				for(int i = 1; i <= 9; i++) {
					for(int j = 2; j <= 9; j++) {
						System.out.printf("%d * %d = %2d ",j, i, j * i);
					}
					System.out.println();
				}
				
			} else {
				System.out.println("** 프로그램 종료**");
				break;
			}
		}
		sc.close();
	}

}
