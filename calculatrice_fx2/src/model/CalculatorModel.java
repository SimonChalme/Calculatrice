package model;
import java.util.Stack;


public class CalculatorModel implements CalculatorModelInterface {
	private Stack<Double> pile;

	//Constructor
	public CalculatorModel() {
		pile=new Stack<Double>();
	}
	
	public Stack<Double> getPile(){
		return pile;
	}

	public void push(Double a) {
		pile.push(a);
	}
	
	public Double pop() {
		if(pile.size()>0) {
			return(pile.pop());
		}
		else {
			return 0.0;
		}
	}
	
	public void clear() {
		pile.clear();
	}
	
	public void drop() {
		pop();
	}
	
	public void swap() {
		Double term1=pop();
		Double term2=pop();
		push(term1);
		push(term2);
		
	}
	
	public void add() {
		if (pile.size()>1) {
			Double term1=pop();
			Double term2=pop();
			push(term1+term2);
		}
		else {}
	}
	
	public void substract() {
		if (pile.size()>1) {
			Double term1=pop();
			Double term2=pop();
			push(-term1+term2);
		}
		else {}
	}
	
	public void multiply() {
		if (pile.size()>1) {
			Double term1=pop();
			Double term2=pop();
			push(term1*term2);
		}
		else {}
	}
	
	public void divide() {
		if (pile.size()>1) {
			Double term1=pop();
			Double term2=pop();
			if(term1!=0) {
			push(term2/term1);
			}
			else {
				push(term2);
				push(term1);	
			}
		}
		}
	
	public void opposite() {
		if(pile.size()>0) {
			Double term1=pop();
			push(-term1);
		}
	}
	

}
