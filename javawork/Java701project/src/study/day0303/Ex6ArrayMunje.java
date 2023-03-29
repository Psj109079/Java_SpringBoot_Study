package study.day0303;

public class Ex6ArrayMunje {
	public static void main(String[] args) {
		int[] data = {100, 78, 67, 190, -100, 89, 350, -290, 78, 200};
		
		int max = data[0];
		int min = data[0];
		
		for(int i = 1; i < data.length; i++) {
			if(data[i] > max) {
				max = data[i];
			}
			if(data[i] < min) {
				min = data[i];
			}
		}
		System.out.println(max);
		System.out.println(min);
	}

}
