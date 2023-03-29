package study.day0310;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex1Set {
	
	public static void main(String[] args) {
	/*
	 * Set 인터페이스를 구현한 클래스 HashSet : 비순차적, 중복허용 안함 
	 * 								  TreeSet : 정렬되어나옴, 중복허용 X
	 */
		// 제네릭스 : <String> : String 타입만 넣을 수 있다는 뜻
		Set<String> set1 = new HashSet<>();
		Set<Integer> set2 = new TreeSet<>();
		
		set1.add("apple");
		set1.add("orange");
		set1.add("apple");
		set1.add("banana");
//		set1.add(3); // 오류발생 .genirics 때문에 발생
		
		System.out.println("set1 = " + set1.size() + " 개"); // 3개 apple은 1번으로 계산
		
		
		System.out.println("** 출력 1 **");
		for(String s : set1) {
			System.out.println(s); // 추가한 순서대로 나오지 않는다(비순차적)
		}
		
		System.out.println("** 출력 2 iterator**");
		Iterator<String> itr = set1.iterator();
		while(itr.hasNext()) {
			String s = itr.next(); // 다음 데이터를 얻어서출력
			System.out.println(s);			
		}
		
		// set2 : 배열에 int를 넣은 후 set2에 넣기
		int[] arr = {4, 1, 8, 3, 5};
		for(int a : arr) {
			set2.add(a);
		}
		System.out.println("set2 = " + set2.size() + "개");
		
		for(int a : set2) {
			System.out.printf("%5d", a);
		}
		
		
		
	}

}
