package study.day0307;

import java.util.Scanner;

class Employee{
	public static final String EMPNAME = "삼성전자";
	private String name;
	private String addr;
	private int gibon;
	private int sudang;
	
	// setter & getter method
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getGibon() {
		return gibon;
	}
	public void setGibon(int gibon) {
		this.gibon = gibon;
	}
	public int getSudang() {
		return sudang;
	}
	public void setSudang(int sudang) {
		this.sudang = sudang;
	}
	
	// 추가 기능을 가진 메서드 구현
	
	// 세금 반환 : 기본급의 3%
	public int getTax() {
		return gibon * 3 / 100;
	}
	
	public int getNetPay() {
		return gibon + sudang - getTax();
	}
	
	// 출력
	public void writeSawon() {
		System.out.println(name + "\t" + addr + "\t" + gibon + "\t" + sudang + "\t" + getTax() + "\t" + getNetPay());
	}
	
	
}

public class Ex1Employee {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt;
		Employee[] emp;
		
		System.out.println("정보를 입력할 사원수는?");
		cnt = Integer.parseInt(sc.nextLine());
		
		// 배열 할당
		emp = new Employee[cnt];
		
		// 생성
		for(int i = 0; i < emp.length; i++) {
			emp[i] = new Employee();	
		}
		
		// 인원수 만큼 정보 입력
		for(int i = 0; i < emp.length; i++) {
			System.out.println("사원명은?");
			String name = sc.nextLine();
			System.out.println("주소는?");
			String addr = sc.nextLine();
			System.out.println("기본급은?");
			int gibon = Integer.parseInt(sc.nextLine());
			System.out.println("이번 달 수당은?");
			int sudang = Integer.parseInt(sc.nextLine());
			
			//클래스에 저장
			emp[i].setName(name);
			emp[i].setAddr(addr);
			emp[i].setGibon(gibon);
			emp[i].setSudang(sudang);
			System.out.println();
		}
		// 출력
		System.out.println("\t\"" + Employee.EMPNAME + "\" 직원 현황\n");
		System.out.println("번호\t사원명\t주소\t기본급\t수당\t세금\t실수령액");
		for(int i = 0; i < emp.length; i++) {
			System.out.print(i + 1 + "\t");
			emp[i].writeSawon();
		}
		sc.close();
	}

}
