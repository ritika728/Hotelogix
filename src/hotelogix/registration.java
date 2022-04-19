package hotelogix;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class registration extends JFrame {

	private JPanel contentPane;
	private JTextField FTF;
	private JTextField LTF;
	private JTextField UTF;
	private JPasswordField PTF;
	private JPasswordField CTF;
	private JTextField ETF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration frame = new registration();
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
	public registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 491);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FIRST NAME");
		lblNewLabel.setFont(new Font("Segoe Script", Font.PLAIN, 16));
		lblNewLabel.setBounds(47, 84, 183, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setFont(new Font("Segoe Script", Font.PLAIN, 16));
		lblLastName.setBounds(47, 131, 183, 37);
		contentPane.add(lblLastName);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Segoe Script", Font.PLAIN, 16));
		lblUsername.setBounds(47, 178, 183, 37);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Segoe Script", Font.PLAIN, 16));
		lblPassword.setBounds(47, 274, 183, 37);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("CONFIRM PASSWORD");
		lblConfirmPassword.setFont(new Font("Segoe Script", Font.PLAIN, 16));
		lblConfirmPassword.setBounds(48, 321, 198, 37);
		contentPane.add(lblConfirmPassword);
		
		JLabel lblNewLabel_1 = new JLabel("CREATE AN ACCOUNT");
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(199, 30, 255, 35);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String f= FTF.getText();
				String l= LTF.getText();
				String u= UTF.getText();
				String x= ETF.getText();
				String p= new String(PTF.getPassword());
				String c= new String(CTF.getPassword());
				try {
					 Class.forName("com.ibm.db2.jcc.DB2Driver");
			         java.sql.Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/sakshi","db2admin","123456789");
                     Statement stmt= conn.createStatement();
                      if( f.isEmpty() ) {
                       	 JOptionPane.showMessageDialog(null,"ENTER YOUR FIRST NAME");
                      }
                      else if(l.isEmpty()) {
                          JOptionPane.showMessageDialog(null,"ENTER YOUR LAST NAME");
                      }
                      else if(u.isEmpty()) {
                       	  JOptionPane.showMessageDialog(null,"ENTER YOUR USERNAME");
                      }
                      else if(x.isEmpty()) {
                          JOptionPane.showMessageDialog(null,"ENTER YOUR E-MAIL");
                      }
                      else if(p.isEmpty()) {
                          JOptionPane.showMessageDialog(null,"ENTER YOUR PASSWORD");
                      }
                      else if(c.isEmpty()) {
                          JOptionPane.showMessageDialog(null,"CONFIRM YOUR PASSWORD");
                      }
                      else if(p.equals(c)) {
                          String query="insert into registration values('"+f+"','"+l+"','"+u+"','"+x+"','"+p+"','"+c+"')";
                          stmt.executeUpdate(query);
                          JOptionPane.showMessageDialog(null,"your account is successfully registered"); 
                          dispose();
                          login_2  lo = new login_2();
     				      lo.setVisible(true);
     			      }
                      else {
                          JOptionPane.showMessageDialog(null,"YOUR CONFIRM PASSWORD IS INCORRECT");
                      }
                  	}catch(Exception e3) {
		                  e3.printStackTrace();
	     	              }
			}
		});
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 23));
		btnNewButton.setBounds(234, 384, 195, 37);
		contentPane.add(btnNewButton);
		
		FTF = new JTextField();
		FTF.setBounds(342, 84, 198, 29);
		contentPane.add(FTF);
		FTF.setColumns(10);
		
		LTF = new JTextField();
		LTF.setColumns(10);
		LTF.setBounds(342, 131, 198, 29);
		contentPane.add(LTF);
		
		UTF = new JTextField();
		UTF.setColumns(10);
		UTF.setBounds(342, 178, 198, 29);
		contentPane.add(UTF);
		
		PTF = new JPasswordField();
		PTF.setBounds(342, 276, 198, 29);
		contentPane.add(PTF);
		
		CTF = new JPasswordField();
		CTF.setBounds(342, 326, 198, 29);
		contentPane.add(CTF);
		
		JLabel lblEmail = new JLabel("E-MAIL");
		lblEmail.setFont(new Font("Segoe Script", Font.PLAIN, 16));
		lblEmail.setBounds(47, 225, 183, 37);
		contentPane.add(lblEmail);
		
		ETF = new JTextField();
		ETF.setColumns(10);
		ETF.setBounds(342, 230, 198, 29);
		contentPane.add(ETF);
	}
}
