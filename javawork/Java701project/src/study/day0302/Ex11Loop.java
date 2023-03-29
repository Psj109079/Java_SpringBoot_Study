package study.day0302;

public class Ex11Loop {
	public static void main(String[] args) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				if(j == 2) {continue;}
				System.out.printf("i = %d, j = %d\n", i, j);
			}
		}
		System.out.println("=".repeat(20));
		Loop1 :
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				if(j == 2) {continue Loop1;} // i++로 이동
				System.out.printf("i = %d, j = %d\n", i, j);
			}
		}
		System.out.println("=".repeat(20));
		
		Loop2:
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.printf("i = %d, j = %d\n", i, j);
				if(j == 2) {
					break Loop2; //다중 for문을 빠져나온다
				}
				
			}
		}
		System.out.println("=".repeat(20));
		
	}

}
