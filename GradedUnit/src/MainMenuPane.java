import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import java.io.*;
import javafx.geometry.*;


public class MainMenuPane extends GridPane{

public MainMenuPane(){


	setAlignment(Pos.CENTER);
    setHgap(5);
    setVgap(5);
    setPadding(new Insets(5));

    Label lblName = new Label("Welcome " + UrBankMain.user.getFirstname() + " " + UrBankMain.user.getLastname() + ", your balance is currently standing at £" + UrBankMain.user.getBalance());
	add(lblName, 2, 0);

	Button cmdAddMoneyIn = new Button("Add Money In");
	add(cmdAddMoneyIn, 1, 1);

	Button cmdAddMoneyOut = new Button("Add Money Out");
	add(cmdAddMoneyOut, 3, 1);

	Button cmdLogOut = new Button("Log Out");
	add(cmdLogOut, 1, 3);


	
	
	if(UrBankMain.user.isInDebt()){
		lblName.setText(UrBankMain.user.getFirstname() + " " + UrBankMain.user.getLastname() + ", you are currently out of funds. You have a current balance of: £" + UrBankMain.user.getBalance()  );
	}
	
	cmdLogOut.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {

			if(event.getSource() == cmdLogOut){
				UrBankMain.stage.setScene(new Scene(new UserPane(), 300, 300)); //Will bring back the log in screen.//
			}
		}
	});



	cmdAddMoneyIn.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {

			if(event.getSource() == cmdAddMoneyIn){
				UrBankMain.stage.setScene(new Scene(new DialogIn(), 300, 300));
			}
		}
	});



	
	cmdAddMoneyOut.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {

			if(event.getSource() == cmdAddMoneyOut){
				UrBankMain.stage.setScene(new Scene(new DialogOut(), 300, 300));
			}
		}
	});



}
	
	





}








