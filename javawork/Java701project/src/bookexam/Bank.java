package bookexam;

class BankAccount {
	
	private int money;
	
	

	public BankAccount(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void transfer(int n, BankAccount b) {
		money -= n;
		b.setMoney(n + b.getMoney());
	}
	
}

public class Bank {
	public static void main(String[] args) {
		BankAccount a1 = new BankAccount(10000);
		BankAccount a2 = new BankAccount(200);
		
		a1.transfer(1000, a2);
		
		System.out.println(a1);
		System.out.println(a2);
		
	}
	
	
}
