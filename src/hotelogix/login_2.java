package hotelogix;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class login_2 extends JFrame {

	private JPanel contentPane;
	private JTextField UTF;
	private JPasswordField PTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_2 frame = new login_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 624, 477);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(101, 27, 404, 243);
		panel_1.setBackground(new Color(0, 0, 0,20));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(60, 32, 106, 25);
		panel_1.add(lblNewLabel_1);
		
		UTF = new JTextField();
		UTF.setBounds(233, 36, 124, 26);
		panel_1.add(UTF);
		UTF.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(60, 67, 106, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=UTF.getText();
				String p=new String(PTF.getPassword());
				try {
					 Class.forName("com.ibm.db2.jcc.DB2Driver");
				     java.sql.Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/sakshi","db2admin","123456789");
	                 Statement stmt= conn.createStatement();
	                 String query=" select password from registration WHERE username='"+s+"'";
	                 ResultSet rs= stmt.executeQuery(query);
	                 boolean next;
	                 next=rs.next();
	                 String str=rs.getString("password");
	                 if(str.equals(p)){ 
	                	   MAIN_FRAME mf = new MAIN_FRAME();
					       dispose();
					       mf.setVisible(true);
	                 }
	                 else
	                 { 
	                	 JOptionPane.showMessageDialog(null,"try again");
	                 }	
	                }catch(Exception e2) {
					    e2.printStackTrace();
				          }
			}
		});
		btnNewButton.setFont(new Font("Lucida Handwriting", Font.PLAIN, 17));
		btnNewButton.setBounds(215, 125, 106, 21);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Forgot Password? click here");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
		
			
			public void mouseClicked(MouseEvent e) {
				forgotpassword fp= new forgotpassword();
				fp.setVisible(true);		
				}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(111, 156, 194, 13);
		panel_1.add(lblNewLabel_2);
		
		PTF = new JPasswordField();
		PTF.setBounds(233, 72, 124, 25);
		panel_1.add(PTF);
		
		JButton btnSignin = new JButton("SIGN-IN");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registration rg= new registration();
				rg.setVisible(true);
			}
		});
		btnSignin.setFont(new Font("Lucida Handwriting", Font.PLAIN, 17));
		btnSignin.setBounds(73, 125, 118, 21);
		panel_1.add(btnSignin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 624, 477);
		Image img= new ImageIcon(this.getClass().getResource("/login.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		panel.add(lblNewLabel);
	}
}
