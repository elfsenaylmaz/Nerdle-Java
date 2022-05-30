import java.io.Serializable;

import javax.swing.JTextField;

public class Statistics implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int abandonedCount;
	private int unsuccessfulCount;
	private int successfulCount;
	private int gameCount;
	private double avRowCount;
	private double avTimeInSec;
	private int secs;
	private int row;
	private boolean isContinue;
	private JTextField[][] txtMatris;
	private String equation;
	
	
	public Statistics() {
		abandonedCount = 0;
		unsuccessfulCount = 0;
		successfulCount = 0;
		gameCount = 0;
		secs = 0;
		row = 0;
		avRowCount = 0.0;
		avTimeInSec = 0.0;
		isContinue = false;
		txtMatris = null;
		equation = "";
	}

	
	

	public int getGameCount() {
		return gameCount;
	}




	public void setGameCount(int gameCount) {
		this.gameCount = gameCount;
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
