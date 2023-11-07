package controler;
import model.CalculatorModelInterface;
import java.util.Stack;

public class CalculatorControler implements CalculatorControlerInterface{
	private CalculatorModelInterface model;
	private String accu;
	
	//Constructeur
	public CalculatorControler(CalculatorModelInterface model) {
		this.model=model;
		accu="";
	}
	
	/*Implémentation des getter et des setters, avec l'élément voulu en retour pour les getter
	 * et la modification de l'éléments voulu pour les setter*/
	public CalculatorModelInterface getModel(){
		return model;
	}
	
	public String getAccu() {
		return accu;
	}
	
	public void setAccu(String a) {
		accu=accu+a;
	}
	
	/*Cas particulier de setAccu, pour remettre à 0 accu, on ne peut pas passer par la concaténation,
	 * toutefois cette dernière est nécessaire pour écrire des nombres avec plus d'un chiffre
	 * on traite donc ce cas à part dasn une méthode qui réinitialise accu*/
	public void setAccuVide() {
		accu="";
	}
	
	
	/*Pour les méthode appui_plus / moins / multiplie / divise, on appelle la méthode du modèle
	 * correspondant et on fait prendre la valeur obtenue à accu pour l'affichage de la réponse*/
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
	
	/* Si le accu n'est pas vide, on envoie sa valeur en double dans la pile*/
	public void appui_entrer() {
		if(accu!="") {
			Double accuDouble = Double.parseDouble(accu);
			model.push(accuDouble);
			accu="";
		}
	}
	
	/*On fait appel à la fonction pour supprimer tout les éléments de la pile*/
	public void appui_C() {
		model.clear();
		accu="";
	}
	
	/*Si accu est vide on renvoie l'inverse du premier élément de la pile, sinon on revoie -accu*/
	public void appui_inv() {
		if(accu.isEmpty()) {
			Double a=model.pop();
			accu=Double.toString(-a);
			model.push(a);
		}
		else {
			Double accuDouble = Double.parseDouble(accu);
			accu=Double.toString(-accuDouble);
		}
	}
	
	/*Si le accu est non nul on crée un nouveau String avec la valeur de accu sans le dernier caractère
	 * et on le renvoie pour l'affichge*/
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
	
	/* on appelle la méthode qui échange les deux premier éléments de la pile*/
	public void appui_swap() {
		model.swap();
	}
	
	/*On récupère le première élément de la pile pour l'affichage dans la seconde zone de texte*/
	public String setAffichage_2(){
		Stack<Double >pile=model.getPile();
		Double a=pile.pop();
		pile.push(a);
		return (Double.toString(a));
	}
	
	/*On récupère le deuxième élément de la pile pour l'affichage dans la troisième zone de texte*/
	public String setAffichage_3() {
		Stack<Double >pile=model.getPile();
		Double a=pile.pop();
		Double b=pile.pop();
		pile.push(b);
		pile.push(a);
		return(Double.toString(b));
	}
	
	
	

}
