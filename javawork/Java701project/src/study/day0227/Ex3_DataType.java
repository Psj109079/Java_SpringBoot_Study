package study.day0227;

public class Ex3_DataType {

	public static void main(String[] args) {
		// 실수 자료형(float(4), double(8))
		float f1 = 1.2f; // 숫자뒤에 f를 넣어야 4byte float 타입으로 인식
		double f2 = 1.5;
		System.out.println(f1);
		System.out.println(f2);
		
		float f3 = 1234.5678912345678f; 
		double f4 = 1234.5678912345678;
		System.out.println(f3); // 1234.5679 (소수점 포함 8자리만 정화하게 나옴)
		System.out.println(f4); // 1234.5678912345677 (소수점 포함 15자리만 정확하게 나옴)
		
		boolean b = true;
		boolean b2 = f1 == f2; // f1과 f2가 같으면 true, 다르면 false
		System.out.println(b);	// true
		System.out.println(b2);	// false
		
	}

}
