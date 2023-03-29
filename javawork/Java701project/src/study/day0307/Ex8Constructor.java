package study.day0307;

import study.day0306.Shop;

public class Ex8Constructor {
	public static void main(String[] args) {
		Shop s1 = new Shop();
		s1.writeShop();
		
		Shop s2 = new Shop("오렌지");
		s2.writeShop();
		
		Shop s3 = new Shop(8000);
		s3.writeShop();
		
		Shop s4 = new Shop("딸기", 840000);
		s4.writeShop();
	}

}
