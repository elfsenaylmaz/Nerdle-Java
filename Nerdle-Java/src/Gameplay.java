import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
		if(checker.check()) {
			/////////////////////////////////////////////////////TAHMİN DOĞRU RENKLENDİR
		}
		else {
			/////////////////////////////////////////////////////TAHMİN YANLIŞ POP-UP FİLAN AYARLA BİR ŞEYLER
		}
	}
	
	public String getEquation() {
		return equation;
	}
	
	public void setTxtMatris(JTextField[][] txtMatris) {
		this.txtMatris = txtMatris;
	}
}
