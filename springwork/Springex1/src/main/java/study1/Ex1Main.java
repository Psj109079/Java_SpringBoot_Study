package study1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex1Main {
	
	public static void main(String[] args) {
		// 자바 방식으로 호출해보기
		MessageInter m1 = new Message1();
		m1.sayHello("캔디");
		
		MessageInter m2 = new Message2();
		m2.sayHello("안소니");
		
		// 스프링 방식으로 호출해보기
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		
		MessageInter m3 =(Message1)context.getBean("mes1"); // 방법1
		MessageInter m33 =(Message1)context.getBean("mes1"); // 방법1
		
		MessageInter m4 = context.getBean("mes2", Message2.class); // 방법2
		m3.sayHello("이영자");
		m33.sayHello("이영자2");
		// scope = "singletone" 인경우 두 주소가 같음 (기본값이 singletone)
		// scope = "prototype" 인 경우는 두 주소가 서로 다르다
		System.out.println("주소비교 : " + m3.hashCode() + ":" + m33.hashCode());
		m4.sayHello("강호동");
		
	}

}
