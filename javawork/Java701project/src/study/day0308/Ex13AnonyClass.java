package study.day0308;

interface InterB {
	
	public void paint();
	public void save();

}

abstract class AbstOne {
	public void show() {
		System.out.println("AbstOne-show");
	}
	abstract public void study();
}

// 익명(Anonymous)클래스
class MyAnony {
	// InterB 구현
	InterB b = new InterB() {		
		@Override
		public void save() {
			System.out.println("save");
		}		
		@Override
		public void paint() {
			System.out.println("paint");
		}
	};
	// AbstOne 구현
	AbstOne o = new AbstOne() {	
		@Override
		public void study() {
			System.out.println("study");
		}
		
		@Override
		public void show() {
			super.show(); // AbstOne 의 show 메서드를 가져옴
			System.out.println("익명 내부클래스에서 나머지 show 처리");
		};
	};
}
public class Ex13AnonyClass {
	public static void main(String[] args) {
		MyAnony a = new MyAnony();
		
		a.b.save();
		a.b.paint();
		a.o.study();
		a.o.show();
	}
}
