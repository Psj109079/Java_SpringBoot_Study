package study.day0228;

import java.util.Scanner;

public class Ex3Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int kor, eng;
//		System.out.println("Input Kor?");
//		kor = sc.nextInt();
//		System.out.println("Input Eng?");
//		eng = sc.nextInt();
//		
//		int sum = kor + eng;
//		System.out.println("두 과목의 합계는 " + sum + "점 입니다.");
		
		String name;
		int age;
		
		System.out.println("나이입력");
		age = sc.nextInt();
//		int 타입 값을 받으면 키보드 버퍼에 저장되는데 문자열을 입력받을때에는
//		키보드 버퍼의 값이 null일 때에만 입력받기때문에 뒤에 문자열을 입력받는 코드에
//		enter값이 들어간다
		
//		키보드 버퍼의 엔터 문자를 먼저 읽어서 없앤다
		System.out.println("이름입력");
		name = sc.nextLine();
		System.out.printf("%s님의 나이는 %d세입니다", name, age);
		sc.close();
	}

}
