package hotelogix;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class booking extends JFrame {

	private JPanel contentPane;
	private JTextField NT;
	private JTextField ET;
	private JTextField MO;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField RT;
	private JTextField ND;
	private JTextField IN;
	private JTextField TR;
	public JTextField RN;
	private JTextField date;
	private JTextField year;
	private JTextField date2;
	private JTextField year2;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					booking frame = new booking();
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
	
	public booking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CUSTOMER DETAILS", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.setBounds(38, 54, 782, 153);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Lucida Bright", Font.BOLD, 16));
		lblNewLabel.setBounds(67, 42, 55, 23);
		panel.add(lblNewLabel);
		
		JLabel lblMobileNo = new JLabel("MOBILE NO.");
		lblMobileNo.setFont(new Font("Lucida Bright", Font.BOLD, 16));
		lblMobileNo.setBounds(411, 92, 104, 27);
		panel.add(lblMobileNo);
		
		JLabel lblAge = new JLabel("E-MAIL");
		lblAge.setFont(new Font("Lucida Bright", Font.BOLD, 16));
		lblAge.setBounds(67, 92, 64, 27);
		panel.add(lblAge);
		
		NT = new JTextField();
		NT.setBounds(154, 42, 170, 28);
		panel.add(NT);
		NT.setColumns(10);
		
		ET = new JTextField();
		ET.setColumns(10);
		ET.setBounds(154, 94, 200, 28);
		panel.add(ET);
		
		MO = new JTextField();
		MO.setColumns(10);
		MO.setBounds(538, 94, 157, 28);
		panel.add(MO);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "GENDER", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(411, 30, 274, 46);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton ma = new JRadioButton("MALE");
		buttonGroup.add(ma);
		ma.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		ma.setBounds(43, 19, 69, 21);
		panel_2.add(ma);
		
		JRadioButton fe = new JRadioButton("FEMALE");
		buttonGroup.add(fe);
		fe.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		fe.setBounds(146, 19, 86, 21);
		panel_2.add(fe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240,240,240));
		panel_1.setBorder(new TitledBorder(null, "BOOKING DETAILS", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		panel_1.setLayout(null);
		panel_1.setBounds(38, 224, 782, 252);
		contentPane.add(panel_1);
		
		JLabel lblRoomType = new JLabel("ROOM TYPE");
		lblRoomType.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblRoomType.setBounds(30, 34, 102, 23);
		panel_1.add(lblRoomType);
		
		JRadioButton N = new JRadioButton("Non-AC Room ");
		buttonGroup_1.add(N);
		N.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		N.setBounds(138, 36, 130, 21);
		panel_1.add(N);
		
		JRadioButton A = new JRadioButton("AC Room ");
		buttonGroup_1.add(A);
		A.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		A.setBounds(270, 36, 87, 21);
		panel_1.add(A);
		
		JRadioButton D = new JRadioButton("Deluxe Room");
		buttonGroup_1.add(D);
		D.setFont(new Font("Lucida Bright", Font.BOLD, 12));
		D.setBounds(373, 36, 130, 21);
		panel_1.add(D);
		
		JLabel lblNoOfRooms = new JLabel("NO. OF ROOMS");
		lblNoOfRooms.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblNoOfRooms.setBounds(534, 34, 113, 23);
		panel_1.add(lblNoOfRooms);
		
		RT = new JTextField();
		RT.setColumns(10);
		RT.setBounds(657, 34, 82, 28);
		panel_1.add(RT);
		
		JLabel lblCheckinDate = new JLabel(" CHECK-IN DATE");
		lblCheckinDate.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblCheckinDate.setBounds(30, 79, 130, 32);
		panel_1.add(lblCheckinDate);
		
		JLabel lblCheckoutDate = new JLabel("CHECK-OUT DATE");
		lblCheckoutDate.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblCheckoutDate.setBounds(22, 116, 138, 32);
		panel_1.add(lblCheckoutDate);
		
		JLabel lblNoOfDays = new JLabel("NO. OF DAYS");
		lblNoOfDays.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblNoOfDays.setBounds(395, 116, 113, 32);
		panel_1.add(lblNoOfDays);
		
		ND = new JTextField();
		ND.setColumns(10);
		ND.setBounds(521, 121, 147, 28);
		panel_1.add(ND);
		
		JLabel lblIdProof = new JLabel(" ID PROOF");
		lblIdProof.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblIdProof.setBounds(78, 158, 82, 32);
		panel_1.add(lblIdProof);
		
		JComboBox IP = new JComboBox();
		IP.setModel(new DefaultComboBoxModel(new String[] {"", "PASSPORT", "AADHAR CARD", "DRIVING LICENSE", "OTHER"}));
		IP.setBounds(183, 166, 147, 24);
		panel_1.add(IP);
		
		JLabel lblIdNumber = new JLabel(" ID NUMBER");
		lblIdNumber.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblIdNumber.setBounds(395, 158, 102, 32);
		panel_1.add(lblIdNumber);
		
		IN = new JTextField();
		IN.setColumns(10);
		IN.setBounds(521, 163, 147, 28);
		panel_1.add(IN);
		
		JLabel lblTotalRoomCharges = new JLabel("TOTAL ROOM CHARGES");
		lblTotalRoomCharges.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblTotalRoomCharges.setBounds(183, 210, 189, 32);
		panel_1.add(lblTotalRoomCharges);
		
		TR = new JTextField();
		TR.setEditable(false);
		TR.setColumns(10);
		TR.setBounds(394, 214, 151, 28);
		panel_1.add(TR);
		
		JLabel lblRoomNo = new JLabel("ROOM NO.");
		lblRoomNo.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblRoomNo.setBounds(395, 79, 113, 32);
		panel_1.add(lblRoomNo);
		
		JComboBox MON = new JComboBox();
		MON.setModel(new DefaultComboBoxModel(new String[] {"MONTH", "JAN", "FEB", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUG", "SEPT", "OCT", "NOV", "DEC"}));
		MON.setBounds(230, 86, 80, 23);
		panel_1.add(MON);
		
		date = new JTextField();
		date.setFont(new Font("Tahoma", Font.PLAIN, 10));
		date.setBounds(183, 84, 37, 23);
		panel_1.add(date);
		date.setColumns(10);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(320, 86, 37, 23);
		panel_1.add(year);
		
		JComboBox MON1 = new JComboBox();
		MON1.setModel(new DefaultComboBoxModel(new String[] {"MONTH", "JAN", "FEB ", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUG", "SEPT", "OCT", "NOV", "DEC"}));
		MON1.setBounds(230, 124, 80, 23);
		panel_1.add(MON1);
		
	 	RN = new JTextField();
		RN.setBounds(521, 84, 147, 28);
		panel_1.add(RN);
		RN.setColumns(10);
		
		date2 = new JTextField();
		date2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		date2.setColumns(10);
		date2.setBounds(183, 123, 37, 23);
		panel_1.add(date2);
		
		year2 = new JTextField();
		year2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		year2.setColumns(10);
		year2.setBounds(320, 123, 37, 23);
		panel_1.add(year2);
		
		JLabel lblNewLabel_3 = new JLabel("Select");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				roomselection rn =new roomselection();
				rn.setVisible(true);
				
					
				}
				
				
			
		});
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(673, 89, 45, 13);
		panel_1.add(lblNewLabel_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(673, 105, 45, 2);
		panel_1.add(separator_1);
		
		JButton btnNewButton = new JButton("CONFIRM BOOKING");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n=NT.getText(); 
				String t=ET.getText();  
				String i=MO.getText();  
				String h=null;  
				int b=0;
				if(N.isSelected()==true)
				{
					h="Non-AC";
					b=1000;
				}
				else if(A.isSelected()==true)
				{
					h="AC";
					b=1800;
				}
				else if(D.isSelected()==true)
				{
					h="Deluxe";
					b=2500;
				}
				int r=Integer.parseInt(RT.getText());  
			    String a= date.getText();
			    String c=year.getText();
			    String z=null;
			    if(MON.getSelectedIndex()==0){
			    	z =" JAN ";
			    }
			    else  if(MON.getSelectedIndex()==1){
			    	z =" FEB ";
			    }
			    else  if(MON.getSelectedIndex()==2){
			    	z =" MARCH ";
			    }
			    else  if(MON.getSelectedIndex()==3){
			    	z =" APRIL ";
			    }
			    else  if(MON.getSelectedIndex()==4){
			    	z =" MAY ";
			    }
			    else  if(MON.getSelectedIndex()==5){
			    	z =" JUNE ";
			    }
			    else  if(MON.getSelectedIndex()==6){
			    	z =" JULY ";
			    }
			    else  if(MON.getSelectedIndex()==7){
			    	z =" AUG ";
			    }
			    else  if(MON.getSelectedIndex()==8){
			    	z =" SEPT ";
			    }
			    else  if(MON.getSelectedIndex()==9){
			    	z =" OCT ";
			    }
			    else  if(MON.getSelectedIndex()==10){
			    	z =" NOV ";
			    }
			    else  if(MON.getSelectedIndex()==11){
			    	z =" DEC ";
			    }
			    String p=a.concat(z.concat(c));  			    
			    String x=RN.getText();
			    String u= date2.getText();
			    String v=year2.getText();
			    String w=null;
			    if(MON.getSelectedIndex()==0){
			    	w =" JAN ";
			    }
			    else  if(MON.getSelectedIndex()==1){
			    	w =" FEB ";
			    }
			    else  if(MON.getSelectedIndex()==2){
			    	w =" MARCH ";
			    }
			    else  if(MON.getSelectedIndex()==3){
			    	w =" APRIL ";
			    }
			    else  if(MON.getSelectedIndex()==4){
			    	w =" MAY ";
			    }
			    else  if(MON.getSelectedIndex()==5){
			    	w =" JUNE ";
			    }
			    else  if(MON.getSelectedIndex()==6){
			    	w =" JULY ";
			    }
			    else  if(MON.getSelectedIndex()==7){
			    	w =" AUG ";
			    }
			    else  if(MON.getSelectedIndex()==8){
			    	w =" SEPT ";
			    }
			    else  if(MON.getSelectedIndex()==9){
			    	w =" OCT ";
			    }
			    else  if(MON.getSelectedIndex()==10){
			    	w =" NOV ";
			    }
			    else  if(MON.getSelectedIndex()==11){
			    	w =" DEC ";
			    }
			    String o=u.concat(w .concat(v));
			   	int d=Integer.parseInt(ND.getText());  
			   	String j=null;                         
				if(IP.getSelectedIndex()==0) {
				     j="PASSPORT";	
				}
				else if(IP.getSelectedIndex()==1) {
				     j="AADHAR CARD";	
				}
				else if(IP.getSelectedIndex()==2) {
				     j="DRIVING LICENSE";	
				}
				else if(IP.getSelectedIndex()==3) {
				     j="OTHER";	
				}
				String g=IN.getText();
				int k=r*d*b; 
				int l=0;     
				TR.setText(Integer.toString(k));
				try {
					 Class.forName("com.ibm.db2.jcc.DB2Driver");
			         java.sql.Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/sakshi","db2admin","123456789");
                     Statement stmt= conn.createStatement();
                     String query ="insert into hotel values('"+n+ "','"+i+"','"+j+"','"+g+"','"+x+"','"+h+"',"+r+","+d+",'"+p+"','"+o+"',"+k+","+l+")";
                     stmt.executeUpdate(query);
         	      	 JOptionPane.showMessageDialog(null,"booking is successful");
                    }catch(Exception e1) {
		                 e1.printStackTrace();
	                 	}
				}
		});
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		btnNewButton.setBounds(316, 499, 202, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("HOTELOGIX");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		lblNewLabel_1.setBounds(377, 22, 141, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("BACK");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				MAIN_FRAME mf = new MAIN_FRAME();
				dispose();
				mf.setVisible(true);
				
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(792, 10, 54, 22);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(792, 30, 44, 7);
		contentPane.add(separator);
	}
}
