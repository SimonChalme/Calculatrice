package view;
import java.util.Stack;

public interface CalculatorGUIInterface {
	public void affiche();
	public void change(String accu);
	public void change(Stack<Double> stackData);
	
}
