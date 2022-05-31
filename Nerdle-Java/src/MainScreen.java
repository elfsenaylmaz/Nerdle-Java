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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Statistics statistics;
	FileInputStream file;
	ObjectInputStream in;
	FileOutputStream fileInit;
	ObjectOutputStream inInit;
	private JTextField textField;


	public MainScreen() {
		setResizable(false);
		setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		try {
			file = new FileInputStream("statistics.txt");
			in = new ObjectInputStream(file);
			statistics = (Statistics)in.readObject();
			in.close();
			file.close();
		} catch (Exception e) {
			try {
				fileInit = new FileOutputStream("statistics.txt");
				inInit = new ObjectOutputStream(fileInit);
				statistics = new Statistics();
				inInit.writeObject(statistics);
				inInit.close();
				fileInit.close();
			}
			catch(Exception ex) {
				e.printStackTrace();
			}
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icons/calculator (1).png")));
		setTitle("nerdle");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(MainScreen.class.getResource("/icons/calculator (1).png")));
		lblNewLabel_1.setBounds(334, 33, 45, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("nerdle");
		lblNewLabel.setForeground(new Color(153, 102, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 45));
		lblNewLabel.setBounds(360, 23, 179, 50);
		contentPane.add(lblNewLabel);
		
		JButton closeButton = new JButton("");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		closeButton.setIcon(new ImageIcon(MainScreen.class.getResource("/icons/close.png")));
		closeButton.setBackground(new Color(204, 0, 0));
		closeButton.setFont(new Font("Century Gothic", Font.BOLD, 10));
		closeButton.setBounds(846, 10, 30, 30);
		contentPane.add(closeButton);
		
		JLabel lblNewLabel_2 = new JLabel("NUMBER OF ABANDONED GAMES:");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_2.setBounds(264, 154, 254, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NUMBER OF UNSUCCESSFUL GAMES:");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_3.setBounds(251, 184, 272, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NUMBER OF SUCCESSFUL GAMES:");
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_4.setBounds(273, 214, 247, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("AVERAGE NUMBER OF LINES OF SUCCESSFUL GAMES:");
		lblNewLabel_5.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_5.setBounds(132, 244, 387, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(" AVERAGE TIME OF SUCCESSFUL GAMES:");
		lblNewLabel_6.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_6.setBounds(224, 274, 294, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel yariOyun = new JLabel("" + statistics.getAbandonedCount());
		yariOyun.setFont(new Font("Century Gothic", Font.BOLD, 15));
		yariOyun.setBounds(526, 154, 105, 20);
		contentPane.add(yariOyun);
		
		JLabel basarisizOyun = new JLabel("" + statistics.getUnsuccessfulCount());
		basarisizOyun.setFont(new Font("Century Gothic", Font.BOLD, 15));
		basarisizOyun.setBounds(526, 184, 105, 20);
		contentPane.add(basarisizOyun);
		
		JLabel basariliOyun = new JLabel("" + statistics.getSuccessfulCount());
		basariliOyun.setFont(new Font("Century Gothic", Font.BOLD, 15));
		basariliOyun.setBounds(526, 214, 105, 20);
		contentPane.add(basariliOyun);
		
		String pattern = "#.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);

		String format = decimalFormat.format(statistics.getAvRowCount());
		
		JLabel satirOyun = new JLabel(format);
		satirOyun.setFont(new Font("Century Gothic", Font.BOLD, 15));
		satirOyun.setBounds(526, 244, 105, 20);
		contentPane.add(satirOyun);
		
		TimeZone tz = TimeZone.getTimeZone("UTC");
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		df.setTimeZone(tz);
		String time = df.format(new Date((int)statistics.getAvTimeInSec()*1000L));
		
		//JLabel sureOyun = new JLabel("" + statistics.getAvTimeInSec());
		JLabel sureOyun = new JLabel(time);
		sureOyun.setFont(new Font("Century Gothic", Font.BOLD, 15));
		sureOyun.setBounds(526, 274, 105, 20);
		contentPane.add(sureOyun);
		
		JButton yeniButton = new JButton("NEW GAME");
		yeniButton.setBackground(new Color(153, 204, 255));
		yeniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(statistics.isContinue())
						statistics.setAbandonedCount(statistics.getAbandonedCount() + 1);
					statistics.setContinue(false);				
					GameScreen frame = new GameScreen(statistics);
					frame.addWindowFocusListener(new WindowAdapter() {
					    public void windowGainedFocus(WindowEvent e) {
					        
					    }
					});
					
				
					frame.setVisible(true);
					dispose();
				} catch (Exception ex) {
					///////////////////////////////////////////////////////////////////////////////////////
				}
				
			}
		});
		yeniButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
		yeniButton.setBounds(375, 377, 120, 50);
		contentPane.add(yeniButton);
		
		JButton devamButton = new JButton("CONTINUE");
		devamButton.setBackground(new Color(153, 204, 204));
		devamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GameScreen frame = new GameScreen(statistics);
					frame.addWindowFocusListener(new WindowAdapter() {
					    public void windowGainedFocus(WindowEvent e) {
					        
					    }
					});
					frame.setVisible(true);
					dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		devamButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
		devamButton.setBounds(375, 437, 120, 50);
		if(!statistics.isContinue())
			devamButton.setEnabled(false);
		contentPane.add(devamButton);
		
		JButton testButton = new JButton("TEST");
		testButton.setBackground(new Color(153, 204, 153));
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
		
		JLabel lblNewLabel_7 = new JLabel("STATISTICS");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setIcon(new ImageIcon(MainScreen.class.getResource("/icons/stats.png")));
		lblNewLabel_7.setForeground(new Color(153, 153, 255));
		lblNewLabel_7.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_7.setBounds(347, 114, 179, 30);
		contentPane.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tw Cen MT", Font.ITALIC, 12));
		textField.setText("6 – 19011040 Engin Memiş – 20011040 Elif Sena Yılmaz");
		textField.setBounds(10, 634, 294, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MainScreen.class.getResource("/icons/background.jpg")));
		background.setBounds(0, 0, 900, 700);
		contentPane.add(background);
	}
}
