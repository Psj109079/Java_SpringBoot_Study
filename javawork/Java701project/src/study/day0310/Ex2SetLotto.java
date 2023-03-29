package study.day0310;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.processing.AbstractProcessor;

public class Ex2SetLotto {
	
	public static void main(String[] args) {
		Random r = new Random();
		Set<Integer> setLotto = new TreeSet<>();
		
		// 1 ~ 45의 난수 6개를 구한 후 오름차순으로 출력
		
		
		while(setLotto.size() != 6) {
			setLotto.add(r.nextInt(45) + 1);
		}
		
//		for(int l : setLotto) {
//			System.out.printf("%5d", l);
//		}
		System.out.println();
		Iterator<Integer> itr = setLotto.iterator();
		while(itr.hasNext()) {
			System.out.printf("%5d", itr.next());
		}
		
	}
}
