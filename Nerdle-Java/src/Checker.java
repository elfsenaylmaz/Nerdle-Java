import java.util.ArrayList;

public class Checker {										//Tahmin edilen denklemin doğru olup olmamasını kontrol eden class
    private String equation;
    private String[] arr;

    private ArrayList<Integer> operands;
    private ArrayList<Character> operators;
    private int result;
    private int equationResult;
    
    private Solver solver;

    public Checker(String equation){						//Olusturulan denklem parametre olarak geliyor
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
        arr = equation.split("=");						//Denklemi eşittirden ikiye bölüyor
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

    private boolean checkEquation(String equationString){			//eşittirin sol tarafının doğruluğunun kontrolü
        int index = 0;
        String numberString;
        int number;
        int start;
        while(index < equationString.length()){							
            numberString = "";					//operandın ne olduğunu tutan değişken
            start = index;
            //denklem * veya / ile başlıyorsa denklem yanlış false döndür
            if(equationString.charAt(start) == '*' || equationString.charAt(start) == '/'){
                return false;
            }
            
            //DENKLEM + VEYA - İLE BAŞLIYORSA DENKLEMİ DOĞRU KABUL EDİYORUZ

            if(equationString.charAt(start) == '+' || equationString.charAt(start) == '-'){
            	//+ veya - den sonra sayı geliyorsa denklem doğru 
                if(equationString.charAt(start + 1) != '+' && equationString.charAt(start + 1) != '-' && equationString.charAt(start + 1) != '*' && equationString.charAt(start + 1) != '/' && equationString.charAt(start + 1) != '='){
                    index++;
                    numberString += equationString.charAt(start);
                }
                else		//+ veya -den sonra yine operator geliyorsa denklem yanlış false döndür
                    return false;
            }
            
            //Denklemde operator gelene kadar olan değerleri numberString değişkenine atıyor
            while(index < equationString.length() && equationString.charAt(index) != '+' && equationString.charAt(index) != '-' && equationString.charAt(index) != '*' && equationString.charAt(index) != '/' && equationString.charAt(index) != '='){
                numberString += equationString.charAt(index);
                index++;
            }
            try {				//numberString değeri integera döndürme işlemi
                number = Integer.parseInt(numberString);
            }catch(Exception e){			//integer olmuyorsa denklem yanlış false döndür
                return false;
            }
            operands.add(number);					//operandların tutulduğu listeye number at
            if(index < equationString.length())							//sayıdan sonra gelen operator listeye atılıyor
                operators.add(equationString.charAt(index));
            index++;
        }
        return true;					//denklem doğru ise true döndür
    }
    private boolean getResult(String resultString){						//eşittirin sağ tarafında kalan kısmı integera döndürme işlemi
        try{
            result = Integer.parseInt(resultString);					
        }
        catch(Exception e){							//integer olmuyorsa false döndür
            return false;
        }
        return true;								//integer oluyorsa true döndür
    }
    
    private boolean isEquationCorrect() {
    	solver.setList(operands, operators);						//eşittirin sol tarafındaki işlemin sonucu
    	if(solver.calculate()) {									//sağ tarafında yazan sayıya eşit ise true
    		equationResult = solver.getResult();
    		return true;
    	}
    	return false;												//değilse false
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

