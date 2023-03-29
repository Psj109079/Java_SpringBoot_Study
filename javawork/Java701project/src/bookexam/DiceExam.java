package bookexam;
class Dice {
	// page 182 miniproject
	
	private int value;
	
	public Dice() {
		value = 0;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public int roll() {
		int dice = (int)(Math.random() * 6) + 1;
		return dice;
	}
}
public class DiceExam {
	
	public static String loop(Dice dice) {
		String result = "";
		int cnt = 0;
		int dice1 = 0;
		int dice2 = 0;
		
		while(true) {
			dice = new Dice();
			dice1 = dice.roll();
			dice2 = dice.roll();
			System.out.println("주사위1 = " + dice1 + "주사위2 = " + dice2);
			dice.setValue(dice1 + dice2);
			cnt++;
	
			if(dice.getValue() == 2) {
				result = "(1, 1)이 나오는데 걸린 횟수 = " + cnt;
				break;
			}	
		}
		return result;
	}

	public static void main(String[] args) {
		Dice dice = new Dice();
//		loop(dice);
		System.out.println(loop(dice));
	}

}
