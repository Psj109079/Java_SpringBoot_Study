package study1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex1Main {
	
	public static void main(String[] args) {
		// �ڹ� ������� ȣ���غ���
		MessageInter m1 = new Message1();
		m1.sayHello("ĵ��");
		
		MessageInter m2 = new Message2();
		m2.sayHello("�ȼҴ�");
		
		// ������ ������� ȣ���غ���
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		
		MessageInter m3 =(Message1)context.getBean("mes1"); // ���1
		MessageInter m33 =(Message1)context.getBean("mes1"); // ���1
		
		MessageInter m4 = context.getBean("mes2", Message2.class); // ���2
		m3.sayHello("�̿���");
		m33.sayHello("�̿���2");
		// scope = "singletone" �ΰ�� �� �ּҰ� ���� (�⺻���� singletone)
		// scope = "prototype" �� ���� �� �ּҰ� ���� �ٸ���
		System.out.println("�ּҺ� : " + m3.hashCode() + ":" + m33.hashCode());
		m4.sayHello("��ȣ��");
		
	}

}
