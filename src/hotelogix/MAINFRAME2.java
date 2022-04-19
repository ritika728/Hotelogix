package hotelogix;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MAINFRAME2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAINFRAME2 frame = new MAINFRAME2();
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
	public MAINFRAME2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img= new ImageIcon(this.getClass().getResource("/reception.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(49, 154, 767, 382);
		contentPane.add(lblNewLabel);
		
		JButton btnFoodService = new JButton("FOOD SERVICE");
		btnFoodService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MENU me = new MENU();
			dispose();
			me.setVisible(true);
			}
			
		});
		btnFoodService.setFont(new Font("MV Boli", Font.PLAIN, 16));
		btnFoodService.setBounds(447, 74, 190, 30);
		contentPane.add(btnFoodService);
		
		JButton btnRoomStatus = new JButton("ROOM STATUS");
		btnRoomStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ROOMSTATUS rs = new ROOMSTATUS();
				dispose();
				rs.setVisible(true);
			}
		});
		btnRoomStatus.setFont(new Font("MV Boli", Font.PLAIN, 16));
		btnRoomStatus.setBounds(243, 74, 179, 30);
		contentPane.add(btnRoomStatus);
		
		JButton btnCustomerData = new JButton("CUSTOMER DATA");
		btnCustomerData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerdata cs = new customerdata();
				dispose();
				cs.setVisible(true);
			}
		});
		btnCustomerData.setFont(new Font("MV Boli", Font.PLAIN, 16));
		btnCustomerData.setBounds(29, 74, 190, 30);
		contentPane.add(btnCustomerData);
		
		JButton btnCheckOut = new JButton("CHECK OUT");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DELETE de = new DELETE();
				dispose();
				de.setVisible(true);
			}
		});
		btnCheckOut.setFont(new Font("MV Boli", Font.PLAIN, 16));
		btnCheckOut.setBounds(662, 74, 179, 30);
		contentPane.add(btnCheckOut);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MAIN_FRAME mf = new MAIN_FRAME();
				dispose();
				mf.setVisible(true);
			}
		});
		btnLogOut.setFont(new Font("MV Boli", Font.PLAIN, 16));
		btnLogOut.setBounds(350, 114, 179, 30);
		contentPane.add(btnLogOut);
		
		JLabel lblNewLabel_1 = new JLabel("FRONT DESK");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblNewLabel_1.setBounds(350, 10, 154, 30);
		contentPane.add(lblNewLabel_1);
	}
}
