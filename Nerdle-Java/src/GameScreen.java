import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class GameScreen extends JFrame {

	private Gameplay gameplay;
	private Generator generator;
	private String equation;
	private JPanel contentPane;
	private JTextField[][] txtMatris;
	private JPanel panel;
	
	public GameScreen() {
		//////////////////////////////////YENİ OYUN MU ESKİ OYUN MU PARAMETRE İLE KONTROL EDİLECEK
		generator = new Generator();
		equation = generator.generateEquation();
		gameplay = new Gameplay(equation);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameScreen.class.getResource("/icons/equals.png")));
		setTitle("NERDLE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(31, 71, 830, 428);
		contentPane.add(panel);
		panel.setLayout(null);
		
		if(equation.length() == 7) {
			create7DigitField();
		}
		else if(equation.length() == 8) {
			create8DigitField();
		}
		else {
			create9DigitField();
		}	
		
		gameplay.setTxtMatris(txtMatris);
		
		JLabel lblNewLabel = new JLabel("timer ekle");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblNewLabel.setBounds(740, 22, 121, 39);
		contentPane.add(lblNewLabel);
		
		JButton button0 = new JButton("");
		button0.setFocusable(false);
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.inputButtonActivate("0");
			}
		});
		button0.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button0.png")));
		button0.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button0Rollover.png")));
		button0.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button0Selected.png")));
		button0.setBounds(189, 509, 40, 50);
		contentPane.add(button0);
		
		JButton button1 = new JButton("");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.inputButtonActivate("1");
			}
		});
		button1.setFocusable(false);
		button1.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button1.png")));
		button1.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button1Rollover.png")));
		button1.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button1Selected.png")));
		button1.setBounds(239, 509, 40, 50);
		contentPane.add(button1);
		
		JButton button2 = new JButton("");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.inputButtonActivate("2");
			}
		});
		button2.setFocusable(false);
		button2.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button2.png")));
		button2.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button2Rollover.png")));
		button2.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button2Selected.png")));
		button2.setBounds(289, 509, 40, 50);
		contentPane.add(button2);
		
		JButton button3 = new JButton("");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.inputButtonActivate("3");
			}
		});
		button3.setFocusable(false);
		button3.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button3.png")));
		button3.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button3Rollover.png")));
		button3.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button3Selected.png")));
		button3.setBounds(339, 509, 40, 50);
		contentPane.add(button3);
		
		JButton button4 = new JButton("");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.inputButtonActivate("4");
			}
		});
		button4.setFocusable(false);
		button4.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button4.png")));
		button4.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button4Rollover.png")));
		button4.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button4Selected.png")));
		button4.setBounds(389, 509, 40, 50);
		contentPane.add(button4);
		
		JButton button5 = new JButton("");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.inputButtonActivate("5");
			}
		});
		button5.setFocusable(false);
		button5.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button5.png")));
		button5.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button5Rollover.png")));
		button5.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button5Selected.png")));
		button5.setBounds(439, 509, 40, 50);
		contentPane.add(button5);
		
		JButton button6 = new JButton("");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.inputButtonActivate("6");
			}
		});
		button6.setFocusable(false);
		button6.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button6.png")));
		button6.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button6Rollover.png")));
		button6.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button6Selected.png")));
		button6.setBounds(489, 509, 40, 50);
		contentPane.add(button6);
		
		JButton button7 = new JButton("");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.inputButtonActivate("7");
			}
		});
		button7.setFocusable(false);
		button7.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button7.png")));
		button7.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button7Rollover.png")));
		button7.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button7Selected.png")));
		button7.setBounds(539, 509, 40, 50);
		contentPane.add(button7);
		
		JButton button8 = new JButton("");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.inputButtonActivate("8");
			}
		});
		button8.setFocusable(false);
		button8.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button8.png")));
		button8.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button8Rollover.png")));
		button8.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button8Selected.png")));
		button8.setBounds(589, 509, 40, 50);
		contentPane.add(button8);
		
		JButton button9 = new JButton("");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.inputButtonActivate("9");
			}
		});
		button9.setFocusable(false);
		button9.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/button9.png")));
		button9.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/button9Rollover.png")));
		button9.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/button9Selected.png")));
		button9.setBounds(639, 509, 40, 50);
		contentPane.add(button9);
		
		JLabel lblNewLabel_1 = new JLabel("6 – 19011040 Engin Memiş – 20011040 Elif Sena Yılmaz");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(10, 640, 294, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton plus = new JButton("");
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.inputButtonActivate("+");
			}
		});
		plus.setFocusable(false);
		plus.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/plus.png")));
		plus.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/plusRollover.png")));
		plus.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/plusSelected.png")));
		plus.setBounds(160, 569, 50, 50);
		contentPane.add(plus);
		
		JButton minus = new JButton("");
		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.inputButtonActivate("-");
			}
		});
		minus.setFocusable(false);
		minus.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/minus.png")));
		minus.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/minusRollover.png")));
		minus.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/minusSelected.png")));
		minus.setBounds(220, 569, 50, 50);
		contentPane.add(minus);
		
		JButton multi = new JButton("");
		multi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.inputButtonActivate("*");
			}
		});
		multi.setFocusable(false);
		multi.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/multi.png")));
		multi.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/multiRollover.png")));
		multi.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/multiSelected.png")));
		multi.setBounds(280, 569, 50, 50);
		contentPane.add(multi);
		
		JButton divide = new JButton("");
		divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.inputButtonActivate("/");
			}
		});
		divide.setFocusable(false);
		divide.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/divide.png")));
		divide.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/divideRollover.png")));
		divide.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/divideSelected.png")));
		divide.setBounds(340, 569, 50, 50);
		contentPane.add(divide);
		
		JButton equals = new JButton("");
		equals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.inputButtonActivate("=");
			}
		});
		equals.setFocusable(false);
		equals.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/equals.png")));
		equals.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/equalsRollover.png")));
		equals.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/equalsSelected.png")));
		equals.setBounds(400, 569, 50, 50);
		contentPane.add(equals);
		
		JButton delete = new JButton("");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.deleteButtonActivate();
			}
		});
		delete.setFocusable(false);
		delete.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/delete.png")));
		delete.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/deleteRollover.png")));
		delete.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/deleteSelected.png")));
		delete.setBounds(460, 569, 75, 50);
		contentPane.add(delete);
		
		JButton tahminEt = new JButton("");
		tahminEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameplay.guessButtonActivate();
			}
		});
		tahminEt.setFocusable(false);
		tahminEt.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/tahminEt.png")));
		tahminEt.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/tahminEtRollover.png")));
		tahminEt.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/tahminEtSelected.png")));
		tahminEt.setBounds(545, 569, 75, 50);
		contentPane.add(tahminEt);
		
		JButton sonraBitir = new JButton("");
		sonraBitir.setFocusable(false);
		sonraBitir.setIcon(new ImageIcon(GameScreen.class.getResource("/icons/sonraBitir.png")));
		sonraBitir.setRolloverIcon(new ImageIcon(GameScreen.class.getResource("/icons/sonraBitirRollover.png")));
		sonraBitir.setPressedIcon(new ImageIcon(GameScreen.class.getResource("/icons/sonraBitirSelected.png")));
		sonraBitir.setBounds(630, 569, 75, 50);
		contentPane.add(sonraBitir);
	}
	
	public void create7DigitField() {
		txtMatris = new JTextField[6][7];
		for(int satir = 0; satir < 6; satir++) {
			for(int sutun = 0; sutun < 7; sutun++) {
				txtMatris[satir][sutun] = new JTextField("");
				txtMatris[satir][sutun].setBounds(163+70*sutun, 10+70*satir, 60, 60);
				txtMatris[satir][sutun].setHorizontalAlignment(SwingConstants.CENTER);
				txtMatris[satir][sutun].setFont(new Font("Century Gothic", Font.BOLD, 20));
				if(satir != 0)
					txtMatris[satir][sutun].setEnabled(false);
				panel.add(txtMatris[satir][sutun]);
			}
		}
	}
	
	public void create8DigitField() {
		txtMatris = new JTextField[6][8];
		for(int satir = 0; satir < 6; satir++) {
			for(int sutun = 0; sutun < 8; sutun++) {
				txtMatris[satir][sutun] = new JTextField("");
				txtMatris[satir][sutun].setBounds(130+70*sutun, 10+70*satir, 60, 60);
				txtMatris[satir][sutun].setHorizontalAlignment(SwingConstants.CENTER);
				txtMatris[satir][sutun].setFont(new Font("Century Gothic", Font.BOLD, 20));
				if(satir != 0)
					txtMatris[satir][sutun].setEnabled(false);
				panel.add(txtMatris[satir][sutun]);
			}
		}
	}
	
	public void create9DigitField() {
		txtMatris = new JTextField[6][9];
		for(int satir = 0; satir < 6; satir++) {
			for(int sutun = 0; sutun < 9; sutun++) {
				txtMatris[satir][sutun] = new JTextField("");
				txtMatris[satir][sutun].setBounds(95+70*sutun, 10+70*satir, 60, 60);
				txtMatris[satir][sutun].setHorizontalAlignment(SwingConstants.CENTER);
				txtMatris[satir][sutun].setFont(new Font("Century Gothic", Font.BOLD, 20));
				if(satir != 0)
					txtMatris[satir][sutun].setEnabled(false);
				panel.add(txtMatris[satir][sutun]);
			}
		}				
	}
	
	public String getEquation() {
		return equation;
	}
	
	public JTextField[][] getMatris() {
		return txtMatris;
	}
}
