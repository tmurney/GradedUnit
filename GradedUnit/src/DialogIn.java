import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import java.io.*;
import javafx.geometry.*;


public class DialogIn extends GridPane{

	public DialogIn(){

	setAlignment(Pos.CENTER);
    setHgap(10);
    setVgap(10);
    setPadding(new Insets(10, 10, 10, 10));


    Label lblValue = new Label("Value (In £):");
	add(lblValue, 0, 0);


	Label lblReason = new Label("Reason:");
	add(lblReason, 0, 1);


    TextField txtValue = new TextField();
    add(txtValue, 1 , 0);
    txtValue.setPromptText("Value");

	TextField txtReason = new TextField();
	add(txtReason, 1, 1);
	txtReason.setPromptText("Reason");


	Button cmdSubmit = new Button(); //Creates a new button for the login system.
	cmdSubmit.setText("Submit"); //The text that will be on the button
	add(cmdSubmit, 1, 3);
	
	
	
	cmdSubmit.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {

			if(event.getSource() == cmdSubmit){
			MoneyIn moneyin = new MoneyIn();
			database database = new database();
			moneyin.setValue(Float.valueOf(txtValue.getText())); //Because the textfield is a String variable, I have to convert that into a float value.
			moneyin.setReason(txtReason.getText());
			
			try {
				moneyin.Transaction(UrBankMain.user, moneyin.getValue());
				database.DBMoneyIn(moneyin);
				UrBankMain.stage.setScene(new Scene(new MainMenuPane(), 750, 300));
			} catch (InputValidationException e) {
			
				e.printStackTrace();
			}
		}
		}
	});



}

}
