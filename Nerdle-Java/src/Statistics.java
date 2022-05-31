import java.io.Serializable;

import javax.swing.JTextField;

public class Statistics implements Serializable{			//dosyada bu class yazdırılıp okunuyor
	private static final long serialVersionUID = 1L;
	
	private int abandonedCount;					//yarıda bırakılan oyun sayısı
	private int unsuccessfulCount;				//başarısız oyun sayısı
	private int successfulCount;				//başarılı oyun sayısı					
	private double avRowCount;					//oyunu ortalama kaç satırda bitirdiğinin sayısı
	private double avTimeInSec;					//oyunu ortalama kaç saniyede bitiriyor
	private int secs;							//yarıda oyun bırakılmışsa kaçıncı saniyede olduğunu tutan değişken
	private int row;							//yarıda oyun bırakıldıysa kaçıncı satırda olduğunu tutan değişken
	private boolean isContinue;					//yarıda oyun bırakılıp bırakılmadığını tutan değişken
	private JTextField[][] txtMatris;			//yarıda oyun bırakıldığında game ekranını tutan matris
	private String equation;					//yarıda oyun bırakıldığında oluşturulmuş olan denklemi tutan değişken
	
	
	public Statistics() {
		abandonedCount = 0;
		unsuccessfulCount = 0;
		successfulCount = 0;
		secs = 0;
		row = 0;
		avRowCount = 0.0;
		avTimeInSec = 0.0;
		isContinue = false;
		txtMatris = null;
		equation = "";
	}

	public int getSecs() {
		return secs;
	}

	public void setSecs(int secs) {
		this.secs = secs;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}



	public int getAbandonedCount() {
		return abandonedCount;
	}


	public int getUnsuccessfulCount() {
		return unsuccessfulCount;
	}


	public int getSuccessfulCount() {
		return successfulCount;
	}


	public double getAvRowCount() {
		return avRowCount;
	}


	public double getAvTimeInSec() {
		return avTimeInSec;
	}


	public boolean isContinue() {
		return isContinue;
	}


	public JTextField[][] getTxtMatris() {
		return txtMatris;
	}


	public String getEquation() {
		return equation;
	}


	public void setAbandonedCount(int abandonedCount) {
		this.abandonedCount = abandonedCount;
	}


	public void setUnsuccessfulCount(int unsuccessfulCount) {
		this.unsuccessfulCount = unsuccessfulCount;
	}


	public void setSuccessfulCount(int successfulCount) {
		this.successfulCount = successfulCount;
	}


	public void setAvRowCount(double avRowCount) {
		this.avRowCount = avRowCount;
	}


	public void setAvTimeInSec(double avTimeInSec) {
		this.avTimeInSec = avTimeInSec;
	}


	public void setContinue(boolean isContinue) {
		this.isContinue = isContinue;
	}


	public void setTxtMatris(JTextField[][] txtMatris) {
		this.txtMatris = txtMatris;
	}


	public void setEquation(String equation) {
		this.equation = equation;
	}
	
	
	
}
