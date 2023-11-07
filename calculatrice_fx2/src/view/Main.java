package view;

import controler.CalculatorControler;
import controler.CalculatorControlerInterface;
import model.CalculatorModel;
import model.CalculatorModelInterface;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



	public class Main extends Application {
		 public static void main(String[] args) {
		        launch(args);
		    }
		 
		 public void start(Stage primaryStage) {

			 /*Création du dans l'odre du model, du controler et du gui en signifiant à chaque fois aux objets
			  * avec quels entités ils sont liés*/
			 
		        CalculatorModelInterface model = new CalculatorModel();
		        CalculatorControlerInterface controler = new CalculatorControler(model);
		        CalculatorGUIInterface gui = new CalculatorGUI(controler);

		        /*Récupération de la scène avec affiche et mise en place du Stage*/
		        Scene scene = gui.affiche();
		        primaryStage.setTitle("Ma calculette");
		        primaryStage.setScene(scene);
		        primaryStage.show();
		    }

	}


