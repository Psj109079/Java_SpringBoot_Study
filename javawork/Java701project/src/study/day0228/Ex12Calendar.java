package study.day0228;

import java.util.Calendar;
import java.util.Date;

public class Ex12Calendar {
	public static void main(String[] args) {
		// Date와 Calendar 클래스를 이용해서 연, 월, 일, 요일을 각각 구해보자
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		// 생성자가 protected라 new로 생성이 안됨
		
		int y1 = date.getYear() + 1900;
		int y2 = cal.get(Calendar.YEAR);
		System.out.println(y1 + ", " + y2);
		
		int m1 = date.getMonth() + 1;
		int m2 = cal.get(Calendar.MONTH) + 1;
		// month: 실제 월보다 1빠진 값을 반환하므로 +1 해줘야 실제 월과 같다 
		System.out.println(m1 + ", " + m2);
		
		int d1 = date.getDate();
		int d2 = cal.get(Calendar.DATE);
		System.out.println(d1 + ", " + d2);
		
		int w1 = date.getDay(); // 일: 0 월: 1
		int w2 = cal.get(Calendar.DAY_OF_WEEK); // 일: 1 월: 2
		System.out.println(w1 + ", " + w2);
		
//		String week = w1 == 0? "일" : w1 == 1? "월" : w1 == 2? "화" : w1 == 3? "수" : w1 == 4? "목" : w1 == 5? "금" : "토";
		
		// switch문
		String week = "";
		switch(w2) {
		case 1: week = "일"; break;
		case 2: week = "월"; break;
		case 3: week = "화"; break;
		case 4: week = "수"; break;
		case 5: week = "목"; break;
		case 6: week = "금"; break;
		case 7: week = "토"; break;
		default : break;
		}
		System.out.println("오늘은 " + week + "요일입니다");

	}
}
