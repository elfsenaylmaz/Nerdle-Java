import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		try {
			MainScreen frame = new MainScreen();
			frame.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "An exception has ocurred while opening main screen!");
		}
	}
}
