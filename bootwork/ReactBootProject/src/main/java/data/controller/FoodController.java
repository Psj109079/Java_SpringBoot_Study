package data.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.FoodDto;
import data.service.FoodService;
import naver.cloud.NcpObjectStorageService;

@RestController
@CrossOrigin
@RequestMapping("/react")
public class FoodController {
	
	@Autowired
	private FoodService fs;
	
	@Autowired
	private NcpObjectStorageService storageService;
	
	//버켓 이름 지정
	private String bucketName = "bit701-bucket-106"; // 각자 자기 버켓 이름
	
	// 여러장의 사진명이 저장될 List 변수
	List<String> foodNames = new ArrayList<>();
	
	
	@PostMapping("/upload")
	public List<String> photoUpload(@RequestParam List<MultipartFile> upload) {
		
		// 기존 버킷의 사진 지우기
		if(foodNames.size() > 0) {
			for(String photo : foodNames) {
				storageService.deleteFile(bucketName, "food", photo);
			}
			foodNames.clear();
		}
		
		// 버킷에 여러장의 사진 저장
		for(MultipartFile file : upload) {
			String uploadName = storageService.uploadFile(bucketName, "food", file);
			foodNames.add(uploadName);
		}
		return foodNames;
	}
	
	@PostMapping("/insert")
	public void insert(@RequestBody FoodDto dto) {
		// 사진은 따로 저장
		String photo = "";
		for(String fname: foodNames) {
			photo += fname + ",";
		}
		
		// 마지막 컴마 제거
		photo = photo.substring(0,photo.length() - 1);
		// dto에 저장
		dto.setFphoto(photo);
		// db insert
		fs.insertFood(dto);
		
		// 스토리지에 저장된 사진변수 비워주기
		foodNames.clear();
	}
	
	@PostMapping("/getdata")
	public List<FoodDto> getList() {
		return fs.getAllData();
	}
	
	@GetMapping("/detail")
	public FoodDto detail(int num) {
		System.out.println("detail >> " + num);
		return fs.getData(num);
	}
	
	//스토리지 사진 지우는 메서드
	public void deleteStorage(int num) {
		// num 에 해당하는 포토명들
		String photos = fs.getData(num).getFphoto();
		// , 로 분리
		String[] arrPhoto = photos.split(",");
		// 스토리지에서 해당 사진 삭제
		for(String p : arrPhoto) {
			storageService.deleteFile(bucketName, "food", p);
		}
	}
	
	@GetMapping("/updatephoto")
	public void updatePhoto(int num) {
		// 기존 사진 지우기
		deleteStorage(num);
		
		// 사진은 따로 저장
		String photo = "";
		for(String fname: foodNames) {
			photo += fname + ",";
		}
		
		// 마지막 컴마 제거
		photo = photo.substring(0,photo.length() - 1);
		fs.updatePhoto(photo, num);
		foodNames.clear();
	}
	
	@PostMapping("/formtoupdate")
	public String formFromupdate(@RequestBody FoodDto dto) {
//		// 기존 사진 지우기
//		deleteStorage(dto.getNum());
//		// 사진은 따로 저장
//		String photo = "";
//		for(String fname: foodNames) {
//			photo += fname + ",";
//		}	
//		// 마지막 컴마 제거
//		photo = photo.substring(0,photo.length() - 1);
//		// dto에 저장
//		dto.setFphoto(photo);
//		// db insert
//		fs.formFromUpdate(dto);
//		
//		// 스토리지에 저장된 사진변수 비워주기
		System.out.println(dto);
//		foodNames.clear();
		return "update";
		
	}
	
	@PostMapping("/update")
	public void updateInfo(@RequestBody FoodDto dto) {
		
		System.out.println("update >> " + dto);
		fs.updateInfo(dto);
	}
	
	@GetMapping("/delete") 
	public void deleteBook(int num) {
		fs.deleteBook(num);
	}
}
