package study.day0227;

public class Ex1_DataType {

	public static void main(String[] args) {
		System.out.println("자바 프로젝트 생성");
//		git 에 그날 수업한 자료 올리려면 (study 폴더에서 gitbash 를 연다)
//		git add .
//		git commit -m “메세지”
//		git push origin master
//		정수 타입 byte(1) - short(2) - int(4) - long(8)
		byte a = 127;
		byte b = (byte)234; // 강제로 자료형보다 큰값을 넣을경우 값손실이 발생한다
		System.out.println(a);
		System.out.println(b); // 원하는 값이 나오지 않는다(자료형보다 큰 값이 들어가서)
		// -2의 보수로 변환된 값 출력
		char ch = 'a';
		System.out.println(ch);					// char
		System.out.println((int)ch);			// int
		System.out.println(String.valueOf(ch)); // String
		
		char m1 = 'A';
		char m2 = '가'; // 자바에서 char 는 2byte라 한글도 가능(한글 = 2byte 영문 = 1byte
		System.out.println(m1 + ", " +m2);
		System.out.println((int)m1); // A의 아스키코드 10진수 값이 나온다
		System.out.println((int)m2);
		
//		묵시적 형변환 = 연산시에 자동으로 결정되는 타입
//		(int + int = int, double + int = double, String + int = String char + int = int)
		System.out.println(m1 + 32); // 'A' + 32 = 97 : char와 int의 결과는 int
		System.out.println((char)(m1 +32)); // char 타입으로 나오게 하려면 형변환이 필요함
		
		char m3 = 66; // 내부적으로는 문자 B(ascii code 66)으로 인식함
		System.out.println(m3);
		int m4 = 'A'; // 내부적으로 65로 인식
		System.out.println(m3 + ", " + m4); // B, 65
		System.out.println((int)m3 + ", " + (char)m4); // 66, A	
	}

}