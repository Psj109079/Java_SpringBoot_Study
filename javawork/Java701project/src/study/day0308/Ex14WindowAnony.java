package study.day0308;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class MyFrame extends JFrame {

	public MyFrame(String title) {
		super(title);

		this.setBounds(800, 200, 400, 400);
		this.getContentPane().setBackground(new Color(161, 250, 79));

		// 기본 레이아웃 없애기
		this.setLayout(null);
		
		// 버튼 생성 후 이벤트 주기
		JButton btn1 = new JButton("BitCamp");
		
		// 버튼의 위치
		btn1.setBounds(100, 100, 100, 30);
		
		// 프레임에 추가하기
		this.add(btn1);
		
		// 버튼 이벤트 - 기능을 익명 내부클래스 형태로 구현한 경우
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MyFrame.this, "버튼을 클릭했어요!");
			}
		});

		this.setVisible(true);

		// 윈도우 종료 이벤트- Ex9번의 인터페이스말고 익명 내부클래스 형태로 구현
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("종료합니다");
				System.exit(0);
			}
		});
	}
}

public class Ex14WindowAnony {
	public static void main(String[] args) {
		MyFrame my = new MyFrame("Anony");

	}
}
