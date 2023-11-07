package model;
import java.util.Stack;


public class CalculatorModel implements CalculatorModelInterface {
	private Stack<Double> pile;

	//Constructor
	public CalculatorModel() {
		pile=new Stack<Double>();
	}
	
	/* implémentation du Getter, renvoie la pile*/
	public Stack<Double> getPile(){
		return pile;
	}

	/* envoie le double a en haute de la pile*/
	public void push(Double a) {
		pile.push(a);
	}
	
	/*Si la pile est non vide, affiche le premier élément
	 * (qui est ensuite supprimé)
	 */
	public Double pop() {
		if(pile.size()>0) {
			return(pile.pop());
		}
		else {
			return 0.0;
		}
	}
	
	/* Supression du contenu de la pile*/
	public void clear() {
		pile.clear();
	}
	
	/*Supression du premier élément de la pile*/
	public void drop() {
		pop();
	}
	
	/* échange des deux premiers éléments de la pile*/
	public void swap() {
		Double term1=pop();
		Double term2=pop();
		push(term1);
		push(term2);
		
	}
	
	/* Si la pile possède plus de deux élément, on les addition
	 * et on envoie le resulat dans la pile
	 */
	public void add() {
		if (pile.size()>1) {
			Double term1=pop();
			Double term2=pop();
			push(term1+term2);
		}
		else {}
	}
	
	/* Si la pile possède plus de deux élément, on les soustrait
	 * et on envoie le resulat dans la pile
	 */
	public void substract() {
		if (pile.size()>1) {
			Double term1=pop();
			Double term2=pop();
			push(-term1+term2);
		}
		else {}
	}
	
	/* Si la pile possède plus de deux élément, on les multiplie
	 * et on envoie le resulat dans la pile
	 */
	public void multiply() {
		if (pile.size()>1) {
			Double term1=pop();
			Double term2=pop();
			push(term1*term2);
		}
		else {}
	}
	
	/* Si la pile possède plus de deux élément et que le premier est non nul, on les divise
	 * et on envoie le resulat dans la pile, sinon on remet les deux éléments dans la pile
	 */
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
	
	/* Si la pile possède plus d'un élément, on prends son inverse
	 * et on envoie le resulat dans la pile
	 */
	public void opposite() {
		if(pile.size()>0) {
			Double term1=pop();
			push(-term1);
		}
	}
	

}
