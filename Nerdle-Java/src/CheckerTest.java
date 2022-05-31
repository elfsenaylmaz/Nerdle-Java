import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckerTest {
	Checker checker = new Checker();
	@Test
	void isEquationResultCorrect() {
		checker.setEquation("24+2*3=30");
		assertEquals(true, checker.check());
	}

}
