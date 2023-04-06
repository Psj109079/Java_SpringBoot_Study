package study.day0321;

import java.util.ArrayList;
import java.util.List;

public class ShopList {
	private List<ShopDto> list=new ArrayList<>();
	
	public ShopList() {
		// TODO Auto-generated constructor stub
		list.add(new ShopDto("화이트원피스",23500, "white", "2"));
		list.add(new ShopDto("플렛단화",19000, "pink", "14"));
		list.add(new ShopDto("구찌스카프",150000, "red", "10"));
		list.add(new ShopDto("머리장식품",11000, "purple", "30"));
		list.add(new ShopDto("자켓",127000, "yellow", "31"));
		
	}
	
	public List<ShopDto> getSangpumList()
	{
		return list;
	}
}	
