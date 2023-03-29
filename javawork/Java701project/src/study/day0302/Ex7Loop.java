package study.day0302;

public class Ex7Loop {
	public static void main(String[] args) {
		// 5행 5열로 * 출력
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("=".repeat(20));
		
		/*
		 * 		*
		 *		**
		 *		***
		 *		****
		 *		*****
		 */
		for(int i = 0; i < 5; i++) {
			System.out.println("*".repeat(i + 1));
		}
		System.out.println("=".repeat(20));
		/*
		 * 	*****
		 *	****	
		 *	*** 			
		 *	**
		 *	* 			
		 */
		for(int i = 5; i > 0; i--) {
			System.out.println("*".repeat(i));
		}
		System.out.println("=".repeat(20));
	}

}
