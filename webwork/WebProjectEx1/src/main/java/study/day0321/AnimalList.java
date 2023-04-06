package study.day0321;

import java.util.List;
import java.util.Vector;

public class AnimalList {
	
	private List<AnimalDto> list=new Vector<>();
	
	public AnimalList() {
		// TODO Auto-generated constructor stub
		list.add(new AnimalDto("영식이",23, "C1"));
		list.add(new AnimalDto("춘식이",20, "C3"));
		
		AnimalDto dto1=new AnimalDto();
		dto1.setAnimalName("순자");
		dto1.setAnimalAge(19);
		dto1.setAnimalPhoto("C5");
		list.add(dto1);
		
		list.add(new AnimalDto("검순이",32, "C8"));
		list.add(new AnimalDto("볼뚱이",15, "C2"));		
	}
	
	public List<AnimalDto> getAllAnimals()
	{
		return list;
	}

}
