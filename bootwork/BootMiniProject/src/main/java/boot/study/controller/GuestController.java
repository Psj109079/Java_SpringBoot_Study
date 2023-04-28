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
}
