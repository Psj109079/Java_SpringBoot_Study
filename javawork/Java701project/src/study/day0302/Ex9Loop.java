package study.day0302;

import java.util.Scanner;

public class Ex9Loop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int menu;
		int su1,su2;
		
		Exit :
		while(true) {
			int result = 0;
			System.out.println("** 메뉴 **");
			System.out.println("1. 숫자 입력 후 1부터 그 숫자까지 합계구하기");
			System.out.println("2. 2개의 숫자 입력 후 수1 ~ 수2 까지 합계구하기");
			System.out.println("3. 숫자 입력 후 Factorial구하기");
			System.out.println("4. 두개의 숫자 입력 후 수1의 수2승 구하기");
			System.out.println("5. 종료");
			
			menu = sc.nextInt();
			
			switch(menu){
			case 1:
				System.out.print("숫자 1개 입력 >>");
				su1 = sc.nextInt();
				for(int i = 1; i <= su1; i++) {
					result += i;
				}
				System.out.println("1부터 " + su1 + "까지의 합 = " + result);
				break;
			case 2:
				System.out.print("숫자 2개 입력 >>");
				su1 = sc.nextInt();
				su2 = sc.nextInt();
				for(int i = su1; i <= su2; i++) {
					result += i;
				}
				System.out.println(su1 + "부터 " + su2 + "까지의 합 = " + result);
				break;
			case 3:
				System.out.print("숫자 1개 입력 >>");
				su1 = sc.nextInt();
				result = 1;
				for(int i = 1; i <= su1; i++) {
					result *= i;
				}
				System.out.println(su1 + "fatorial = " + result);
				break;
			case 4:
				System.out.println("4. 두개의 숫자 입력 후 수1의 수2승 구하기");
				su1 = sc.nextInt();
				su2 = sc.nextInt();
				result = 1;
//				System.out.println(su1 + "의" + su2 + "승 = " + (int)Math.pow(su1, su2));
				for(int i = 1; i <= su2; i++) {
					result *= su1;
				}
				System.out.println(su1 + "의" + su2 + "승 = " + result);
				
				break;
			default:
				System.out.println("** 프로그램 종료 **");
				// break 만 쓸경우 switch 만 빠져나와서 while문은 계속 반복됨
				// while문까지 빠져나오고 싶다면 레이블을 사용
				break Exit;
				
			}
			
		}
		sc.close();
	}

}
