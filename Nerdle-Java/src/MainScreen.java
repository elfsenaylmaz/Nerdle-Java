import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	//kaldırılacak
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icons/equals.png")));
		setTitle("NERDLE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("6 – 19011040 Engin Memiş – 20011040 Elif Sena Yılmaz");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(10, 640, 294, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("nerdle");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblNewLabel.setBounds(375, 10, 128, 50);
		contentPane.add(lblNewLabel);
		
		JButton closeButton = new JButton("");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		closeButton.setIcon(new ImageIcon(MainScreen.class.getResource("/icons/close.png")));
		closeButton.setBackground(new Color(204, 0, 0));
		closeButton.setFont(new Font("Century Gothic", Font.BOLD, 10));
		closeButton.setBounds(846, 10, 30, 30);
		contentPane.add(closeButton);
		
		JLabel lblNewLabel_2 = new JLabel("YARIDA BIRAKILAN OYUN SAYISI:");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_2.setBounds(305, 154, 235, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("BAŞARISIZLIKLA SONUÇLANAN OYUN SAYISI:");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_3.setBounds(219, 184, 328, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("BAŞARIYLA TAMAMLANAN OYUN SAYISI:");
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_4.setBounds(250, 214, 294, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("TAMAMLANAN OYUNLARIN ORTALAMA SATIR SAYISI:");
		lblNewLabel_5.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_5.setBounds(165, 244, 378, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("TAMAMLANAN OYUNLARIN ORTALAMA SÜRESİ:");
		lblNewLabel_6.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_6.setBounds(205, 274, 338, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel yariOyun = new JLabel("");
		yariOyun.setFont(new Font("Century Gothic", Font.BOLD, 15));
		yariOyun.setBounds(550, 154, 105, 20);
		contentPane.add(yariOyun);
		
		JLabel basarisizOyun = new JLabel("");
		basarisizOyun.setFont(new Font("Century Gothic", Font.BOLD, 15));
		basarisizOyun.setBounds(550, 184, 105, 20);
		contentPane.add(basarisizOyun);
		
		JLabel basariliOyun = new JLabel("");
		basariliOyun.setFont(new Font("Century Gothic", Font.BOLD, 15));
		basariliOyun.setBounds(550, 214, 105, 20);
		contentPane.add(basariliOyun);
		
		JLabel satirOyun = new JLabel("");
		satirOyun.setFont(new Font("Century Gothic", Font.BOLD, 15));
		satirOyun.setBounds(550, 244, 105, 20);
		contentPane.add(satirOyun);
		
		JLabel sureOyun = new JLabel("");
		sureOyun.setFont(new Font("Century Gothic", Font.BOLD, 15));
		sureOyun.setBounds(550, 274, 105, 20);
		contentPane.add(sureOyun);
		
		JButton yeniButton = new JButton("YENİ OYUN");
		yeniButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
		yeniButton.setBounds(375, 377, 120, 50);
		contentPane.add(yeniButton);
		
		JButton devamButton = new JButton("DEVAM ET");
		devamButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
		devamButton.setBounds(375, 437, 120, 50);
		contentPane.add(devamButton);
		
		JButton testButton = new JButton("TEST");
		testButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TestScreen frame = new TestScreen();
					frame.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error!");
					//e1.printStackTrace();
				}
				dispose();
			}
		});
		testButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
		testButton.setBounds(375, 497, 120, 50);
		contentPane.add(testButton);
		
		JLabel lblNewLabel_7 = new JLabel("İSTATİSTİKLER");
		lblNewLabel_7.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_7.setBounds(375, 114, 128, 30);
		contentPane.add(lblNewLabel_7);
	}

}
