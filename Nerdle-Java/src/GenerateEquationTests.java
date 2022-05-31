import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GenerateEquationTests {

	Generator generator = new Generator();
	
	@Test
	void doesEquationContainsEqual() {											//denklem eşittir içeriyor mu testi
		assertEquals(true, generator.generateEquation().contains("="));
	}
	
	@Test
	void isLengthOfEquationValid() {											//denklemin uzunluğu 7, 8 veya 9 mu testi
		String equation = generator.generateEquation();
		assertEquals(true, (equation.length() == 7 || equation.length() == 8 || equation.length() == 9));
	}
	
	@Test
	void doesContainTwoOperatorsBackToBack() {						//denklemde 2 tane operator yan yana geliyor mu testi
		String equation = generator.generateEquation();
		assertEquals(false, (equation.contains("++") || equation.contains("--") || equation.contains("**") || equation.contains("//")));
	}
	
	@Test
	void doesContainAtLeastOneOperator() {							//denklemde en az 1 tae operator var mı testi
		String equation = generator.generateEquation();
		assertEquals(true, (equation.contains("+") || equation.contains("-") || equation.contains("*") || equation.contains("/")));
	}
	
	@Test
	void isThereAnyOperatorAfterEquals() {							//denklemde eşittirden sonra operator var mı testi
		String equation = generator.generateEquation();
		String afterEqual = equation.split("=")[1];
		assertEquals(false, (afterEqual.contains("+") || afterEqual.contains("-") || afterEqual.contains("*") || afterEqual.contains("/")));
	
	}
	
}
