package study.day0228;

import java.util.Date;
import java.util.Scanner;

public class sol3 {
	public static void main(String[] args) {
//		[문제3]
//		태어난 년도와 월 일을 키보드로부터 입력받아 그날이 무슨 요일인지 출력하시오
//		(Scanner, Date  클래스 사용)
		
		Scanner sc = new Scanner(System.in);
		
		int year, month, days,day ;
		String week;
		
		System.out.print("년도 >>");
		year = sc.nextInt();
		System.out.print("월 >>");
		month = sc.nextInt();
		System.out.print("일 >>");
		days = sc.nextInt();
		Date date = new Date(year - 1900, month - 1, days);
		day = date.getDay();
		
		week = day == 0? "일" : day == 1? "월" : day == 2? "화" : day == 3? "수" : day == 4? "목" : day == 5? "금" : "토";
		
		System.out.printf("%d년 %d월 %d일은 %s요일 입니다", year, month, days, week);
		sc.close();
	}

}
