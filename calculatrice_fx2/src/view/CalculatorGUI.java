package view;
import controler.CalculatorControlerInterface;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class CalculatorGUI implements CalculatorGUIInterface {
	
		private CalculatorControlerInterface controleur;

		// Constructor	
		public CalculatorGUI(CalculatorControlerInterface controleur) {
			this.controleur = controleur;
		}
		
	
		
	/* implémentation de la fonction affiche*/
		
	public Scene affiche() {
		
		
		/*création d'un nouveau BorderPane*/
		
		BorderPane bp=new BorderPane();
	
		
		/* création d'un GridPane envoyé en haut du BorderPane*/
		
		GridPane gp_aff=new GridPane();
		bp.setTop(gp_aff);
		
		
		/* création des 3 zone de texte, la première pour dialoguer avec l'utilisateur
		 * et les autres pour afficher les éléments de la pile. On empèche l'édition manuelle de ces
		 * zones et les insère dans le GridPane dédié à l'affichage gp_aff
		 */
		
		TextField affichage=new TextField();
		gp_aff.add(affichage, 0, 0);
		affichage.setPrefSize(340,40);
		affichage.setEditable(false);
	
		TextField affichage_2=new TextField();
		gp_aff.add(affichage_2, 0, 1);
		affichage_2.setPrefSize(340,40);
		affichage_2.setEditable(false);
		
		TextField affichage_3=new TextField();
		gp_aff.add(affichage_3, 0, 2);
		affichage_3.setPrefSize(340,40);
		affichage_3.setEditable(false);
		
		
		/* création d'un gridPane envoyé au milieu du borderPane*/
		GridPane gp=new GridPane();
		bp.setCenter(gp);
		
		/* création des boutons de 0 à 9, on les place sur le gridPane dédié aux boutons
		 * Pour chacun de ces boutons, on défini l'action :
		 * On modifie l'accu et on le récupère pour l'affichage
		 */
		Button bouton7=new Button("7");
		bouton7.setPrefSize(85,85); 
		gp.add(bouton7,0,1);
		bouton7.setOnAction(event->{
			controleur.setAccu("7");
			affichage.setText(controleur.getAccu());
			});
		
		Button bouton8=new Button("8");
		bouton8.setPrefSize(85,85); 
		gp.add(bouton8,1,1);
		bouton8.setOnAction(event->{
			controleur.setAccu("8");
			affichage.setText(controleur.getAccu());
			});
		
		Button bouton9=new Button("9");
		bouton9.setPrefSize(85,85); 
		gp.add(bouton9,2,1);
		bouton9.setOnAction(event->{
			controleur.setAccu("9");
			affichage.setText(controleur.getAccu());
			});
		
		Button bouton4=new Button("4");
		bouton4.setPrefSize(85,85); 
		gp.add(bouton4,0,2);
		bouton4.setOnAction(event->{
			controleur.setAccu("4");
			affichage.setText(controleur.getAccu());
			});
		
		Button bouton5=new Button("5");
		bouton5.setPrefSize(85,85); 
		gp.add(bouton5,1,2);
		bouton5.setOnAction(event->{
			controleur.setAccu("5");
			affichage.setText(controleur.getAccu());
			});
		
		Button bouton6=new Button("6");
		bouton6.setPrefSize(85,85); 
		gp.add(bouton6,2,2);
		bouton6.setOnAction(event->{
			controleur.setAccu("6");
			affichage.setText(controleur.getAccu());
			});
		
		Button bouton1=new Button("1");
		bouton1.setPrefSize(85,85); 
		gp.add(bouton1,0,3);
		bouton1.setOnAction(event->{
			controleur.setAccu("1");
			affichage.setText(controleur.getAccu());
			});
		
		Button bouton2=new Button("2");
		bouton2.setPrefSize(85,85); 
		gp.add(bouton2,1,3);
		bouton2.setOnAction(event->{
			controleur.setAccu("2");
			affichage.setText(controleur.getAccu());
			});
		
		Button bouton3=new Button("3");
		bouton3.setPrefSize(85,85); 
		gp.add(bouton3,2,3);
		bouton3.setOnAction(event->{
			controleur.setAccu("3");
			affichage.setText(controleur.getAccu());
			});
		
		Button bouton0=new Button("0");
		bouton0.setPrefSize(85,85); 
		gp.add(bouton0,1,4);
		bouton0.setOnAction(event->{
			controleur.setAccu("0");
			affichage.setText(controleur.getAccu());
			});
		
		
		/* Création du bouton pour la virgule
		 * On définit son action : Si une virgule n'est pas présente dans le accu, on en ajoute une
		 * et on renvoie la valeur de accu pour l'affichage*/
		
		Button bouton_virg=new Button(".");
		bouton_virg.setPrefSize(85,85); 
		gp.add(bouton_virg,2,4);
		bouton_virg.setOnAction(event->{
			if (!controleur.getAccu().contains(".")) {
				controleur.setAccu(".");
				affichage.setText(controleur.getAccu());
				}
			});
		
		
		/* Création du bouton pour changer de signe
		 * On définit son action : On fait appel à la méthode correspondante dans le controler 
		 * et on renvoie la valeur de accu pour l'affichage
		 */
		
		Button bouton_sign=new Button("+/-");
		bouton_sign.setPrefSize(85,85); 
		gp.add(bouton_sign,0,4);
		bouton_sign.setOnAction(event->{
			controleur.appui_inv();
			affichage.setText(controleur.getAccu());
			});
		
		
		/* Création des boutons +,-,*,/
		 * A chaque fois on définit son action : On fait appel à la méthode correspondante dans le controler 
		 * et on renvoie la valeur de accu pour l'affichage
		 */
		
	    Button bouton_plus=new Button("+");
    	bouton_plus.setPrefSize(85,85); 
		gp.add(bouton_plus,3,0);
		bouton_plus.setOnAction(event->{
			controleur.appui_plus();
			controleur.setAccuVide();
			
			/* Gestion de l'affichage des éléments de la pile
			 * Si il y a plus d'un élément, on vérifie si il y en a deux 
			 * Si c'est le cas on affiche les deux premiers éléments dans les zones de texte correspondantes
			 * Sinon on affiche seulement l'unique valeur dans la seconde zone d'affichage
			 * Sinon on affiche rien dans les deux zones */
			if(controleur.getModel().getPile().size()>0) {
				affichage_2.setText(controleur.setAffichage_2());
				if(controleur.getModel().getPile().size()>1) {
					affichage_3.setText(controleur.setAffichage_3());
				}
				else {
					affichage_3.setText("");
				}
			}
			else {
					affichage_2.setText("");
					affichage_3.setText("");
			}
			});
		
		Button bouton_moins=new Button("-");
    	bouton_moins.setPrefSize(85,85); 
		gp.add(bouton_moins,3,1);
		bouton_moins.setOnAction(event->{
			controleur.appui_moins();
			controleur.setAccuVide();
			if(controleur.getModel().getPile().size()>0) {
				affichage_2.setText(controleur.setAffichage_2());
				if(controleur.getModel().getPile().size()>1) {
					affichage_3.setText(controleur.setAffichage_3());
				}
				else {
					affichage_3.setText("");
				}
			}
			else {
					affichage_2.setText("");
					affichage_3.setText("");
			}
			});
		
		Button bouton_fois=new Button("*");
    	bouton_fois.setPrefSize(85,85); 
		gp.add(bouton_fois,3,2);
		bouton_fois.setOnAction(event->{
			controleur.appui_fois();
			controleur.setAccuVide();
			if(controleur.getModel().getPile().size()>0) {
				affichage_2.setText(controleur.setAffichage_2());
				if(controleur.getModel().getPile().size()>1) {
					affichage_3.setText(controleur.setAffichage_3());
				}
				else {
					affichage_3.setText("");
				}
			}
			else {
					affichage_2.setText("");
					affichage_3.setText("");
			}
			});
		
		Button bouton_divise=new Button("/");
    	bouton_divise.setPrefSize(85,85); 
		gp.add(bouton_divise,3,3);
		bouton_divise.setOnAction(event->{
			controleur.appui_divise();
			controleur.setAccuVide();
			if(controleur.getModel().getPile().size()>0) {
				affichage_2.setText(controleur.setAffichage_2());
				if(controleur.getModel().getPile().size()>1) {
					affichage_3.setText(controleur.setAffichage_3());
				}
				else {
					affichage_3.setText("");
				}
			}
			else {
					affichage_2.setText("");
					affichage_3.setText("");
			}
			});
		
		
		/*
		 * Création du bouton entrer
		 * On définit son action : On fait appel à la méthode correspondante dans le controler
		 * On remmet le texte à 0 (accu à été réinitialisé dans la méthode appui_entrer*/
		
		Button bouton_entrer=new Button("<>");
    	bouton_entrer.setPrefSize(85,85); 
		gp.add(bouton_entrer,3,4);
		bouton_entrer.setOnAction(event->{
			controleur.appui_entrer();
			affichage.setText("");
			if(controleur.getModel().getPile().size()>0) {
				affichage_2.setText(controleur.setAffichage_2());
				if(controleur.getModel().getPile().size()>1) {
					affichage_3.setText(controleur.setAffichage_3());
				}
				else {
					affichage_3.setText("");
				}
			}
			else {
					affichage_2.setText("");
					affichage_3.setText("");
			}
			});
		
		
		/*
		 * Création du bouton pour la remise à 0
		 * On définit son action : On fait appel à la méthode correspondante dans le controler
		 * On remmet le texte à 0 (accu à été réinitialisé dans la méthode appui_C*/
		
		Button bouton_C=new Button("C");
    	bouton_C.setPrefSize(85,85); 
		gp.add(bouton_C,0,0);
		bouton_C.setOnAction(event->{
			controleur.appui_C();
			affichage.setText("");
			if(controleur.getModel().getPile().size()>0) {
				affichage_2.setText(controleur.setAffichage_2());
				if(controleur.getModel().getPile().size()>1) {
					affichage_3.setText(controleur.setAffichage_3());
				}
				else {
					affichage_3.setText("");
				}
			}
			else {
					affichage_2.setText("");
					affichage_3.setText("");
			}
			});
			
		
		/*
		 * Création du bouton swap
		 * On définit son action : On fait appel à la méthode correspondante dans le controler
		 * On remmet le texte à 0 (accu à été réinitialisé dans la méthode appui_swap*/
		Button bouton_swap=new Button("swap");
    	bouton_swap.setPrefSize(85,85); 
		gp.add(bouton_swap,2,0);
		bouton_swap.setOnAction(event->{
			controleur.appui_swap();
			affichage.setText("");
			if(controleur.getModel().getPile().size()>0) {
				affichage_2.setText(controleur.setAffichage_2());
				if(controleur.getModel().getPile().size()>1) {
					affichage_3.setText(controleur.setAffichage_3());
				}
				else {
					affichage_3.setText("");
				}
			}
			else {
					affichage_2.setText("");
					affichage_3.setText("");
			}
			});
	   
		
		/*
		 * Création du bouton entrer
		 * On définit son action : On fait appel à la méthode correspondante dans le controler
		 * On renvoie accu dans l'affichage
		 */
		Button bouton_retour=new Button("<-");
    	bouton_retour.setPrefSize(85,85); 
		gp.add(bouton_retour,1,0);
		bouton_retour.setOnAction(event->{
			controleur.setAccu(controleur.appui_retour());
			affichage.setText(controleur.getAccu());
			});
	    
		/* création d'une nouvelle scène à partir du borderPane définit dans les étapes précedentes
		 * 
		 */
		Scene scene = new Scene(bp,340,460);
	return (scene);
}

}
