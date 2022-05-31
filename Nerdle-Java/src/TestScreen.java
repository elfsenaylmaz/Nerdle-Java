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
import java.awt.Color;

public class TestScreen extends JFrame {
	private JPanel contentPane;
	private Generator generator;
	private String equation;
	public TestScreen() {
		setResizable(false);
		
		generator = new Generator();
		equation = generator.generateEquation();
		
		setTitle("nerdle");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TestScreen.class.getResource("/icons/calculator (1).png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("6 – 19011040 Engin Memiş – 20011040 Elif Sena Yılmaz");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(10, 240, 294, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel equationLabel = new JLabel(equation);
		equationLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
		equationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		equationLabel.setBounds(82, 41, 273, 39);
		contentPane.add(equationLabel);
		
		JLabel digitLabel = new JLabel(equation.length() + " Digits");
		digitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		digitLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		digitLabel.setBounds(82, 80, 273, 25);
		contentPane.add(digitLabel);
		
		JButton btnNewButton = new JButton(" GENERATE AGAIN");
		btnNewButton.setBackground(new Color(153, 204, 204));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equation = generator.generateEquation();
				equationLabel.setText(equation);
				digitLabel.setText(equation.length() + " Digits");			
			}
		});
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnNewButton.setBounds(137, 120, 155, 39);
		contentPane.add(btnNewButton);
		
		JButton mainScreenButton = new JButton("  MAIN SCREEN");
		mainScreenButton.setBackground(new Color(153, 204, 153));
		mainScreenButton.setHorizontalAlignment(SwingConstants.LEADING);
		mainScreenButton.setFont(new Font("Century Gothic", Font.BOLD, 13));
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
		mainScreenButton.setIcon(new ImageIcon(TestScreen.class.getResource("/icons/home (1).png")));
		mainScreenButton.setBounds(137, 169, 155, 39);
		contentPane.add(mainScreenButton);
	}
}
