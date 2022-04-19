package hotelogix;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class INFORMATION extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField MN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					INFORMATION frame = new INFORMATION();
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
	public INFORMATION() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("SHOW DETAILS");
		btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
			    try{
			    	 Class.forName("com.ibm.db2.jcc.DB2Driver");
				     java.sql.Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/sakshi","db2admin","123456789");
			         Statement stmt=conn.createStatement();
			         String query="Select NAME , MOBILE_NO,ROOM_NO,R00M_TYPE,ID_NUMBER,ROOM_CHARGES,FOOD_CHARGES from hotel";
			         ResultSet rs=stmt.executeQuery(query);
			         while(rs.next())
			         {
			          	 String na=rs.getString("NAME");
			             String ag=rs.getString("MOBILE_NO");			             
			             String mo=rs.getString("ROOM_NO");
			             String ro=rs.getString("R00M_TYPE");
			             String per=rs.getString("ID_NUMBER");
			             String rc=rs.getString("ROOM_CHARGES");
			             String fc=rs.getString("FOOD_CHARGES");
			             model.addRow(new Object[]{na,ag,mo,ro,per,rc,fc});
			        } 
			     }catch(Exception e3){
			         e3.printStackTrace();
			       }

			}
		});
		btnNewButton.setBounds(147, 325, 170, 42);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 48, 718, 165);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NAME", "MOBILE NUMBER", "ROOM NO.", "ROOM TYPE", "ID NUMBER", "ROOM CHARGES", "FOOD CHARGES"
			}
		));
		
		JButton btnDelete = new JButton("CANCEL BOOKING");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String m=MN.getText();
		        try{
		        	Class.forName("com.ibm.db2.jcc.DB2Driver");
				    java.sql.Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/sakshi","db2admin","123456789");
		            Statement stmt=conn.createStatement();
		            String query="Delete from hotel where mobile_no='"+m+"'";
		            stmt.executeUpdate(query);
		            JOptionPane.showMessageDialog(null,"booking is canceled");
		            }catch(Exception e4) {
		            	e4.printStackTrace();
		            }
			}
		});
		btnDelete.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 14));
		btnDelete.setBounds(415, 325, 209, 42);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("MOBILE NUMBER");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel.setBounds(203, 256, 119, 27);
		contentPane.add(lblNewLabel);
		
		MN = new JTextField();
		MN.setBounds(373, 258, 150, 27);
		contentPane.add(MN);
		MN.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("BACK");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				MAIN_FRAME mf = new MAIN_FRAME();
				dispose();
				mf.setVisible(true);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 10, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 30, 45, 5);
		contentPane.add(separator);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(5).setPreferredWidth(89);
		table.getColumnModel().getColumn(6).setPreferredWidth(85);
		
	}
}
