package study.day0228;

import java.util.Scanner;

public class Ex16AsciiCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char ch;
		while(true) {
			System.out.println("키보드의 키를 눌러보세요");
			ch = sc.next().charAt(0); // 첫글자를 char 타입으로 반환
			if(ch == 'q' || ch == 'Q') {break;}
			
			System.out.printf("%c => %d\n", ch, (int)ch);
			// %c = ch값이 나옴 %d = int 타입으로 형변환 했기때문에 ascii코드값이 나옴
		}
		System.out.println("** End **");
		sc.close();
	}
}
