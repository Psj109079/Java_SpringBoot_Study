package study.day0313;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex4ButtonArray extends JFrame implements ActionListener{
	
	JButton[] btn = new JButton[5];
	String[] btnTitle = {"빨강", "초록", "파랑", "분홍", "오렌지"};
	Color[] bgColors = {Color.red, Color.green, Color.blue, Color.pink, Color.orange};
	
	
	public Ex4ButtonArray(String title) {
		super(title);
		
		// 단순히 윈도우만 종료하고 싶을때는 메서드를 통해서 종료하면 된다
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 컴포넌트 생성 및 이벤트 설정하기 위한 메서드
		this.initDesign();
		
		this.getContentPane().setBackground(new Color(200, 200, 200));
		this.setBounds(900, 100, 300, 300); // x, y, w, h
		this.setVisible(true);
	}
	
	private void initDesign() {
		this.setLayout(null); // 기본 레이아웃인 BorderLayout을 없앰
		int yPos = 5;
		for(int i = 0; i < btn.length; i++) {
			
			// 생성
			btn[i] = new JButton(btnTitle[i]);
			// 버튼의 글자색을 color 변수색으로 변경
			btn[i].setBackground(bgColors[i]);
			// 위치및 크기 설정
			btn[i].setBounds(0, yPos, 100, 40);
			yPos += 50;
			// 프레임에 추가
			this.add(btn[i]);
			
			// 각 버튼에 이벤트 추가
			btn[i].addActionListener(this);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource(); // 이벤트가 발생한 오브젝트를 얻는다
		
		// 어차피 다 버튼이라면 다운캐스팅을 통해서 JButton으로 선언
		JButton b = (JButton)e.getSource();
		for(int i = 0; i <btn.length; i++) {
			if(b == btn[i]) {
				this.getContentPane().setBackground(bgColors[i]);
			}
		}
	}
	public static void main(String[] args) {
		new Ex4ButtonArray("버튼배열");
	}


}
