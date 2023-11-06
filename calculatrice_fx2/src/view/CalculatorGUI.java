package view;
import java.util.Stack;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import controler.CalculatorControler;

public class CalculatorGUI extends Application implements CalculatorGUIInterface {
	
		public CalculatorControler controleur;

		// Constructor	
		public CalculatorGUI() {
			this.controleur = new CalculatorControler();
		}
		
	public void start(Stage primaryStage) {
		try {
			
			BorderPane bp=new BorderPane();
			
			GridPane gp_aff=new GridPane();
			bp.setTop(gp_aff);
			
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
			
			
			
			GridPane gp=new GridPane();
			bp.setCenter(gp);
			
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
			
			Button bouton_virg=new Button(".");
			bouton_virg.setPrefSize(85,85); 
			gp.add(bouton_virg,2,4);
			bouton_virg.setOnAction(event->{
				if (!controleur.getAccu().contains(".")) {
					controleur.setAccu(".");
					affichage.setText(controleur.getAccu());
					}
				});
			
			Button bouton_sign=new Button("+/-");
			bouton_sign.setPrefSize(85,85); 
			gp.add(bouton_sign,0,4);
			bouton_sign.setOnAction(event->{
				controleur.appui_inv();
				affichage.setText(controleur.getAccu());
				});
			
		    
		    Button bouton_plus=new Button("+");
	    	bouton_plus.setPrefSize(85,85); 
			gp.add(bouton_plus,3,0);
			bouton_plus.setOnAction(event->{
				controleur.appui_plus();
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
		   
			Button bouton_retour=new Button("<-");
	    	bouton_retour.setPrefSize(85,85); 
			gp.add(bouton_retour,1,0);
			bouton_retour.setOnAction(event->{
				controleur.setAccu(controleur.appui_retour());
				affichage.setText(controleur.getAccu());
				});
		    
			
			Scene scene = new Scene(bp,340,460);
			scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void affiche() {
		launch();}
	
	public void change(String accu) {}
	public void change(Stack<Double> stackData) {}

}
