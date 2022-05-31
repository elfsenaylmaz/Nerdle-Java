import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WinScreen extends JFrame {
	private Gameplay gameplay;
	private JPanel contentPane;
	
	public WinScreen(int secs) {
		String time = "";
		int minute, second;
		minute = secs / 60;
		second = secs % 60;
		if(minute < 10) {
			if(second < 10)
				time += "0" + minute + ":0" + second; 
			else
				time += "0" + minute + ":" + second; 
		}
		else {
			if(second < 10)
				time += minute + ":0" + second; 
			else
				time += minute + ":" + second;
		}
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(WinScreen.class.getResource("/icons/equals.png")));
		setTitle("NERDLE");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ANA SAYFA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.gc();
					for (Window window : Window.getWindows()) {
					    window.dispose();
					}
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} 
				catch (Exception ex) {
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(WinScreen.class.getResource("/icons/home (1).png")));
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnNewButton.setBounds(130, 159, 155, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("6 – 19011040 Engin Memiş – 20011040 Elif Sena Yılmaz");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(10, 240, 294, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("TEBRİKLER!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel.setBounds(130, 46, 155, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("DENKLEMİ BULMA SÜRENİZ: " + time);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblNewLabel_2.setBounds(72, 99, 286, 28);
		contentPane.add(lblNewLabel_2);
	}
}
