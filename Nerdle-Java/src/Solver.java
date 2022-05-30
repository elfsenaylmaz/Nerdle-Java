import java.util.ArrayList;
import java.util.Stack;

public class Solver {
	private Stack<Integer> operandStack;
	private Stack<Character> operatorStack;
	private ArrayList<Integer> operands;
	private ArrayList<Character> operators;
	private int number1, number2;
    private int result;
    private char symbol;
	
	
	public Solver(ArrayList<Integer> operands, ArrayList<Character> operators){
        operandStack = new Stack<Integer>();
        operatorStack = new Stack<Character>();
        this.operands = operands;
        this.operators = operators;
    }
	
	public Solver() {
		operandStack = new Stack<Integer>();
        operatorStack = new Stack<Character>();
	}
	
	public boolean calculate(){
        try{
        	operandStack.clear();
        	operatorStack.clear();
            while(operands.size() != 0 || operators.size() != 0){
                operandStack.push(operands.remove(0));
                if(operatorStack.isEmpty()){                          //stack boşsa push
                    operatorStack.push(operators.remove(0));
                }
                else if(operators.size() != 0){
                    //en üsttekinin önceliği gelenden küçükse push
                    if((operatorStack.peek() == '+' || operatorStack.peek()  == '-') && (operators.get(0) == '*' || operators.get(0) == '/')){
                        operatorStack.push(operators.remove(0));
                    }
                    else{
                        number2 = operandStack.pop();
                        symbol = operatorStack.pop();
                        number1 = operandStack.pop();

                        if(symbol == '+'){
                            operandStack.push(number1 + number2);
                        }
                        else if(symbol == '-'){
                        	if(number1 - number2 < 0)
                        		return false;                      		
                            operandStack.push(number1 - number2);
                        }
                        else if(symbol == '*'){
                            operandStack.push(number1 * number2);
                        }
                        else if(symbol == '/'){
                        	if(number1 % number2 != 0) 
                        		return false;	
                            operandStack.push(number1 / number2);
                        }
                        operatorStack.push(operators.remove(0));
                    }
                }
                else{
                    number2 = operandStack.pop();
                    symbol = operatorStack.pop();
                    number1 = operandStack.pop();

                    if(symbol == '+'){
                        operandStack.push(number1 + number2);
                    }
                    else if(symbol == '-'){
                    	if(number1 - number2 < 0)
                    		return false;
                        operandStack.push(number1 - number2);
                    }
                    else if(symbol == '*'){
                        operandStack.push(number1 * number2);
                    }
                    else if(symbol == '/'){
                    	if(number1 % number2 != 0)
                    		return false;
                        operandStack.push(number1 / number2);
                    }
                }
            }

            while(!operatorStack.isEmpty()){
                number2 = operandStack.pop();
                symbol = operatorStack.pop();
                number1 = operandStack.pop();

                if(symbol == '+'){
                    operandStack.push(number1 + number2);
                }
                else if(symbol == '-'){
                	if(number1 - number2 < 0) 
                		return false;
                    operandStack.push(number1 - number2);
                }
                else if(symbol == '*'){
                    operandStack.push(number1 * number2);
                }
                else if(symbol == '/'){
                	if(number1 % number2 != 0)
                		return false;
                    operandStack.push(number1 / number2);
                }
            }
            result = operandStack.pop();
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
	
	public void setList(ArrayList<Integer> operands, ArrayList<Character> operators){
        this.operands = operands;
        this.operators = operators;
    }
	
	public int getResult(){
        return result;
    }
}
