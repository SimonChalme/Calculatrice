package view;
import java.util.Stack;
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
			
			TextField affichage=new TextField();
			affichage.setPrefSize(60,60);
			bp.setTop(affichage);
			
			GridPane gp=new GridPane();
			bp.setCenter(gp);
			
			Button bouton7=new Button("7");
			bouton7.setPrefSize(85,85); 
			gp.add(bouton7,0,0);
			bouton7.setOnAction(event->{
				controleur.accu+="7";
				affichage.setText(controleur.accu);
				});
			
			Button bouton8=new Button("8");
			bouton8.setPrefSize(85,85); 
			gp.add(bouton8,1,0);
			bouton8.setOnAction(event->{
				controleur.accu+="8";
				affichage.setText(controleur.accu);
				});
			
			Button bouton9=new Button("9");
			bouton9.setPrefSize(85,85); 
			gp.add(bouton9,2,0);
			bouton9.setOnAction(event->{
				controleur.accu+="9";
				affichage.setText(controleur.accu);
				});
			
			Button bouton4=new Button("4");
			bouton4.setPrefSize(85,85); 
			gp.add(bouton4,0,1);
			bouton4.setOnAction(event->{
				controleur.accu+="4";
				affichage.setText(controleur.accu);
				});
			
			Button bouton5=new Button("5");
			bouton5.setPrefSize(85,85); 
			gp.add(bouton5,1,1);
			bouton5.setOnAction(event->{
				controleur.accu+="5";
				affichage.setText(controleur.accu);
				});
			
			Button bouton6=new Button("6");
			bouton6.setPrefSize(85,85); 
			gp.add(bouton6,2,1);
			bouton6.setOnAction(event->{
				controleur.accu+="6";
				affichage.setText(controleur.accu);
				});
			
			Button bouton1=new Button("1");
			bouton1.setPrefSize(85,85); 
			gp.add(bouton1,0,2);
			bouton1.setOnAction(event->{
				controleur.accu+="1";
				affichage.setText(controleur.accu);
				});
			
			Button bouton2=new Button("2");
			bouton2.setPrefSize(85,85); 
			gp.add(bouton2,1,2);
			bouton2.setOnAction(event->{
				controleur.accu+="2";
				affichage.setText(controleur.accu);
				});
			
			Button bouton3=new Button("3");
			bouton3.setPrefSize(85,85); 
			gp.add(bouton3,2,2);
			bouton3.setOnAction(event->{
				controleur.accu+="3";
				affichage.setText(controleur.accu);
				});
			
			Button bouton0=new Button("0");
			bouton0.setPrefSize(85,85); 
			gp.add(bouton0,0,3);
			bouton0.setOnAction(event->{
				controleur.accu+="0";
				affichage.setText(controleur.accu);
				});
			
			Button bouton_virg=new Button(".");
			bouton_virg.setPrefSize(85,85); 
			gp.add(bouton_virg,1,3);
			bouton_virg.setOnAction(event->{
				if (!controleur.accu.contains(".")) {
					controleur.accu+=".";
					affichage.setText(controleur.accu);
					}
				});
			
			Button bouton_sign=new Button("+/-");
			bouton_sign.setPrefSize(85,85); 
			gp.add(bouton_sign,2,3);
			bouton_sign.setOnAction(event->{
				controleur.accu="-";
				affichage.setText(controleur.accu);
				});
			
		    GridPane gp2=new GridPane();
		    bp.setRight(gp2);
		    
		    Button bouton_plus=new Button("+");
	    	bouton_plus.setPrefSize(85,85); 
			gp2.add(bouton_plus,0,0);
			bouton_plus.setOnAction(event->{
				controleur.appui_plus();
				affichage.setText(controleur.accu);
				controleur.accu="";
				});
			
			Button bouton_moins=new Button("-");
	    	bouton_moins.setPrefSize(85,85); 
			gp2.add(bouton_moins,0,1);
			bouton_moins.setOnAction(event->{
				controleur.appui_moins();
				affichage.setText(controleur.accu);
				controleur.accu="";
				});
			
			Button bouton_fois=new Button("*");
	    	bouton_fois.setPrefSize(85,85); 
			gp2.add(bouton_fois,0,2);
			bouton_fois.setOnAction(event->{
				controleur.appui_fois();
				affichage.setText(controleur.accu);
				controleur.accu="";
				});
			
			Button bouton_divise=new Button("/");
	    	bouton_divise.setPrefSize(85,85); 
			gp2.add(bouton_divise,0,3);
			bouton_divise.setOnAction(event->{
				controleur.appui_divise();
				affichage.setText(controleur.accu);
				controleur.accu="";
				});
			
			Button bouton_entrer=new Button("<>");
	    	bouton_entrer.setPrefSize(85,85); 
			gp2.add(bouton_entrer,0,4);
			bouton_entrer.setOnAction(event->{
				controleur.appui_entrer();
				affichage.setText("");
				});
			
			Button bouton_C=new Button("C");
	    	bouton_entrer.setPrefSize(85,85); 
			gp2.add(bouton_C,0,5);
			bouton_C.setOnAction(event->{
				controleur.appui_C();
				affichage.setText("");
				});
		   
		    
			
			Scene scene = new Scene(bp,400,400);	
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
