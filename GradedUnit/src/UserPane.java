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
import javafx.scene.input.*;
import javafx.scene.layout.*;
import java.io.*;
import javafx.geometry.*;



public class UserPane extends GridPane {


	public UserPane() {

		setAlignment(Pos.CENTER);
	    setHgap(10);
	    setVgap(10);
	    setPadding(new Insets(10, 10, 10, 10));


	    Label lblName = new Label("Username:");
		add(lblName, 0, 0);


		Label lblPass = new Label("Password:");
		add(lblPass, 0, 1);


	    TextField txtUsername = new TextField();
	    add(txtUsername, 1 , 0);
	    txtUsername.setPromptText("Username");

		TextField txtPassword = new TextField();
		add(txtPassword, 1, 1);
		txtPassword.setPromptText("Password");


		Button cmdLogin = new Button(); //Creates a new button for the login system.
		cmdLogin.setText("Log In to UrBank"); //The text that will be on the button
		add(cmdLogin, 1, 3);


		Label lblAlert = new Label();
		lblAlert.setText("");
		add(lblAlert, 1, 5);




	cmdLogin.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {

			if(event.getSource() == cmdLogin){
				try{
					database database = new database();
					User user = new User();



					user.setUsername(txtUsername.getText());
					user.setPassword(txtPassword.getText());

					database.DBLogin(user);

					if(user.isCorrect()){

						
						UrBankMain.user.setUsername(user.getUsername());
						UrBankMain.user.setFirstname(user.getFirstname());
						UrBankMain.user.setLastname(user.getLastname());
						UrBankMain.user.setBalance(user.getBalance());

						UrBankMain.stage.setScene(new Scene(new MainMenuPane(), 600, 300));

					} else {
						lblAlert.setText("Incorrect username and/or password");

					}

				} catch(Exception e) {

					lblAlert.setText("Connection Failed");
					e.printStackTrace();

				}



			}
		}


	});








	}





}
