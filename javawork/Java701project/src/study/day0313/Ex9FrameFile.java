package study.day0313;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex9FrameFile extends JFrame {
	
	JButton btnSave = new JButton("파일저장");
	JButton btnOpen = new JButton("파일열기");
	JTextArea area = new JTextArea();
	
	public Ex9FrameFile(String title) {
		super(title);
		
		// 단순히 윈도우만 종료하고 싶을때는 메서드를 통해서 종료하면 된다
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 컴포넌트 생성 및 이벤트 설정하기 위한 메서드
		this.initDesign();
		
		this.getContentPane().setBackground(new Color(200, 200, 200));
		this.setBounds(900, 100, 500, 500); // x, y, w, h
		this.setVisible(true);
	}
	
	private void initDesign() {
		JPanel p = new JPanel();
		p.add(btnSave);
		p.add(btnOpen);
		this.add("North", p);
		
		this.add("Center", new JScrollPane(area));
		// 불러오기
		btnOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText(""); // 기존의 내용 모두 지운 후 추가하기
				
				FileDialog dlg = new FileDialog(Ex9FrameFile.this, "파일불러오기", FileDialog.LOAD);
				dlg.setVisible(true);
				
				// 취소 누를경우 메서드 종료
				if(dlg.getDirectory() == null) {
					return;
				}
				// 파일 디렉토리 + 파일명 얻기
				String path = dlg.getDirectory() + dlg.getFile();
//				System.out.println(path);
				// 파일 줄단위로 읽어서 메모장에 가져오기
				FileReader fr = null;
				BufferedReader br = null;
				
				try {
					fr = new FileReader(path);
					br = new BufferedReader(fr);
					
					while(true) {
						String read = br.readLine();
						if(read == null) {
							break;
						}
						area.append(read + "\n");
					}
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					try {
						if(br != null) {br.close();}
						if(fr != null) {fr.close();}
					} catch(IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		// 저장하기
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlg = new FileDialog(Ex9FrameFile.this, "파일저장하기", FileDialog.SAVE);
				dlg.setVisible(true);
				
				// 취소 누를경우 메서드 종료
				if(dlg.getDirectory() == null) {
					return;
				}
				// 파일 디렉토리 + 파일명 얻기
				String path = dlg.getDirectory() + dlg.getFile();
				
				// 메모장에 입력한 데이터
				String data = area.getText();
				
				// 파일 저장
				FileWriter fw = null;
				try {
					fw = new FileWriter(path);
					
					// 파일 저장 후 창제목 변경
					fw.write(data);
					
					Ex9FrameFile.this.setTitle(dlg.getFile());
					
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					try {
						fw.close();
					} catch(IOException e1) {}
				}
			}
		});
	}
	public static void main(String[] args) {
		new Ex9FrameFile("메모장");
	}

}
