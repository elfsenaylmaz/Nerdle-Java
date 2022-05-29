
public class Gameplay {
	
	private Generator generator;
	private String equation;
	
	public Gameplay() {
		generator = new Generator();
	}
	
	public String generateEquation() {
		return generator.generateEquation();
	}
	
	public void newGame() {
		try {
			equation = generateEquation();
			GameScreen frame = new GameScreen(equation);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getEquation() {
		return equation;
	}
	
}
