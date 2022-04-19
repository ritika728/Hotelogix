package hotelogix;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;

public class MAIN_FRAME extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAIN_FRAME frame = new MAIN_FRAME();
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
	public MAIN_FRAME() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//setUndecorated(true);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/reception.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		lblNewLabel.setBounds(58, 123, 800, 485);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FRONT DESK");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblNewLabel_1.setBounds(401, 10, 154, 30);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("NEW BOOKING");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booking book = new booking();
				book.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("MV Boli", Font.PLAIN, 16));
		btnNewButton.setBounds(84, 67, 156, 30);
		contentPane.add(btnNewButton);
		
		JButton btnCancelBooking = new JButton("CANCEL BOOKING");
		btnCancelBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				INFORMATION info = new INFORMATION();
				info.setVisible(true);
			}
		});
		btnCancelBooking.setFont(new Font("MV Boli", Font.PLAIN, 16));
		btnCancelBooking.setBounds(273, 67, 183, 30);
		contentPane.add(btnCancelBooking);
		
		JButton btnAboutUs = new JButton("ABOUT US");
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutus au = new aboutus();
				au.setVisible(true);
			}
		});
		btnAboutUs.setFont(new Font("MV Boli", Font.PLAIN, 16));
		btnAboutUs.setBounds(491, 67, 156, 30);
		contentPane.add(btnAboutUs);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogOut.setFont(new Font("MV Boli", Font.PLAIN, 16));
		btnLogOut.setBounds(683, 67, 156, 30);
		contentPane.add(btnLogOut);
		
		JLabel lblNewLabel_2 = new JLabel("ADMIN LOGIN");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				login_1 lo = new login_1();
				dispose();
				lo.setVisible(true);
				
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Image im= new ImageIcon(this.getClass().getResource("/adlogin.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(im));
	//	lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\DEEPAK\\Desktop\\adlogin.png"));
		lblNewLabel_2.setBounds(822, 10, 120, 23);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(832, 38, 110, 2);
		contentPane.add(separator);
	}
}
