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

	@Override
	public void deletePhoto(int photo_idx) {
		guestMapper.deletePhoto(photo_idx);
	}

	@Override
	public void deleteAllPhoto(int guest_idx) {
		guestMapper.deleteAllPhoto(guest_idx); // on delete cascade 설정시 필요없음
	}

	@Override
	public void deleteGuest(int guest_idx) {
		guestMapper.deleteGuest(guest_idx);
	}

	@Override
	public String getSelectPhoto(int photo_idx) {
		return guestMapper.getSelectPhoto(photo_idx);
	}

	@Override
	public List<String> getAllPhoto(int guest_idx) {
		return guestMapper.getAllPhoto(guest_idx);
	}
	
	
	
}
