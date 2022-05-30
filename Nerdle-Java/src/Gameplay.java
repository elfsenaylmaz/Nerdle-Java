import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Gameplay {
	
	private Generator generator;
	private Checker checker;
	private String equation;
	private String guessEquation;
	private JTextField[][] txtMatris;
	private int row, column;
	
	public Gameplay(String equation) {
		checker = new Checker();
		this.equation = equation;
		row = 0;
		column = 0;
	}
	
	public void generateEquation() {
		equation = generator.generateEquation();
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
					JOptionPane.showMessageDialog(null, "basaramadin oc!");			//ANA SAYFAYA DON
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "basardin oc!");			//ANA SAYFAYA DON
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, "gecersiz islem oc!");
		}
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
