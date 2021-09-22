package Prac;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tong extends JFrame {
	
	Container cp;
	
	JLabel []lbl = new JLabel[13];
	JLabel []lbl2 = new JLabel[13];
	String[] str = {"수입 통계","지출 통계","용돈","급여","금융수입","사업수입","기타수입","식비","카페/간식","술/유흥","온라인쇼핑","교통","뷰티/미용"};
	String[] str2 = {"","","","","","","","","","","","",""};
	
	ImageIcon img;
	
	
	
	public Tong(String title) {
		super(title);
		
		cp = this.getContentPane();
		this.setBounds(500, 500, 420, 400);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(new Color(255, 211, 155));
		this.initDesign();
		//this.setVisible(true);
		
	}
	
	public void initDesign() {
		this.setLayout(null);
		
		for (int i = 0 ; i < lbl.length ; i++) {
			lbl[i] = new JLabel(str[i]);
			lbl2[i] = new JLabel(str2[i]);
			lbl[i].setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
			lbl2[i].setFont(new Font("나눔바른고딕", Font.BOLD, 15));
		}
		
		lbl[0].setBounds(85, 8, 100, 50);
		this.add(lbl[0]);
		lbl[2].setBounds(60,80,100,50);
		this.add(lbl[2]);
		lbl[3].setBounds(60,120,100,50);
		this.add(lbl[3]);
		lbl[4].setBounds(60,160,100,50);
		this.add(lbl[4]);
		lbl[5].setBounds(60,200,100,50);
		this.add(lbl[5]);
		lbl[6].setBounds(60,240,100,50);
		this.add(lbl[6]);
		
		/*lbl2[0].setText((double)(Login.Yongcnt) / Login.addtotal + " %");
		lbl2[1].setText((double)(Login.Geupcnt) / Login.addtotal + " %");
		lbl2[2].setText((double)(Login.Geumcnt) / Login.addtotal + " %");
		lbl2[3].setText((double)(Login.Sacnt) / Login.addtotal + " %");
		lbl2[4].setText((double)(Login.Gicnt) / Login.addtotal + " %");*/
		lbl2[0].setBounds(100, 80, 100, 50);
		this.add(lbl2[0]);
		lbl2[1].setBounds(100, 120, 100, 50);
		this.add(lbl2[1]);
		lbl2[2].setBounds(120, 160, 100, 50);
		this.add(lbl2[2]);
		lbl2[3].setBounds(120, 200, 100, 50);
		this.add(lbl2[3]);
		lbl2[4].setBounds(120, 240, 100, 50);
		this.add(lbl2[4]);
		
		
		
		//지출
		lbl[1].setBounds(266,8,100,50);
		this.add(lbl[1]);
		lbl[7].setBounds(250, 80, 100, 50);
		this.add(lbl[7]);
		lbl[8].setBounds(250,120,100,50);
		this.add(lbl[8]);
		lbl[9].setBounds(250,160,100,50);
		this.add(lbl[9]);
		lbl[10].setBounds(250,200,100,50);
		this.add(lbl[10]);
		lbl[11].setBounds(250,240,100,50);
		this.add(lbl[11]);
		lbl[12].setBounds(250,280,100,50);
		this.add(lbl[12]);
		
		lbl2[7].setBounds(320, 80, 100, 50);
		this.add(lbl2[7]);
		lbl2[8].setBounds(320, 120, 100, 50);
		this.add(lbl2[8]);
		lbl2[9].setBounds(320, 160, 100, 50);
		this.add(lbl2[9]);
		lbl2[10].setBounds(320, 200, 100, 50);
		this.add(lbl2[10]);
		lbl2[11].setBounds(320, 240, 100, 50);
		this.add(lbl2[11]);
		lbl2[12].setBounds(320, 280, 100, 50);
		this.add(lbl2[12]);
		
		img = new ImageIcon("C:\\Users\\zippp\\Desktop\\Summer_PracticalEdu\\swingimage\\제목 없음-7.png");
		JLabel imgBox = new JLabel(img);
		imgBox.setBounds(2, -55, 400, 500);
		cp.add(imgBox);
		
		
		
	}
	

	/*public static void main(String[] args) {
		new Tong("통계");

	}*/

}
