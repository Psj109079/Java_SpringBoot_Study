package study.day0308;

// 멤버 내부 클래스
class Outer {
	int a = 10;
	static int b = 20;
	
	class Inner {
		int c =30;
//		static int d = 40; // 일반 내부클래스 내에서는 static 멤버 변수 선언 불가능
		
		public void show() {
			// 멤버 내부클래스에서는 외부클래스의 모든 변수를 사용 가능하다
			System.out.println("Inner 내부 클래스의 메서드");
			System.out.println("a =" + a);
			System.out.println("b =" + b);
			System.out.println("c =" + c);
		}
	}
	
	static class Inner2 {
		int e = 50;
		static int f = 60; // static 내부 클래스에서는 static 변수 선언 가능
		
		public void show() {
			
			// static 내부클래스에서는 외부 클래스의 static 변수만 접근이 가능하다
			System.out.println("Inner2 내부 클래스의 메서드");
//			System.out.println("a =" + a); // 외부클래스의 인스턴스 멤버변수는 접근 불가능
			System.out.println("b =" + b);
			System.out.println("e =" + e);
			System.out.println("f =" + f);
		}
	}
	
	public void write() {
		// 멤버 내부클래스는 기능별로 클래스로 따로 구현하고자 할때 많이 사용
		Inner in1 = new Inner();
		in1.show();
		
		Inner2 in2 = new Inner2();
		in2.show();
		
	}
}
public class Ex11InnerClass {
	public static void main(String[] args) {
		Outer o = new Outer();
		o.write();
		
		// 내부클래스를 직접 선언 후 메서드를 호출하고자 할 경우
		Outer.Inner in1 = new Outer().new Inner(); // member 내부클래스
		in1.show();
		
		Outer.Inner2 in2 = new Outer.Inner2(); // static 내부클래스
		in2.show();
	}

}
