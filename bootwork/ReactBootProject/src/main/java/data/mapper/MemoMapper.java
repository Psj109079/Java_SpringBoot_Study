package data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.dto.MemoDto;

@Mapper
public interface MemoMapper {
	public void insertMemo(MemoDto dto);
	public List<MemoDto> getAllMemos(String search);
	public void updateMemo(MemoDto dto);
	public void deleteMemo(int num);

}
