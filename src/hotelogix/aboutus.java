package hotelogix;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class aboutus extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aboutus frame = new aboutus();
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
	public aboutus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				MAIN_FRAME mf = new MAIN_FRAME();
				dispose();
				mf.setVisible(true);
				
			}
		});
		Image img= new ImageIcon(this.getClass().getResource("/HOTEL.JPG")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		lblNewLabel.setBounds(10, 52, 306, 388);
		contentPane.add(lblNewLabel);
		
		JTextArea txtrOppositeBataChowk = new JTextArea();
		txtrOppositeBataChowk.setEditable(false);
		txtrOppositeBataChowk.setText("Opposite Bata Chowk metro station and near 3 shopping \r\nmalls, this chic, contemporary hotel is 2 km from the \r\nTown Park and 19 km from the ruins of the Tughlakabad\r\n Fort.\r\nSlick rooms feature free Wi-Fi, satellite TV, minibars, and\r\ntea and coffeemaking facilities. Upgraded rooms add \r\naccess to a private lounge that hosts happy hours. Suites\r\n have living rooms. Kids stay at no charge with an adult.\r\n Room service is available 24/7.\r\nA breakfast buffet is complimentary. There are also \r\n 2 bars, plus a tea lounge. Other amenities include a spa, \r\na gym, and an outdoor pool with a kids' section. \r\nA ballroom is on-site.\r\n\r\nAddress & contact information\r\nSector 20-B, New Industrial Town, Faridabad, Haryana 121001\r\n \r\nPhone no.: 0129 275 6496");
		txtrOppositeBataChowk.setBounds(321, 52, 486, 409);
		contentPane.add(txtrOppositeBataChowk);
		
		JLabel lblNewLabel_1 = new JLabel("ABOUT US");
		lblNewLabel_1.setFont(new Font("Algerian", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(340, 10, 98, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("BACK");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				MAIN_FRAME mf= new MAIN_FRAME();
				dispose();
				mf.setVisible(true);
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(10, 16, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 31, 45, 2);
		contentPane.add(separator);
	}
}
