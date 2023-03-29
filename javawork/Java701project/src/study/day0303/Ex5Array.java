package study.day0303;

public class Ex5Array {
	public static void main(String[] args) {
		// 2차원 배열에 초기값 지정하기
		int[][] arr = {{34, 56, 100}, {45, 77, 99, 100}, {55, 66, 77, 88, 99}};
		
		System.out.println("행갯수 : " + arr.length);
		System.out.println("0번행의 열갯수 : " + arr[0].length);
		System.out.println("1번행의 열갯수 : " + arr[1].length);
		System.out.println("2번행의 열갯수 : " + arr[2].length);
		
		System.out.println("** 출력 1 **");
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.printf("%5d", arr[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("** 출력 2 **");
		
		for(int[] a : arr) {
			for(int n : a) {
				System.out.printf("%5d", n);
			}
			System.out.println();
		}
	}

}
