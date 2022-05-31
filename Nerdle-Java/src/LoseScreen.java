
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class LoseScreen extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public LoseScreen(String equation) {
		setResizable(false);
		setTitle("nerdle");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoseScreen.class.getResource("/icons/calculator (1).png")));
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
		
		JLabel lblNewLabel = new JLabel("YOU LOST!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel.setBounds(139, 55, 154, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("CORRECT EQUATION: " +equation);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 108, 416, 30);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton(" MAIN SCREEN");
		btnNewButton_1.setIcon(new ImageIcon(LoseScreen.class.getResource("/icons/home (1).png")));
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(153, 204, 204));
		btnNewButton_1.setBounds(139, 167, 155, 43);
		contentPane.add(btnNewButton_1);
	}
}
