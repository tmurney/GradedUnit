/**
 *
 */

/**
 * @author Thomas
 *
 */
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.text.Font;


public class UserPane extends GridPane {


	public UserPane() {

		setAlignment(Pos.CENTER); //The pane will be primarily centred otherwise specified
	    setHgap(10); //Horizontal Bordering
	    setVgap(10); //Vertical Bordering
	    setPadding(new Insets(10, 10, 10, 10)); //The space that the border must leave in the window.


	    Label lblName = new Label("Username:"); //The text in a label
		add(lblName, 0, 0); //Added according to coordinates in the GridPane
		lblName.setFont(new Font("Arial", 20));

		Label lblPass = new Label("Password:"); //The text in the label
		add(lblPass, 0, 1); //Added according to coordinates in the GridPane
		lblPass.setFont(new Font("Arial", 20));

	    TextField txtUsername = new TextField(); //Textfield made for the username entry
	    add(txtUsername, 1 , 0); //Added according to coordinates in the GridPane
	    txtUsername.setPromptText("Username"); //Text appears in a light colouring to prompt the user what to put in.

		TextField txtPassword = new TextField(); //Textfield made for the password entry
		add(txtPassword, 1, 1); //Added according to coordinates in the GridPane
		txtPassword.setPromptText("Password"); //Text appears in a light colouring to prompt the user what to put in.


		Button cmdLogin = new Button(); //Creates a new button for the login system.
		cmdLogin.setText("Log In to UrBank"); //The text that will be on the button
		add(cmdLogin, 0, 3); //Added according to coordinates in the GridPane


		Label lblAlert = new Label();
		lblAlert.setText(""); //Left blank to later be changed if an event happens i.e. Incorrect Username or Password
		add(lblAlert, 1, 5); //Added according to coordinates in the GridPane




	cmdLogin.setOnAction(new EventHandler<ActionEvent>(){   //Event Handler

		@Override
		public void handle(ActionEvent event) {

			if(event.getSource() == cmdLogin){
				try{
					database database = new database();
					User user = new User();
					//Constructors to be added in order to use local variables.



					user.setUsername(txtUsername.getText()); //The attempted username will be taken in from the TextField
					user.setPassword(txtPassword.getText()); //The attempted password will be taken in from the TextField

					database.DBLogin(user); //Taking these details in will go through a function in the Database class

					if(user.isCorrect()){

						//User made in Main Class's details will match the details in this class.
						UrBankMain.user.setUsername(user.getUsername());
						UrBankMain.user.setFirstname(user.getFirstname());
						UrBankMain.user.setLastname(user.getLastname());
						UrBankMain.user.setBalance(user.getBalance());

						UrBankMain.stage.setScene(new Scene(new MainMenuPane(), 750, 300));
						//If the login is correct, then the users details will be stored as a current user and will have access to the main menu.

					} else {
						lblAlert.setText("Incorrect username and/or password"); //Shown up in the event of an incorrect entry

					}

				} catch(Exception e) { //If there were an error it would have something to do with the database, therefore an exception must be thrown.

					lblAlert.setText("Connection Failed");
					e.printStackTrace();

				}



			}
		}


	});










	}





}
