package mycar.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import mycar.data.MyCarDao;
import mycar.data.MyCarDto;

@Controller
public class MyCarController {
		
	@Autowired
	MyCarDao mycarDao;
	
	@GetMapping("/mycarform")
	public String form() {
		return "mycarform";
		
	}
	
	@GetMapping("/")
	public String home(Model model) {
		
		// 총갯수
		Long totalCount = mycarDao.getTotalCount();
		
		List<MyCarDto> list = mycarDao.getAllCars();
		
		model.addAttribute("list", list);
		model.addAttribute("totalCount", totalCount);
		return "mycarlist";
	}
	
	@PostMapping("/addcar")
	public String insert(MyCarDto dto, MultipartFile upload, HttpServletRequest request) {
		
		// 업로드 할 경로 구하기
		String  realPath = request.getSession().getServletContext().getRealPath("/save");
		// 파일명 dto에 저장
		dto.setCarphoto(upload.getOriginalFilename());
		
		// 파일 업로드
		try {
			upload.transferTo(new File(realPath + "/" + upload.getOriginalFilename()));
			// db insert
			mycarDao.insertCar(dto);
		} catch(IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, Long num) {
		MyCarDto dto = mycarDao.getMyCar(num);
		model.addAttribute("dto", dto);
		return "detailcar";
	}
	
	@GetMapping("/updatecar")
	public String update(Model model, Long num) {
		MyCarDto dto = mycarDao.getMyCar(num);
		
		model.addAttribute("dto", dto);
		return "updateform";
	}
	
	@PostMapping("/update")
	public String update(MyCarDto dto, MultipartFile upload, HttpServletRequest request) {
		
		// 업로드 할 경로 구하기
		String  realPath = request.getSession().getServletContext().getRealPath("/save");
		// 파일명 dto에 저장
		if(upload.getOriginalFilename().equals("")) {
			// 기존이름으로 넣는다
			String photo = mycarDao.getMyCar(dto.getNum()).getCarphoto();
			dto.setCarphoto(photo);
		} else {
			dto.setCarphoto(upload.getOriginalFilename());
			
			// 파일 업로드
			try {
				upload.transferTo(new File(realPath + "/" + upload.getOriginalFilename()));
			} catch(IllegalStateException | IOException e) {
				e.printStackTrace();
			}			
		}
		// db insert
		mycarDao.updateCar(dto);
		
		return "redirect:detail?num=" + dto.getNum();
	}
	
	@GetMapping("deletecar")
	public String delete(Long num) {
		mycarDao.deleteCar(num);
		return "redirect:/";
	}
	
	@GetMapping("/ajaxlist")
	public String list() {
		return "ajaxlist";
	}
} 
