import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameScreen extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameScreen frame = new GameScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public GameScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 71, 830, 310);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("timer ekle");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblNewLabel.setBounds(740, 22, 121, 39);
		contentPane.add(lblNewLabel);
		
		JButton button0 = new JButton("");
		button0.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button0.png")));
		button0.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button0Rollover.png")));
		button0.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button0Selected.png")));
		button0.setBounds(189, 473, 40, 50);
		contentPane.add(button0);
		
		JButton button1 = new JButton("");
		button1.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button1.png")));
		button1.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button1Rollover.png")));
		button1.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button1Selected.png")));
		button1.setBounds(239, 473, 40, 50);
		contentPane.add(button1);
		
		JButton button2 = new JButton("");
		button2.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button2.png")));
		button2.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button2Rollover.png")));
		button2.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button2Selected.png")));
		button2.setBounds(289, 473, 40, 50);
		contentPane.add(button2);
		
		JButton button3 = new JButton("");
		button3.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button3.png")));
		button3.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button3Rollover.png")));
		button3.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button3Selected.png")));
		button3.setBounds(339, 473, 40, 50);
		contentPane.add(button3);
		
		JButton button4 = new JButton("");
		button4.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button4.png")));
		button4.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button4Rollover.png")));
		button4.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button4Selected.png")));
		button4.setBounds(389, 473, 40, 50);
		contentPane.add(button4);
		
		JButton button5 = new JButton("");
		button5.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button5.png")));
		button5.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button5Rollover.png")));
		button5.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button5Selected.png")));
		button5.setBounds(439, 473, 40, 50);
		contentPane.add(button5);
		
		JButton button6 = new JButton("");
		button6.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button6.png")));
		button6.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button6Rollover.png")));
		button6.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button6Selected.png")));
		button6.setBounds(489, 473, 40, 50);
		contentPane.add(button6);
		
		JButton button7 = new JButton("");
		button7.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button7.png")));
		button7.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button7Rollover.png")));
		button7.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button7Selected.png")));
		button7.setBounds(539, 473, 40, 50);
		contentPane.add(button7);
		
		JButton button8 = new JButton("");
		button8.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button8.png")));
		button8.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button8Rollover.png")));
		button8.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button8Selected.png")));
		button8.setBounds(589, 473, 40, 50);
		contentPane.add(button8);
		
		JButton button9 = new JButton("");
		button9.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button9.png")));
		button9.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button9Rollover.png")));
		button9.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button9Selected.png")));
		button9.setBounds(639, 473, 40, 50);
		contentPane.add(button9);
		
		JLabel lblNewLabel_1 = new JLabel("6 – 19011040 Engin Memiş – 20011040 Elif Sena Yılmaz");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(10, 640, 294, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton plus = new JButton("");
		plus.setBounds(160, 533, 50, 50);
		contentPane.add(plus);
		
		JButton minus = new JButton("");
		minus.setBounds(220, 533, 50, 50);
		contentPane.add(minus);
		
		JButton multi = new JButton("");
		multi.setBounds(280, 533, 50, 50);
		contentPane.add(multi);
		
		JButton divide = new JButton("");
		divide.setBounds(340, 533, 50, 50);
		contentPane.add(divide);
		
		JButton equals = new JButton("");
		equals.setBounds(400, 533, 50, 50);
		contentPane.add(equals);
		
		JButton delete = new JButton("");
		delete.setBounds(460, 533, 75, 50);
		contentPane.add(delete);
		
		JButton tahminEt = new JButton("");
		tahminEt.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/tahminEt.png")));
		tahminEt.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/tahminEtRollover.png")));
		tahminEt.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/tahminEtSelected.png")));
		tahminEt.setBounds(545, 533, 75, 50);
		contentPane.add(tahminEt);
		
		JButton sonraBitir = new JButton("");
		sonraBitir.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/sonraBitir.png")));
		sonraBitir.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/sonraBitirRollover.png")));
		sonraBitir.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/sonraBitirSelected.png")));
		sonraBitir.setBounds(630, 533, 75, 50);
		contentPane.add(sonraBitir);
		
	}
	
	public void create7DigitField() {
		
	}
}
