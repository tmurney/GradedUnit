import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.geometry.*;


public class DialogIn extends GridPane{

	public DialogIn(){

	setAlignment(Pos.CENTER);	//The GUI will be laid out in the centre
    setHgap(10);		//Horizontal Bordering
    setVgap(10);		//Vertical Bordering
    setPadding(new Insets(10, 10, 10, 10)); //Border Padding


    Label lblValue = new Label("Value (In £):");						//Creates a new Label with text
    lblValue.setFont(new Font("Arial", 20));		//Defines the font
	add(lblValue, 0, 0);		//positions the label


	Label lblReason = new Label("Reason:");								//Creates a new button for the text field
	lblReason.setFont(new Font("Arial", 20));
	add(lblReason, 0, 1);		//positions the label


    TextField txtValue = new TextField(); //Creates a new button for the text field
    add(txtValue, 1 , 0); //positions the label
    txtValue.setPromptText("Value"); //Shows text in a lighter colour to prompt user input

	TextField txtReason = new TextField(); //Creates a new textfield for the logi
	add(txtReason, 1, 1); //positions the label
	txtReason.setPromptText("Reason"); //Shows text in a lighter colour to prompt user input


	Button cmdSubmit = new Button(); //Creates a new button for the system.
	cmdSubmit.setText("Submit"); //The text that will be on the button
	add(cmdSubmit, 0, 3); //Puts the button in coordinates laid in the gridpane


	Button cmdBack = new Button(); 	//Creates a new button for the system.
	cmdBack.setText("Back"); //The text that will be on the button
	add(cmdBack, 1, 3);
	lblValue.setFont(new Font("Arial", 15));


	cmdSubmit.setOnAction(new EventHandler<ActionEvent>(){  			//Event Handler

		@Override
		public void handle(ActionEvent event) {

		if(event.getSource() == cmdSubmit){	//Event handler for when Submit is pressed
			MoneyIn moneyin = new MoneyIn();
			database database = new database(); //""

			try {
				moneyin.setValue(Float.valueOf(txtValue.getText())); 	//Will be taking in the Textfield named txtValue as the Value variable.
			} catch (NumberFormatException e) { 						//The value variable is a float, and will only be accepted as a number and not a String.
				System.out.println("Error" + e); 						//Displays the error message and throws a new exception
				e.printStackTrace();
			}


			try {
				moneyin.setReason(txtReason.getText());					//Sets the text input and stores it as a reason.
			} catch (Exception e) {										//Try Catch for error handling
				System.out.println("Error: " + e);
				e.printStackTrace();									//Displays the error message and throws a new exception
			}





			try {
				
				moneyin.Transaction(UrBankMain.user, moneyin.getValue(), moneyin.getID()); //Runs the transaction function made in the MoneyIn class
				moneyin.Save(UrBankMain.user, moneyin.getValue(), moneyin.getReason()); //Runs a function that saves the last transaction made in the MoneyIn class
				database.DBUpdateBalance(UrBankMain.user);
				UrBankMain.stage.setScene(new Scene(new MainMenuPane(), 750, 300)); //Returns the user to the main menu



			} catch (InputValidationException e) { //Try Catch for error handling
				System.out.println("Error:" + e);
				e.printStackTrace();
			}
		}
	}
});


	cmdBack.setOnAction(new EventHandler<ActionEvent>(){ //Event Handler

		@Override
		public void handle(ActionEvent event) {

			if(event.getSource() == cmdBack){
				UrBankMain.stage.setScene(new Scene(new MainMenuPane(), 750, 300)); //Returns the main menu with no effect on the balance.
			}
		}
	});


}

}
