package study.day0302;

public class Ex8Loop {
	public static void main(String[] args) {
		/*
		 * 		    *
		 * 		   **
		 * 		  ***
		 * 		 ****
		 * 		*****
		 */
		for(int i = 0; i < 5; i++) {
			System.out.printf("%5s\n", "*".repeat(i + 1));
		}
		
//		for(int i = 1; i <= 5; i++) {
//			for(int sp = i; sp < 5; sp++) {
//				System.out.print(" ");
//			}
//			for(int j = 1; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		System.out.println();
		System.out.println("=".repeat(20));
		/*
		 * 		    *
		 * 		   ***
		 * 		  *****
		 * 		 *******
		 * 		*********
		 */
		int n = 1;
		for(int i = 5; i > 0; i--) {
			System.out.println(" ".repeat(i-1) + "*".repeat(n));
			n += 2;
		}
		
//		for(int i = 1; i <= 5; i++) {
//			for(int sp = i; sp < 5; sp++) {
//				System.out.print(" ");
//			}
//			for(int j = 0; j < i * 2 - 1; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
	}
	

}
