package study.day0313;

public class Ex1Thread extends Thread {
	
	int num;
	String threadName;
	
	public Ex1Thread(String threadName, int num) {
		this.threadName = threadName;
		this.num = num;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= num; i++) {
			System.out.println(threadName + " => " + i);
		}
	}
	public static void main(String[] args) {
		Ex1Thread ex1 = new Ex1Thread("one-thread", 500);
		Ex1Thread ex2 = new Ex1Thread("two-thread", 500);
		Ex1Thread ex3 = new Ex1Thread("three-thread", 500);
		
		// thread 에서 run 호출은 start()
		ex1.start();
		ex2.start();
		ex3.start();
		
	}
}
