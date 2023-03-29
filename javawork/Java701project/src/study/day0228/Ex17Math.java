package study.day0228;

public class Ex17Math {
	public static void main(String[] args) {
		// Math 클래스는 수학메서드들을 가지고 있는 수학 클래스입니다
		// 상수는 Math.PI => 3.141592......
		// Math 클래스의 모든 메서드는 static 메서드이다
		// static 메서드는 클래스 생성없이 클래스명으로 호출한다 (예 : Math.random)
		
		System.out.println(Math.PI);
		System.out.println("3과 5중 더 큰값은 " + Math.max(3, 5));
		System.out.println("3과 5중 더 작은값은 " + Math.min(3, 5));
		System.out.println("3의 4승은" + Math.pow(3, 4));
		System.out.println("0 ~ 1 사이의 난수구하기: " + Math.random());
		
		double su = 3.;
		System.out.println("무조건 올림 출력: " + Math.ceil(su)); // 3.1이나 3.9나 무조건 4.0
		System.out.println("무조건 내림 출력: " + Math.floor(su));
		System.out.println("반올림: " + Math.round(su));
		
		// 반지름이 20센치인 피자 2개와, 반지름이 30센치인 피자 1개? 어떤게 면적이 더 클까
		
		System.out.println("반지름이 20센치인 피자 2개의 전체면적");
		System.out.println(20 * 20 * Math.PI * 2); // 2513.2
		
		System.out.println("반지름이 30센치인 피자 1개의 전체면적");
		System.out.println(30 * 30 * Math.PI); // 2827.4
	}

}
