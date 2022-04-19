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

public class DRINKS extends JFrame {

	private JPanel contentPane;
	private JTextField M;
	private JTextField A;
	private JTextField S;
	private JTextField P;
	private JTextField H;
	private JTextField TTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DRINKS frame = new DRINKS();
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
	public DRINKS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	    setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 473, 447);
		panel.setBackground(new Color(145, 61, 136));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(205, 66, 63, 48);
		Image img= new ImageIcon(this.getClass().getResource("/drinks.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Drinks");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(205, 124, 73, 13);
		panel.add(lblNewLabel_1);
		
		JCheckBox hot = new JCheckBox("Hot chocolate");
		hot.setForeground(Color.WHITE);
		hot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hot.setBounds(92, 295, 127, 21);
		hot.setBackground(new Color(145, 61, 136));
		panel.add(hot);
		
		JCheckBox moj = new JCheckBox("Mojito");
		moj.setForeground(Color.WHITE);
		moj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		moj.setBackground(new Color(145, 61, 136));
		moj.setBounds(92, 162, 93, 21);
		panel.add(moj);
		
		JCheckBox mar = new JCheckBox("Margarita");
		mar.setForeground(Color.WHITE);
		mar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mar.setBackground(new Color(145, 61, 136));
		mar.setBounds(92, 194, 93, 21);
		panel.add(mar);
		
		JCheckBox sea = new JCheckBox("Sea Breeze");
		sea.setForeground(Color.WHITE);
		sea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sea.setBackground(new Color(145, 61, 136));
		sea.setBounds(92, 228, 110, 21);
		panel.add(sea);
		
		JCheckBox pina = new JCheckBox("Pina Colada");
		pina.setForeground(Color.WHITE);
		pina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pina.setBackground(new Color(145, 61, 136));
		pina.setBounds(92, 261, 110, 21);
		panel.add(pina);
		
		M = new JTextField();
		M.setBounds(334, 165, 63, 19);
		panel.add(M);
		M.setColumns(10);
		
		A = new JTextField();
		A.setColumns(10);
		A.setBounds(334, 197, 63, 19);
		panel.add(A);
		
		S = new JTextField();
		S.setColumns(10);
		S.setBounds(334, 231, 63, 19);
		panel.add(S);
		
		P = new JTextField();
		P.setColumns(10);
		P.setBounds(334, 264, 63, 19);
		panel.add(P);
		
		H = new JTextField();
		H.setColumns(10);
		H.setBounds(334, 298, 63, 19);
		panel.add(H);
		
		TTF = new JTextField();
		TTF.setColumns(10);
		TTF.setBounds(245, 337, 119, 19);
		panel.add(TTF);
		
		JLabel lblNewLabel_2 = new JLabel("MOBILE NO.");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(125, 338, 110, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Qty");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(355, 134, 110, 21);
		panel.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("ORDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String m=TTF.getText();				
				int b=0;
				if(moj.isSelected()==true) {
					 	b=b + 100*(Integer.parseInt(M.getText()));
					}
				if(mar.isSelected()==true) {
						b=b + 175*(Integer.parseInt(A.getText()));
					}
				if(sea.isSelected()==true) {
						b=b + 70*(Integer.parseInt(S.getText()));
					}
				if(pina.isSelected()==true) {
						b=b +  100*(Integer.parseInt(P.getText()));
					}
				if(hot.isSelected()==true) {
					    b=b + 150*(Integer.parseInt(H.getText()));
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
				     int d=b+Integer.valueOf(ag);
				   				             
				     Statement stm= conn.createStatement();
	                 String que= "UPDATE hotel SET FOOD_CHARGES = "+d+" WHERE MOBILE_NO='"+m+"'";
	                 stm.executeUpdate(que);
	                 JOptionPane.showMessageDialog(null,"Your order has been placed");	
	          	    }catch(Exception e3) {
					      e3.printStackTrace();
				      }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(205, 376, 85, 21);
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
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(23, 23, 45, 13);
		panel.add(lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 40, 45, 2);
		panel.add(separator);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		Image mg= new ImageIcon(this.getClass().getResource("/d1.jpg")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(mg));
	//	lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\DEEPAK\\Desktop\\d1.jpg"));
		lblNewLabel_4.setBounds(480, 10, 334, 447);
		contentPane.add(lblNewLabel_4);
	}

}
