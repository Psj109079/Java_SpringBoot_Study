package study.day0309;

import java.io.File;

public class Ex10File {
	
	static final String FILENAME1 = "d:/bit701naver/memo.txt";
	static final String FILENAME2 = "d:/bit701naver/score.txt";
	static final String DIR = "d:/bit701naver";
	
	public static void main(String[] args) {
		// File 객체 공부하기
		File file1 = new File(FILENAME1);
		File file2 = new File(FILENAME2);
		File file3 = new File(DIR);
		
		System.out.println("file1의 크기: " + file1.length() + "바이트");
		System.out.println("file2의 크기: " + file2.length() + "바이트");
		
		System.out.println("file1 은 파일인가요? " + file1.isFile());
		System.out.println("file1 은 디렉토리인가요? " + file1.isDirectory());
		
		System.out.println("file3 은 파일인가요? " + file3.isFile());
		System.out.println("file3 은 디렉토리인가요? " + file3.isDirectory());
		// isFile = 파일인지 확인 파일이라면 true 아니면 false
		// isDirectory = 폴더인지 확인 폴더면 true 아니면 flase
		
		if(file3.isDirectory()) {
			String[] list = file3.list();
			for(String a : list) {
				System.out.println(a);
			}
		}
		System.out.println(file1.getAbsolutePath()); // 경로포함 파일명
		System.out.println(file1.getName()); // 파일명만
		System.out.println(file1.exists()); // file1이 실제 존재하는가
		
		// 파일 삭제
		file1.delete(); // memo.txt삭제
	}

}
