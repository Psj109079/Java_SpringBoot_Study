package data.service;

import java.util.List;

import data.dto.FoodDto;

public interface FoodServiceInter {
	public void insertFood(FoodDto dto);
	public List<FoodDto> getAllData();
	public FoodDto getData(int num);
	public void updatePhoto(String fphoto, int num);
	public void formFromUpdate(FoodDto dto);
	public void updateInfo(FoodDto dto);
	public void deleteBook(int num);
}
