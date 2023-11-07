package controler;

import model.CalculatorModelInterface;

public interface CalculatorControlerInterface {
	
	/* déclaration des getter et des setter*/
	public void setAccu(String a);
	public String getAccu();
	public CalculatorModelInterface getModel();
	
	/* déclaration dans l'interface des méthodes liée aux évenement 
	 * quand un bouton est cliqué
	 */
	public void appui_plus();
	public void appui_moins();
	public void appui_fois();
	public void appui_divise();
	public void appui_entrer();
	public void appui_inv();
	public void appui_C();
	public String appui_retour();
	public void appui_swap();
	public void setAccuVide();
	
	/* déclaration dans l'interface des méthode 
	 pour gérer l'affichage dans différentes zone de texte de la calculette
	 */
	public String setAffichage_2();
	public String setAffichage_3();
	

}
