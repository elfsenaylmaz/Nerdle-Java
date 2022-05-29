import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestScreen extends JFrame {
	private JPanel contentPane;
	private Generator generator;
	//kaldırılacak
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestScreen frame = new TestScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TestScreen() {
		
		generator = new Generator();
		
		setTitle("NERDLE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TestScreen.class.getResource("/icons/equals.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("6 – 19011040 Engin Memiş – 20011040 Elif Sena Yılmaz");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(10, 240, 294, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel equationLabel = new JLabel(generator.generateEquation());
		equationLabel.setFont(new Font("Century Gothic", Font.BOLD, 15));
		equationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		equationLabel.setBounds(85, 62, 273, 39);
		contentPane.add(equationLabel);
		
		JButton btnNewButton = new JButton("YENİDEN ÜRET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equationLabel.setText(generator.generateEquation());
			}
		});
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnNewButton.setBounds(152, 136, 140, 50);
		contentPane.add(btnNewButton);
		
		JButton mainScreenButton = new JButton("");
		mainScreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error!");
					//e1.printStackTrace();
				}
				dispose();
			}
		});
		mainScreenButton.setIcon(new ImageIcon(TestScreen.class.getResource("/icons/home.png")));
		mainScreenButton.setBounds(10, 10, 30, 30);
		contentPane.add(mainScreenButton);
		
		JLabel digitLabel = new JLabel("");
		digitLabel.setFont(new Font("Century Gothic", Font.BOLD, 15));
		digitLabel.setBounds(85, 101, 273, 25);
		contentPane.add(digitLabel);
		
	}

}
