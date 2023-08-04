package data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.dto.TestDto;

@Mapper
public interface TestMapper {
	public void testInsert(TestDto dto);
	public List<TestDto> getAllDatas();
	public void testDelete(int num);
}
