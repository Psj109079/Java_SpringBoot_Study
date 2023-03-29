package study.day0308;

import java.util.Scanner;

interface Command {
	public void process();
}
class Add implements Command {

	@Override
	public void process() {
		System.out.println("추가합니다");
	}
}
class Delete implements Command {

	@Override
	public void process() {
		System.out.println("삭제합니다");
	}
}
class Select implements Command {

	@Override
	public void process() {
		System.out.println("조회합니다");
	}
}
class Update implements Command {

	@Override
	public void process() {
		System.out.println("수정합니다");
	}
}
public class Ex10Interface {
	public static void process(Command comm) {
		comm.process(); // 1.추가합니다 2.삭제합니다 3.조회합니다. 4.수정합니다 라고 출력되도록 구현하기
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int menu;
		
		Command comm = null; // Command는 Interface
		
		Exit :
		while(true) {
			System.out.println("1.추가 2.삭제 3.조회 4.수정 5.종료");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				comm = new Add();
				break;
			case 2:
				comm = new Delete();
				break;
			case 3:
				comm = new Select();
				break;
			case 4:
				comm = new Update();
				break;
			default:
				System.out.println("** 종료합니다 **");
				break Exit;
			}
			process(comm);
			System.out.println("=".repeat(30));
			
		}
		sc.close();
	}
}
