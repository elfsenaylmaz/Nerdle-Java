import java.util.ArrayList;

public class Checker {
    private String equation;
    private String[] arr;

    private ArrayList<Integer> operands;
    private ArrayList<Character> operators;
    private int result;
    private int equationResult;
    
    private Solver solver;

    public Checker(String equation){
        this.equation = equation;
        arr = new String[2];
        operands = new ArrayList<Integer>();
        operators = new ArrayList<Character>();
        solver = new Solver();
    }

    public Checker(){
        arr = new String[2];
        operands = new ArrayList<Integer>();
        operators = new ArrayList<Character>();
        solver = new Solver();
    }

    public boolean check(){
        arr = equation.split("=");
        try{
            if(getResult(arr[1]) && checkEquation(arr[0]) && isEquationCorrect() && (getEquationResult() == getResult()) ){
            	return true;
            }
            else
                return false;
        }
        catch (Exception e){
            return false;
        }

    }

    private boolean checkEquation(String equationString){
        int index = 0;
        String numberString;
        int number;
        int start;
        while(index < equationString.length()){
            numberString = "";
            start = index;
            if(equationString.charAt(start) == '*' || equationString.charAt(start) == '/'){
                return false;
            }

            if(equationString.charAt(start) == '+' || equationString.charAt(start) == '-'){
                if(equationString.charAt(start + 1) != '+' && equationString.charAt(start + 1) != '-' && equationString.charAt(start + 1) != '*' && equationString.charAt(start + 1) != '/' && equationString.charAt(start + 1) != '='){
                    index++;
                    numberString += equationString.charAt(start);
                }
                else
                    return false;
            }
            while(index < equationString.length() && equationString.charAt(index) != '+' && equationString.charAt(index) != '-' && equationString.charAt(index) != '*' && equationString.charAt(index) != '/' && equationString.charAt(index) != '='){
                numberString += equationString.charAt(index);
                index++;
            }
            try {
                number = Integer.parseInt(numberString);
            }catch(Exception e){
                return false;
            }
            operands.add(number);
            if(index < equationString.length())
                operators.add(equationString.charAt(index));
            index++;
        }
        return true;
    }
    private boolean getResult(String resultString){
        try{
            result = Integer.parseInt(resultString);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    
    private boolean isEquationCorrect() {
    	solver.setList(operands, operators);
    	if(solver.calculate()) {
    		equationResult = solver.getResult();
    		return true;
    	}
    	return false;
    }
    

    public int getResult(){
        return result;
    }
    
    public int getEquationResult() {
    	return equationResult;
    }

    public void setEquation(String equation){
        this.equation = equation;
    }

    public ArrayList<Integer> getOperands(){
        return operands;
    }
    public ArrayList<Character> getOperators(){
        return operators;
    }
}

