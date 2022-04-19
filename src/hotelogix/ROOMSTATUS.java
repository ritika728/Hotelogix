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

public class ROOMSTATUS extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ROOMSTATUS frame = new ROOMSTATUS();
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
	public ROOMSTATUS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 53, 664, 286);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ROOM NUMBER", "AVAILABILITY", "CLEAN STATUS", "ROOM TYPE", "PRICE"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(88);
		table.getColumnModel().getColumn(2).setPreferredWidth(86);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("CHECK ROOM STATUS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
			   try{
			    	 Class.forName("com.ibm.db2.jcc.DB2Driver");
				     java.sql.Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/sakshi","db2admin","123456789");
			         Statement stmt=conn.createStatement();
			         String query="Select *from rooms";
			         ResultSet rs=stmt.executeQuery(query);
			         while(rs.next())
			         {
			             String na=rs.getString("ROOM_NUMBER");
			             String ag=rs.getString("AVAILABILITY");
			             String gen=rs.getString("CLEAN_STATUS");
			             String per=rs.getString("ROOM_TYPE");
			             String mo=rs.getString("PRICE");
			             model.addRow(new Object[]{na,ag,gen,per,mo});
			         } 
			      }catch(Exception e2){
			           e2.printStackTrace();
			         }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(70, 374, 217, 31);
		contentPane.add(btnNewButton);
		
		JButton btnUpdateRoomStatus = new JButton("UPDATE ROOM STATUS");
		btnUpdateRoomStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateroom ur = new updateroom();
				dispose();
				ur.setVisible(true);
			}
		});
		btnUpdateRoomStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdateRoomStatus.setBounds(416, 374, 239, 31);
		contentPane.add(btnUpdateRoomStatus);
		
		JLabel lblNewLabel = new JLabel("BACK");
		lblNewLabel.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				MAINFRAME2 mf = new MAINFRAME2();
				dispose();
				mf.setVisible(true);
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 45, 13);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 28, 45, 2);
		contentPane.add(separator);
	}
}
