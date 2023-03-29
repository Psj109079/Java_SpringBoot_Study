package study.day0302;

public class Ex5Loop {

	public static void main(String[] args) {
		int a =65; // 'A'
		
		while(a <= 'Z') {
			System.out.print((char)a++);
		}
		System.out.println();
		
		char b = 'A';
		do {
			System.out.print(b++);
		} while(b <= 'Z');
		
		System.out.println();
		for(char ch = 'a'; ch <= 'z'; ch++) {
			System.out.printf("%c", ch);
		}
		
		System.out.println();
		System.out.println(".".repeat(30)); // .을 30번 반복
		
		String msg = "Happy!";
		int idx = 0;
		while(true) {
			System.out.printf("%8s", msg);
			idx++;
			if(idx == 5) {break;}
		}
		
		System.out.println();
		idx = 0;
		
		do {
			System.out.printf("%8s", msg);
			idx++;
			if(idx == 5) {break;}
		} while(true);
		
		System.out.println();
		
		for(idx = 1; idx <=5; idx++) {
			System.out.printf("%8s", msg);
		}
		
		System.out.println();
		System.out.println("=".repeat(84000)); // =을84000번 반복
		
		// msg 를 5번씩 출력하는데 총 3번 반복
		// 다중 for문 이용
		
		for(int row = 1; row <= 3; row++) {
			for(int col = 1; col <= 5; col++) {
				System.out.printf("%8s", msg);
			}
			System.out.println();
		}
	}

}
