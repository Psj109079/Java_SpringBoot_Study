package study.day0308;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

class MyHome extends JFrame implements WindowListener{
	
	public MyHome(String title) {
		super(title);
		this.setBounds(700, 100, 300, 300); // x, y, w, h
		// 프레임 색 변경
//		this.getContentPane().setBackground(Color.GREEN); // Color 의 static 상수들을 이용해서 색상변경
		this.getContentPane().setBackground(new Color(234, 123, 190));
		// 윈도우 이벤트를 발생하려면
		this.addWindowListener(this);
		this.setVisible(true); // 프레임 보이게 하기
		
	}

	// WindowListener 라는 인터페이스가 가진 추상 메소드들, 무조건 모두 오버라이드 해야한다 
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("윈도우를 종료합니다");
		System.exit(0); // 0: 정상 종료시
	}
	@Override
	public void windowClosed(WindowEvent e) {
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
	
	
}
public class Ex9Window {
	public static void main(String[] args) {
		MyHome my = new MyHome("BitCamp"); // 생성자 호출
	}

}
