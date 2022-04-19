package hotelogix;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class customerdata extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerdata frame = new customerdata();
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
	public customerdata() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1055, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 1021, 292);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NAME", "MOBILE N0", "ID PROOF", "ID NUMBER", "ROOM NO.", "ROOM TYPE", "NO. OF ROOMS", "NO. OF DAYS", "CHECK-IN", "CHECK-OUT", "ROOM CHARGES", "FOOD CHARGES"
			}
		));
		table.getColumnModel().getColumn(6).setPreferredWidth(86);
		table.getColumnModel().getColumn(10).setPreferredWidth(93);
		table.getColumnModel().getColumn(11).setPreferredWidth(87);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("SHOW DETAILS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				 try{
			    	 Class.forName("com.ibm.db2.jcc.DB2Driver");
				     java.sql.Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/sakshi","db2admin","123456789");
			         Statement stmt=conn.createStatement();
			         String query="Select * from hotel";
			         ResultSet rs=stmt.executeQuery(query);
				     while(rs.next())
			         {      
			             String na=rs.getString("NAME");
			             String ag=rs.getString("MOBILE_NO");
			             String gen=rs.getString("ID_PROOF");
			             String per=rs.getString("ID_NUMBER");
			             String mo=rs.getString("ROOM_NO");
			             String ro=rs.getString("R00M_TYPE");
			             String roo=rs.getString("N0_OF_ROOMS");
			             String doc=rs.getString("NO_OF_DAYS");
			             String cin=rs.getString("CHECKIN");
			             String cout=rs.getString("CHECKOUT");
			             String rc=rs.getString("ROOM_CHARGES");
			             String fc=rs.getString("FOOD_CHARGES");
			             model.addRow(new Object[]{na,ag,gen,per,mo,ro,roo,doc,cin,cout,rc,fc});
			         } 
			       }catch(Exception e3){
			             e3.printStackTrace();
			            }

			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 24));
		btnNewButton.setBounds(399, 363, 223, 35);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("BACK");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				MAINFRAME2 mf = new MAINFRAME2();
				dispose();
				mf.setVisible(true);
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 9, 45, 13);
		contentPane.add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBounds(10, 25, 45, 13);
		contentPane.add(separator);
	}
}
