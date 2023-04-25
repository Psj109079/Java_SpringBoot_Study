package boot.study.service;

import java.util.List;

import boot.study.dto.BoardDto;

public interface BoardServiceInter {
	public int getMaxNum();
	
	public int getTotalCount();
	
	public void updateStep(int ref, int step); // ref, step
	
	public void insertBoard(BoardDto dto);
	
	public List<BoardDto> getPagingList(int start, int perpage); // map: start, perpage
	
	public void updateReadcount(int num);
	
	public BoardDto getData(int num);
}
