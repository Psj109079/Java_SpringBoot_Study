package data.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.FoodDto;
import data.mapper.FoodMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FoodService implements FoodServiceInter {
	
	private FoodMapper fm;
	
	@Override
	public void insertFood(FoodDto dto) {
		fm.insertFood(dto);
	}

	@Override
	public List<FoodDto> getAllData() {
		return fm.getAllData();
	}

	@Override
	public FoodDto getData(int num) {
		return fm.getData(num);
	}

	@Override
	public void updatePhoto(String fphoto, int num) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("fphoto",fphoto);
		map.put("num",num);
		fm.updatePhoto(map);	
	}
	
	@Override
	public void formFromUpdate(FoodDto dto) {
		fm.formFromUpdate(dto);
	}
	

	@Override
	public void updateInfo(FoodDto dto) {
		fm.updateInfo(dto);
	}

	@Override
	public void deleteBook(int num) {
		fm.deleteBook(num);
	}


	
	
	
	
	
	
	
}
