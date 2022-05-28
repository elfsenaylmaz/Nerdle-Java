import java.util.Random;

public class Generator {
	private char[] operators = {'+', '-', '*', '/'};
	private Random random;
	private String equation = "";
	
	public Generator() {
		random = new Random();
	}
	
	public String generate7DigitEquation() {
		int operand;
        char operator;
        int type;
        int numberOfOperator;
        type = random.nextInt(2);									// = sembolunun yerlesecegi kisimi secmek
        if(type == 0){
            numberOfOperator = random.nextInt(2);					// denklemde kac tane operator olacaginin secimi
            if(numberOfOperator == 1){								//2 operator olmasi durumu
                operand = random.nextInt(10);
                equation += operand;

                operator = operators[random.nextInt(4)];
                equation += operator;
                if(operator == '/')
                    operand = random.nextInt(1,10);
                else
                    operand = random.nextInt(10);
                equation += operand;

                operator = operators[random.nextInt(4)];
                equation += operator;
                if(operator == '/')
                    operand = random.nextInt(1,10);
                else
                    operand = random.nextInt(10);
                equation += operand;
            }
            else{																//tek operator olmasi durumu
                operand = random.nextInt(10,100);
                equation += operand;
                do {
                    operator = operators[random.nextInt(4)];
                }while (operator == '+' || operator == '*');
                equation += operator;
                if(operator == '-')
                    equation += random.nextInt(operand - 9,operand + 1);
                else
                    equation += random.nextInt(10,100);
            }
        }
        else{
            if(random.nextInt(2) == 0){
                operand = random.nextInt(10,100);
                equation += operand;
                operator = operators[random.nextInt(4)];
                equation += operator;
                if(operator == '/')
                    operand = random.nextInt(1,10);
                else
                    operand = random.nextInt(10);
                equation += operand;
            }
            else{
                equation += random.nextInt(10,100);
                do{
                    operator = operators[random.nextInt(4)];
                }while(operator == '-' || operator == '/');
                equation += operator;
                if(operator == '/')
                    operand = random.nextInt(1,10);
                else
                    operand = random.nextInt(10);
                equation += operand;
            }
        }

        return equation;
	}

}
