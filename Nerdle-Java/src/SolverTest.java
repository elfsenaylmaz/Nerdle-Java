import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class SolverTest {
	ArrayList<Integer> operands = new ArrayList<Integer>();
	ArrayList<Character> operators = new ArrayList<Character>();
	Solver solver = new Solver();
	@Test
	public void islemOnceligiTest() {						//Islem onceligi test ediliyor
		operands.clear();
		operators.clear();
		
		operands.add(10);				//10+5*2
		operands.add(5);
		operands.add(2);
		operators.add('+');
		operators.add('*');
		
		solver.setList(operands, operators);
		solver.calculate();
		assertEquals(20, solver.getResult());
	}
	
	
	
	

}
