import java.util.ArrayList;
import java.util.Random;

public class Generator {
	private char[] operators = {'+', '-', '*', '/'};
	private Random random;
	private String equation;
	ArrayList<Integer> operandsList;								//Solver classinda cozmek icin sayilarin listede tutulmasi
	ArrayList<Character> operatorsList;								//Solver classinda cozmek icin operatorlerin listede tutulmasi
	private Solver solver;
	private int digitCount;
	
	public Generator() {
		random = new Random();
		operandsList = new ArrayList<Integer>();
		operatorsList = new ArrayList<Character>();
		solver = new Solver();
	}
	
	public int getDigitCount() {
		return digitCount;
	}

	public String generateEquation() {								//7, 8 veya 9 uzunlugunda random denklem uretecek fonksiyon
		digitCount = random.nextInt(3);								//Denklem uzunlugunun random secilmesi
		if(digitCount == 0) {
			return create7DigitEquation();
		}
		else if(digitCount == 1) {
			return create8DigitEquation();
		}
		else {
			return create9DigitEquation();
		}
	}
	
	public String create7DigitEquation() {							//7 uzunlugunda denklemi olusturan fonksiyon
		int operand1, operand2, operand3;
		char operator1, operator2;
		int type;
		int numberOfOperator;
		int placement;
		boolean control;
		int result;
		String newEquation;
		
		operandsList.clear();
        operatorsList.clear();
        equation = "";
        
        type = random.nextInt(2);
        if(type == 0) {													//Esittirden sonra 1 basamak bulunmasi (... = 1 digit)
        	numberOfOperator = random.nextInt(2);						//Denklemde bulunacak operator sayisinin random secilmesi
        	if(numberOfOperator == 1) {									//2 operand bulunmasi
    			
        		control = false;
    			while(!control) {	
    				operand1 = random.nextInt(1, 10);
				    operand2 = random.nextInt(1, 10);
				    operand3 = random.nextInt(1, 10);	
				    operator1 = operators[random.nextInt(4)];
				    operator2 = operators[random.nextInt(4)];
			        
					operandsList.clear();
			        operatorsList.clear();
			        equation = "";   			      
			        
			        equation += operand1;
			        operandsList.add(operand1);      			        
			     
			        equation += operator1;
			        operatorsList.add(operator1);
			        
			        equation += operand2;
			        operandsList.add(operand2);      			        
			     
			        equation += operator2;
			        operatorsList.add(operator2);
			        
			        equation += operand3;
			        operandsList.add(operand3);      			             			        

			        
			        solver.setList(operandsList, operatorsList);
			        if(solver.calculate()) {
			        	result = solver.getResult();
						newEquation = equation;
						newEquation += '=';
						newEquation += result;
						if(newEquation.length() == 7) {
							control = true;
							equation = newEquation;
						}
			        }

    			}
        	}
        	else {														//1 operand bulunmasi
        		control = false;
    			
    			while(!control) {
    				operand1 = random.nextInt(10, 100);
				    operand2 = random.nextInt(10, 100);
				    operator1 = operators[random.nextInt(4)];
			        
					operandsList.clear();
			        operatorsList.clear();
			        equation = "";   			      
			        
			        equation += operand1;
			        operandsList.add(operand1);      			        
			     
			        equation += operator1;
			        operatorsList.add(operator1);
			        
			        equation += operand2;
			        operandsList.add(operand2);      			             			             			        

			        
			        solver.setList(operandsList, operatorsList);
			        if(solver.calculate()) {
			        	result = solver.getResult();
						newEquation = equation;
						newEquation += '=';
						newEquation += result;
						if(newEquation.length() == 7) {
							control = true;
							equation = newEquation;
						}
			        }

    			}
        	}
        }
        else {															// ... = 2 digit
        	placement = random.nextInt(2);								//Sayilarin yerlesecegi yerlerin random secilmesi
        	if(placement == 0) {
        		control = false;
    			
    			while(!control) {
    				operand1 = random.nextInt(1, 10);
				    operand2 = random.nextInt(10, 100);
				    operator1 = operators[random.nextInt(4)];
			        
					operandsList.clear();
			        operatorsList.clear();
			        equation = "";   			      
			        
			        equation += operand1;
			        operandsList.add(operand1);      			        
			     
			        equation += operator1;
			        operatorsList.add(operator1);
			        
			        equation += operand2;
			        operandsList.add(operand2);      			            			             			        

			        
			        solver.setList(operandsList, operatorsList);
			        if(solver.calculate()) {
			        	result = solver.getResult();
						newEquation = equation;
						newEquation += '=';
						newEquation += result;
						if(newEquation.length() == 7) {
							control = true;
							equation = newEquation;
						}
			        }

    			}
        	}
        	else {
        		control = false;
    			
    			while(!control) {
    				operand1 = random.nextInt(10, 100);
				    operand2 = random.nextInt(1, 10);	
				    operator1 = operators[random.nextInt(4)];
			        
					operandsList.clear();
			        operatorsList.clear();
			        equation = "";   			      
			        
			        equation += operand1;
			        operandsList.add(operand1);      			        
			     
			        equation += operator1;
			        operatorsList.add(operator1);
			        
			        equation += operand2;
			        operandsList.add(operand2);      			        

			        
			        solver.setList(operandsList, operatorsList);
			        if(solver.calculate()) {
			        	result = solver.getResult();
						newEquation = equation;
						newEquation += '=';
						newEquation += result;
						if(newEquation.length() == 7) {
							control = true;
							equation = newEquation;
						}
			        }

    			}
        	}
        }
        return equation;
	}
	
