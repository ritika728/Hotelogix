package hotelogix;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class forgotpassword extends JFrame {

	private JPanel contentPane;
	private JTextField UTF;
	private JTextField ETF;
	private JPasswordField NTF;
	private JPasswordField CTF;

	/**
	 * Launch the application.
	 */
	int i=0;
	public String c;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgotpassword frame = new forgotpassword();
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
	public forgotpassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		lblNewLabel.setBounds(94, 69, 101, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("E-MAIL");
		lblEmail.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		lblEmail.setBounds(94, 117, 101, 29);
		contentPane.add(lblEmail);
		
		UTF = new JTextField();
		UTF.setBounds(350, 69, 129, 26);
		contentPane.add(UTF);
		UTF.setColumns(10);
		
		ETF = new JTextField();
		ETF.setColumns(10);
		ETF.setBounds(350, 120, 129, 26);
		contentPane.add(ETF);
		
		JLabel lblNewLabel_1 = new JLabel("TO VERIFY ACCOUNT  CLICK HERE");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String u = UTF.getText();
				String a = ETF.getText();
				c=u;
				try {
					  Class.forName("com.ibm.db2.jcc.DB2Driver");
				      java.sql.Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/sakshi","db2admin","123456789");
	                  Statement stmt= conn.createStatement();
	                  String query=" select USERNAME,EMAIL from registration WHERE username='"+u+"'";
	                  ResultSet rs= stmt.executeQuery(query);
	                  boolean next;
	                  next=rs.next();
	                  String str=rs.getString("USERNAME");
	                  String ema=rs.getString("EMAIL");
	                  if(str.equals(u)) {
	                	 if(ema.equals(a)) {
	                		i=1;
	                		JOptionPane.showMessageDialog(null, "Your account is verified");
	                	 }
	                	 else 
	                	 {
	                		JOptionPane.showMessageDialog(null, "email is incorrect");
	                	 }
	                  }
	                  else 
	                  {
	                	JOptionPane.showMessageDialog(null,"Username is incorrect ");
	                  }
	                }catch(Exception e2) {
					     e2.printStackTrace();
				              }
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(94, 178, 237, 17);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(94, 196, 218, 4);
		contentPane.add(separator);
		
		JLabel lblNewPassword = new JLabel("NEW PASSWORD");
		lblNewPassword.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		lblNewPassword.setBounds(94, 224, 154, 29);
		contentPane.add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("CONFIRM PASSWORD");
		lblConfirmPassword.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		lblConfirmPassword.setBounds(94, 269, 168, 29);
		contentPane.add(lblConfirmPassword);
		
		JButton btnNewButton = new JButton("SET NEW PASSWORD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p = new String(NTF.getPassword());
				String f = new String(CTF.getPassword());
			    if(i==1) {
		     		try {
			     	     Class.forName("com.ibm.db2.jcc.DB2Driver");
				         java.sql.Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/sakshi","db2admin","123456789");
	                     Statement stmt= conn.createStatement();
	                     String query= "UPDATE REGISTRATION SET PASSWORD = '"+p+"',CONFIRM_PASSWORD = '"+f+"' WHERE USERNAME='"+c+"'";
	                     stmt.executeUpdate(query);
	                     JOptionPane.showMessageDialog(null,"Your password is updated");	
				        }catch(Exception e2) {
					         e2.printStackTrace();
				           }
				}
			    else 
			    {
					JOptionPane.showMessageDialog(null,"pls verify your account first");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(176, 346, 218, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("BACK");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				login_2 lo = new login_2();
				dispose();
				lo.setVisible(true);
			}
		});
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 10, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 30, 45, 4);
		contentPane.add(separator_1);
		
		NTF = new JPasswordField();
		NTF.setBounds(350, 224, 129, 26);
		contentPane.add(NTF);
		
		CTF = new JPasswordField();
		CTF.setBounds(350, 272, 129, 26);
		contentPane.add(CTF);
	}
}
