package study.day0228;

public class Ex6Operator {
	public static void main(String[] args) {
		
//		산술연산자 : +, -, *, /, %
		
		int su1 = 7;
		int su2 = 4;
		
		System.out.printf("%d + %d = %d\n", su1, su2, su1 + su2);
		System.out.printf("%d - %d = %d\n", su1, su2, su1 - su2);
		System.out.printf("%d * %d = %d\n", su1, su2, su1 * su2);
		System.out.printf("%d / %d = %d\n", su1, su2, su1 / su2);
//		정수끼리의 계산결과는 무조건 정수 타입
//		실수 타입으로 출력하려면 계산하는 값중에 하나라도 double 타입이 있어야한다
		System.out.printf("%d / %d = %3.1f\n", su1, su2, (double)su1 / su2); 
		// 계산할때에만 su1을 double 타입으로 바꿔서 계산
		System.out.printf("%d %% %d = %d\n", su1, su2, su1 % su2); // printf에서 %자체 출력시 %%
		
	}

}
