package study.day0313;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Prac extends JFrame{
	
	Draw draw = new Draw();
	JComboBox<String> shapeBox;
	JComboBox<String> colorBox;
	Image image;
	Color c;
	public Prac(String title) {
		super(title);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		
		this.setBounds(600, 250, 500, 500);
		this.setVisible(true);
	}
	
	private void initDesign() {
		String[] shape = {"원", "사각형", "사진", "문자열"};
		String[] color = {"빨강", "주황", "노랑", "초록", "파랑", "핑크", "검정"};
		
		shapeBox = new JComboBox<>(shape);
		colorBox = new JComboBox<>(color);
		
		JPanel p = new JPanel();
		p.add(shapeBox);
		p.add(colorBox);
		
		
		this.add("North", p);
		this.add("Center", draw);
		
		colorBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				switch (colorBox.getSelectedIndex()) {
				case 0:
					c = Color.RED;
					break;
				case 1:
					c = Color.ORANGE;
					break;
				case 2:
					c = Color.YELLOW;
					break;
				case 3:
					c = Color.GREEN;
					break;
				case 4:
					c = Color.BLUE;
					break;
				case 5:
					c = Color.PINK;
					break;
				case 6:
					c = Color.BLACK;
					break;
				}
				draw.repaint();
			}
		});
		
		shapeBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				draw.repaint();
			}
		});
			
		
 	}
	
	class Draw extends Canvas {
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			switch (shapeBox.getSelectedIndex()) {
			case 0:
				g.setColor(c);
				g.fillOval(150, 150, 150, 150);
				break;
			case 1:
				g.setColor(c);
				g.fillRect(150, 150, 150, 150);
				break;
			case 2:
				image = new ImageIcon("D:\\bit701naver\\study\\webwork\\image\\jquery_image\\01.png").getImage();
				g.drawImage(image, 100, 50, 300, 300, this);
				break;
			case 3:
				g.setFont(new Font("Impact", Font.ITALIC| Font.BOLD, 50));
				g.setColor(c);
				g.drawString("BitCamp", 100, 200);
				
				break;
			}
			System.out.println(shapeBox.getSelectedIndex());
		}
	}
	
	
	public static void main(String[] args) {
		new Prac("예제");
	}
	
}
