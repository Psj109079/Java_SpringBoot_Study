package study4;

public class Car {
	Tire tire;
	
	public Car(Tire tire) {
		this.tire = tire;
	}
	
	public void myCarTire() {
		System.out.println("�� ���� Ÿ�̾�� " + tire.getTireNmae());
	}

}