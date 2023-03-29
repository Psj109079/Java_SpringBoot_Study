
package study.day0308;

// class 가 class 를 상속받을 때 extends
// interface 가 interface 를 상속받을 때 extends
// class 가 interface 를 구현할 때 implements

interface Kiwi {
	public void play();
}

interface Manggo extends Kiwi {
	public void study();
}
class Banana {
	public void eat() {
		System.out.println("바나나를 먹어요");
	}
}
class Berry extends Banana implements Manggo {
	
	@Override
	public void play() {
		System.out.println("우리 다같이 놀아요!");
	}
	@Override
	public void study() {
		System.out.println("자바 공부를 합시다");
	}
	

}
public class Ex8Interface {
	public static void main(String[] args) {
		Manggo m = new Berry(); // 업캐스팅
		
		m.play();
		m.study();
		
		Kiwi k = new Berry();
		k.play();
		
		((Manggo)k).study();	// 다운 캐스팅
		Manggo a = (Manggo)k; 	// 다운 캐스팅
		a.study();
		a.play();
		
		Banana b = new Berry();
		b.eat();
		
		Berry e = (Berry)b;
		e.eat();
		e.study();
		e.play();
		
		
	}

}
