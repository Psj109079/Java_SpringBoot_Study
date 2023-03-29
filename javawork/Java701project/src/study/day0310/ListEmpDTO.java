package study.day0310;
//[문제]-파일입출력,컬렉션 
//EmpDto
//  이름,부서,나이,핸드폰
//
//**  메뉴 **
//1. 사원추가
//2. 사원검색 - 이름,부서,나이,핸드폰 모두 출력
//3. 사원삭제
//4. 부서명 검색 - 부서별로 출력
//5. 전체출력
//6. 종료

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEmpDTO {
	static final String FILENAME = "D:/bit701naver/employee.txt";
	
	List<EmpDTO> emp = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	// 생성자 호출 시 바로 파일 불러옴
	public ListEmpDTO() {
		fileRead();
	}
	
	// 파일 불러오기
	public void fileRead() {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			while(true) {
				String read = br.readLine();
				if(read == null || read.length() == 0) {
					break;
				}
				String[] spl = read.split(",");
				EmpDTO dto = new EmpDTO(spl[0], spl[1], Integer.parseInt(spl[2].trim()), spl[3]);
				
				emp.add(dto);
				
			}
			System.out.println("총 " + emp.size() + "개의 사원정보가 있습니다");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다");
//			e.printStackTrace();
		} catch (IOException e) {
//			e.printStackTrace();
		} finally {
			try {
				if(br != null) {br.close();}
				if(fr != null) {fr.close();}
			} catch(IOException e) {}
		}
	}
	// 파일 저장
	public void fileWrite() {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(FILENAME);
			
			for(EmpDTO dto : emp) {
				fw.write(dto.getName() + "," + dto.getPart() + "," + dto.getAge() + "," + dto.getHp() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
	}
	// 사원 추가
	public void addEmp() {
		System.out.println("이름 입력");
		String name = sc.nextLine();
		System.out.println("부서 입력");
		String part = sc.nextLine();
		System.out.println("나이 입력");
		int age = 0;
		try {
			age = Integer.parseInt(sc.nextLine());		
		} catch(NumberFormatException e) {
			System.out.println("잘못된 입력 나이 = 0");
			age = 0;
		}
		System.out.println("번호 입력");
		String hp = sc.nextLine();
		
		EmpDTO dto = new EmpDTO(name, part, age, hp);
		emp.add(dto);
		
	}
	// 사원 검색
	public void empSearch() {
		System.out.println("이름 입력");
		String name = sc.nextLine();
		boolean flag = false;
		
		for(int i = emp.size() - 1; i >= 0; i--) {
			if(emp.get(i).getName().contains(name)) {
				flag = true;
				System.out.println(emp.get(i).getName() + ", " + emp.get(i).getPart() + ", " + emp.get(i).getAge() + ", " + emp.get(i).getHp());
			}
		}
		if(flag == false) {
			System.out.println("이름에 " + name + "이(가) 포함되는 사원은 없습니다");
		}
	}
	// 사원 삭제
	public void empDelete() {
		System.out.println("이름 입력");
		String name = sc.nextLine();
		boolean flag = false;
		
		for(int i = emp.size() - 1; i >= 0; i--) {
			if(emp.get(i).getName().equals(name)) {
				flag = true;
				System.out.println(emp.get(i).getName() + ", " + emp.get(i).getPart() + ", " + emp.get(i).getAge() + ", " + emp.get(i).getHp() + " 삭제되었습니다");
				emp.remove(i);
			}
		}
		if(flag == false) {
			System.out.println(name + " 사원이 존재하지 않습니다");
		} 
	}
	// 부서 검색
	public void partSearch() {
		System.out.println("부서 입력");
		String part = sc.nextLine();
		boolean flag = false;
		
		for(int i = 0; i < emp.size(); i++) {
			if(emp.get(i).getPart().equals(part)) {
				System.out.println(emp.get(i).getName() + ", " + emp.get(i).getPart() + ", " + emp.get(i).getAge() + ", " + emp.get(i).getHp());
				flag = true;
			}
		}
		if(flag == false) {
			System.out.println(part + " 부서는 없습니다");
		}

		
	}
	// 전체 출력
	public void totalView() {
		System.out.println("이름\t부서\t나이\t핸드폰");
		System.out.println("=".repeat(30));
		
		for(EmpDTO dto : emp) {
			System.out.println(dto.getName() + "\t" + dto.getPart() + "\t" + dto.getAge() + "\t" + dto.getHp());
		}
	}
	
	
	// 선택
	public int select() {
		System.out.println("1. 사원추가 2. 사원검색 3. 사원삭제 4. 부서명 검색 5. 전체출력 6.종료");
		int sel = 0;
		try {
			sel = Integer.parseInt(sc.nextLine());			
		} catch(NumberFormatException e) {
			sel = 5;
		}
		return sel;
	}
			
	public static void main(String[] args) {
		ListEmpDTO emp = new ListEmpDTO();
		while(true) {
			switch (emp.select()) {
			case 1:
				emp.addEmp();;
				break;
			case 2:
				emp.empSearch();
				break;
			case 3:
				emp.empDelete();
				break;
			case 4:
				emp.partSearch();
				break;
			case 5:
				emp.totalView();
				break;

			default:
				System.out.println("저장 후 종료");
				emp.fileWrite();
				System.exit(0);
			}
		}
	}
}
