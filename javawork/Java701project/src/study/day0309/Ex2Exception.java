package study.day0309;

import java.util.Scanner;

class ExcepTest2 {
	
	// throws: 메서드를 호출하는 곳으로 2개의 예외를 던짐
	public static void inputData() throws NumberFormatException, ArithmeticException{
		Scanner sc = new Scanner(System.in);
		int su1, su2;
		
		System.out.println("두개의 숫자를 입력하세요");
		su1 = Integer.parseInt(sc.next());
		su2 = Integer.parseInt(sc.next());
		
		System.out.printf("%d + %d = %d\n", su1, su2, su1 + su2);
		System.out.printf("%d / %d = %d\n", su1, su2, su1 / su2);
		sc.close();
		
	}
}

public class Ex2Exception {
	public static void main(String[] args) {
//		try {
//			ExcepTest2.inputData();
//		} catch(NumberFormatException e) {
//			System.out.println("문자가 입력됨: " + e.getMessage());
//		} catch(ArithmeticException e) {
//			System.out.println("2번째 숫자가 0이입력됨: " + e.getMessage());
//		}
		
		// 두개의 Exception 을 묶어서 처리하고 싶을때
		try {
			ExcepTest2.inputData();
		} catch(NumberFormatException | ArithmeticException e) {
			System.out.println("문자가 들어갔거나 2번째 숫자가 0이 입력된경우 " + e.getMessage());
		} finally {
			System.out.println("** 여기는 무조건 실행하는 영역입니다 **");
		}
		System.out.println("** 정상 종료 **");
		
	}
}
