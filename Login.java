package Prac;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class Login extends JFrame implements ActionListener {
	
	Container cp;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	
	
	JLabel lblID,lblPwd;
	JTextField txtID;
	JPasswordField txtPwd;
	JButton btnLogin,btnJoin;
	ImageIcon img;
	
	
	static int recentMoney ;
	
	static int Yongcnt,Geupcnt,Geumcnt,Sacnt,Gicnt,Sikcnt,Cafecnt,Alcoholcnt,Shopcnt,Buscnt,Beautycnt;
	
	static int addtotal;

	int subtotal;

	int alltotal;
	
	Join join = new Join("회원가입");
	MoneyBank mb = new MoneyBank("====가계부===");
	incomeFrame iF = new incomeFrame("수입 등록");
	outcomeFrame oF = new outcomeFrame("지출 등록");
	Tong tg = new Tong("통계치");
	
	public Login(String title) {
		super(title);
		
		try {
			Class.forName(driver);
			System.out.println("오라클 드라이버 연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("오라클 드라이버 연결 실패");
		}
		
		cp = this.getContentPane();
		cp.setBackground(new Color(210, 240, 180));
		this.setBounds(200,300,500,300);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
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
	
	public void deleteData(String num) {
		String sql = "delete from moneybank where num = " + num;
		
		Connection conn = null;
		Statement stmt = null;
		
	conn = getConnection();
		try {
			stmt = conn.createStatement();
			int a = stmt.executeUpdate(sql);
			
			if(a==0) {
				JOptionPane.showMessageDialog(this, "없는 데이터입니다.");
			} else
				tableWrite();			
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
	
	
	
	public void tableWrite() {
		
		//테이블 초기화
		mb.model.setRowCount(0);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from moneybank order by num asc";
		System.out.println(sql);

		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Vector<String> data = new Vector<String>();
				
				data.add(rs.getString("num"));
				data.add(rs.getString("indate"));
				data.add(rs.getString("cate"));
				data.add(rs.getString("content"));
				data.add(rs.getString("income"));
				data.add(rs.getString("outcome"));
				data.add(rs.getString("recent"));
				
				
				mb.model.addRow(data);
				
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//조회는 select resultset
		
		
	}
	
public void insertData() {
		
		String cate = (String) iF.cbCate.getSelectedItem();
		String Date = iF.tfDate.getText();
		String content = iF.tfContent.getText();
		String income = iF.tfIncome.getText();
		String Yongincome = iF.tfIncome.getText();
		String Geupincome = iF.tfIncome.getText();
		String Geumincome = iF.tfIncome.getText();
		String Saincome = iF.tfIncome.getText();
		String Giincome = iF.tfIncome.getText();
		String outcome = oF.tfOutcome.getText();
		recentMoney += Integer.parseInt(income);
		
		if(cate.equals("용돈")) {
			Yongcnt+= Integer.parseInt(Yongincome);
			addtotal += Integer.parseInt(Yongincome);
			alltotal += Integer.parseInt(Yongincome);
		}else if(cate.equals("급여")) {
			Geupcnt+= Integer.parseInt(Geupincome);
		addtotal += Integer.parseInt(Geupincome);
		alltotal += Integer.parseInt(Geupincome);
		}else if(cate.equals("금융수입")) {
			Geumcnt+= Integer.parseInt(Geumincome);
		addtotal += Integer.parseInt(Geumincome);
		alltotal += Integer.parseInt(Geumincome);
		} else if(cate.equals("사업수입")) {
			Sacnt+= Integer.parseInt(Saincome);
		addtotal += Integer.parseInt(Saincome);
		alltotal += Integer.parseInt(Saincome);
		} else if(cate.equals("기타수입")) {
			Gicnt+= Integer.parseInt(Giincome);
		addtotal += Integer.parseInt(Giincome);
		alltotal += Integer.parseInt(Giincome);}
		
		
		/*addtotal += Integer.parseInt(income);
		alltotal += Integer.parseInt(income);*/
		mb.lblResult[0].setText(addtotal+"원 ");
		mb.lblResult[2].setText(alltotal+"원 ");
		
		
		String sql = "insert into moneybank values (seq1.nextval, '" + Date + "', '" + cate + "', '" + content + "', '" + income + "', '" + outcome + "', " + recentMoney + ")"; 
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		
		conn = getConnection();
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

public void deleteData() {
	
	String cate = (String) oF.cbCate.getSelectedItem();
	String Date = oF.tfDate.getText();
	String content = oF.tfContent.getText();
	String income = iF.tfIncome.getText();
	String outcome = oF.tfOutcome.getText();
	String Sikoutcome = oF.tfOutcome.getText();
	String Cafeoutcome = oF.tfOutcome.getText();
	String Alcoholoutcome = oF.tfOutcome.getText();
	String Shopoutcome = oF.tfOutcome.getText();
	String Busoutcome = oF.tfOutcome.getText();
	String Beautyoutcome = oF.tfOutcome.getText();
	recentMoney -= Integer.parseInt(outcome);
	
	/*"식비","카페/간식","술/유흥","온라인쇼핑","교통","뷰티/미용"*/
	
	if(cate.equals("식비")) {
		Sikcnt+= Integer.parseInt(Sikoutcome);
		subtotal += Integer.parseInt(Sikoutcome);
		alltotal += Integer.parseInt(Sikoutcome);
	} else if(cate.equals("카페/간식")) {
		Cafecnt+= Integer.parseInt(Cafeoutcome);
		subtotal += Integer.parseInt(Cafeoutcome);
		alltotal += Integer.parseInt(Cafeoutcome);
	}  else if(cate.equals("술/유흥")) {
		Alcoholcnt+= Integer.parseInt(Alcoholoutcome);
		subtotal += Integer.parseInt(Alcoholoutcome);
		alltotal += Integer.parseInt(Alcoholoutcome);
	} else if(cate.equals("온라인쇼핑")) {
		Shopcnt+= Integer.parseInt(Shopoutcome);
		subtotal += Integer.parseInt(Shopoutcome);
		alltotal += Integer.parseInt(Shopoutcome);
	} else if(cate.equals("교통")) {
		Buscnt+= Integer.parseInt(Busoutcome);
		subtotal += Integer.parseInt(Busoutcome);
		alltotal += Integer.parseInt(Busoutcome);
	} else if(cate.equals("뷰티/미용")) {
		Beautycnt+= Integer.parseInt(Beautyoutcome);
		subtotal += Integer.parseInt(Beautyoutcome);
		alltotal += Integer.parseInt(Beautyoutcome);
	}
	
	
	mb.lblResult[1].setText(subtotal+"원 ");
	mb.lblResult[2].setText(alltotal+"원 ");
	
	
	String sql = "insert into moneybank values (seq1.nextval, '" + Date + "', '" + cate + "', '" + content + "', '" + income + "', '" + outcome + "', " + recentMoney + ")"; 
	System.out.println(sql);
	
	Connection conn = null;
	Statement stmt = null;
	
	conn = getConnection();
	try {
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
	
	
	
public void select() {
	
		String tempid = txtID.getText();
		String temppwd = txtPwd.getText();
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		//sql
		String sql = "select id, passwd from member where id='" + tempid + "' and passwd='" + temppwd + "'";
		
		conn = getConnection();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				JOptionPane.showMessageDialog(this, tempid + "님 환영합니다.");			
				mb.setVisible(true);
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(this, "로그인 정보가 올바르지 않습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	


public void incomesetData() {
	float f1 = (float)Yongcnt / addtotal * 100;
	String str1 = String.format("%.2f", f1);
	float f2 = (float)Geupcnt / addtotal * 100;
	String str2 = String.format("%.2f", f2);
	float f3 = (float)Geumcnt / addtotal * 100;
	String str3 = String.format("%.2f", f3);
	float f4 = (float)Sacnt / addtotal * 100;
	String str4 = String.format("%.2f", f4);
	float f5 = (float)Gicnt / addtotal * 100;
	String str5 = String.format("%.2f", f5);

	tg.lbl2[0].setText(str1 + " %");
	tg.lbl2[1].setText(str2 + " %");
	tg.lbl2[2].setText(str3 + " %");
	tg.lbl2[3].setText(str4 + " %");
	tg.lbl2[4].setText(str5 + " %");
	
}

public void outcomesetData() {
	float f1 = (float)Sikcnt / subtotal * 100;
	String str1 = String.format("%.2f", f1);
	float f2 = (float)Cafecnt / subtotal * 100;
	String str2 = String.format("%.2f", f2);
	float f3 = (float)Alcoholcnt / subtotal * 100;
	String str3 = String.format("%.2f", f3);
	float f4 = (float)Shopcnt / subtotal * 100;
	String str4 = String.format("%.2f", f4);
	float f5 = (float)Buscnt / subtotal * 100;
	String str5 = String.format("%.2f", f5);
	float f6 = (float)Beautycnt / subtotal * 100;
	String str6 = String.format("%.2f", f6);
	
	
	tg.lbl2[7].setText(str1 + " %");
	tg.lbl2[8].setText(str2 + " %");
	tg.lbl2[9].setText(str3 + " %");
	tg.lbl2[10].setText(str4 + " %");
	tg.lbl2[11].setText(str5 + " %");
	tg.lbl2[12].setText(str6 + " %");
	
}
	
	
	
	public void initDesign() {
		this.setLayout(null);
		lblID = new JLabel("아이디");
		lblID.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		lblID.setBounds(140, 30, 100, 100);
		this.add(lblID);
		txtID = new JTextField();
		txtID.setBounds(200, 67, 150, 22);
		this.add(txtID);
		
		lblPwd = new JLabel("비밀번호");
		lblPwd.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		lblPwd.setBounds(130, 80, 100, 100);
		this.add(lblPwd);
		txtPwd = new JPasswordField();
		txtPwd.setBounds(200,117,150,22);
		this.add(txtPwd);
		
		btnLogin = new JButton("로그인");
		btnLogin.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		btnLogin.setBounds(140, 170, 100, 40);
		this.add(btnLogin);
		btnJoin = new JButton("회원가입");
		btnJoin.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		btnJoin.setBounds(250, 170, 100, 40);
		this.add(btnJoin);
		
		img = new ImageIcon("C:\\Users\\zippp\\Desktop\\Summer_PracticalEdu\\swingimage\\제목 없음-3.png");
		JLabel imgBox = new JLabel(img);
		imgBox.setBounds(0, -110, img.getIconWidth(), img.getIconWidth());
		cp.add(imgBox);
		
		btnJoin.addActionListener(this);
		btnLogin.addActionListener(this);
		
		mb.btn[0].addActionListener(this);
		mb.btn[1].addActionListener(this);
		mb.btn[2].addActionListener(this);
		mb.btn[3].addActionListener(this);
		
		iF.btnAdd.addActionListener(this);
		oF.btnAdd.addActionListener(this);
		
		
	}
	
	

	public static void main(String[] args) {
		new Login("로그인");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if (ob == mb.btn[0]) {
			iF.setVisible(true);
					
		} else if(ob == iF.btnAdd) {
			/*if(iF.tfContent.getText().length() == 0 || iF.tfIncome.getText().length() == 0 ){
				JOptionPane Warn = new JOptionPane();
				Warn.showMessageDialog(this, "모든 칸을 입력해주세요!", "주의", Warn.WARNING_MESSAGE);
			}*//*else {*/
			insertData();
			incomesetData();
			tableWrite();
			iF.cbCate.setSelectedIndex(0);
			iF.tfDate.setText(" / ");
			iF.tfContent.setText("");
			iF.tfIncome.setText("");
			oF.tfOutcome.setText("");
			
		}else if (ob == mb.btn[1]) {
			oF.setVisible(true);
					
		}else if(ob == oF.btnAdd) {
			/*if(oF.tfContent.getText().length() == 0 || oF.tfOutcome.getText().length() == 0 ){
				JOptionPane Warn = new JOptionPane();
				Warn.showMessageDialog(this, "모든 칸을 입력해주세요!", "주의", Warn.WARNING_MESSAGE);*/
			/*}*/
				deleteData();
				outcomesetData();
				tableWrite();
				oF.cbCate.setSelectedIndex(0);
				oF.tfDate.setText(" / ");
				oF.tfContent.setText("");
				iF.tfIncome.setText("");
				oF.tfOutcome.setText("");
				}
			
		else if(ob == btnJoin) {
			System.out.println("join");
			join.setVisible(true);
			
		} else if (ob == btnLogin) {
			select();
			tableWrite();
			
			
		}else if (ob == mb.btn[2]) {
			tg.setVisible(true);
			
		} else if (ob == mb.btn[3]) {
				while(true) {
				String num = JOptionPane.showInputDialog("삭제할 번호를 입력하세요");
				
				if(Integer.parseInt(num) > 0) {				
				deleteData(num);
				}else {
					break;
				}
			
		}
		
	}

}
}
