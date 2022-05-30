import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Gameplay {
	
	private Generator generator;
	private Checker checker;
	private String equation;
	private String guessEquation;
	private JTextField[][] txtMatris;
	private int row;
	private int secs;
	private boolean isGameOver;
	private FileOutputStream file;
	private ObjectOutputStream in;
	private Statistics statistics;
	
	public Gameplay(String equation, Statistics statistics) {
		checker = new Checker();
		this.equation = equation;
		row = 0;
		secs = 0;
		isGameOver = false;
		this.statistics = statistics;
		if(statistics.isContinue() == false)
			txtMatris = new JTextField[6][equation.length()];
		else
			txtMatris = statistics.getTxtMatris();
		try {
			file = new FileOutputStream("statistics.txt");
			in = new ObjectOutputStream(file);
		} catch (Exception e) {
			
		}
		
	}
	
	public void generateEquation() {
		equation = generator.generateEquation();
	}
	
	public int getSecs() {
		return secs;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public void setSecs(int secs) {
		this.secs = secs;
	}
	
	public void incrementSecs() {
		secs++;
	}
	
	public void sonraBitirButtonActivate() {
		statistics.setEquation(equation);
		statistics.setContinue(true);
		statistics.setSecs(secs);
		statistics.setTxtMatris(txtMatris);
		statistics.setRow(row);
		try {
			in.writeObject(statistics);
			MainScreen frame = new MainScreen();
			frame.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void inputButtonActivate(String buttonText) {
		for(int i = 0; i<equation.length(); ++i) {
			if(txtMatris[row][i].isFocusOwner()) {
				txtMatris[row][i].setText(buttonText);
				if(i != equation.length() - 1) {
					txtMatris[row][i+1].requestFocusInWindow();
				}
				return;
			}
		}
	}
	
	public void deleteButtonActivate() {
		for(int i = 0; i<equation.length(); ++i) {
			if(txtMatris[row][i].isFocusOwner()) {
				if(txtMatris[row][i].getText().compareTo("") != 0) {
					txtMatris[row][i].setText("");
				}
				else {
					if(i != 0) {
						txtMatris[row][i-1].requestFocusInWindow();
						txtMatris[row][i-1].setText("");
					}
				}
				return;
			}
		}
	}
	
	public void guessButtonActivate() {
		guessEquation = "";
		for(int i = 0; i<equation.length(); ++i) {
			guessEquation += txtMatris[row][i].getText();
		}
		if(equation.length() == guessEquation.length()) {
			checker.setEquation(guessEquation);
			System.out.println(equation);
			if(checker.check()) {
				/////////////////////////////////////////////////////TAHMİN DOĞRU RENKLENDİR
				if(!colorButtons()) {
					if(row != 5) {
						setEnableButtons();
						row++;
						txtMatris[row][0].requestFocusInWindow();
					}
					else {												//TAHMİN HAKKI BİTTİ
						isGameOver = true;
						statistics.setUnsuccessfulCount(statistics.getUnsuccessfulCount() + 1);
						statistics.setContinue(false);
						try {
							in.writeObject(statistics);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						try {
							LoseScreen loseFrame = new LoseScreen(equation);
							loseFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				else {
					statistics.setAvRowCount(calculateAvRowCount(row));
					statistics.setAvTimeInSec(calculateAvTimeInSec(secs));
					//BURDAN DEVAM
					statistics.setSuccessfulCount(statistics.getSuccessfulCount() + 1);
					statistics.setContinue(false);
					try {
						in.writeObject(statistics);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					isGameOver = true;			//ANA SAYFAYA DON
					try {
						WinScreen frame = new WinScreen(secs);
						frame.setVisible(true);
					} catch (Exception e) {
						//e.printStackTrace();
					}
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Gecersiz Islem!");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Gecersiz Islem!");
		}
		
	}
	
	public double calculateAvRowCount(int row) {
		double allRowCount = statistics.getAvRowCount() * statistics.getSuccessfulCount();
		return (allRowCount + (double)row) / (statistics.getSuccessfulCount() + 1);
	}
	
	public double calculateAvTimeInSec(int secs) {
		double allTime = statistics.getAvTimeInSec() * statistics.getSuccessfulCount();
		return (allTime + (double)secs) / (statistics.getSuccessfulCount() + 1);
	}
	
	public boolean isGameOver() {
		return isGameOver;
	}

	public void setEnableButtons() {
		for(JTextField text : txtMatris[row]) {
			text.setEnabled(false);
		}
		for(JTextField text : txtMatris[row + 1]) {
			text.setEnabled(true);
		}
	}
	
	public boolean colorButtons() {
		boolean[] control = new boolean[equation.length()];
		boolean[] isColored = new boolean[equation.length()];
		boolean isAllGreen = true;
		//boolean isColored;
		for(int i = 0; i<equation.length(); ++i) {
			control[i] = false;
			isColored[i] = false;
		}
		
		for(int i = 0; i<equation.length(); ++i) {
			if(equation.charAt(i) == guessEquation.charAt(i)) {
				txtMatris[row][i].setBackground(new Color(143, 188, 143));				//yeşil
				control[i] = true;
				isColored[i] = true;
			}
		}
		for(int i = 0; i<equation.length(); ++i) {
			int j = 0;
		
			while(j < equation.length() && !isColored[i]) {
				if(j != i && control[j] == false) {
					if(equation.charAt(j) == guessEquation.charAt(i)) {
						txtMatris[row][i].setBackground(new Color(240, 230, 140));			//sari
						control[j] = true;
						isColored[i] = true;
						isAllGreen = false;
					}
				}
				j++;
			}
			if(isColored[i] == false) {
				txtMatris[row][i].setBackground(new Color(255, 99, 71));					//kirmizi
				isColored[i] = true;
				isAllGreen = false;
			}
			
		}
		return isAllGreen;
	}
	
	public String getEquation() {
		return equation;
	}
	
	public void setTxtMatris(JTextField[][] txtMatris) {
		this.txtMatris = txtMatris;
	}
}
