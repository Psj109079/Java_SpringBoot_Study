package data.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.dto.TestDto;
import data.mapper.TestMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin
@Api(value = "TestController v1")
public class TestController {
	
	private TestMapper testMapper;
	
	@PostMapping("/test/insert")
	public String insert(@RequestBody TestDto dto) { // json 데이터가 dto로 자동 변환
		System.out.println("react>> " + dto);
		testMapper.testInsert(dto);
		return "success";
	}
	
	@GetMapping("/test/list")
	public List<TestDto> list() {
		System.out.println("react >> list");
		return testMapper.getAllDatas();
	}
	
//	@ApiOperation(value = "3", notes = "삭제할 num 값")
//	@DeleteMapping("/test/delete")
//	public String delete(@RequestParam int num) {
//		System.out.println("delete>>" + num);
//		testMapper.testDelete(num);
//		return "success";
//	}
	
	@DeleteMapping("/test/delete/{num}")
	public String delete(@PathVariable int num) { // 리터럴로 문자를 받아오는 경우
		System.out.println("delete>>" + num);
		testMapper.testDelete(num);
		return "success";
	}
	
	
}
