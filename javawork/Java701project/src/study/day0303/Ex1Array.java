package study.day0303;

public class Ex1Array {
	public static void main(String[] args) {
		char[] ch ;// 배열 선언, 메모리 할당이 안되있어서 이 상태로는 데이터 저장 불가
		ch = new char[4]; // 메모리 할당이 가능함
		// 할당된 배열에 데이터 넣기
		ch[0] = 'A';
		ch[1] = 'J';
		ch[2] = 'N';
		ch[3] = 'L';
		
		// 출력 #1
		for(int i = 0; i < ch.length; i++) {
			System.out.println(ch[i] + " : " + (int)ch[i]) ;
		}
		System.out.println("=".repeat(20));
		
		//출력 #2
		// ch 에 있는 변수값이 자동으로 a변수에 넘어감
		for(char a : ch) {
			System.out.println(a + " : " + (int)a);
		}
		
	}

}
