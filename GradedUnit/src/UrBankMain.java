/**
 *
 */

/**
 * @author Thomas
 *
 */

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import java.io.*;
import javafx.geometry.*;



	public class UrBankMain extends Application{

		public static User user = new User();
		public static Stage stage;



	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;

		UserPane userpane = new UserPane();
		MainMenuPane menu = new MainMenuPane();
		Scene scene = new Scene(userpane, 300, 300);
		Scene scene2 = new Scene(menu, 900, 600);

		primaryStage.setTitle("Murphy's UrBank");
		primaryStage.setScene(scene);

	
		primaryStage.show();


	}



	public static void main(String[] args){
		launch(args); //Calls arguments loading up the program as an application
	}



	}





