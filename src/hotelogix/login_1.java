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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login_1 extends JFrame {

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
					login_1 frame = new login_1();
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
	public login_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		lblNewLabel.setBounds(88, 98, 131, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		lblPassword.setBounds(88, 147, 131, 23);
		contentPane.add(lblPassword);
		
		UTF = new JTextField();
		UTF.setBounds(278, 102, 120, 19);
		contentPane.add(UTF);
		UTF.setColumns(10);
		
		JLabel lblAdminLogin = new JLabel("ADMIN LOGIN");
		lblAdminLogin.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		lblAdminLogin.setBounds(173, 48, 131, 23);
		contentPane.add(lblAdminLogin);
		
		PTF = new JPasswordField();
		PTF.setEchoChar('*');
		PTF.setBounds(278, 151, 120, 19);
		contentPane.add(PTF);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a= "admin_hotelogix";
				String b= "adm0123";
				String c=UTF.getText();
				String d=new String(PTF.getPassword());
				if(c.equals(a)) {
					if(d.equals(b)) {
						MAINFRAME2 mf= new MAINFRAME2();
						mf.setVisible(true);
					}
					else 
					{
						JOptionPane.showMessageDialog(null,"Incorrect password");
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Username incorrect");
				}          	
			}
		});
		btnNewButton.setFont(new Font("Lucida Handwriting", Font.PLAIN, 17));
		btnNewButton.setBounds(173, 207, 113, 33);
		contentPane.add(btnNewButton);
	}
}
