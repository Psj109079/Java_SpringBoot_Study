package data.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.InfoDto;
import data.mapper.InfoMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InfoService implements InfoServiceInter {
	
	private InfoMapper infoMapper;
	
	@Override
	public void insertInfo(InfoDto dto) {
		infoMapper.insertInfo(dto);
	}

	@Override
	public void updatePhoto(int num, String photo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("num", num);
		map.put("photo", photo);
		infoMapper.updatePhoto(map);
	}

	@Override
	public List<InfoDto> list() {
		return infoMapper.list();
	}

	@Override
	public void deleteInfo(int num) {
		infoMapper.deleteInfo(num);
	}

	@Override
	public InfoDto getData(int num) {
		return infoMapper.getData(num);
	}

	@Override
	public void updateData(InfoDto dto) {
		infoMapper.updateData(dto);
	}
}
