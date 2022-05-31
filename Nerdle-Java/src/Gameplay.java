import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
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
	}
	
	public void finishLaterButtonActivate() { 							//FinishLater butonuna basıldığında statistics objesinin içine mevcut oyun bilgileri set edilir.
		statistics.setEquation(equation);
		statistics.setContinue(true);
		statistics.setSecs(secs);
		statistics.setTxtMatris(txtMatris);
		statistics.setRow(row);
		try {
			file = new FileOutputStream("statistics.txt"); 				//statistics objesi dosyaya kaydedilir.
			in = new ObjectOutputStream(file);
			in.writeObject(statistics);
			file.close();
			in.close();
		} catch (IOException e) {  										//Dosya açılamadıysa kullanıcıya hata mesajı gösterilir.
			JOptionPane.showMessageDialog(null, "An IOException has "
					+ "occured while saving your last game!");
		}
		finally {
			MainScreen frame = new MainScreen(); 						//Ana menüye dönülür.
			frame.setVisible(true);
		}
	}
	
	public void inputButtonActivate(String buttonText) { 			//Sayı ya da işlem butonlarına basıldığında mevcut satırdaki focus sahibi textField bulunur.
		for(int i = 0; i<equation.length(); ++i) {
			if(txtMatris[row][i].isFocusOwner()) {
				txtMatris[row][i].setText(buttonText); 				//Focus sahibi fieldın içine butona karşılık gelen input yazılır.
				if(i != equation.length() - 1) { 					//Satırın sonundaki fieldda olmadığımız sürece focus, bir sonraki fielda verilir.
					txtMatris[row][i+1].requestFocusInWindow(); 	//Böylece arka arkaya butona tıklanınca tüm satır doldurulabilir.
				}
				return;
			}
		}
	}
	
	public void deleteButtonActivate() { 						     //Silme butonuna basıldığında satırdaki focus sahibi textField bulunur.
		for(int i = 0; i<equation.length(); ++i) {
			if(txtMatris[row][i].isFocusOwner()) {
				if(txtMatris[row][i].getText().compareTo("") != 0) { //field doluysa içindeki text silinir.
					txtMatris[row][i].setText("");
				}
				else { 												 //field boşsa ve birinci field değilse focus, mevcut fieldın solundaki fielda verilir ve solundaki field boşaltılır.
					if(i != 0) {
						txtMatris[row][i-1].requestFocusInWindow();  // Böylece arka arkaya butona tıklanınca tüm satır silinebilir.
						txtMatris[row][i-1].setText("");
					}
				}
				return;
			}
		}
	}
	
	public void guessButtonActivate() { 
		guessEquation = ""; 										// Guess butonuna basıldığında bulunduğumuz satırdaki textFieldların içinden yazılan değerler bu Stringe çekilir.
		for(int i = 0; i<equation.length(); ++i) { 
			guessEquation += txtMatris[row][i].getText();
		}
		if(equation.length() == guessEquation.length()) {			// Herhangi bir field boş bırakılmış mı diye kontrol edilir.
			checker.setEquation(guessEquation);
			if(checker.check()) { 									// Yazılan tahmin doğruysa bu ifin içine girlir ve textFieldların renklendirilmesi işlemi gerçekleştirilir.
				if(!colorButtons()) { 								//Renklendirilme metodu(satır 178) çağırılır, oyunun başarıyla tamamlandığına dair bir değer döner.
					if(row != 5) { 									//Son satırda olmadığımız sürece bir alt satır kullanılabilir hale getirilir ve focus yeni satırın ilk fieldına verilir.
						setEnableButtons();							//Bir sonraki satırın enable'ını açan metod(satır 169) açılır.
						row++;
						txtMatris[row][0].requestFocusInWindow();
					}
					else { 											// Son satırdaysak yani tahmin hakkımız bittiyse statistics objesi güncellenir, dosyaya kaydedilir, oyun biter.
						isGameOver = true;
						statistics.setUnsuccessfulCount(statistics.getUnsuccessfulCount() + 1);
						statistics.setContinue(false);				
						for(JTextField text : txtMatris[row]) { 
							text.setEnabled(false);
						}
						try {
							file = new FileOutputStream("statistics.txt");
							in = new ObjectOutputStream(file);
							in.writeObject(statistics);
							file.close();
							in.close();
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null, "An IOException has ocurred while updating your data!");
						}
						try {
							LoseScreen loseFrame = new LoseScreen(equation); 
							loseFrame.setVisible(true);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "An Exception has ocurred while opening lose screen!");
						}
					}
				}
				else {													// Yapılan tahmin doğruysa oyun başarıyla sonlanır, statistics objesi güncellenir, dosyaya kaydedilir.
					statistics.setAvRowCount(calculateAvRowCount(row));
					statistics.setAvTimeInSec(calculateAvTimeInSec(secs));
					statistics.setSuccessfulCount(statistics.getSuccessfulCount() + 1);
					statistics.setContinue(false);
					for(JTextField text : txtMatris[row]) {
						text.setEnabled(false);
					}
					try {
						file = new FileOutputStream("statistics.txt");
						in = new ObjectOutputStream(file);
						in.writeObject(statistics);
						file.close();
						in.close();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "An IOException has ocurred while updating your data!");
					}
					isGameOver = true;
					try {
						WinScreen frame = new WinScreen(secs);
						frame.setVisible(true);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "An Exception has ocurred while opening win screen!");
					}
				}
				
			}
			else { // Yapılan tahminin geçerli bir denklem olmadığına dair bilgi verilir.
				JOptionPane.showMessageDialog(null, "That guess doesn't compute!"); 
			}
		}
		else {     // Yapılan tahminin uzunluğu, doğru tahminin uzunluğundan küçükse boş fieldlar olduğuna dair bilgi verilir.
			JOptionPane.showMessageDialog(null, "Your guess is not complete - please fill in the blanks!");
		}
		
	}
	
	public double calculateAvRowCount(int row) {   // Oyun başarıyla sonuçlandığında ortalama satır sayısını güncelleyen metod
		double allRowCount = statistics.getAvRowCount() * statistics.getSuccessfulCount();
		return (allRowCount + (double)row) / (statistics.getSuccessfulCount() + 1);
	}
	
	public double calculateAvTimeInSec(int secs) { // Oyun başarıyla sonuçlandığında ortalama süreyi güncelleyen metod
		double allTime = statistics.getAvTimeInSec() * statistics.getSuccessfulCount();
		return (allTime + (double)secs) / (statistics.getSuccessfulCount() + 1);
	}
	
	public void setEnableButtons() {  				//Tahmin yapıldıktan sonra textFieldları enable eden metod
		for(JTextField text : txtMatris[row]) {
			text.setEnabled(false);
		}
		for(JTextField text : txtMatris[row + 1]) {
			text.setEnabled(true);
		}
	}
	
	public boolean colorButtons() {									// Yapılan tahmine göre tektFieldların rengini değiştiren metod
		boolean[] control = new boolean[equation.length()];			// Asıl equationda o karakter için bir fieldın boyanıp boyanmadığını tutan metod
		boolean[] isColored = new boolean[equation.length()];		// Tahmin equationında o karakterin boyanıp boyanmadığını tutan metod
		boolean isAllGreen = true;
		int j;
		for(int i = 0; i<equation.length(); ++i) {					// Initilaze
			control[i] = false;
			isColored[i] = false;
		}
		
		for(int i = 0; i<equation.length(); ++i) {					// Asıl tahminde doğru yerde bulunan fieldlar öncelikle yeşile boyanır.
			if(equation.charAt(i) == guessEquation.charAt(i)) {
				txtMatris[row][i].setBackground(new Color(143, 188, 143));
				control[i] = true;
				isColored[i] = true;
			}
		}
		for(int i = 0; i<equation.length(); ++i) {					
			j = 0;
			while(j < equation.length() && !isColored[i]) {						// Daha önceden boyanmadıysa
				if(j != i && control[j] == false) {								// O karakter için asıl equationda daha önce bir şey boyanmadıysa (2 tane 2 bulunması gibi durumlar için)
					if(equation.charAt(j) == guessEquation.charAt(i)) {			// O karakter asıl equation da herhangi bir yerde bulunuyorsa field sarıya boyanır
						txtMatris[row][i].setBackground(new Color(240, 230, 140));			
						control[j] = true;
						isColored[i] = true;
						isAllGreen = false;
					}
				}
				j++;
			}
			if(isColored[i] == false) {											//En son filed ne sarıya ne de yeşile boyanmadıysa asıl denklemde yoktur kırmızıya boyanır.
				txtMatris[row][i].setBackground(new Color(255, 99, 71));		
				isColored[i] = true;
				isAllGreen = false;
			}
			
		}
		return isAllGreen;
	}
	
	public boolean isGameOver() {
		return isGameOver;
	}
	
	public String getEquation() {
		return equation;
	}
	
	public void setTxtMatris(JTextField[][] txtMatris) {
		this.txtMatris = txtMatris;
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
}
