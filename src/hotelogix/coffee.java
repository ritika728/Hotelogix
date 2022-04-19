package hotelogix;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class coffee extends JFrame {

	private JPanel contentPane;
	private JTextField C;
	private JTextField F;
	private JTextField M;
	private JTextField CF;
	private JTextField E;
	private JTextField TTF;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					coffee frame = new coffee();
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
	public coffee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 471, 393);
		panel.setBackground(new Color(30, 139, 195));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/coffee.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		lblNewLabel.setBounds(201, 46, 53, 57);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Coffee");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(201, 102, 65, 22);
		panel.add(lblNewLabel_1);
		
		JCheckBox cap = new JCheckBox("Cappuccino");
		cap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cap.setForeground(Color.WHITE);
		cap.setBackground(new Color(30, 139, 195));
		cap.setBounds(91, 139, 111, 21);
		panel.add(cap);
		

		
		
		JCheckBox frap = new JCheckBox("Frappucino");
		frap.setForeground(Color.WHITE);
		frap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frap.setBackground(new Color(30, 139, 195));
		frap.setBounds(91, 173, 111, 21);
		panel.add(frap);
		
		JCheckBox moch = new JCheckBox("Mocha");
		moch.setForeground(Color.WHITE);
		moch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		moch.setBackground(new Color(30, 139, 195));
		moch.setBounds(91, 206, 111, 21);
		panel.add(moch);
		
		JCheckBox car = new JCheckBox("Caramel frappe");
		car.setForeground(Color.WHITE);
		car.setFont(new Font("Tahoma", Font.PLAIN, 14));
		car.setBackground(new Color(30, 139, 195));
		car.setBounds(91, 236, 121, 21);
		panel.add(car);
		
		JCheckBox esp = new JCheckBox("Espresso");
		esp.setForeground(Color.WHITE);
		esp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		esp.setBackground(new Color(30, 139, 195));
		esp.setBounds(91, 269, 111, 21);
		panel.add(esp);
		
		C = new JTextField();
		C.setBounds(331, 142, 53, 19);
		panel.add(C);
		C.setColumns(10);
		
		JButton btnNewButton = new JButton("ORDER");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String m= TTF.getText();
				int k=0;

				if(cap.isSelected()==true) {
					 	k=k + 120*(Integer.parseInt(C.getText()));
					}
				if(frap.isSelected()==true) {
						k=k + 250*(Integer.parseInt(F.getText()));
					}
				if(moch.isSelected()==true) {
						k=k + 280*(Integer.parseInt(M.getText()));
					}
				if(car.isSelected()==true) {
						k=k + 300*(Integer.parseInt(CF.getText()));
					}
				if(esp.isSelected()==true) {
					    k=k + 130*(Integer.parseInt(E.getText()));
					}
				try {
					 Class.forName("com.ibm.db2.jcc.DB2Driver");
				     java.sql.Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/sakshi","db2admin","123456789");
				     Statement stmt=conn.createStatement();
				     String query="Select FOOD_CHARGES from hotel WHERE MOBILE_NO='"+m+"'";
		             ResultSet rs = stmt.executeQuery(query);
				     boolean next;
			         next=rs.next();
				     String ag=rs.getString("FOOD_CHARGES");
				     int d=k+Integer.valueOf(ag);
				    				             
				     Statement stm= conn.createStatement();
	                 String que= "UPDATE hotel SET FOOD_CHARGES = "+d+" WHERE MOBILE_NO='"+m+"'";
	                 stm.executeUpdate(que);
	                 JOptionPane.showMessageDialog(null,"Your order has been placed");	
	                }catch(Exception e2) {
					      e2.printStackTrace();
				       }
			}
		});
		btnNewButton.setBounds(202, 350, 85, 21);
		panel.add(btnNewButton);
		
		F = new JTextField();
		F.setColumns(10);
		F.setBounds(331, 176, 53, 19);
		panel.add(F);
		
		M = new JTextField();
		M.setColumns(10);
		M.setBounds(331, 209, 53, 19);
		panel.add(M);
		
		CF = new JTextField();
		CF.setColumns(10);
		CF.setBounds(331, 239, 53, 19);
		panel.add(CF);
		
		E = new JTextField();
		E.setColumns(10);
		E.setBounds(331, 272, 53, 19);
		panel.add(E);
		
		JLabel lblNewLabel_2 = new JLabel("Qty");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(339, 119, 45, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MOBILE NO.");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(133, 317, 97, 13);
		panel.add(lblNewLabel_3);
		
		TTF = new JTextField();
		TTF.setBounds(267, 316, 85, 19);
		panel.add(TTF);
		TTF.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("BACK");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				MENU me = new MENU();
				dispose();
				me.setVisible(true);
			}
		});
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(416, 10, 45, 13);
		panel.add(lblNewLabel_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(416, 25, 45, 2);
		panel.add(separator);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		Image mg= new ImageIcon(this.getClass().getResource("/co1.jpg")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(mg));
		//lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\DEEPAK\\Desktop\\co1.jpg"));
		lblNewLabel_5.setBounds(479, 10, 316, 393);
		contentPane.add(lblNewLabel_5);
	}
}
