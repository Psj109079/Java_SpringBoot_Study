package study.day0228;

import java.util.Scanner;

public class Sol2 {
	public static void main(String[] args) {
//		[문제2]
//		상품명과 수량 단가를 입력받아서 총 금액을 구해서 출력하시오
//		(단 수량이 5개 이상이면 총금액 출력후 10프로 디씨된 금액도 같이 출력해주세요)
//		(예)
//		상품명 
//		딸기
//		수량
//		5
//		단가
//		1000
//			                
//		총 5000 원
//		10프로 할인된 금액  4500 원
		Scanner sc = new Scanner(System.in);
		String name;
		int a, b;
		
		System.out.print("상품명 >>");
		name = sc.nextLine();
		System.out.print("수량 >>");
		a = sc.nextInt();
		System.out.print("단가 >>");
		b = sc.nextInt();
		
		System.out.printf("상품명: %s, 수량: %d, 단가: %d\n", name, a, b);			
		System.out.println(a >= 5? "10% 할인된 금액" + a * (b * 0.9) + "원" :"총" + b * a + "원");
		sc.close();
		
	

	}

}
