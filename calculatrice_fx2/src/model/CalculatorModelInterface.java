package model;
import java.util.Stack;

public interface CalculatorModelInterface {
	/*Déclaration des méthode pour agir sur le contnenu de la pile*/
	public void add();
	public void substract();
	public void multiply();
	public void divide();
	public void opposite();
	public void push(Double a);
	public Double pop();
	public void drop();
	public void swap();
	public void clear(); 
	
	/*Déclation du getter pour récupérer la pile*/
	public Stack<Double> getPile();
}
