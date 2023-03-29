package study.day0303;

public class Ex12ArraySort {
	public static void main(String[] args) {
		int[] data = {3, 5, 4, 1, 2};
		int temp = 0;
		
		// selection sort - 다중 for문
		for(int i = 0; i < data.length - 1; i++) {
			for(int j = i + 1; j < data.length; j++) {
				if(data[i] > data[j]) { // > : 오름차순, < : 내림차순
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		
		// 출력
		for(int d : data) {
			System.out.printf("%5d",d);			
		}
//		for(int i = 0; i < data.length; i++) {
//			System.out.printf("%5d",data[i]);
//		}
		System.out.println();
	}

}
