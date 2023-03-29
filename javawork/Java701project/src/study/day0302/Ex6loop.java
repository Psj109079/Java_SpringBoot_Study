package study.day0302;

public class Ex6loop {

	public static void main(String[] args) {
		//1. 1 ~ 20 까지의 숫자중 3의 배수만 출력 printf("%4d",변수) = 4칸단위로 출력\
		for(int i = 1; i <= 20; i++) {
			if(i % 3 == 0) {
				System.out.printf("%4d", i);
			}
		}
		System.out.println();
		System.out.println("-".repeat(20));
		
		//2. 10 ~ 1까지 거꾸로 출력
		for(int i = 10; i > 0; i--) {

			System.out.printf("%4d", i);
		}
		System.out.println();
		System.out.println("-".repeat(20));
		
		//3. 1 ~ 30까지 숫자중 5의 배수만 출력
		for(int i = 1; i <= 30; i++) {
			if(i % 5 == 0) {
				System.out.printf("%4d", i);
			}
		}
		System.out.println();
		System.out.println("-".repeat(20));
		
		//4. * 20개 출력 (for문으로)
		for(int i = 0; i < 20; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println("*".repeat(20));
		
		//5. 1 ~ 20까지중 홀수만 출력
		for(int i = 1; i <= 20; i+=2) {
			System.out.printf("%4d", i);
		}
	}

}
