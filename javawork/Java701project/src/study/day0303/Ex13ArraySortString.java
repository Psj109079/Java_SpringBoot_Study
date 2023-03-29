package study.day0303;

public class Ex13ArraySortString {
	public static void main(String[] args) {
		String[] names = {"홍길동", "강호동", "James", "남순희", "신지아"};
		String temp = "";
		
		for(int i = 0; i < names.length - 1; i++) {
			for(int j = i + 1; j < names.length; j++) {
				if(names[i].compareTo(names[j]) > 0) { // i번값이 j번지값보다 더 클경우 양수 값이 나온다
					temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}
			}
		}
		
		for(String s : names) {
			System.out.println(s);
		}
//		for(int i = 0; i < names.length; i++) {
//			System.out.printf("%s", names[i]);
//		}
	}

}
