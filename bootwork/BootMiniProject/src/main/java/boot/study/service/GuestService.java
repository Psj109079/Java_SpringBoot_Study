package boot.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.study.dto.GuestDto;
import boot.study.dto.GuestPhotoDto;
import boot.study.mapper.GuestMapper;

@Service
public class GuestService implements GuestServiceInter{

	@Autowired
	GuestMapper guestMapper;
	
	@Override
	public void insertGuset(GuestDto dto) {
		guestMapper.insertGuset(dto);
	}

	@Override
	public void insertPhoto(GuestPhotoDto dto) {
		guestMapper.insertPhoto(dto);
	}

	@Override
	public List<GuestDto> getAllGuest() {
		return guestMapper.getAllGuest();
	}

	@Override
	public List<GuestPhotoDto> getPhotos(int guest_idx) {
		return guestMapper.getPhotos(guest_idx);
	}
	
}
