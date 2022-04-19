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

public class FOOD extends JFrame {

	private JPanel contentPane;
	private JTextField C;
	private JTextField S;
	private JTextField H;
	private JTextField T;
	private JTextField B;
	private JTextField TTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FOOD frame = new FOOD();
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
	public FOOD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	    setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(142, 68, 173));
		panel.setBounds(10, 10, 541, 361);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/food.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		lblNewLabel.setBounds(232, 43, 58, 46);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Food");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(232, 99, 58, 13);
		panel.add(lblNewLabel_1);
		
		JCheckBox car = new JCheckBox("Pasta Carbonara");
		car.setForeground(Color.WHITE);
		car.setFont(new Font("Tahoma", Font.PLAIN, 14));
		car.setBounds(96, 134, 154, 21);
		car.setBackground(new Color(142, 68, 173));
		panel.add(car);
		
		JCheckBox club = new JCheckBox("Club Sandwhich");
		club.setForeground(Color.WHITE);
		club.setFont(new Font("Tahoma", Font.PLAIN, 14));
		club.setBackground(new Color(142, 68, 173));
		club.setBounds(96, 167, 125, 21);
		panel.add(club);
		
		JCheckBox ham = new JCheckBox("Hamburger");
		ham.setForeground(Color.WHITE);
		ham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ham.setBackground(new Color(142, 68, 173));
		ham.setBounds(96, 196, 125, 21);
		panel.add(ham);
		
		JCheckBox toss = new JCheckBox("Tossed Salad");
		toss.setForeground(Color.WHITE);
		toss.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toss.setBackground(new Color(142, 68, 173));
		toss.setBounds(96, 223, 109, 25);
		panel.add(toss);
		
		JCheckBox bro = new JCheckBox("Broth");
		bro.setForeground(Color.WHITE);
		bro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bro.setBackground(new Color(142, 68, 173));
		bro.setBounds(96, 254, 93, 21);
		panel.add(bro);
		
		C = new JTextField();
		C.setBounds(343, 137, 64, 19);
		panel.add(C);
		C.setColumns(10);
		
		S = new JTextField();
		S.setColumns(10);
		S.setBounds(343, 170, 64, 19);
		panel.add(S);
		
		H = new JTextField();
		H.setColumns(10);
		H.setBounds(343, 199, 64, 19);
		panel.add(H);
		
		T = new JTextField();
		T.setColumns(10);
		T.setBounds(343, 228, 64, 19);
		panel.add(T);
		
		B = new JTextField();
		B.setColumns(10);
		B.setBounds(343, 257, 64, 19);
		panel.add(B);
		
		TTF = new JTextField();
		TTF.setColumns(10);
		TTF.setBounds(260, 286, 109, 19);
		panel.add(TTF);
		
		JLabel lblNewLabel_2 = new JLabel("MOBILE NO.");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(141, 287, 109, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Qty");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(355, 99, 58, 21);
		panel.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("ORDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String m= TTF.getText();				
				int i=0;
				if(car.isSelected()==true) {
					 	i=i + 200*(Integer.parseInt(C.getText()));
					}
				if(club.isSelected()==true) {
						i=i + 140*(Integer.parseInt(S.getText()));
					}
				if(ham.isSelected()==true) {
						i=i + 250*(Integer.parseInt(H.getText()));
					}
				if(toss.isSelected()==true) {
						i=i + 220*(Integer.parseInt(T.getText()));
					}
				if(bro.isSelected()==true) {
					    i=i + 1500*(Integer.parseInt(B.getText()));
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
			         int d=i+Integer.valueOf(ag);
				    			             
				     Statement stm= conn.createStatement();
	                 String que= "UPDATE hotel SET FOOD_CHARGES = "+d+" WHERE MOBILE_NO='"+m+"'";
	                 stm.executeUpdate(que);
	                 JOptionPane.showMessageDialog(null,"Your order has been placed");	
	                }catch(Exception e4) {
					      e4.printStackTrace();
				        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(215, 315, 85, 21);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("BACK");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				MENU me = new MENU();
				dispose();
				me.setVisible(true);
			}
		});
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(10, 10, 45, 13);
		panel.add(lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 30, 45, 2);
		panel.add(separator);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		Image mg= new ImageIcon(this.getClass().getResource("/f3.jpg")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(mg));
	//	lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\DEEPAK\\Desktop\\f3.jpg"));
		lblNewLabel_4.setBounds(542, 10, 421, 361);
		contentPane.add(lblNewLabel_4);
	}

}
