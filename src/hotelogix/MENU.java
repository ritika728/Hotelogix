package hotelogix;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSeparator;



public class MENU extends JFrame {
	  

	private JPanel contentPane;
	private JTextField TC;
	public String b;
	private JTextField TTF;
	 public MENU(int z) {
		   b= Integer.toString(z);
		  
		 //  JOptionPane.showMessageDialog(null, b);
	   }
	public static void main(String[] args) {
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MENU frame = new MENU();
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
	
	public MENU() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 286, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	    setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 287, 125);
		panel.setBackground(new Color(78, 205, 196));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(72, 16, 71, 19);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		Image mag= new ImageIcon(this.getClass().getResource("/menu.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(mag));
		//lblNewLabel_1.setIcon(new ImageIcon("menu.png"));
		lblNewLabel_1.setBounds(10, 9, 32, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("X");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
		       MAINFRAME2 mf = new MAINFRAME2();
		       dispose();
		       mf.setVisible(true);
			}
		});
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(256, 13, 21, 23);
		panel.add(lblNewLabel_6);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(254, 40, 23, 2);
		panel.add(separator);
		
		JLabel lblNewLabel_5 = new JLabel("MOBILE NO.");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(26, 96, 95, 19);
		panel.add(lblNewLabel_5);
		
		TTF = new JTextField();
		TTF.setBounds(136, 98, 125, 19);
		panel.add(TTF);
		TTF.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 122, 287, 105);
		panel_1.setBackground(new Color(30, 139, 195));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		Image img= new ImageIcon(this.getClass().getResource("/coffee.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		//lblNewLabel_2.setIcon(new ImageIcon("coffee.png"));
		lblNewLabel_2.setBounds(10, 34, 51, 44);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Coffee");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				coffee co= new coffee();
				co.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(84, 34, 78, 17);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Lorem ipsum dolor sit amet");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(84, 65, 172, 13);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(58, 83, 155));
		panel_1_1.setBounds(0, 227, 287, 105);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		Image im= new ImageIcon(this.getClass().getResource("/sweets.png")).getImage();
		lblNewLabel_2_1.setIcon(new ImageIcon(im));
	//	lblNewLabel_2_1.setIcon(new ImageIcon("sweets.png"));
		lblNewLabel_2_1.setBounds(10, 29, 51, 44);
		panel_1_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Sweet");
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				sweets sw = new sweets();
				sw.setVisible(true);
			}
		});
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(86, 29, 78, 17);
		panel_1_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Consecteur adipisicing elit");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(86, 60, 172, 13);
		panel_1_1.add(lblNewLabel_4_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(142, 68, 173));
		panel_1_2.setBounds(0, 332, 287, 105);
		contentPane.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("New label");
		Image mg= new ImageIcon(this.getClass().getResource("/food.png")).getImage();
		lblNewLabel_2_1_1.setIcon(new ImageIcon(mg));
	//	lblNewLabel_2_1_1.setIcon(new ImageIcon("food.png"));
		lblNewLabel_2_1_1.setBounds(10, 29, 51, 44);
		panel_1_2.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Food");
		lblNewLabel_3_1_1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				FOOD fo =new FOOD();
				fo.setVisible(true);
			}
		});
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1_1.setBounds(84, 29, 78, 17);
		panel_1_2.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Nullam eu auctor enim");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1_1.setBounds(84, 60, 172, 13);
		panel_1_2.add(lblNewLabel_4_1_1);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(new Color(145, 61, 136));
		panel_1_3.setBounds(0, 435, 287, 105);
		contentPane.add(panel_1_3);
		panel_1_3.setLayout(null);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("New label");
		Image imag= new ImageIcon(this.getClass().getResource("/drinks.png")).getImage();
		lblNewLabel_2_1_1_1.setIcon(new ImageIcon(imag));
		//lblNewLabel_2_1_1_1.setIcon(new ImageIcon("drinks.png"));
		lblNewLabel_2_1_1_1.setBounds(10, 27, 51, 44);
		panel_1_3.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Drink");
		lblNewLabel_3_1_1_1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				DRINKS dr =new DRINKS();
				dr.setVisible(true);
			}
		});
		lblNewLabel_3_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1_1_1.setBounds(84, 27, 78, 17);
		panel_1_3.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Fusce auctor est in ultricies");
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1_1_1.setBounds(84, 58, 172, 13);
		panel_1_3.add(lblNewLabel_4_1_1_1);
		
		JButton btnNewButton = new JButton("TOTAL COST");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String mo =TTF.getText();
				try {
					 Class.forName("com.ibm.db2.jcc.DB2Driver");
				     java.sql.Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/sakshi","db2admin","123456789");
				     Statement stmt=conn.createStatement();
				     String query="Select FOOD_CHARGES from hotel WHERE MOBILE_NO='"+mo+"'";
				     ResultSet rs = stmt.executeQuery(query);
				     boolean next;
			         next=rs.next();
				     String ag=rs.getString("FOOD_CHARGES");
				     TC.setText(ag);
				    }catch(Exception e5) {
					      e5.printStackTrace();
				         }	
			}
		});
		btnNewButton.setBounds(65, 550, 132, 21);
		contentPane.add(btnNewButton);
		
		TC = new JTextField();
		TC.setBounds(88, 583, 96, 19);
		contentPane.add(TC);
		TC.setColumns(10);
	}
}
