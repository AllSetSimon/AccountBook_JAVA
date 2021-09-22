package Prac;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;


public class MoneyBank extends JFrame {
	Container cp;
	
	/*String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";*/
	
	JPanel pTop,pBottom;
	JButton [] btn = new JButton[4];
	
	JLabel [] lbl = new JLabel[3];
	JLabel [] lblResult = new JLabel[3];
	
	String[] str = {"수입","지출","통계","삭제"};
	String[] str1 = {"수입 총 합 : ","지출 총 합 : ","총 합계 : "};
	
	
	String strtitle[] = {"번호","날짜","카테고리","내용","수입","지출","현재금액"};
	String data[][] = {{"","","","","","",""}};
	
	
	DefaultTableModel model;
	JTable table;
	JScrollPane scroll;
	DefaultTableCellRenderer dtcr;
	TableColumnModel tcm;
	
	ImageIcon img;
	
	/*incomeFrame iF = new incomeFrame("수입 등록");
	outcomeFrame oF = new outcomeFrame("지출 등록");*/
	
	int addtotal,subtotal,alltotal,recenttotal;
	static int cnt = 0;
	
	public MoneyBank(String title) {
		super(title);
		
		/*try {
			Class.forName(driver);
			System.out.println("오라클 드라이버 연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("오라클 드라이버 연결 실패");
		}*/
		
		
		model = new DefaultTableModel(strtitle,0);
		
		cp = this.getContentPane();
		this.setBounds(500, 250, 550, 550);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(new Color(255, 250, 156));
		this.initDesign();
		//this.setVisible(true);
	}
	
	
	
	
	/*public Connection getConnection() {
		
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
	}*/
	
	
	
	public void initDesign() {
		img = new ImageIcon("C:\\Users\\zippp\\Desktop\\Summer_PracticalEdu\\swingimage\\다운로드.png");
		pTop = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(img.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
				
			}
			
			
		};
		this.add("North",pTop);
		
		pBottom = new JPanel();
		this.add("South", pBottom);
		
		for( int i = 0 ; i < btn.length; i++) {
			btn[i] = new JButton(str[i]);
			pTop.add(btn[i]);
			btn[i].setFont(new Font("Adobe 고딕 Std B", Font.BOLD, 12));
			
		}
		
		
		
		
		for (int i = 0 ; i < lbl.length ; i++) {
			
			
		/*	btn[i].addActionListener(this);*/
			
			lbl[i] = new JLabel(str1[i]);
			lblResult[i] = new JLabel();
			
			pBottom.add(lbl[i]);
			pBottom.add(lblResult[i]);
			
		}
		
		
		
	table = new JTable(model);
	scroll = new JScrollPane(table);
	table.setSelectionBackground(new Color(102, 238, 238));
	table.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
	
	
	
	
	
	
	
	/*public void paint( Graphics g )	{

	Dimension d = getSize();
	for( int x = 0; x < d.width; x += img.getIconWidth() )
	for( int y = 0; y < d.height; y += img.getIconHeight() )
	g.drawImage( img.getImage(), x, y, null, null );

	super.paint(g);
	};*/

	

	table.setOpaque(false);
	
	
	
	
	this.add("Center", scroll);
	
	dtcr = new DefaultTableCellRenderer();
	dtcr.setHorizontalAlignment(SwingConstants.CENTER);
	tcm = table.getColumnModel();
	
	table.setAutoCreateRowSorter(true);
	TableRowSorter tablesorter = new TableRowSorter(table.getModel());
	table.setRowSorter(tablesorter);
	
	/*JLabel imgBox = new JLabel(img);
	imgBox.setBounds(0, -110, img.getIconWidth(), img.getIconWidth());
	pTop.add("South",imgBox);*/


	
	
	for(int i = 0 ; i < tcm.getColumnCount() ; i++) {
		tcm.getColumn(i).setCellRenderer(dtcr);
	}
	
		
		
	}
	
/*	public void tableWrite() {
		
		//테이블 초기화
		model.setRowCount(0);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from moneybank";
		System.out.println(sql);

		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Vector<String> data = new Vector<String>();
				
				data.add(rs.getString("num"));
				data.add(rs.getString("cate"));
				data.add(rs.getString("content"));
				data.add(rs.getString("income"));
				data.add(rs.getString("outcome"));
				data.add(rs.getString("recent"));
				
				
				model.addRow(data);
				
				
				
				
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
		
		
	}*/
	
	
	
	/*public void insertData() {
		
		String cate = (String) iF.cbCate.getSelectedItem();
		String content = iF.tfContent.getText();
		String income = iF.tfIncome.getText();
		String outcome = oF.tfOutcome.getText();
		int recentMoney = 0;
		recentMoney += Integer.parseInt(income);
		
		
		String sql = "insert into  values (seq1.nextval, '" + cate + "', '" + content + "', '" + income + "', '" + outcome + "', " + recentMoney + ")"; 
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
		
	}*/
	
	
	/*@Override*/
	/*public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if (ob == btn[0]) {
			iF.setVisible(true);
					
		} else if(ob == iF.btnAdd) {
			if(iF.tfContent.getText().length() == 0 || iF.tfIncome.getText().length() == 0 ){
				JOptionPane Warn = new JOptionPane();
				Warn.showMessageDialog(this, "모든 칸을 입력해주세요!", "주의", Warn.WARNING_MESSAGE);
			}else {
			insertData();
			tableWrite();
			}
		}		
		else if (ob == btn[1]) {
			oF.setVisible(true);
			
			
		}
	}*/
	
	/*public static void main(String[] args) {
		new MoneyBank("==가계부==");

	}*/
}