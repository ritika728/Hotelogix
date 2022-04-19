package hotelogix;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome frame = new welcome();
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
	public welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img= new ImageIcon(this.getClass().getResource("/welcome1.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		//lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DEEPAK\\Desktop\\welcome1.jpg"));
		lblNewLabel.setBounds(10, 10, 705, 295);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("WE  HOTELOGIX TEAM WELCOME YOU");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_2 lo = new login_2();
				dispose();
				lo.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		btnNewButton.setBounds(174, 339, 398, 28);
		contentPane.add(btnNewButton);
	}
}
