package study.day0313;

// Thread 클래스를 상속받을 수 없는경우(이미 다른 클래스를 상속받는 경우)
// Runnable 인터페이스를 구현해서 Thread를 실행해야함
public class Ex2Runnable implements Runnable{
	
	int num;
	String threadName;
	
	public Ex2Runnable(String threadName, int num) {
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
		Thread th1 = new Thread(new Ex2Runnable("one-thread", 300));
		Thread th2 = new Thread(new Ex2Runnable("two-thread", 300));
		Thread th3 = new Thread(new Ex2Runnable("three-thread", 300));
		
		th1.start();
		th2.start();
		th3.start();
		
	}

}
