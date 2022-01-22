package game.omok;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OmokRun extends JFrame implements ActionListener{
	  
    MyPanel panel = new MyPanel();
    
	ImageIcon backicon = new ImageIcon("/Users/m/eclipse-workspace/OmokGame/img/pan.png"); // 판 이미지
    Image backimg=backicon.getImage();
    
    ImageIcon bi= new ImageIcon("/Users/m/eclipse-workspace/OmokGame/img/blackStone.png"); // 흑돌 이미지 
	Image bimg= bi.getImage();
	Image blackimg= bimg.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
	ImageIcon blackicon= new ImageIcon(blackimg);
	
	ImageIcon wi= new ImageIcon("/Users/m/eclipse-workspace/OmokGame/img/whiteStone.png"); // 백돌 이미지 
	Image wimg= wi.getImage();
	Image whiteimg= wimg.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
	ImageIcon whiteicon= new ImageIcon(whiteimg);
	

	JButton [][]button= new JButton[19][19];
	ArrayList<JButton> index= new ArrayList<JButton>();
	private int row, col;
	private int win;
	OmokProcess omok=new OmokProcess();

	public void initLayEx() {
		panel.setLayout(new GridLayout(19, 19)); //레이아웃 생성
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[i].length; j++) {
				button[i][j] = new JButton();
				button[i][j].addActionListener(this); //이벤트 메소드 호출 
				button[i][j].setContentAreaFilled(false);
				button[i][j].setBorderPainted(false);
				panel.add(button[i][j]);
			}
		}	
	}

	
	
	private int temp=0;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jb=(JButton)e.getSource();
	
		buttonIndex(e.getSource());
		
		if ((temp % 2) == 1) { // 백돌
			jb.setIcon(whiteicon);
			jb.setEnabled(false);
			jb.setDisabledIcon(whiteicon);
		} else { // 흑돌
			jb.setIcon(blackicon);
			jb.setEnabled(false);
			jb.setDisabledIcon(blackicon);
		}
		
		jb.setOpaque(false);
		
		win=omok.gamePrint(row, col ,temp);
		
		if(win>0) { // 승리 조건 확인
			if(win==1)
				JOptionPane.showMessageDialog(this,"백돌 승리","GAME OVER",JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(this,"흑돌 승리","GAME OVER",JOptionPane.INFORMATION_MESSAGE);
			
			int again=JOptionPane.showConfirmDialog(this,"다시 하시겠습니까?","GAME AGAIN",JOptionPane.YES_NO_OPTION);
			
			switch(again) {
			case JOptionPane.YES_OPTION:
				new OmokRun();
			case JOptionPane.NO_OPTION:
				dispose();
				break;
			default:
				dispose();
			}
		}
		temp++;
	}

	private void buttonIndex(Object c) {
		for (int x = 0; x <button.length; x++) {
			for (int y = 0; y < button[0].length; y++) {
				if (c.equals(button[x][y])) {
					row=x;
					col=y;
					return;
				}
			}
		}
	}
	
	class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(backimg,0,0,getWidth(),getHeight(),this);
        }
    }

	public OmokRun() {	
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				System.exit(0);
			}
			
		});
        
		initLayEx();
        this.add(panel);
        this.setBounds(300,150,500,500);
        this.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new OmokRun();
	}

}