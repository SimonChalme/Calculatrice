package controler;

import java.util.Stack;
import model.CalculatorModel;



public class CalculatorControler implements CalculatorControlerInterface{
	private CalculatorModel model;
	private String accu;
	
	//Constructor
	public CalculatorControler() {
		this.model=new CalculatorModel();
		accu="";
	}
	
	public CalculatorModel getModel(){
		return model;
	}
	
	public String getAccu() {
		return accu;
	}
	
	public void setAccu(String a) {
		accu=accu+a;
	}
	
	public void setAccuVide() {
		accu="";
	}
	
	
	public void appui_virg() {
	}
	

	
	public void appui_plus() {
		model.add();
		Double a=model.pop();
		model.push(a);
		accu=Double.toString(a);
	}
	
	public void appui_moins() {	
		model.substract();
		Double a=model.pop();
		model.push(a);
		accu=Double.toString(a);
	}
	
	public void appui_fois() {	
		model.multiply();
		Double a=model.pop();
		model.push(a);
		accu=Double.toString(a);
	}
	
	public void appui_divise() {	
		model.divide();
		Double a=model.pop();
		model.push(a);
		accu=Double.toString(a);
	}
	
	public void appui_entrer() {
		if(accu!="") {
			Double accuDouble = Double.parseDouble(accu);
			model.push(accuDouble);
			accu="";
		}
	}
	
	public void appui_C() {
		model.clear();
		accu="";
	}
	
	public void appui_inv() {
		if(accu.isEmpty()) {
			Double a=model.pop();
			accu=Double.toString(-a);
			model.push(a);
			/* Si on veut inverser le dernier membre obtenu car on a pas accès à ce dernier quand celui ci est dans l'accu, il est instantanément push et donc l'accu est réinitialisé*/
		}
		else {
			Double accuDouble = Double.parseDouble(accu);
			accu=Double.toString(-accuDouble);
		}
	}
	
	public String appui_retour() {
		if(accu.length()>0) {
			String accu_temp=accu.substring(0, accu.length() - 1);
			accu="";
			return accu_temp;
		}
		else {
			return accu;
		}
		}
	
	public String setAffichage_2(){
		Stack<Double >pile=model.getPile();
		Double a=pile.pop();
		pile.push(a);
		return (Double.toString(a));
	}
	
	public String setAffichage_3() {
		Stack<Double >pile=model.getPile();
		Double a=pile.pop();
		Double b=pile.pop();
		pile.push(b);
		pile.push(a);
		return(Double.toString(b));
	}
	
	public void appui_swap() {
		model.swap();
	}
	
	public void change(String accu) {
		
	};
	public void change(Stack<Double> pile) {
		
	};

}
