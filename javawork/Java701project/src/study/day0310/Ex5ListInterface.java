package study.day0310;

import java.util.List;
import java.util.Stack;

public class Ex5ListInterface {
	
	public static void main(String[] args) {
		Stack<String> list1 = new Stack<>();
		
		list1.push("사과");
		list1.push("바나나");
		list1.push("사과");
		list1.push("오렌지");
		
		System.out.println(list1.size());
		
		while(!list1.isEmpty()) {
			System.out.println(list1.pop());
		}
	}

}
