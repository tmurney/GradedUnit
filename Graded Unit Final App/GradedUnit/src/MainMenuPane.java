import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.text.Font;
//Libraries are imported

public class MainMenuPane extends GridPane{ //This defines that this GUI pane will be using the GridPane format

public MainMenuPane(){ //A constructor which allows this to be used globally


	setAlignment(Pos.CENTER); //The GUI will be laid out in the centre
    setHgap(10); //Horizontal Bordering
    setVgap(10); //Vertical Bordering
    setPadding(new Insets(10)); //Border Padding

    Label lblName = new Label("Welcome " + UrBankMain.user.getFirstname() + " " + UrBankMain.user.getLastname() + "."); //Welcome Message
    add(lblName, 2, 0); //Where the label is placed
    lblName.setFont(new Font("Arial", 20)); //The font of the label

    Label lblStatus = new Label("Your balance is currently standing at £" + UrBankMain.user.getBalance()); //Displays the balance of the user
	add(lblStatus, 2, 1); //Where the label is placed
	lblStatus.setFont(new Font("Arial", 20)); //Font of the label

	Button cmdAddMoneyIn = new Button("Add Money In"); //Button to add money in
	cmdAddMoneyIn.setFont(new Font("Arial", 15)); //Font of the button text
	add(cmdAddMoneyIn, 1, 5); //Where the button is placed


	Button cmdAddMoneyOut = new Button("Add Money Out"); //Button to take money out
	add(cmdAddMoneyOut, 3, 5); //Where the button is placed
	cmdAddMoneyOut.setFont(new Font("Arial", 15)); //Font of the button text

	Button cmdLogOut = new Button("Log Out"); //Button to log out
	add(cmdLogOut, 1, 6); //Where the button is located
	cmdLogOut.setFont(new Font("Arial", 15)); //Font of the button text

	Label lblLastPay = new Label("Last Payment: £" + UrBankMain.user.getLastPayment()); //Displays the last payment made
	add(lblLastPay, 2, 2); //Where the label is placed
	lblLastPay.setFont(new Font("Arial", 20)); //Font of the label

	Label lblLastReason = new Label("Reason: " + UrBankMain.user.getLastReason()); //Displays the reason for that payment
	add(lblLastReason, 2, 3); //Where the label is placed
	lblLastReason.setFont(new Font("Arial", 20)); //Font of the label

	if(UrBankMain.user.isInDebt()){ //If the user has less than 0 pounds in their account
		lblName.setText(UrBankMain.user.getFirstname() + " " + UrBankMain.user.getLastname() + ", you are currently out of funds."); //Displays this message
	}

	cmdLogOut.setOnAction(new EventHandler<ActionEvent>(){ //Event handler for logging out

		@Override
		public void handle(ActionEvent event) {

			if(event.getSource() == cmdLogOut){
				UrBankMain.stage.setScene(new Scene(new UserPane(), 300, 300)); //Will bring back the log in screen.
			}
		}
	});



	cmdAddMoneyIn.setOnAction(new EventHandler<ActionEvent>(){ //Event handler for adding money in

		@Override
		public void handle(ActionEvent event) {

			if(event.getSource() == cmdAddMoneyIn){
				UrBankMain.stage.setScene(new Scene(new DialogIn(), 300, 300)); //Will prompt the user to add in money
			}
		}
	});




	cmdAddMoneyOut.setOnAction(new EventHandler<ActionEvent>(){ //Event handler for taking money out

		@Override
		public void handle(ActionEvent event) {

			if(event.getSource() == cmdAddMoneyOut){
				UrBankMain.stage.setScene(new Scene(new DialogOut(), 300, 300)); //Will prompt user to take money out
			}
		}
	});



}







}








