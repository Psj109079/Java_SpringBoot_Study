package study.day0306;

import java.util.Scanner;

//클래스명  Employee
class Employee{
	
//	멤버변수    회사명 EMPNAME=”삼성전자” 
//				사원명  name
//	           	주소   	addr
//	           	기본급  gibon
//	           	수당    sudang
	public static final String EMPNAME = "삼성전자";
	private String name;
	private String addr;
	private int gibon;
	private int sudang;
	
//	메서드
//	기본 setter & getter    
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddr() {
		return addr;
	}
	
	public void setGibon(int gibon) {
		this.gibon = gibon;
	}
	public int getGibon() {
		return gibon;
	}
	
	public void setSudang(int sudang) {
		this.sudang = sudang;
	}
	public int getSudang() {
		return sudang;
	}
//	세금구하는 메서드 (기본급의 3프로 반환) : 메서드명 getTax()
	public int getTax() {
		return (int) (getGibon() * 0.03);
	}
	
//	실수령액 반환하는 메서드   getNetPay() : 기본급+수당-세금
	public int getNetPay() {
		return getGibon() + getSudang() - getTax();
	}
}
public class parctice {
	public static void main(String[] args) {
//	메인
//		cnt : 처음 입력할 갯수부터 입력후 배열할당하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("사원 수 >> ");
		int cnt = Integer.parseInt(sc.nextLine());
		Employee[] emp = new Employee[cnt];
		
//		순서대로 사원명,주소,기본급,수당 을 인원수만큼 입력후 출력하세요
		for(int i = 0; i < emp.length; i++) {
			emp[i] = new Employee();
			System.out.print("사원명 >> ");
			emp[i].setName(sc.nextLine());
			
			System.out.print("주소 >> ");
			emp[i].setAddr(sc.nextLine());
			
			System.out.print("기본급 >> ");
			emp[i].setGibon(Integer.parseInt(sc.nextLine()));
			
			System.out.print("수당 >> ");
			emp[i].setSudang(Integer.parseInt(sc.nextLine()));
		}
		
//		출력 예시
//		 
//		“삼성전자” 직원 현황
//
//		번호   사원명   주소     기본급     수당      세금   실수령액
//		—------------------------------------------------------------
//		1      이영자   강남구  2500000  300000     75000  	2725000
		System.out.println("\"" +Employee.EMPNAME + "\" 직원 현황");
		
		System.out.printf("%s%8s%8s%8s%8s%8s%8s\n", "번호", "사원명", "주소", "기본급", "수당", "세금", "실수령액");
		for(int i = 0; i < emp.length; i++) {
			System.out.printf("%d%8s%8s%12d%12d%12d%12d\n", i + 1, emp[i].getName(), emp[i].getAddr(), emp[i].getGibon(), emp[i].getSudang(), emp[i].getTax(), emp[i].getNetPay());
		}
		sc.close();
	}

}
