package data.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.dto.InfoDto;

@Mapper
public interface InfoMapper {
	public void insertInfo(InfoDto dto);
	public void updatePhoto(HashMap<String, Object> map);
	public List<InfoDto> list();
	public void deleteInfo(int num);
	public InfoDto getData(int num);
	public void updateData(InfoDto dto);
}
