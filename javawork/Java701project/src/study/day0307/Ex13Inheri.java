package study.day0307;

// 부모 클래스(super class)
class SuperObj {
	String msg;
	
	SuperObj() {
		
		System.out.println("super 클래스의 생성자");
	}
	SuperObj(String msg) {
		this.msg = msg;
	}
	
	
}

// 자식 클래스 (sub class) : 자바는 단일상속만 지원

class SubObj extends SuperObj {
	String msg2;
	
	SubObj() {
		
		// 상속을 받으면 super(); 가 생략되어있음, 무조건 첫줄에 있어야만 한다.
		// default인 경우에만 super(); 생략가능
		System.out.println("sub 클래스의 생성자");
	}
	
	SubObj(String msg ,String msg2) {
		super(msg); // super()로 부모 생성자 호출
		// super() 안에 변수를 넣어주면 인자가 같은 타입을 가지고있는 부모 생성자를 호출한다
		// 생략 안됨
		this.msg2 = msg2;
	}
	
	public void writeData() {
		System.out.println(msg);
		System.out.println(msg2);
	}
}

public class Ex13Inheri {
	public static void main(String[] args) {
		SubObj sub = new SubObj();

		SubObj sub2 =new SubObj("아버지", "저에요");
		sub2.writeData();
	}
}
