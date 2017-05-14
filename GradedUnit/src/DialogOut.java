import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import java.io.*;
import javafx.geometry.*;


public class DialogOut extends GridPane{

	public DialogOut(){

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
			MoneyOut moneyout = new MoneyOut();

			try {
				moneyout.setValue(Float.valueOf(txtValue.getText()));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //Because the textfield is a String variable, I have to convert that into a float value.
			
			
			try {
				moneyout.setReason(txtReason.getText());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				moneyout.Transaction(UrBankMain.user, moneyout.getValue());
				UrBankMain.stage.setScene(new Scene(new MainMenuPane(), 750, 300));
			} catch (InputValidationException e) {

				e.printStackTrace();
			}
		}
		}
	});


}

}
