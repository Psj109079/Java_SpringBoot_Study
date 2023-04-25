package boot.study.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import boot.study.dto.BoardDto;

@Mapper
public interface BoardMapper {
	public int getMaxNum();
	
	public int getTotalCount();
	
	public void updateStep(Map<String, Integer> map); // ref, step
	
	public void insertBoard(BoardDto dto);
	
	public List<BoardDto> getPagingList(Map<String, Integer> map); // map: start, perpage
	
	public void updateReadcount(int num);
	
	public BoardDto getData(int num);
}
