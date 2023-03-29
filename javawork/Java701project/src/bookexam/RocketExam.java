package bookexam;

class Rocket {
	// page 187
	private int x, y;

	Rocket(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Rocket [x=" + x + ", y=" + y + "]";
	}
	
	public void moveUp() {
		setY(getY() + 1);
	}
	
	
}

public class RocketExam {
	public static void main(String[] args) {
		Rocket rk = new Rocket(1, 2);
		
		System.out.println(rk.toString());
		rk.moveUp();
		System.out.println(rk.toString());
		
		for(int i = 0; i < 200; i++) {
			rk.moveUp();
		}
		System.out.println(rk.toString());
		
	}
}
