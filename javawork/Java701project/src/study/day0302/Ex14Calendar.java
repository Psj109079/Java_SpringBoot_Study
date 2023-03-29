package study.day0302;

import java.util.Date;
import java.util.Scanner;

public class Ex14Calendar {
	public static void main(String[] args) {
		// 년도와 월을 입력 시 해당 달력을 출력하시오
		Scanner sc = new Scanner(System.in);
		int year, month, week, endday;
		
		System.out.println("년도와 월 입력하기");
		year = sc.nextInt();
		month = sc.nextInt();
		if(month < 1 || month > 12) {
			System.out.println("월 입력을 잘못했어요(1 ~ 12)");
			return; // 메인 메서드 종료
		}
		
		System.out.printf("%20d년 %2d월 달력 \n\n",year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("=".repeat(50));
		
		// 입력한 년도, 월의 1일이 무슨 요일인지 week값 필요
		Date date = new Date(year - 1900, month - 1, 1);
		week = date.getDay();
		// 입력한 년도의 월이 몇일까지 있는지 구하기
		switch(month) {
		case 2:
			// 윤년이면 29일 평년이면 28일
			if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				endday = 29;
			} else {
				endday = 28;
			}
			break;
		case 4: case 6: case 9:case 11:
			endday = 30;
			break;
		default:
			endday = 31;
			break;
		}
		
		// week 숫자만큼 \t 으로 띄워주기
		for(int i = 1; i <= week; i++) {
			System.out.print("\t");
		}
		
		// 1일부터 endday까지 출력(토요일은 출력 후 \n)
		for(int i = 1; i <= endday; i++) {
			week++;
			System.out.printf("%2d\t", i);
			if(week % 7 == 0) {
				System.out.println();
			}
		}
		sc.close();
	}

}
