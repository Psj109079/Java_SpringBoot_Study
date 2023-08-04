package data.service;

import java.util.List;


import data.dto.InfoDto;

public interface InfoServiceInter {
	public void insertInfo(InfoDto dto);
	public void updatePhoto(int num, String photo);
	public List<InfoDto> list();
	public void deleteInfo(int num);
	public InfoDto getData(int num);
	public void updateData(InfoDto dto);
}
