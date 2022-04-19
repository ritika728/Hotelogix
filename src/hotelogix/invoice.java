package hotelogix;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class invoice extends JFrame {

	private JPanel contentPane;
	private JTextField RT;
	private JTextField NR;
	private JTextField A1;
	private JTextField A2;
	private JTextField A3;
	private JTextField A4;
	private JTextField A5;
	private JTextField A6;
	private JTextField IN;
	private JTextField N;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					invoice frame = new invoice();
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
	Double a,b;
	public invoice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 590, 658);
		panel.setBackground(new Color(0,0,0,30));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOTELOGIX");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(247, 10, 96, 19);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BILL PAYMENT");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(223, 39, 154, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID NUMBER :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(53, 88, 110, 19);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("NAME :");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(53, 111, 110, 19);
		panel.add(lblNewLabel_2_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "FOR ROOM", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(20, 162, 534, 101);
		panel_1.setBackground(new Color(0,0,0,10));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("ROOM TYPE");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_2.setBounds(31, 21, 144, 19);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("AMOUNT");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_3.setBounds(401, 21, 110, 19);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("NO. OF ROOMS");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_4.setBounds(196, 21, 128, 19);
		panel_1.add(lblNewLabel_2_4);
		
		RT = new JTextField();
		RT.setEditable(false);
		RT.setBounds(10, 50, 138, 19);
	//	RT.setBackground(new Color(0,0,0,10));
		panel_1.add(RT);
		RT.setColumns(10);
		
		NR = new JTextField();
		NR.setEditable(false);
		NR.setColumns(10);
		//NR.setBackground(new Color(0, 0, 0, 10));
		NR.setBounds(186, 50, 138, 19);
		panel_1.add(NR);
		
		A1 = new JTextField();
		A1.setEditable(false);
		A1.setColumns(10);
		//A1.setBackground(new Color(0, 0, 0, 10));
		A1.setBounds(401, 50, 104, 19);
		panel_1.add(A1);
		
		JLabel lblNewLabel_2_5 = new JLabel("Rs.");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_5.setBounds(376, 50, 38, 19);
		panel_1.add(lblNewLabel_2_5);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "FOR FOOD", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBackground(new Color(0, 0, 0, 10));
		panel_1_1.setBounds(20, 273, 534, 101);
		panel.add(panel_1_1);
		
		A2 = new JTextField();
		A2.setEditable(false);
		A2.setColumns(10);
		//A2.setBackground(new Color(0, 0, 0, 10));
		A2.setBounds(401, 50, 104, 19);
		panel_1_1.add(A2);
		
		JLabel lblNewLabel_2_5_1 = new JLabel("Rs.");
		lblNewLabel_2_5_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_5_1.setBounds(376, 50, 38, 19);
		panel_1_1.add(lblNewLabel_2_5_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("FOOD CHARGES");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_2_1.setBounds(31, 50, 156, 19);
		panel_1_1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_6 = new JLabel("TOTAL AMOUNT");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_6.setBounds(53, 390, 139, 19);
		panel.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_5_1_1 = new JLabel("Rs.");
		lblNewLabel_2_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_5_1_1.setBounds(397, 390, 38, 19);
		panel.add(lblNewLabel_2_5_1_1);
		
		A3 = new JTextField();
		A3.setEditable(false);
		A3.setColumns(10);
		//A3.setBackground(new Color(0, 0, 0, 10));
		A3.setBounds(425, 387, 104, 19);
		panel.add(A3);
		
		JLabel lblNewLabel_2_6_1 = new JLabel("VAT(12.5%)");
		lblNewLabel_2_6_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_6_1.setBounds(53, 419, 110, 19);
		panel.add(lblNewLabel_2_6_1);
		
		JLabel lblNewLabel_2_5_1_1_1 = new JLabel("Rs.");
		lblNewLabel_2_5_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_5_1_1_1.setBounds(397, 419, 38, 19);
		panel.add(lblNewLabel_2_5_1_1_1);
		
		A4 = new JTextField();
		A4.setEditable(false);
		A4.setColumns(10);
		//A4.setBackground(new Color(0, 0, 0, 10));
		A4.setBounds(425, 419, 104, 19);
		panel.add(A4);
		
		JLabel lblNewLabel_2_6_2 = new JLabel("PAYMENT MODE");
		lblNewLabel_2_6_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_6_2.setBounds(53, 450, 139, 19);
		panel.add(lblNewLabel_2_6_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Cash", "Digital Banking", "Credit Card"}));
		comboBox.setBounds(189, 452, 130, 21);
		panel.add(comboBox);
		
		JLabel lblNewLabel_2_6_2_1 = new JLabel("AMOUNT PAID");
		lblNewLabel_2_6_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_6_2_1.setBounds(53, 483, 139, 19);
		panel.add(lblNewLabel_2_6_2_1);
		
		A5 = new JTextField();
		A5.setColumns(10);
		//A5.setBackground(new Color(0, 0, 0, 10));
		A5.setBounds(425, 483, 104, 19);
		panel.add(A5);
		
		JLabel lblNewLabel_2_5_1_1_1_1 = new JLabel("Rs.");
		lblNewLabel_2_5_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_5_1_1_1_1.setBounds(397, 483, 38, 19);
		panel.add(lblNewLabel_2_5_1_1_1_1);
		
		JLabel lblNewLabel_2_6_2_1_1 = new JLabel("CHANGE");
		lblNewLabel_2_6_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_6_2_1_1.setBounds(53, 512, 139, 19);
		panel.add(lblNewLabel_2_6_2_1_1);
		
		A6 = new JTextField();
		A6.setEditable(false);
		A6.setColumns(10);
	//	A6.setBackground(new Color(0, 0, 0, 10));
		A6.setBounds(425, 515, 104, 19);
		panel.add(A6);
		
		JLabel lblNewLabel_2_5_1_1_1_1_1 = new JLabel("Rs.");
		lblNewLabel_2_5_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_5_1_1_1_1_1.setBounds(397, 512, 38, 19);
		panel.add(lblNewLabel_2_5_1_1_1_1_1);
		
		IN = new JTextField();
		IN.setColumns(10);
	//	IN.setBackground(new Color(0, 0, 0, 10));
		IN.setBounds(226, 91, 138, 19);
		panel.add(IN);
		
		N = new JTextField();
		N.setEditable(false);
		N.setColumns(10);
//		N.setBackground(new Color(0, 0, 0, 10));
		N.setBounds(226, 114, 138, 19);
		panel.add(N);
		
		JButton btnNewButton = new JButton("CALCULATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Double c=Double.parseDouble(A5.getText());
	             Double d=c-b;
				 A6.setText(Double.toString(d));
			 }
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(236, 552, 130, 28);
	//	btnNewButton.setBackground(new Color(0,0,0,10));
		panel.add(btnNewButton);
		
		JCheckBox PS = new JCheckBox("Payment Successful");
		PS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PS.setBounds(53, 598, 173, 21);
	//	PS.setBackground(new Color(0,0,0,10));
		panel.add(PS);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String i =IN.getText();
				 try{
			    	 Class.forName("com.ibm.db2.jcc.DB2Driver");
				     java.sql.Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/sakshi","db2admin","123456789");
			         Statement stmt=conn.createStatement();
			         String query="Select NAME, R00M_TYPE,N0_OF_ROOMS,ROOM_CHARGES,FOOD_CHARGES from hotel WHERE ID_NUMBER ='"+i+"' ";
			         ResultSet rs=stmt.executeQuery(query);
			         while(rs.next())
			         {
			             String na=rs.getString("NAME");          
			             String ro=rs.getString("R00M_TYPE");
			             String roo=rs.getString("N0_OF_ROOMS");
			             String rc=rs.getString("ROOM_CHARGES");
			             String fc=rs.getString("FOOD_CHARGES");
			             N.setText(na);
			             RT.setText(ro);
			             NR.setText(roo);
			             A1.setText(rc);
			             A2.setText(fc);
			             a=Double.valueOf(rc)+Double.valueOf(fc);
			             b=0.125*a+a;
			             A3.setText(Double.toString(a));
			             A4.setText(Double.toString(b));
			         } 
			        }catch(Exception e3){
			         e3.printStackTrace();
			     }
			}
		});
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShow.setBounds(413, 90, 130, 28);
	//	btnShow.setBackground(new Color(0,0,0,10));
		panel.add(btnShow);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PS.isSelected()==true) {
				  DELETE de = new DELETE();
				  dispose();
	              de.setVisible(true);
			 	}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.setBounds(236, 620, 130, 28);
		panel.add(btnSubmit);
	}	
}
	
	
		
