package study.day0310;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex3Map {
	public static void main(String[] args) {
		// Map 인터페이스를 구현하는 HashMap,TreeMap
		// key 와 value의 쌍으로 저장되는 구조
		// 이때 key의 타입이 Set이다 (중복허용X,비순차적)
		Map<String, String> map = new HashMap<>();
		map.put("name", "이효리");
		map.put("addr", "강남구");
		map.put("blood", "AB형");
		
		System.out.println(map.size());
		// key를 이용해서 value 값을 얻는다
		System.out.println("이름: " + map.get("name"));
		System.out.println("주소: " + map.get("addr"));
		System.out.println("혈액형: " + map.get("blood"));
		
		map.put("name", "송혜교");
		System.out.println(map.size());
		System.out.println("이름: " + map.get("name")); // 송혜교
		System.out.println("나이: " + map.get("age"));	// 없는 key를 이용해서 값을 얻을경우 null
		
		// 일괄적으로 map에 들어있는 모든 값을 얻고자 한다면
		Set<String> keySet = map.keySet(); // key 들만 얻는다(Set타입)
		System.out.println("=".repeat(30));
		for(String key : keySet) {
			String v = map.get(key);
			System.out.println(key + " => " + v);
		}
		System.out.println(map.keySet());
		
	}

}
