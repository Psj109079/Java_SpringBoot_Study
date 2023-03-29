package study.day0321;

import java.util.ArrayList;
import java.util.List;

public class ShopList {
	private List<ShopDto> list = new ArrayList<>();

	public ShopList() {
		list.add(new ShopDto("옷1", 15000, "red", "1.jpg"));
		list.add(new ShopDto("옷2", 16000, "orange", "2.jpg"));
		list.add(new ShopDto("옷3", 17000, "yellow", "3.jpg"));
		list.add(new ShopDto("옷4", 18000, "green", "4.jpg"));
		list.add(new ShopDto("옷5", 19000, "blue", "5.jpg"));
		list.add(new ShopDto("옷6", 20000, "navy", "6.jpg"));
		list.add(new ShopDto("옷7", 21000, "purple", "7.jpg"));
	}

	public List<ShopDto> getSangpumList(){
		return list;
	}


}
