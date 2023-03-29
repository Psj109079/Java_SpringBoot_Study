package study.day0228;

public class Ex5Operator {
	public static void main(String[] args) {
		
		/* 증감연산자 ++, --
		 * a++, ++a : 단항으로 사용 시 전치, 후치 모두 같다
		 * 다른 연산자와 같이 사용 시 전치는 1순위, 후치는 끝순위로 계산된다
		 * 
		 */
		
		int a,b,m,n;
		a = b = 5;
		++a;
		b++;
		System.out.printf("a = %d, b = %d\n", a, b);
		
		m = ++a * 3; // 먼저 a 증가 후 3을 곱한값을 m으로 대입한다 7 * 3
		n = b++ * 3; // 먼저 3을 곱한 값을 n에 대입 후 b가 증가딘다 6 * 3
		
		System.out.printf("a = %d, b = %d, m = %d, n = %d", a, b, m, n);
		
		a = b = 3;
		System.out.println(a++); // 출력 후 증가 3
		System.out.println(++b); // 증가 후 출력 4
	}
}
