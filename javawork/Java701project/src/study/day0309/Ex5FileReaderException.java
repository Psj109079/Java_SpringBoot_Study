package study.day0309;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex5FileReaderException {
	
//	static final String FILENAME = "d:/bit701naver/member1.txt";
	static final String FILENAME = "d:\\bit701naver\\member2.txt";
//	/ 를 \\ 로 바꿀 수 있음 \를 한번 쓰게되면 제어문자열로 인식해서 두번 써줘야 함(\\)
	
	public static void memberRead() {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME);
			System.out.println("파일 존재함!");
			
			// 한줄단위로 파일에서 읽기 위해서 BufferedReader로 변환
			br = new BufferedReader(fr);
			while(true) {
				String name = br.readLine();
				if(name == null || name.length() == 0) {
					break;
				}
				String addr = br.readLine();
				String hp = br.readLine();
				System.out.println("이름: " + name + ", 주소: " + addr + ", 핸드폰: " + hp);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없어요: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 파일이 없을 경우 br이 생성되기전에 catch로 가면서 br이 NullPointerException 이 발생 
//			try {
//				System.out.println("자원들 모두 닫힘");
//				br.close();
//				fr.close();
//			} catch (IOException | NullPointerException e) {
//				e.printStackTrace();
//			}
			
			// 방법2
			try {
				if(br != null) {br.close();}
				if(fr != null) {fr.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		memberRead();
		System.out.println("** 정상 종료 **");
	}
}
