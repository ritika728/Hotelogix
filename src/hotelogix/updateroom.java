package hotelogix;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class updateroom extends JFrame {

	private JPanel contentPane;
	private JTextField R;
	private JTextField A;
	private JTextField C;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateroom frame = new updateroom();
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
	public updateroom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ROOM NUMBER");
		lblNewLabel.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 15));
		lblNewLabel.setBounds(85, 75, 149, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblAvailability = new JLabel("AVAILABILITY");
		lblAvailability.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 15));
		lblAvailability.setBounds(85, 112, 149, 19);
		contentPane.add(lblAvailability);
		
		JLabel lblCleanStatus = new JLabel("CLEAN STATUS");
		lblCleanStatus.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 15));
		lblCleanStatus.setBounds(85, 150, 149, 19);
		contentPane.add(lblCleanStatus);
		
		R = new JTextField();
		R.setBounds(299, 74, 114, 19);
		contentPane.add(R);
		R.setColumns(10);
		
		A = new JTextField();
		A.setColumns(10);
		A.setBounds(299, 111, 114, 19);
		contentPane.add(A);
		
		C = new JTextField();
		C.setColumns(10);
		C.setBounds(299, 149, 114, 19);
		contentPane.add(C);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(R.getText());
				String a=A.getText();
				String c=C.getText();
				try {
					 Class.forName("com.ibm.db2.jcc.DB2Driver");
				     java.sql.Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/sakshi","db2admin","123456789");
	                 Statement stmt= conn.createStatement();
	                 String query= "UPDATE ROOMS SET AVAILABILITY = '"+a+"',CLEAN_STATUS = '"+c+"' WHERE ROOM_NUMBER="+i+"";
	                 stmt.executeUpdate(query);
	                 JOptionPane.showMessageDialog(null,"Information is updated");	
	                }catch(Exception e2) {
					    e2.printStackTrace();
				         }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(196, 211, 104, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblRoomStatus = new JLabel("ROOM STATUS");
		lblRoomStatus.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 15));
		lblRoomStatus.setBounds(190, 24, 149, 19);
		contentPane.add(lblRoomStatus);
		
		JLabel lblNewLabel_1 = new JLabel("BACK");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
			ROOMSTATUS rs = new ROOMSTATUS();
			dispose();
			rs.setVisible(true);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 10, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 24, 36, 8);
		contentPane.add(separator);
	}
}
