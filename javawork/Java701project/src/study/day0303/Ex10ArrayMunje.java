package study.day0303;

import java.util.Scanner;

public class Ex10ArrayMunje {
	public static void main(String[] args) {
		String[] members = {"이효리", "강호동", "손미나", "손흥민", "강호순", "이진", "박재범",
				"이효순", "박재순", "손예진", "김순자", "김말자", "이진상", "박진상",
				"손진상", "마이클", "재니퍼", "재니슨", "마이콜", "이순자"};
		Scanner sc = new Scanner(System.in);
		String name;
		int count = 0, menu;
		
		/*
		 * 		* 메뉴 *
		 * 		1. 시작하는 이름으로 찾기
		 * 		2. 끝나는 이름으로 찾기
		 * 		3. 종료
		 */
		Exit:
		while(true) {
			System.out.println("** 메뉴선택 **");
			System.out.println("1. 시작하는 이름으로 찾기");
			System.out.println("2. 끝나는 이름으로 찾기");
			System.out.println("3. 종료");
			System.out.println("=".repeat(20));
			
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:
				count = 0;
				System.out.println("검색할 이름을 입력해주세요");
				name = sc.nextLine();
				for(int i = 0; i < members.length; i++) {
					if(members[i].startsWith(name)) {
						count++;
						System.out.println(i + "번지 : " + members[i]);
					}
				}
				if(count == 0) {
					System.out.println("\"" + name + "\" 로 시작하는 멤버는 없습니다");
				} else {
					System.out.println("총 " + count + "명");
				}
				break;
			case 2:
				count = 0;
				System.out.println("검색할 이름을 입력해주세요");
				name = sc.nextLine();
				for(int i = 0; i < members.length; i++) {
					if(members[i].endsWith(name)) {
						count++;
						System.out.println(i + "번지 : " + members[i]);
					}
				}
				if(count == 0) {
					System.out.println("\"" + name + "\" 로 끝나는 멤버는 없습니다");
				} else {
					System.out.println("총 " + count + "명");
				}
				break;
			default :
				System.out.println("** 프로그램 종료 **");
				break Exit; 
				
			}
		}
		
	}

}
