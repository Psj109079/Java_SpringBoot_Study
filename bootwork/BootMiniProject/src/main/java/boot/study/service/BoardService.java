package boot.study.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.study.dto.BoardDto;
import boot.study.mapper.BoardMapper;

@Service
public class BoardService implements BoardServiceInter{
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public int getMaxNum() {
		return boardMapper.getMaxNum();
	}

	@Override
	public int getTotalCount() {
		return boardMapper.getTotalCount();
	}

	@Override
	public void updateStep(int ref, int step) {
		Map<String, Integer> map = new HashMap<>();
		map.put("ref", ref);
		map.put("step", step);
		
		boardMapper.updateStep(map);
 	}

	@Override
	public void insertBoard(BoardDto dto) {
		// 새글인지 답글인지 판단
		int ref = dto.getRef(); // 그룹번호
		int step = dto.getStep();
		int depth = dto.getDepth();
		
		if(dto.getNum() == 0) {
			// 새글인경우
			step = 0;
			depth = 0;
			ref = boardMapper.getMaxNum() + 1; // 새 그룹번호를 겹치지 않는 값으로 만들기 위해서
		} else {
			// 답글인경우
			// 전달받은 그룹(ref)중 step보다 큰 값이 있는경우 모두 +1
			this.updateStep(ref, step);
			// 전달받은 step과 depth에 1 증가
			step++;
			depth++;
		}
		dto.setRef(ref);
		dto.setStep(step);
		dto.setDepth(depth);
		
		boardMapper.insertBoard(dto);
	}

	@Override
	public List<BoardDto> getPagingList(int start, int perpage) {
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("perpage", perpage);
		return boardMapper.getPagingList(map);
	}

	@Override
	public void updateReadcount(int num) {
		boardMapper.updateReadcount(num);
	}

	@Override
	public BoardDto getData(int num) {
		return boardMapper.getData(num);
	}

	@Override
	public boolean isEqualPass(int num, String pass) {
		Map<String, Object> map = new HashMap<>();
		map.put("num", num);
		map.put("pass", pass);
		// 비번이 맞으면 1 -> true반환, 틀리면 0 -> false반환
		boolean b = boardMapper.isEqualPass(map) == 0 ? false : true;
		return b;
	}

	@Override
	public void deleteBoard(int num) {
		boardMapper.deleteBoard(num);
	}

	@Override
	public void updateBoard(BoardDto dto) {
		boardMapper.updateBoard(dto);
	}
	
	
}
