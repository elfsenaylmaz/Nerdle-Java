import java.util.ArrayList;
import java.util.Random;

public class Generator {
	private char[] operators = {'+', '-', '*', '/'};
	private Random random;
	private String equation;
	ArrayList<Integer> operandsList;
	ArrayList<Character> operatorsList;
	private Solver solver;
	
	public Generator() {
		random = new Random();
		operandsList = new ArrayList<Integer>();
		operatorsList = new ArrayList<Character>();
		solver = new Solver();
	}
	
	public void create7DigitString() {
		int operand, newOperand;
        char operator;
        int type;
        int numberOfOperator;
        
        operandsList.clear();
        operatorsList.clear();
        equation = "";
        
        type = random.nextInt(2);									// = sembolunun yerlesecegi kisimi secmek
        if(type == 0){
            numberOfOperator = random.nextInt(2);					// denklemde kac tane operator olacaginin secimi
            if(numberOfOperator == 1){								//2 operator olmasi durumu
                operand = random.nextInt(10);
                operandsList.add(operand);
                equation += operand;

                operator = operators[random.nextInt(4)];
                operatorsList.add(operator);
                equation += operator;
                if(operator == '/')
                    operand = random.nextInt(1,10);
                else
                    operand = random.nextInt(10);
                operandsList.add(operand);
                equation += operand;

                operator = operators[random.nextInt(4)];
                operatorsList.add(operator);
                equation += operator;
                if(operator == '/')
                    operand = random.nextInt(1,10);
                else
                    operand = random.nextInt(10);
                operandsList.add(operand);
                equation += operand;
            }
            else{																//tek operator olmasi durumu
                operand = random.nextInt(10,100);
                operandsList.add(operand);
                equation += operand;
                do {
                    operator = operators[random.nextInt(4)];
                }while (operator == '+' || operator == '*');
                operatorsList.add(operator);
                equation += operator;
                if(operator == '-')
                    operand = random.nextInt(operand - 9, operand + 1);
                else {
                	do {
                		newOperand = random.nextInt(10, operand + 1);
                	}while(operand % newOperand != 0);           
                	operand = newOperand;
                }                
                operandsList.add(operand);
                equation += operand;
            }
        }
        else{
            if(random.nextInt(2) == 0){
                operand = random.nextInt(10,100);
                operandsList.add(operand);
                equation += operand;
                operator = operators[random.nextInt(4)];
                operatorsList.add(operator);
                equation += operator;
                if(operator == '/') {
                	do {
                		newOperand = random.nextInt(1,10);
                	}while(operand % newOperand != 0);
                	operand = newOperand;
                }
                else
                    operand = random.nextInt(10);
                operandsList.add(operand);
                equation += operand;
            }
            else{
                operand = random.nextInt(10,100);
                operandsList.add(operand);
                equation += operand;
                do{
                    operator = operators[random.nextInt(4)];
                }while(operator == '-' || operator == '/');
                operatorsList.add(operator);
                equation += operator;
                if(operator == '/')
                    operand = random.nextInt(1,10);
                else
                    operand = random.nextInt(10);
                operandsList.add(operand);
                equation += operand;
            }
        }
        //return equation;
	}
	
	public String generate7DigitEquation() {
		int result;
		String newEquation;
		do {
			do {
				create7DigitString();
				solver.setList(operandsList, operatorsList);
			}while(!solver.calculate());
			result = solver.getResult();
			newEquation = equation;
			newEquation += '=';
			newEquation += result;
		}while(newEquation.length() != 7);
		equation = newEquation;
		return equation;
	}
	
	
	
}
