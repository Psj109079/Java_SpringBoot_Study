package study.day0306;

import java.util.Scanner;

class MyCar{
	public static final String EMP = "현대자동차";
	private String carName;
	private String carColor;
	private int carPrice;
	
	// setter
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	
	// getter
	public String getCarName() {
		return carName;
	}
	public String getCarColor() {
		return carColor;
	}
	public int getCarPrice() {
		return carPrice;
	}
	
	// 출력하기 위한 메서드
	public void writeCar() {
		System.out.printf("%12s%7s%8d\n", this.getCarName(), this.getCarColor(), this.getCarPrice());
	}
}
public class Ex7Object {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt;
		MyCar[] cars;
		
		// 입력할 갯수
		System.out.println("입력할 자동차 갯수는?");
		cnt = Integer.parseInt(sc.nextLine());
		
		// 갯수만큼 할당
		
		cars = new MyCar[cnt];
		
		// 갯수만큼 자동차에 대한 데이터 넣기
		for(int i = 0; i < cars.length; i++) {
			// 각 배열의 객체 생성
			cars[i] = new MyCar();
			System.out.println("자동차명?");
//			String carName = sc.nextLine();
			cars[i].setCarName(sc.nextLine());
			
			System.out.println("자동차 색상은?");
			String color = sc.nextLine();
			cars[i].setCarColor(color);
			
			System.out.println("자동차 가격은?");
			int price = Integer.parseInt(sc.nextLine());
			cars[i].setCarPrice(price);
			System.out.println();
		}
		// 출력
		System.out.println("자동차 회사명: " + MyCar.EMP);
		System.out.println();
		System.out.printf("%12s%7s%8s\n", "carname", "color", "price");
		System.out.println("=".repeat(40));
		for(MyCar my : cars) {
			my.writeCar();
		}
		sc.close();
	}

}
