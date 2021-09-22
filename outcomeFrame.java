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

public class outcomeFrame extends JFrame implements ActionListener {
	
	Container cp;
	JTextField tfDate;
	JTextField tfContent;
	JTextField tfOutcome;
	JComboBox<String> cbCate;
	JButton btnAdd;
	JLabel lblWarn;
	ImageIcon img;
	
	
	public outcomeFrame(String title) {
		super(title);
		
		cp = this.getContentPane();
		this.setBounds(400,250,300,500);
		cp.setBackground(new Color(220, 230, 170));
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		//this.setVisible(true);
	}
	
	public void initDesign() {
		this.setLayout(null);
		JLabel title1 = new JLabel("ī�װ�");
		JLabel title2 = new JLabel("����");
		JLabel title3 = new JLabel("����");
		JLabel title4 = new JLabel("��¥");
		lblWarn = new JLabel();
		
		tfContent = new JTextField(20);
		tfOutcome = new JTextField(10);
		tfDate = new JTextField(10);
		tfDate.setText("/");
		
		String []Category = {"�ĺ�","ī��/����","��/����","�¶��μ���","����","��Ƽ/�̿�"};
		cbCate = new JComboBox<String>(Category);
		
		btnAdd = new JButton("������ �߰�");
		
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
		tfOutcome.setBounds(90, 130, 170, 20);
		this.add(tfOutcome);
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
		
		btnAdd.addActionListener(this);
		
		img = new ImageIcon("C:\\Users\\zippp\\Desktop\\Summer_PracticalEdu\\swingimage\\���� ����-6.png");
		JLabel imgBox = new JLabel(img);
		imgBox.setBounds(0, 0, 300, 500);
		cp.add(imgBox);
		
		
		
		
	}
	
	/*public static void main(String[] args) {
		new outcomeFrame("����ǥ");

	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob == btnAdd) {
			/*if(tfContent.getText().length() == 0 || tfOutcome.getText().length() == 0 ){
				JOptionPane Warn = new JOptionPane();
				Warn.showMessageDialog(this, "��� ĭ�� �Է����ּ���!", "����", Warn.WARNING_MESSAGE);*/
				
			/*lblWarn.setText("��� ĭ�� �Է����ֽʽÿ�.");
			lblWarn.setFont(new Font("���� ���", Font.BOLD, 20));
			lblWarn.setForeground(Color.RED);
			
			this.add(lblWarn);*/
		} else {
			
		}
		
		
	}

	}
