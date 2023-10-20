package controler;

import java.util.Stack;
import model.CalculatorModel;



public class CalculatorControler implements CalculatorControlerInterface{
	public CalculatorModel model;
	public String accu;
	
	//Constructor
	public CalculatorControler() {
		this.model=new CalculatorModel();
		accu="";
	}
	
	public void change(String accu)
	{};
	
	public void change(Stack<Double> pile)
	{};
	
	
	public void appui_virg() {
	}
	
	public void appui_sign() {	
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
		Double accuDouble = Double.parseDouble(accu);
		model.push(accuDouble);
		accu="";
	}
	
	public void appui_C() {
		model.clear();
	}
	

}
