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

public class sweets extends JFrame {

	private JPanel contentPane;
	private JTextField D;
	private JTextField S;
	private JTextField G;
	private JTextField C;
	private JTextField L;
	private JTextField TTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sweets frame = new sweets();
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
	public sweets() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	    setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 447, 362);
		panel.setBackground(new Color(58, 83, 155));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/sweets.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		//lblNewLabel.setIcon(new ImageIcon("sweets.png"));
		lblNewLabel.setBounds(202, 40, 48, 55);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sweets");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(202, 98, 58, 13);
		panel.add(lblNewLabel_1);
		
		JCheckBox don = new JCheckBox("Donuts");
		don.setFont(new Font("Tahoma", Font.PLAIN, 14));
		don.setForeground(Color.WHITE);
		don.setBounds(91, 135, 93, 21);
		don.setBackground(new Color(58, 83, 155));
		panel.add(don);
		
		JCheckBox shor = new JCheckBox("Shortcrust pastry");
		shor.setForeground(Color.WHITE);
		shor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		shor.setBackground(new Color(58, 83, 155));
		shor.setBounds(91, 165, 141, 21);
		panel.add(shor);
		
		JCheckBox jam = new JCheckBox("Gulab Jamun");
		jam.setForeground(Color.WHITE);
		jam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jam.setBackground(new Color(58, 83, 155));
		jam.setBounds(93, 194, 127, 21);
		panel.add(jam);
		
		JCheckBox chee = new JCheckBox("Cheesecake");
		chee.setForeground(Color.WHITE);
		chee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chee.setBackground(new Color(58, 83, 155));
		chee.setBounds(91, 220, 116, 21);
		panel.add(chee);
		
		JCheckBox choco = new JCheckBox("Choco lava cake");
		choco.setForeground(Color.WHITE);
		choco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		choco.setBackground(new Color(58, 83, 155));
		choco.setBounds(91, 252, 141, 21);
		panel.add(choco);
		
		D = new JTextField();
		D.setBounds(310, 138, 70, 19);
		panel.add(D);
		D.setColumns(10);
		
		S = new JTextField();
		S.setColumns(10);
		S.setBounds(310, 168, 70, 19);
		panel.add(S);
		
		G = new JTextField();
		G.setColumns(10);
		G.setBounds(310, 197, 70, 19);
		panel.add(G);
		
		C = new JTextField();
		C.setColumns(10);
		C.setBounds(310, 223, 70, 19);
		panel.add(C);
		
		L = new JTextField();
		L.setColumns(10);
		L.setBounds(310, 255, 70, 19);
		panel.add(L);
		
		TTF = new JTextField();
		TTF.setColumns(10);
		TTF.setBounds(225, 290, 108, 19);
		panel.add(TTF);
		
		JLabel lblNewLabel_2 = new JLabel("MOBILE NO.");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(118, 291, 123, 13);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("ORDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String m= TTF.getText();			
				int h=0;
				if(don.isSelected()==true) {
					 	h=h + 100*(Integer.parseInt(D.getText()));
					}
				if(shor.isSelected()==true) {
						h=h + 120*(Integer.parseInt(S.getText()));
					}
				if(jam.isSelected()==true) {
						h=h + 20*(Integer.parseInt(G.getText()));
					}
				if(chee.isSelected()==true) {
						h=h + 600*(Integer.parseInt(C.getText()));
					}
				if(choco.isSelected()==true) {
					    h=h + 200*(Integer.parseInt(L.getText()));
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
				     int d=h+Integer.valueOf(ag);
				    				             
				     Statement stm= conn.createStatement();
	                 String que= "UPDATE hotel SET FOOD_CHARGES = "+d+" WHERE MOBILE_NO='"+m+"'";
	                 stm.executeUpdate(que);
	                 JOptionPane.showMessageDialog(null,"Your order has been placed");	
	                }catch(Exception e2) {
					      e2.printStackTrace();
				       }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(191, 319, 93, 21);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Qty");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(335, 115, 45, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("BACK");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				MENU me = new MENU();
				dispose();
				me.setVisible(true);
			}
		});
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(10, 10, 45, 13);
		panel.add(lblNewLabel_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 30, 48, 2);
		panel.add(separator);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		Image mg= new ImageIcon(this.getClass().getResource("/s2.jpg")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(mg));
		//lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\DEEPAK\\Desktop\\s2.jpg"));
		lblNewLabel_5.setBounds(455, 10, 268, 362);
		contentPane.add(lblNewLabel_5);
	}
}
