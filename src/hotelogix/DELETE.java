package hotelogix;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DELETE extends JFrame {

	private JPanel contentPane;
	private JTextField IN;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DELETE frame = new DELETE();
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
	public DELETE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID NUMBER");
		lblNewLabel_1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 19));
		lblNewLabel_1.setBounds(153, 243, 121, 24);
		contentPane.add(lblNewLabel_1);
		
		IN = new JTextField();
		IN.setBounds(352, 245, 148, 24);
		contentPane.add(IN);
		IN.setColumns(10);
		
		JButton btnNewButton = new JButton("SHOW");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				try{
					 Class.forName("com.ibm.db2.jcc.DB2Driver");
				     java.sql.Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/sakshi","db2admin","123456789");
				     Statement stmt=conn.createStatement();
				     String query="Select name,mobile_no,id_number from hotel";
				     ResultSet rs=stmt.executeQuery(query);
				     while(rs.next())
				     {
				        String na=rs.getString("NAME");
				        String ro=rs.getString("mobile_no");
				        String gen =rs.getString("id_number");
				        model.addRow(new Object[]{na,ro,gen});
				     }
				    }catch(Exception e1){
				      	e1.printStackTrace();
				    }
			}
		});
		btnNewButton.setFont(new Font("Algerian", Font.PLAIN, 17));
		btnNewButton.setBounds(267, 201, 85, 24);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("CHECK OUT");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		     	String m=IN.getText();
		        try{
		        	Class.forName("com.ibm.db2.jcc.DB2Driver");
				    java.sql.Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/sakshi","db2admin","123456789");
		            Statement stmt=conn.createStatement();
		            String query="Delete from hotel where ID_NUMBER='"+m+"'";
		            stmt.executeUpdate(query);
		            JOptionPane.showMessageDialog(null,"you have been successfully checked out");
		            stmt.close();
		           }catch(Exception e3) {
			          e3.printStackTrace();
			         }
			}
		});
		btnDelete.setFont(new Font("Algerian", Font.PLAIN, 21));
		btnDelete.setBounds(364, 312, 148, 33);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 47, 571, 133);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NAME", "MOBILE NUMBER", "ID NUMBER"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("BACK");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				MAINFRAME2 mf = new MAINFRAME2();
				dispose();
				mf.setVisible(true);
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(593, 10, 45, 13);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(593, 25, 45, 2);
		contentPane.add(separator);
		
		JButton btnReceipt = new JButton("RECEIPT");
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoice in = new invoice();
				dispose();
				in.setVisible(true);
				}
		});
		btnReceipt.setFont(new Font("Algerian", Font.PLAIN, 21));
		btnReceipt.setBounds(139, 312, 148, 33);
		contentPane.add(btnReceipt);
	}
}
