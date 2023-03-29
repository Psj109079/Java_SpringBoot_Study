package study.day0303;

import java.util.Scanner;

public class Ex7Array {
	public static void main(String[] args) {
		int[] data = {12, 5, 8, 11, 9, 15, 3, 17, 1, 10};
		Scanner sc = new Scanner(System.in);

		/*
		 * 숫자 입력 후 그 숫자가 배열 몇번째에 있는지 출력
		 * 없을 경우 x는 배열에 없습니다 출력
		 * 
		 * 방법 1 : int 타입 변수에 배열 번지에 없는 값으로 초기화 한 후
		 * 찾을경우 그 배열 번지값을 대입한다
		 * 반복문을 빠져나온 후 -1 이면 '없다는 메세지' 아닐경우 위치 출력
		 */
		
//		int n = -1;
//		int su;
//		System.out.print("검색할 숫자 입력 >>");
//		su = sc.nextInt();
//		
//		for(int i = 0; i < data.length; i++) {
//			if(su == data[i]) {
//				n = i + 1;
//			}
//		}
//		if(n != - 1) {
//			System.out.printf("%d >> data배열 %d번째에 있습니다", su, n);
//		} else {
//			System.out.printf("%d >> data배열에 없습니다",su);
//		}
		
		/*
		 * 방법 2
		 * 같은 값을 찾으면 출력 후 n = true로 변경
		 * 반복문을 빠져나왔을 때 같은 값이 없다면 n = false
		 */
		boolean flag = false;
		
		System.out.print("숫자 입력 >>");
		int input = sc.nextInt();
		for(int i = 0; i < data.length; i++) {
			
			if(data[i] == input) {
				System.out.printf("%d >> data배열 %d번째에 있습니다", input , i + 1);
				flag = true;
				break;
			}
		}
		if(flag == false) {
			System.out.printf("%d >> data배열에 없습니다", input);
		}
		sc.close();
		
	}

}
