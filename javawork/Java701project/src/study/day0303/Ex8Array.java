package study.day0303;

import java.util.Scanner;

public class Ex8Array {
	public static void main(String[] args) {
		String[] members = {"이효리", "강호동", "손미나", "손흥민", "강호순", "이진", "박재범",
							"이효순", "박재순", "손예진", "김순자", "김말자", "이진상", "박진상",
							"손진상", "마이클", "재니퍼", "재니슨", "마이콜", "이순자"};
		
		/*
		 * 검색할 이름을 입력 후 몇번째에 있는지 출력
		 * 없을경우 없다는 메세지 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("찾을 이름 입력 >> ");
		String find = sc.nextLine();
		
		boolean flag = false;
		for(int i = 0; i < members.length; i++) {
			if(find.compareTo(members[i]) == 0) { // compareTo = 0이면 같다는 뜻
				System.out.printf("%s >> members의 %d번째에 있습니다", find, i + 1);
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.printf("%s >> members에 없습니다", find);
		}
		sc.close();
		
	}
}
