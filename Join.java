package Prac;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class Join extends JFrame implements ActionListener {
	
	Container cp;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	
	JTextField tfID;
	JTextField tfPwd;
	JTextField tfName;
	ImageIcon img;
	JButton btnRegister,btnCancel;
	JLabel lblID,lblPwd,lblName,lblWarn;
	
	
	
	public Join(String title) {
		super(title);
		
		try {
			Class.forName(driver);
			System.out.println("����Ŭ ����̹� ���� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("����Ŭ ����̹� ���� ����");
		}		
		cp = this.getContentPane();
		this.setBounds(400,250,300,500);
		cp.setBackground(new Color(255, 250, 140));
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		//this.setVisible(true);
	}
	
	public Connection getConnection() {
		
		Connection conn = null;
		
		try {
			System.out.println("DB Connection Success");
			conn = DriverManager.getConnection(url, "zipppy", "a1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("DB Connection Fail");
			//e.printStackTrace();
		}
		
		return conn;
	}
	
	public void insert() {
		
		Scanner sc = new Scanner(System.in);
		String ID, Passwd, Name;
		
		String sql = "";
		
		ID = tfID.getText();
		Passwd = tfPwd.getText();
		Name = tfName.getText();
		
		sql = "insert into member values (seq2.nextval,'"+
				ID +"','"+ Passwd + "','"+Name+"')";
				
				System.out.println(sql);
				
				//1. db����
				Connection conn = null;
				//2. statement
				Statement stmt = null;
				
				conn = getConnection();
				
				try {
					stmt = conn.createStatement();
					//sql�� ���۽���
					stmt.executeUpdate(sql);
					System.out.println("�߰� �Ǿ����ϴ�.");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
		
	}
	
	
	
	public void initDesign() {
		this.setLayout(null);
		lblID = new JLabel("���̵�");
		lblID.setFont(new Font("���", Font.BOLD, 13));
		lblPwd = new JLabel("��й�ȣ");
		lblPwd.setFont(new Font("���", Font.BOLD, 13));
		lblName = new JLabel("�̸�");
		lblName.setFont(new Font("���", Font.BOLD, 13));
		lblWarn = new JLabel();
		
		tfID = new JTextField(20);
		tfPwd = new JTextField(10);
		tfName = new JTextField(20);
		
		btnRegister = new JButton("����");
		btnCancel = new JButton("���");
		
		lblID.setBounds(40,80,60,20);
		this.add(lblID);
		tfID.setBounds(90,80,170,20);
		this.add(tfID);
		
		lblPwd.setBounds(30,130,60,20);
		this.add(lblPwd);
		tfPwd.setBounds(90,130,170,20);
		this.add(tfPwd);
		lblName.setBounds(55,180,60,20);
		this.add(lblName);
		tfName.setBounds(90, 180, 170, 20);
		this.add(tfName);
		btnRegister.setBounds(50, 250, 170,	20);
		btnRegister.addActionListener(this);
		this.add(btnRegister);
		
		img = new ImageIcon("C:\\Users\\zippp\\Desktop\\Summer_PracticalEdu\\swingimage\\���� ����-4.png");
		JLabel imgBox = new JLabel(img);
		imgBox.setBounds(0, 0, 300, 500);
		cp.add(imgBox);
		
		
		
	}
	
	/*public static void main(String[] args) {
		new Join("ȸ������");

	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob == btnRegister) {
			if(tfID.getText().length() == 0 || tfPwd.getText().length() == 0 || tfName.getText().length() == 0){
				/*JOptionPane Warn = new JOptionPane();
				Warn.showMessageDialog(this, "��� ĭ�� �Է����ּ���!", "����", Warn.WARNING_MESSAGE);*/
				
			lblWarn.setText("��� ĭ�� �Է����ֽʽÿ�.");
			lblWarn.setFont(new Font("���� ���", Font.BOLD, 12));
			lblWarn.setForeground(Color.RED);
			lblWarn.setBounds(50,160,150,50);
			this.add(lblWarn,lblWarn.CENTER);
		} else {
			insert();
			JOptionPane.showMessageDialog(this, "            ȸ�������� �Ϸ�Ǿ����ϴ�.", "���ԿϷ�",JOptionPane.DEFAULT_OPTION);
			dispose();
		}
		
		
	}

	}
}