	public String create8DigitEquation() {
		int operand1, operand2, operand3;
		char operator1, operator2;
        int type;
        int numberOfOperator;
        boolean control;
		int placement;
		int result;
		String newEquation;
        
        operandsList.clear();
        operatorsList.clear();
        equation = "";
        
        type = random.nextInt(3);
        if(type == 0) {																		// ... = 1 digit
       	
        	numberOfOperator = random.nextInt(2);
        	if(numberOfOperator == 1) {															//2 operand bulunmasi											      		
        			
        			control = false;
        			while(!control) {
        				operand1 = random.nextInt(10, 100);
					    operand2 = random.nextInt(1, 10);
					    operand3 = random.nextInt(1, 10);
					    placement = random.nextInt(3);
        				if(placement == 0) {													//2 digit + operand + 1 digit + operand + 1 digit

							operandsList.clear();
					        operatorsList.clear();
					        equation = "";
					      
					        
					        equation += operand1;
					        operandsList.add(operand1);   

					        operator1 = operators[random.nextInt(4)];
					        equation += operator1;
					        operatorsList.add(operator1);
					        
					        equation += operand2;
					        operandsList.add(operand2);
					        
					        operator2 = operators[random.nextInt(4)];
					        equation += operator2;
					        operatorsList.add(operator2);
					        
					        equation += operand3;
					        operandsList.add(operand3);
					        
					        solver.setList(operandsList, operatorsList);
					        if(solver.calculate()) {
					        	result = solver.getResult();
								newEquation = equation;
								newEquation += '=';
								newEquation += result;
								if(newEquation.length() == 8) {
									control = true;
									equation = newEquation;
								}
					        }

        				}
        				else if(placement == 1) {												//1 digit + operand + 2 digit + operand + 1 digit

							operandsList.clear();
					        operatorsList.clear();
					        equation = "";
					      
					        
					        equation += operand2;
					        operandsList.add(operand2);   
					        
					        operator1 = operators[random.nextInt(4)];
					        equation += operator1;
					        operatorsList.add(operator1);
					        
					        equation += operand1;
					        operandsList.add(operand1);
					        
					        operator2 = operators[random.nextInt(4)];
					        equation += operator2;
					        operatorsList.add(operator2);
					        
					        equation += operand3;
					        operandsList.add(operand3);
					        
					        solver.setList(operandsList, operatorsList);
					        if(solver.calculate()) {
					        	result = solver.getResult();
								newEquation = equation;
								newEquation += '=';
								newEquation += result;
								if(newEquation.length() == 8) {
									control = true;
									equation = newEquation;
								}
					        }
        				}
        				else {																		//1 digit + operand + 1 digit + operand + 2 digit

							operandsList.clear();
					        operatorsList.clear();
					        equation = "";
					      
					        
					        equation += operand2;
					        operandsList.add(operand2);   

					        operator1 = operators[random.nextInt(4)];
					        equation += operator1;
					        operatorsList.add(operator1);
					        
					        equation += operand3;
					        operandsList.add(operand3);

					        operator2 = operators[random.nextInt(4)];
					        equation += operator2;
					        operatorsList.add(operator2);
					        
					        equation += operand1;
					        operandsList.add(operand1);
					        
					        solver.setList(operandsList, operatorsList);
					        if(solver.calculate()) {
					        	result = solver.getResult();
								newEquation = equation;
								newEquation += '=';
								newEquation += result;
								if(newEquation.length() == 8) {
									control = true;
									equation = newEquation;
								}
					        }
        				}
        		}
        		  		
        	}
        	else {																	//1 operand bulunmasi
        		
        		control = false;
    			
    			while(!control) {
    				operand1 = random.nextInt(100, 1000);
				    operand2 = random.nextInt(10, 100);											
				    operator1 = operators[random.nextInt(4)];
			        
					operandsList.clear();
			        operatorsList.clear();
			        equation = "";
			      
			        
			        equation += operand1;
			        operandsList.add(operand1);   
			     
			        equation += operator1;
			        operatorsList.add(operator1);
			        
			        equation += operand2;
			        operandsList.add(operand2);
			        
			        solver.setList(operandsList, operatorsList);
			        if(solver.calculate()) {
			        	result = solver.getResult();
						newEquation = equation;
						newEquation += '=';
						newEquation += result;
						if(newEquation.length() == 8) {
							control = true;
							equation = newEquation;
						}
			        }

    			}
        		
        	}
        
        }
        else if(type == 1){															// ... = 2 digit
        	numberOfOperator = random.nextInt(2);
        	if(numberOfOperator == 1) {									//2 operand bulunmasi
        		control = false;
    			
    			while(!control) {
    				operand1 = random.nextInt(10);
				    operand2 = random.nextInt(10);
				    operand3 = random.nextInt(10);												
				    operator1 = operators[random.nextInt(4)];
			        operator2 = operators[random.nextInt(4)];
			        
					operandsList.clear();
			        operatorsList.clear();
			        equation = "";
			      
			        
			        equation += operand1;
			        operandsList.add(operand1);   
			     
			        equation += operator1;
			        operatorsList.add(operator1);
			        
			        equation += operand2;
			        operandsList.add(operand2);
			        
			        equation += operator2;
			        operatorsList.add(operator2);
			        
			        equation += operand3;
			        operandsList.add(operand3);
			        
			        solver.setList(operandsList, operatorsList);
			        if(solver.calculate()) {
			        	result = solver.getResult();
						newEquation = equation;
						newEquation += '=';
						newEquation += result;
						if(newEquation.length() == 8) {
							control = true;
							equation = newEquation;
						}
			        }

    			}
        	}
        	else {														//1 operand bulunmasi
        		if(random.nextInt(2) == 0) {
        			control = false;
        			
        			while(!control) {
        				operand1 = random.nextInt(10, 100);
    				    operand2 = random.nextInt(10, 100);											
    				    operator1 = operators[random.nextInt(4)];
    			        
    					operandsList.clear();
    			        operatorsList.clear();
    			        equation = "";   			      
    			        
    			        equation += operand1;
    			        operandsList.add(operand1);      			        
    			     
    			        equation += operator1;
    			        operatorsList.add(operator1);
    			        
    			        equation += operand2;
    			        operandsList.add(operand2);

    			        
    			        solver.setList(operandsList, operatorsList);
    			        if(solver.calculate()) {
    			        	result = solver.getResult();
    						newEquation = equation;
    						newEquation += '=';
    						newEquation += result;
    						if(newEquation.length() == 8) {
    							control = true;
    							equation = newEquation;
    						}
    			        }

        			}
        		}
        		else {
        			control = false;
        			
        			while(!control) {
        				operand1 = random.nextInt(100, 1000);
    				    operand2 = random.nextInt(10);											
    				    operator1 = operators[random.nextInt(4)];
    			        
    					operandsList.clear();
    			        operatorsList.clear();
    			        equation = "";   			      
    			        
    			        equation += operand1;
    			        operandsList.add(operand1);      			        
    			     
    			        equation += operator1;
    			        operatorsList.add(operator1);
    			        
    			        equation += operand2;
    			        operandsList.add(operand2);

    			        
    			        solver.setList(operandsList, operatorsList);
    			        if(solver.calculate()) {
    			        	result = solver.getResult();
    						newEquation = equation;
    						newEquation += '=';
    						newEquation += result;
    						if(newEquation.length() == 8) {
    							control = true;
    							equation = newEquation;
    						}
    			        }

        			}
        		}
        	}
        }
        else {															// ... = 3 digit
        	if(random.nextInt(2) == 0) {
        		control = false;
    			
    			while(!control) {
    				operand1 = random.nextInt(10);
				    operand2 = random.nextInt(10, 100);											
				    operator1 = operators[random.nextInt(4)];
			        
					operandsList.clear();
			        operatorsList.clear();
			        equation = "";   			      
			        
			        equation += operand1;
			        operandsList.add(operand1);      			        
			     
			        equation += operator1;
			        operatorsList.add(operator1);
			        
			        equation += operand2;
			        operandsList.add(operand2);

			        
			        solver.setList(operandsList, operatorsList);
			        if(solver.calculate()) {
			        	result = solver.getResult();
						newEquation = equation;
						newEquation += '=';
						newEquation += result;
						if(newEquation.length() == 8) {
							control = true;
							equation = newEquation;
						}
			        }

    			}
        	}
        	else {
        		control = false;
    			
    			while(!control) {
    				operand1 = random.nextInt(10, 100);
				    operand2 = random.nextInt(10);										
				    operator1 = operators[random.nextInt(4)];
			        
					operandsList.clear();
			        operatorsList.clear();
			        equation = "";   			      
			        
			        equation += operand1;
			        operandsList.add(operand1);      			        
			     
			        equation += operator1;
			        operatorsList.add(operator1);
			        
			        equation += operand2;
			        operandsList.add(operand2);

			        
			        solver.setList(operandsList, operatorsList);
			        if(solver.calculate()) {
			        	result = solver.getResult();
						newEquation = equation;
						newEquation += '=';
						newEquation += result;
						if(newEquation.length() == 8) {
							control = true;
							equation = newEquation;
						}
			        }

    			}
        	}
        }
        return equation;
	}
	
	
	public String create9DigitEquation() {
		int operand1, operand2, operand3, operand4;
		char operator1, operator2, operator3;
        int type;
        int numberOfOperator;
        int placement;
		boolean control;
		int result;
		String newEquation;
        
        operandsList.clear();
        operatorsList.clear();
        equation = "";
        
        type = random.nextInt(3);
        if(type == 0) {													// ... = 1 digit
        	numberOfOperator = random.nextInt(3);
        	if(numberOfOperator == 2) {									// 3 operand bulunmasi
    			control = false;
    			while(!control) {
    				operand1 = random.nextInt(1, 10);
				    operand2 = random.nextInt(1, 10);
				    operand3 = random.nextInt(1, 10);	
				    operand4 = random.nextInt(1, 10);	
				    operator1 = operators[random.nextInt(4)];
				    operator2 = operators[random.nextInt(4)];
				    operator3 = operators[random.nextInt(4)];
			        
					operandsList.clear();
			        operatorsList.clear();
			        equation = "";   			      
			        
			        equation += operand1;
			        operandsList.add(operand1);      			        
			     
			        equation += operator1;
			        operatorsList.add(operator1);
			        
			        equation += operand2;
			        operandsList.add(operand2);      			        
			     
			        equation += operator2;
			        operatorsList.add(operator2);
			        
			        equation += operand3;
			        operandsList.add(operand3);      			        
			     
			        equation += operator3;
			        operatorsList.add(operator3);
			        
			        equation += operand4;
			        operandsList.add(operand4);      			        

			        
			        solver.setList(operandsList, operatorsList);
			        if(solver.calculate()) {
			        	result = solver.getResult();
						newEquation = equation;
						newEquation += '=';
						newEquation += result;
						if(newEquation.length() == 9) {
							control = true;
							equation = newEquation;
						}
			        }

    			}
        	}
        	else if(numberOfOperator == 1) {							// 2 operand bulunmasi
        		placement = random.nextInt(3);
        		if(placement == 0) {
        			control = false;
        			
        			while(!control) {
        				operand1 = random.nextInt(10, 100);
    				    operand2 = random.nextInt(1, 10);
    				    operand3 = random.nextInt(10, 100);	
    				    operator1 = operators[random.nextInt(4)];
    				    operator2 = operators[random.nextInt(4)];
    			        
    					operandsList.clear();
    			        operatorsList.clear();
    			        equation = "";   			      
    			        
    			        equation += operand1;
    			        operandsList.add(operand1);      			        
    			     
    			        equation += operator1;
    			        operatorsList.add(operator1);
    			        
    			        equation += operand2;
    			        operandsList.add(operand2);      			        
    			     
    			        equation += operator2;
    			        operatorsList.add(operator2);
    			        
    			        equation += operand3;
    			        operandsList.add(operand3);      			             			        

    			        
    			        solver.setList(operandsList, operatorsList);
    			        if(solver.calculate()) {
    			        	result = solver.getResult();
    						newEquation = equation;
    						newEquation += '=';
    						newEquation += result;
    						if(newEquation.length() == 9) {
    							control = true;
    							equation = newEquation;
    						}
    			        }

        			}
        		}
        		else if(placement == 1) {
        			control = false;
        			
        			while(!control) {
        				operand1 = random.nextInt(1, 10);
    				    operand2 = random.nextInt(10, 100);
    				    operand3 = random.nextInt(10, 100);	
    				    operator1 = operators[random.nextInt(4)];
    				    operator2 = operators[random.nextInt(4)];
    			        
    					operandsList.clear();
    			        operatorsList.clear();
    			        equation = "";   			      
    			        
    			        equation += operand1;
    			        operandsList.add(operand1);      			        
    			     
    			        equation += operator1;
    			        operatorsList.add(operator1);
    			        
    			        equation += operand2;
    			        operandsList.add(operand2);      			        
    			     
    			        equation += operator2;
    			        operatorsList.add(operator2);
    			        
    			        equation += operand3;
    			        operandsList.add(operand3);      			             			        

    			        
    			        solver.setList(operandsList, operatorsList);
    			        if(solver.calculate()) {
    			        	result = solver.getResult();
    						newEquation = equation;
    						newEquation += '=';
    						newEquation += result;
    						if(newEquation.length() == 9) {
    							control = true;
    							equation = newEquation;
    						}
    			        }

        			}
        		}
        		else{
        			control = false;
        			
        			while(!control) {
        				operand1 = random.nextInt(10, 100);
    				    operand2 = random.nextInt(10, 100);
    				    operand3 = random.nextInt(1, 10);		
    				    operator1 = operators[random.nextInt(4)];
    				    operator2 = operators[random.nextInt(4)];
    			        
    					operandsList.clear();
    			        operatorsList.clear();
    			        equation = "";   			      
    			        
    			        equation += operand1;
    			        operandsList.add(operand1);      			        
    			     
    			        equation += operator1;
    			        operatorsList.add(operator1);
    			        
    			        equation += operand2;
    			        operandsList.add(operand2);      			        
    			     
    			        equation += operator2;
    			        operatorsList.add(operator2);
    			        
    			        equation += operand3;
    			        operandsList.add(operand3);      			           			        

    			        
    			        solver.setList(operandsList, operatorsList);
    			        if(solver.calculate()) {
    			        	result = solver.getResult();
    						newEquation = equation;
    						newEquation += '=';
    						newEquation += result;
    						if(newEquation.length() == 9) {
    							control = true;
    							equation = newEquation;
    						}
    			        }

        			}
        		}

        	}
        	else {														//1 operand bulunmasi
        		control = false;
    			
    			while(!control) {
    				operand1 = random.nextInt(100, 1000);
				    operand2 = random.nextInt(100, 1000);
				    operator1 = operators[random.nextInt(4)];
			        
					operandsList.clear();
			        operatorsList.clear();
			        equation = "";   			      
			        
			        equation += operand1;
			        operandsList.add(operand1);      			        
			     
			        equation += operator1;
			        operatorsList.add(operator1);
			        
			        equation += operand2;
			        operandsList.add(operand2);      			             			        

			        
			        solver.setList(operandsList, operatorsList);
			        if(solver.calculate()) {
			        	result = solver.getResult();
						newEquation = equation;
						newEquation += '=';
						newEquation += result;
						if(newEquation.length() == 9) {
							control = true;
							equation = newEquation;
						}
			        }

    			}
        	}
        }
        else if(type == 1) {											// ... = 2 digit
        	numberOfOperator = random.nextInt(2);
        	if(numberOfOperator == 1) {									//2 operand bulunmasi
        		placement = random.nextInt(3);
        		if(placement == 0) {
        			control = false;
        			
        			while(!control) {
        				operand1 = random.nextInt(10, 100);
    				    operand2 = random.nextInt(1, 10);
    				    operand3 = random.nextInt(1, 10);	
    				    operator1 = operators[random.nextInt(4)];
    				    operator2 = operators[random.nextInt(4)];
    			        
    					operandsList.clear();
    			        operatorsList.clear();
    			        equation = "";   			      
    			        
    			        equation += operand1;
    			        operandsList.add(operand1);      			        
    			     
    			        equation += operator1;
    			        operatorsList.add(operator1);
    			        
    			        equation += operand2;
    			        operandsList.add(operand2);      			        
    			     
    			        equation += operator2;
    			        operatorsList.add(operator2);
    			        
    			        equation += operand3;
    			        operandsList.add(operand3);      			             			        
    			        
    			        solver.setList(operandsList, operatorsList);
    			        if(solver.calculate()) {
    			        	result = solver.getResult();
    						newEquation = equation;
    						newEquation += '=';
    						newEquation += result;
    						if(newEquation.length() == 9) {
    							control = true;
    							equation = newEquation;
    						}
    			        }

        			}
        		}
        		else if(placement == 1) {
        			control = false;
        			
        			while(!control) {
        				operand1 = random.nextInt(1, 10);
    				    operand2 = random.nextInt(10, 100);
    				    operand3 = random.nextInt(1, 10);		
    				    operator1 = operators[random.nextInt(4)];
    				    operator2 = operators[random.nextInt(4)];
    			        
    					operandsList.clear();
    			        operatorsList.clear();
    			        equation = "";   			      
    			        
    			        equation += operand1;
    			        operandsList.add(operand1);      			        
    			     
    			        equation += operator1;
    			        operatorsList.add(operator1);
    			        
    			        equation += operand2;
    			        operandsList.add(operand2);      			        
    			     
    			        equation += operator2;
    			        operatorsList.add(operator2);
    			        
    			        equation += operand3;
    			        operandsList.add(operand3);      			           			        

    			        
    			        solver.setList(operandsList, operatorsList);
    			        if(solver.calculate()) {
    			        	result = solver.getResult();
    						newEquation = equation;
    						newEquation += '=';
    						newEquation += result;
    						if(newEquation.length() == 9) {
    							control = true;
    							equation = newEquation;
    						}
    			        }

        			}
        		}
        		else {
        			control = false;
        			
        			while(!control) {
        				operand1 = random.nextInt(1, 10);
    				    operand2 = random.nextInt(1, 10);
    				    operand3 = random.nextInt(10, 100);	
    				    operator1 = operators[random.nextInt(4)];
    				    operator2 = operators[random.nextInt(4)];
    			        
    					operandsList.clear();
    			        operatorsList.clear();
    			        equation = "";   			      
    			        
    			        equation += operand1;
    			        operandsList.add(operand1);      			        
    			     
    			        equation += operator1;
    			        operatorsList.add(operator1);
    			        
    			        equation += operand2;
    			        operandsList.add(operand2);      			        
    			     
    			        equation += operator2;
    			        operatorsList.add(operator2);
    			        
    			        equation += operand3;
    			        operandsList.add(operand3);      			        
   			        
    			        
    			        solver.setList(operandsList, operatorsList);
    			        if(solver.calculate()) {
    			        	result = solver.getResult();
    						newEquation = equation;
    						newEquation += '=';
    						newEquation += result;
    						if(newEquation.length() == 9) {
    							control = true;
    							equation = newEquation;
    						}
    			        }

        			}
        		}
        	}
        	else {														//1 operand bulunmasi
        		control = false;
    			
    			while(!control) {
    				operand1 = random.nextInt(100, 1000);
				    operand2 = random.nextInt(10, 100);
				    operator1 = operators[random.nextInt(4)];
			        
					operandsList.clear();
			        operatorsList.clear();
			        equation = "";   			      
			        
			        equation += operand1;
			        operandsList.add(operand1);      			        
			     
			        equation += operator1;
			        operatorsList.add(operator1);
			        
			        equation += operand2;
			        operandsList.add(operand2);      			        		        

			        
			        solver.setList(operandsList, operatorsList);
			        if(solver.calculate()) {
			        	result = solver.getResult();
						newEquation = equation;
						newEquation += '=';
						newEquation += result;
						if(newEquation.length() == 9) {
							control = true;
							equation = newEquation;
						}
			        }

    			}
        	}
        }
        else {															// ... = 3 digit
        	numberOfOperator = random.nextInt(2);
        	if(numberOfOperator == 1) {									//2 operand bulunmasi
        		control = false;
    			
    			while(!control) {
    				operand1 = random.nextInt(1, 10);
				    operand2 = random.nextInt(1, 10);
				    operand3 = random.nextInt(1, 10);	
				    operator1 = operators[random.nextInt(4)];
				    operator2 = operators[random.nextInt(4)];
			        
					operandsList.clear();
			        operatorsList.clear();
			        equation = "";   			      
			        
			        equation += operand1;
			        operandsList.add(operand1);      			        
			     
			        equation += operator1;
			        operatorsList.add(operator1);
			        
			        equation += operand2;
			        operandsList.add(operand2);      			        
			     
			        equation += operator2;
			        operatorsList.add(operator2);
			        
			        equation += operand3;
			        operandsList.add(operand3);      			        
			        
			        solver.setList(operandsList, operatorsList);
			        if(solver.calculate()) {
			        	result = solver.getResult();
						newEquation = equation;
						newEquation += '=';
						newEquation += result;
						if(newEquation.length() == 9) {
							control = true;
							equation = newEquation;
						}
			        }

    			}
        	}
        	else {														//1 operand bulunmasi
        		placement = random.nextInt(3);
        		if(placement == 0) {
        			control = false;
        			
        			while(!control) {
        				operand1 = random.nextInt(100, 1000);
    				    operand2 = random.nextInt(1, 10);

    				    operator1 = operators[random.nextInt(4)];
    			        
    					operandsList.clear();
    			        operatorsList.clear();
    			        equation = "";   			      
    			        
    			        equation += operand1;
    			        operandsList.add(operand1);      			        
    			     
    			        equation += operator1;
    			        operatorsList.add(operator1);
    			        
    			        equation += operand2;
    			        operandsList.add(operand2);      			             			        

    			        
    			        solver.setList(operandsList, operatorsList);
    			        if(solver.calculate()) {
    			        	result = solver.getResult();
    						newEquation = equation;
    						newEquation += '=';
    						newEquation += result;
    						if(newEquation.length() == 9) {
    							control = true;
    							equation = newEquation;
    						}
    			        }

        			}
        		}
        		else if(placement == 1) {
        			control = false;
        			
        			while(!control) {
        				operand1 = random.nextInt(10, 100);
    				    operand2 = random.nextInt(10, 100);

    				    operator1 = operators[random.nextInt(4)];
    			        
    					operandsList.clear();
    			        operatorsList.clear();
    			        equation = "";   			      
    			        
    			        equation += operand1;
    			        operandsList.add(operand1);      			        
    			     
    			        equation += operator1;
    			        operatorsList.add(operator1);
    			        
    			        equation += operand2;
    			        operandsList.add(operand2);      			             			        

    			        
    			        solver.setList(operandsList, operatorsList);
    			        if(solver.calculate()) {
    			        	result = solver.getResult();
    						newEquation = equation;
    						newEquation += '=';
    						newEquation += result;
    						if(newEquation.length() == 9) {
    							control = true;
    							equation = newEquation;
    						}
    			        }

        			}
        		}
        		else {
        			control = false;
        			
        			while(!control) {
        				operand1 = random.nextInt(1, 10);
    				    operand2 = random.nextInt(100, 1000);

    				    operator1 = operators[random.nextInt(4)];
    			        
    					operandsList.clear();
    			        operatorsList.clear();
    			        equation = "";   			      
    			        
    			        equation += operand1;
    			        operandsList.add(operand1);      			        
    			     
    			        equation += operator1;
    			        operatorsList.add(operator1);
    			        
    			        equation += operand2;
    			        operandsList.add(operand2);      			        
    			        
    			        solver.setList(operandsList, operatorsList);
    			        if(solver.calculate()) {
    			        	result = solver.getResult();
    						newEquation = equation;
    						newEquation += '=';
    						newEquation += result;
    						if(newEquation.length() == 9) {
    							control = true;
    							equation = newEquation;
    						}
    			        }

        			}
        		}
        	}
        }
        return equation;
	}
}
