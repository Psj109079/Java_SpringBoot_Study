package study1;

public class Message1 implements MessageInter {

	@Override
	public void sayHello(String name) {
		System.out.println("내 이름은 " + name + " 입니다");
	}

}
