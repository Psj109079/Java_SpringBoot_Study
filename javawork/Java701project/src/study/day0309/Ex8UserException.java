package study.day0309;

import java.util.Scanner;

class UserException extends Exception {
	
	public UserException(String message) {
		super(message);
	}
}
public class Ex8UserException {
	
	public static void inputName() throws UserException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		
		// 김태희 또는 송혜교 입력시 강제 예외 발생
		if(name.equals("김태희") || name.equals("송혜교")) {
			throw new UserException("잘못된 이름입니다"); // 강제로 예외발생
		} else {
			System.out.println("내 이름은 " + name);
		}
	}
	public static void main(String[] args) {
		try {
			inputName();
		} catch (UserException e) {
			e.printStackTrace();
		}
		
	}

}
