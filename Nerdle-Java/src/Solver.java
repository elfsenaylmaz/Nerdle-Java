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
	
	
	public Solver(ArrayList<Integer> operands, ArrayList<Character> operators){		//oluşturulan stringdeki operand ve operatorler listelerde tutuluyor		
        operandStack = new Stack<Integer>();					
        operatorStack = new Stack<Character>();
        this.operands = operands;
        this.operators = operators;
    }
	
	public Solver() {
		operandStack = new Stack<Integer>();
        operatorStack = new Stack<Character>();
	}
	
	public boolean calculate(){											//Denklemin sonucunun stack işlemleri ile üretilmesi
        try{
        	operandStack.clear();
        	operatorStack.clear();
            while(operands.size() != 0 || operators.size() != 0){				//Eğer hala listelerde eleman var ise dönen döngü
                operandStack.push(operands.remove(0));					//stacke listenin başındaki eleman push edilir
                if(operatorStack.isEmpty()){                          //stack boşsa push
                    operatorStack.push(operators.remove(0));
                }
                else if(operators.size() != 0){									//operator listesi boş ise
                    //en üsttekinin önceliği gelenden küçükse push
                    if((operatorStack.peek() == '+' || operatorStack.peek()  == '-') && (operators.get(0) == '*' || operators.get(0) == '/')){
                        operatorStack.push(operators.remove(0));
                    }
                    else{										//stackte en üsttekinin önceliği gelenden büyükse işlem yapmak için
                        number2 = operandStack.pop();			//operand ve operator stackten elemanlar çekiliyor
                        symbol = operatorStack.pop();
                        number1 = operandStack.pop();

                        if(symbol == '+'){									//operator stackten gelen operatore göre işlemin yapılması
                            operandStack.push(number1 + number2);			//ve çıkan sonucun stacke tekrar atılması
                        }
                        else if(symbol == '-'){
                        	if(number1 - number2 < 0)						//Çıkarma işlemi sonucu negatif bir değer üretirse false döndür
                        		return false;                      		
                            operandStack.push(number1 - number2);
                        }
                        else if(symbol == '*'){
                            operandStack.push(number1 * number2);
                        }
                        else if(symbol == '/'){
                        	if(number1 % number2 != 0) 						//Bölme işlemi float bir değer döndürüyorsa false döndür
                        		return false;	
                            operandStack.push(number1 / number2);
                        }
                        operatorStack.push(operators.remove(0));
                    }
                }													//operator listesinin içinde eleman yok ise
                else{
                    number2 = operandStack.pop();
                    symbol = operatorStack.pop();
                    number1 = operandStack.pop();

                    if(symbol == '+'){								//operatore göre işlemin yapılması ve stacke atılması
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

            while(!operatorStack.isEmpty()){							//operand ve operator listeleri boş ise stackte en son kalan değerler ile işlemin yapılması
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
            result = operandStack.pop();								//operand stackte kalan son değer denklemin sonucu
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
	
	public int getResult(){										//Denklemin sonucunun getteri
        return result;
    }
}
