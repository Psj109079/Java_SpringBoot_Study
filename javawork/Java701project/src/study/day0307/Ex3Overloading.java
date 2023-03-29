package study.day0307;

class Orange{
	public static int add(int n1, int n2) {
		return n1 + n2;
	}
	public static double add(double n1, double n2) {
		return n1 + n2;
	}
	public static float add(float n1, float n2) {
		return n1 + n2;
	}
	public static String add(String s1, String s2) {
		return s1 + s2;
	}
}
public class Ex3Overloading {
	public static void main(String[] args) {
		
		System.out.println("5 + 6 = " + Orange.add(5, 6));
		System.out.println("3.2 + 2.5 = " + Orange.add(3.2, 2.5));
		System.out.println("2.4f + 1.2f = " + Orange.add(2.4f, 1.2f));
		System.out.println("Apple + Orange = " + Orange.add("Apple", "Orange"));
		
	}

}
