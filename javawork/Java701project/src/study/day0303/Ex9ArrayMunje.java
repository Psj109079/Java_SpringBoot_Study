package study.day0303;

import java.util.Scanner;

public class Ex9ArrayMunje {
	public static void main(String[] args) {
		String[] members = {"이효리", "강호동", "손미나", "손흥민", "강호순", "이진", "박재범",
				"이효순", "박재순", "손예진", "김순자", "김말자", "이진상", "박진상",
				"손진상", "마이클", "재니퍼", "재니슨", "마이콜", "이순자"};
		Scanner sc = new Scanner(System.in);
		String name;
		int count = 0;
		
		/*
		 * 이름의 앞글자를 입력 시 그 단어로 시작하는 이름들을 출력하고
		 * 그 인원수를 출력하시오
		 * 
		 * (예)
		 * 		검색할 이름은? 강호
		 *		1: 강호동
		 *		4: 강호순
		 *		총 2명
		 */
		
		System.out.print("검색할 이름 입력 >>");
		name = sc.nextLine();
		
		for(int i = 0; i < members.length; i++) {
			if(members[i].startsWith(name)) {
				System.out.printf("%d: %s\n",i, members[i]);
				count++;
			}
		}
		if(count > 0) {
			System.out.printf("총 %d명", count);
		} else {
			System.out.printf("\'%s\' 로 시작하는 회원님은 없습니다", name);
			
		}
		sc.close();
	}

}
