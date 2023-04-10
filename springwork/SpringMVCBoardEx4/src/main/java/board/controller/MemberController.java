package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import board.dao.MemberDao;
import board.dto.MemberDto;

@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	
	
	@GetMapping("/member/form")
	public String form(Model model) {
		
		// ���Ե� �� �ο����� �� ���� ����ϱ� ���� ���� ��´�
		int totalCount = memberDao.getTotalCount();
		// request �� ����
		model.addAttribute("totalCount", totalCount);
		
		return "member/form";
	}
	
	@PostMapping("/member/addmember")
	public String insertmember(@ModelAttribute MemberDto dto, @RequestParam MultipartFile upload, HttpServletRequest request) {
		// ���ε��� ���� ��� ���ϱ�
		String realFolder = request.getSession().getServletContext().getRealPath("/resources/photo");
		System.out.println(request.getSession());
		System.out.println(request.getSession().getServletContext());
		System.out.println(realFolder);
		// ���� ���ε�
		String photo = upload.getOriginalFilename();
		
		try {
			upload.transferTo(new File(realFolder + "/" + photo));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		dto.setPhoto(photo);
		// insert
		memberDao.insertMember(dto);
		// ȸ������ ���� �� ��� ������� �̵�
		return "redirect:list";
	}
	
	
	@GetMapping("/member/list")
	public String listMember(Model model, HttpSession session) {
		int totalCount = memberDao.getTotalCount();
		List<MemberDto> list = memberDao.getAllMembers();
		String loginEmail = (String) session.getAttribute("loginemail");
		
		model.addAttribute("loginEmail", loginEmail);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "member/list";		
	}
	
	@GetMapping("/member/delete")
	public String delete(@RequestParam int num) {
		memberDao.deleteMember(num);
		return "redirect:list";
	}
	// redirect:list = mapping �Ǿ��ִ� �ش� �޼ҵ�� ��
	// return member/list = �ش� jsp�� ��
	
	// json ���� ��ȯ�ϴ� �޼���
	// @Controller �� ���� json ��ȯ�ΰ�� @ResponseBody �� ����
	// @RestController �� ��� ������ json ���� ó���ǹǷ� @ResponseBody �� �Ⱥ���
	@GetMapping("/member/isemail")
	public @ResponseBody Map<String, String> emailProcess(@RequestParam String email) {
		// �ش� �̸����� �����ϸ� 1, �������� ������ 0
		int count = memberDao.isEqualEmail(email);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", count == 0 ? "success" : "fail");
		return map;
	}
	
	@GetMapping("/member/updateform")
	public String update(@RequestParam int num, Model model) {
		
		MemberDto dto = memberDao.selectOneOfNum(num);
		
		model.addAttribute("dto", dto);
		return "member/update";
	}
	
	@PostMapping("/member/updateMember")
	public String updateMember(@ModelAttribute MemberDto dto, @RequestParam MultipartFile upload, HttpServletRequest request, HttpSession session) {
		
		// ���ε��� ���� ��� ���ϱ�
		String realFolder = request.getSession().getServletContext().getRealPath("/resources/photo");
		System.out.println(request.getSession());
		System.out.println(request.getSession().getServletContext());
		System.out.println(realFolder);
		// ���� ���ε�
		String photo = upload.getOriginalFilename();
			
		try {
			upload.transferTo(new File(realFolder + "/" + photo));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		dto.setPhoto(photo);
		session.removeAttribute("loginok");
		session.removeAttribute("loginemail");
		memberDao.updateOfMember(dto);
				
		return "redirect:list";
	}
}
