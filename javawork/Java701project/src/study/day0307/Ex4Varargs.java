package study.day0307;

class Berry {
	
	// Variable Arguments : 같은 타입으로 갯수 상관없이 인자로 받음(배열 타입)

	public static int sum(int ...n) { // ... = 배열타입
		System.out.println("갯수: " + n.length);
		int s = 0;
		for(int i = 0; i < n.length; i++) {
			s += n[i];
		}
		return s;
		
	}
	
	public static void writeName(String ...name) {
		System.out.println("총 " + name.length + "명");
		for(String n : name) {
			System.out.println(n);
		}
		System.out.println("=".repeat(30));
	}
}
public class Ex4Varargs {
	public static void main(String[] args) {
		int s1 = Berry.sum(3, 4);
		System.out.println(s1);
		
		System.out.println(Berry.sum(5, 6, 8, 9, 10));
		
		Berry.writeName("이미자");
		Berry.writeName("장미꽃", "안개꽃", "국화꽃");
		Berry.writeName("빨강", "파랑", "노랑", "보라", "검정");
	}

}
