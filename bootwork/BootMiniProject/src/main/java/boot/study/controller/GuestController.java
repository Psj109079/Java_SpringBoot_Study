package boot.study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import boot.study.dto.GuestDto;
import boot.study.dto.GuestPhotoDto;
import boot.study.service.GuestService;
import naver.cloud.NcpObjectStorageService;

@Controller
@RequestMapping("/guest")
public class GuestController {
	
	@Autowired
	GuestService guestService;
	
	@Autowired
	private NcpObjectStorageService storageService;
	
	// 버켓이름지정
	//private String bucketName = "bit701-bucket-106"; // 각자 클라우드 버킷이름
	private String bucketName="bit701-bucket-106";
	
	List<String> photoNames = new ArrayList<>();
	
	@GetMapping("/list")
	public String list() {
		return "/sub/guest/guestlist";
	}
	
	@PostMapping("/upload")
	@ResponseBody
	public void upload(List<MultipartFile> upload) {
		System.out.println("size: " + upload.size());
		System.out.println("filename 0: " + upload.get(0).getOriginalFilename());
		
		photoNames.clear();
		for(MultipartFile file : upload) {
			// 스토리지에 업로드
			String photoname = storageService.uploadFile(bucketName, "guest", file);
			System.out.println("name: " + photoname);
			// 업로드한 파일명을 db에 저장
			photoNames.add(photoname);
		}
	}
	
//	@PostMapping("/insert")
//	@ResponseBody
//	public void  insertGuest(GuestDto dto) {
//		
//		// 방명록 데이터부터 db에 저장
//		guestService.insertGuset(dto);
//		System.out.println("guest_idx: " + dto.getGuest_idx());
//		
//		// 업로드한 사진이 있는 경우
//		for(String photoname : photoNames) {
//			// 업로드한 파일명을 db에 저장
//			GuestPhotoDto pdto = new GuestPhotoDto();
//			pdto.setGuest_idx(dto.getGuest_idx());
//			pdto.setPhotoname(photoname);
//			guestService.insertPhoto(pdto);
//		}
//	}
	
	// insert 할때 파일도 업로드 하기
	@PostMapping("/insert")
	@ResponseBody
	public void insertGuest(GuestDto dto, List<MultipartFile> upload) {
		System.out.println("content: " + dto.getContent());
		
		// 방명록 데이터부터 db에 저장
		guestService.insertGuset(dto);
		System.out.println("guest_idx: " + dto.getGuest_idx());
		
		if(upload != null) {
			System.out.println("size: " + upload.size());
			System.out.println("upload.get(0).getOriginalFilename(): " + upload.get(0).getOriginalFilename());
			for(MultipartFile file : upload) {
				// 스토리지에 업로드하기
				String photoname = storageService.uploadFile(bucketName, "guest", file);
				// 업로드한 파일명을 db에 저장
				GuestPhotoDto pdto = new GuestPhotoDto();
				pdto.setGuest_idx(dto.getGuest_idx());
				pdto.setPhotoname(photoname);
				guestService.insertPhoto(pdto);
			}
		}
	}
	
	@GetMapping("/alist")
	@ResponseBody
	public List<GuestDto> alist() {
		List<GuestDto> list = guestService.getAllGuest();
		// 각 방명록글에 등록한 사진들을 가져온다.
		for(GuestDto dto : list) {
			int gidx = dto.getGuest_idx();
			List<GuestPhotoDto> plist = guestService.getPhotos(gidx);
			dto.setPhotoList(plist);
		}
		return list;
	}
	
	// 사진 한장 (x 아이콘 클릭시 호출)
	@GetMapping("/deletephoto")
	@ResponseBody
	public void deletePhoto(int photo_idx) {
		// db의 데이터 삭제 전 스토리지의 사진부터 삭제하기
		
		// photo_idx 에 해당하는 파일명 얻기
		String photoname = guestService.getSelectPhoto(photo_idx);
		
		// 스토리지에서 사진 삭제
		storageService.deleteFile(bucketName, "guest", photoname);
		
		// db 삭제
		guestService.deletePhoto(photo_idx);
	}
	
	// 방명록 글 삭제
	@GetMapping("/delete")
	@ResponseBody
	public void delete(int guest_idx) {
		// 방명록 삭제 전 그 글에 연결된 모든 사진부터 스토리지에서 삭제하기
		List<String> list = guestService.getAllPhoto(guest_idx);
		for(String photoname : list) {
			storageService.deleteFile(bucketName, "guest", photoname);
		}
		// db에서 글 삭제
		// on delete cascade 설정 시 외부키로 연결된 데이터들은 자동으로 삭제된다
		// 설정을 안했을경우 자식 테이블부터 먼저 삭제 후 부모테이블을 삭제함
		guestService.deleteGuest(guest_idx);
	}
	
}
