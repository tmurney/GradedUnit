/**
 *
 */

/**
 * @author Thomas
 *
 */

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;




	public class UrBankMain extends Application{ //Main Class incorporates Java FX

		public static User user = new User(); //New User which takes its variables from the UserPane class
		public static Stage stage; //Needed to show windows of the application



	@Override
	public void start(Stage primaryStage) throws Exception { //Will be ran as part of the Code
		stage = primaryStage;

		UserPane userpane = new UserPane(); //Starts from Userpane, which acts as a login screen
		Scene scene = new Scene(userpane, 500, 300); //Userpane will start, with dimensions 400x300


		primaryStage.setTitle("Murphy's UrBank"); //The title at the top of the window is established
		primaryStage.setScene(scene);


		primaryStage.show(); //The application runs


	}



	public static void main(String[] args){
		launch(args); //Calls arguments loading up the program as an application
	}



	}





