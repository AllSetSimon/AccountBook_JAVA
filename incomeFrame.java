package Prac;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class incomeFrame extends JFrame {
	
	Container cp;
	JComboBox<String> cbCate;
	JTextField tfContent;
	
	JTextField tfIncome;
	
	JTextField tfDate;
	
	/*JTextField tfYongIncome;
	JTextField tfGeupIncome;
	JTextField tfGeumIncome;
	JTextField tfSaIncome;
	JTextField tfGiIncome;*/
	
	
	JButton btnAdd;
	JLabel lblWarn;
	
	ImageIcon img;
	

	
	
	
	public incomeFrame(String title) {
		super(title);
		
		cp = this.getContentPane();
		this.setBounds(400,250,300,500);
		cp.setBackground(new Color(255, 250, 140));
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		//this.setVisible(true);
	}
	
	
	
	public void initDesign() {
		this.setLayout(null);
		JLabel title1 = new JLabel("카테고리");
		JLabel title2 = new JLabel("내용");
		JLabel title3 = new JLabel("수입");
		
		JLabel title4 = new JLabel("날짜");
		
		lblWarn = new JLabel();
		
		tfContent = new JTextField(20);
		tfIncome = new JTextField(10);
		tfDate = new JTextField(10);
		tfDate.setText("/");
		
		String []Category = {"용돈","급여","금융수입","사업수입","기타수입"};
		cbCate = new JComboBox<String>(Category);
		
		btnAdd = new JButton("데이터 추가");
		
		title1.setBounds(30,30,60,20);
		this.add(title1);
		cbCate.setBounds(90,30, 170, 20);
		this.add(cbCate);
		title2.setBounds(55,80,60,20);
		this.add(title2);
		tfContent.setBounds(90,80,170,20);
		this.add(tfContent);
		/*cbCate.setBounds(60, 80, 170, 20);
		this.add(cbCate);*/
		title3.setBounds(55,130,60,20);
		this.add(title3);
		tfIncome.setBounds(90, 130, 170, 20);
		this.add(tfIncome);
		title4.setBounds(55,180,60,20);
		this.add(title4);
		tfDate.setBounds(90, 180, 170, 20);
		this.add(tfDate);
		/*tfJava.setBounds(60, 130, 170, 20);
		this.add(tfJava);
		title4.setBounds(30,180,60,20);
		this.add(title4);
		tfJsp.setBounds(60, 180, 170, 20);
		this.add(tfJsp);
		title5.setBounds(20,230,60,20);
		this.add(title5);
		tfSpring.setBounds(60, 230, 170, 20);
		this.add(tfSpring);*/
		btnAdd.setBounds(50, 230, 170,	20);
		this.add("Center",btnAdd);
		
		img = new ImageIcon("C:\\Users\\zippp\\Desktop\\Summer_PracticalEdu\\swingimage\\제목 없음-5.png");
		JLabel imgBox = new JLabel(img);
		imgBox.setBounds(0, 0, 300, 500);
		cp.add(imgBox);
		
		
		
	}
	
	/*public static void main(String[] args) {
		new incomeFrame("수입표");

	}*/
		
	

	}
