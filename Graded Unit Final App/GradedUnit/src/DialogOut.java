import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import java.io.*;
import javafx.geometry.*;
import javafx.scene.text.Font;

public class DialogOut extends GridPane{

	public DialogOut(){

	setAlignment(Pos.CENTER);			//The GUI will be laid out in the centre
    setHgap(10); //Horizontal Bordering
    setVgap(10); //Vertical Bordering
    setPadding(new Insets(10, 10, 10, 10)); //Border Padding


    Label lblValue = new Label("Value (In £):"); //Label which describes the value
	add(lblValue, 0, 0); //Where the label is placed
	lblValue.setFont(new Font("Arial", 20)); //The font of the label

	Label lblReason = new Label("Reason:"); //Label which describes the Reason
	add(lblReason, 0, 1); //Where the label is placed
	lblReason.setFont(new Font("Arial", 20)); //The font of the label

    TextField txtValue = new TextField(); //The textfield for the user to enter the Value
    add(txtValue, 1 , 0); //Where the textfield is placed
    txtValue.setPromptText("Value"); //Text which is lightly coloured to prompt user input

	TextField txtReason = new TextField(); //Textfield for the user to enter the Reason
	add(txtReason, 1, 1); //Where the textfield is placed
	txtReason.setPromptText("Reason"); //Text which is lightly coloured to prompt user input

	Button cmdSubmit = new Button(); //Creates a new button for the system.
	cmdSubmit.setText("Submit"); //The text that will be on the button
	add(cmdSubmit, 0, 3); //Where the button is placed
	cmdSubmit.setFont(new Font("Arial", 15)); //The font of the button

	Button cmdBack = new Button(); //Creates a new button for the system.
	cmdBack.setText("Back"); //The text that will be on the button
	add(cmdBack, 1, 3); //Where the button is placed
	cmdBack.setFont(new Font("Arial", 15)); //The font of the Buttn

	cmdSubmit.setOnAction(new EventHandler<ActionEvent>(){ //Event Handler for Submitting

		@Override
		public void handle(ActionEvent event) {

			if(event.getSource() == cmdSubmit){

			MoneyOut moneyout = new MoneyOut(); //Used so variables can be used globally

			try {
				moneyout.setValue(Float.valueOf(txtValue.getText())); //Because the textfield is a String variable, I have to convert that into a float value.
			} catch (NumberFormatException e) { //Try catch for error handling

				System.out.println("Error" + e);
				e.printStackTrace();

			}


			try {
				moneyout.setReason(txtReason.getText()); //The text will be saved
			} catch (Exception e) { //Try catch for error handling
				System.out.println("Error" + e);
				e.printStackTrace();
			}

			try {
				moneyout.Transaction(UrBankMain.user, moneyout.getValue()); //The function for the transaction
				moneyout.Save(UrBankMain.user, moneyout.getValue(), moneyout.getReason()); //Function made to save the last transaction to go through
				moneyout.DatabaseUpdate(moneyout);
				UrBankMain.stage.setScene(new Scene(new MainMenuPane(), 750, 300)); //Returns the user to the main menu with the transaction going through

			} catch (InputValidationException e) { //Throws new input validation exception
				System.out.println("Error" + e);
				e.printStackTrace();
			}
		}
		}
	});


	cmdBack.setOnAction(new EventHandler<ActionEvent>(){ //Event handler for going back

		@Override
		public void handle(ActionEvent event) {

			if(event.getSource() == cmdBack){
				UrBankMain.stage.setScene(new Scene(new MainMenuPane(), 750, 300)); //User returns to main menu, with NO transaction taking place
			}
		}
	});




}

}
