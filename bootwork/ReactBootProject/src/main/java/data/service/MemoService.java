package data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.MemoDto;
import data.mapper.MemoMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemoService implements MemoServiceInter {
	
	private MemoMapper mm;
	
	@Override
	public void insertMemo(MemoDto dto) {
		mm.insertMemo(dto);
	}

	@Override
	public List<MemoDto> getAllMemos(String search) {
		return mm.getAllMemos(search);
	}

	@Override
	public void updateMemo(MemoDto dto) {
		mm.updateMemo(dto);
	}

	@Override
	public void deleteMemo(int num) {
		mm.deleteMemo(num);
	}
}
