package study.day0227;

public class Ex2_StringType {

	public static void main(String[] args) {
		// 2글자 이상 저장시 문자열 처리
		String s1 = new String("Hello"); // 방법1
		String s2 = "Apple Mango"; // 방법2
		String s4 = "   Happy     ";
		System.out.println(s1);
		System.out.println(s2);
		
		String s3 = s1 + 100; // String + int = String 
		// 문자열 + 는 나열
		System.out.println(s3);
		System.out.println("34 + 89 = " + 34 + 89); // 34 + 89 = 3489
		// 문자열을 먼저 계산해서 뒤에오는 숫자도 문자열처리됨
		// int 계산전에 String이 있다면 뒤에 오는 int형도 문자열이 됨
		// int 형으로 출력하고 싶다면 ()를통해 우선계산 or int 형 변수에 담기
		int a = 34 + 89;
		System.out.println("34 + 89 = " + a); // 34 + 89 = 123
		System.out.println("34 + 89 = " + (34 + 89)); // 34 + 89 = 123
		
		// String 클래스가 가진 매서드들
		System.out.println("s1의 length = " + s1.length());
//		대상의 길이를 구하는 length() 메서드
		System.out.println("s2의 length = " + s2.length());
		System.out.println("s4의 length = " + s4.length());
		// n.length = 공백의 길이까지 포함
		// trim() = 앞뒤 공백을 제거함
		System.out.println("s4의 length = " + s4.trim().length()); // 앞뒤 공백을 제거한 길이
		
		// charAt(인덱스) : 문자열에서 인덱스번지에 해당하는 문자(1글자) 반환
		// indexOf(문자) : 해당 문자가 어디에 있는지 인덱스 번호 반환
		String msg = "Have a Good Day";
		System.out.println(msg.charAt(7)); // 7번째 있는 G 반환
		System.out.println(msg.indexOf(7)); // 7이라는 값이 없으면 -1 반환
		System.out.println(msg.indexOf("a")); // a값의 첫번째 인덱스 1 반환
		System.out.println(msg.indexOf("a", 2));
		// 2번 인덱스부터 a 를 찾아서 나오는 첫번째 a의 인덱스 번호5 반환
		System.out.println(msg.indexOf("a", 7)); 
		// 7번 인덱스부터 a 를 찾아서 나오는 첫번째 a의 인덱스 번호13 반환
		System.out.println(msg.lastIndexOf("a")); // 마지막 a의 인덱스값 13반환
		
		// 문자열변수.startsWith("문자열"): 변수가 "문자열" 로 시작하면 true 반환
		// 문자열변수.endsWith("문자열"): 변수가 "문자열" 로 끝나면 true 반환
		System.out.println(msg.startsWith("Have")); // true
		System.out.println(msg.startsWith("have")); // false
		
		System.out.println(msg.endsWith("Hello")); // false
		System.out.println(msg.endsWith("Day")); // true
		
		// substring(5) = 5번 인덱스부터 끝까지 반환
		// substring(1, 10) = 1 ~ (10 - 1) 인덱스에 해당하는 문자열 반환
		System.out.println(msg.substring(7)); // 7번(G) 부터 끝까지 추출해서 반환
		System.out.println(msg.substring(7, 10)); 
		// Goo (7번 인덱스부터 9번 인덱스 까지 추출해서 반환)
		
		System.out.println(msg.toLowerCase()); // 전부 소문자로 반환
		System.out.println(msg.toUpperCase()); // 전부 대문자로 반환
		
		// replace = 일부 문자 또는 단어 변경 후 반환
		System.out.println(msg.replace("a", "*")); // H*ve * Good D*y
		System.out.println(msg.replace("Good", "Happy")); // Have a Happy Day
		System.out.println(msg.replace("a", "")); // Have a Happy Day
		
		// 문자열 비교 equals, compareTo
		String m1 = "Apple";
		String m2 = "apple";
		String m3 = "Orange";
		
		// == 기본형에서는 값으로 비교, 클래스 타입에서는 주소비교를 의미
		System.out.println(m1 == m2); // 주소비교
		// 문자열같은 경우는 정확하게 값을 비교하려면 위의 두 메서드를 사용
		System.out.println(m1.equals(m2)); //false =  m1이 m2와 같은지 비교(대소문자가 다를경우 false)
		System.out.println(m1.equals("Apple")); // true
		System.out.println(m1.equalsIgnoreCase(m2)); // true = 대소문자 무시하고 철자만 비교
		
		// compareTo = 두 문자열의 아스키코드값의 차이를 반환
		System.out.println(m1.compareTo(m3));
		// A(65), O(79) : -14 : (음수 : m1이 작을경우)
		System.out.println(m1.compareTo("Apple")); // 두 변수의 값이 완전히 같은경우 0이 나온다
		System.out.println("computer".compareTo("command"));
		// com까지는 같으니 그 이후 p와 m을 비교 p(112), m(109) : 3(양수값은 앞의값이 더 크다는 뜻)
		
		// split(",") = , 로 분리하여 배열타입으로 반환
		String colors = "red,blue,green,orange,pink,black";
		
		String[] mycolor = colors.split(",");
		System.out.println("총 " + mycolor.length +" 개 분리");
		// for 문으로 출력
		for(String ch: mycolor) {
			System.out.println(ch); // 분리한 색상표 출력하기
		}
		
		
		
		
		
		
		
		
	}

}
