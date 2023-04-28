package boot.study.service;

import java.util.List;

import boot.study.dto.GuestDto;
import boot.study.dto.GuestPhotoDto;

public interface GuestServiceInter {
	public void insertGuset(GuestDto dto);
	
	public void insertPhoto(GuestPhotoDto dto);
	
	public List<GuestDto> getAllGuest();
	
	public List<GuestPhotoDto> getPhotos(int guest_idx);
}
