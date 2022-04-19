package hotelogix;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class roomselection extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField RN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					roomselection frame = new roomselection();
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
	public roomselection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 36, 699, 187);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ROOM NUMBER", "AVAILABILITY", "ROOM TYPE", "PRICE"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(91);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("CHECK ROOM STATUS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
		        try{
			    	 Class.forName("com.ibm.db2.jcc.DB2Driver");
				     java.sql.Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/sakshi","db2admin","123456789");
			         Statement stmt=conn.createStatement();
			         String query="Select ROOM_NUMBER,AVAILABILITY,ROOM_TYPE,PRICE from rooms";
			         ResultSet rs=stmt.executeQuery(query);
			         while(rs.next())
			         {
			             String na=rs.getString("ROOM_NUMBER");
			             String ag=rs.getString("AVAILABILITY");
			             String per=rs.getString("ROOM_TYPE");
			             String mo=rs.getString("PRICE");
			             model.addRow(new Object[]{na,ag,per,mo});
			         } 
			        }catch(Exception e2){
			           e2.printStackTrace();
			         }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(279, 247, 215, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ENTER ROOM NUMBER");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(132, 319, 199, 21);
		contentPane.add(lblNewLabel);
		
		RN = new JTextField();
		RN.setBounds(438, 323, 187, 19);
		contentPane.add(RN);
		RN.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("* Please note -In order for multiple selection write in the format  roomnumber1_roomnumber2_ .... and so on (for ex-101_102_103 _...).");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(40, 350, 699, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("CONFIRM SELECTION");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booking bo = new booking();
				bo.RN.setText(roomselection.this.RN.getText());
				bo.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(296, 392, 187, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblRoomSelection = new JLabel("ROOM SELECTION");
		lblRoomSelection.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRoomSelection.setBounds(279, 10, 199, 21);
		contentPane.add(lblRoomSelection);
	}
}
