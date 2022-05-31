import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GenerateEquationTests {

	Generator generator = new Generator();
	
	@Test
	void doesEquationContainsEqual() {
		assertEquals(true, generator.generateEquation().contains("="));
	}
	
	@Test
	void isLengthOfEquationValid() {
		String equation = generator.generateEquation();
		assertEquals(true, (equation.length() == 7 || equation.length() == 8 || equation.length() == 9));
	}
	
	@Test
	void doesContainTwoOperatorsBackToBack() {
		String equation = generator.generateEquation();
		assertEquals(false, (equation.contains("++") || equation.contains("--") || equation.contains("**") || equation.contains("//")));
	}
	
	@Test
	void doesContainAtLeastOneOperator() {
		String equation = generator.generateEquation();
		assertEquals(true, (equation.contains("+") || equation.contains("-") || equation.contains("*") || equation.contains("/")));
	}
	
	@Test
	void isThereAnyOperatorAfterEquals() {
		String equation = generator.generateEquation();
		String afterEqual = equation.split("=")[1];
		assertEquals(false, (afterEqual.contains("+") || afterEqual.contains("-") || afterEqual.contains("*") || afterEqual.contains("/")));
	
	}
	
}
