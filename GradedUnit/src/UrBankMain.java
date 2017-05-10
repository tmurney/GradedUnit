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


		private static User currentuser;


	public static User getCurrentuser() {
			return currentuser;
		}

	public static void setCurrentuser(User newcurrentuser) {
			currentuser = newcurrentuser;
		}



	@Override
	public void start(Stage primaryStage) throws Exception {

		UserPane user = new UserPane();
		Scene scene = new Scene(user, 300, 300);


		primaryStage.setTitle("Murphy's UrBank");
		primaryStage.setScene(scene);
		primaryStage.show();


	}



	public static void main(String[] args){
		launch(args); //Calls arguments loading up the program as an application
	}



	}





