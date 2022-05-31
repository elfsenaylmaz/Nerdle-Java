import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckerTest {
	Checker checker = new Checker();
	@Test
	void isEquationResultCorrectTest1() {
		checker.setEquation("24+2*3=30");
		assertEquals(true, checker.check());
	}
	
	@Test
	void isEquationResultCorrectTest2() {
		checker.setEquation("12+4/0=12");
		assertEquals(false, checker.check());
	}
	
	

}
