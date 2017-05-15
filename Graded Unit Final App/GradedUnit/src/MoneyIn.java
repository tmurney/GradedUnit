import java.util.*;


public class MoneyIn {

	private float value; //Variables are declared here
	private String reason;
	private int ID = 0;
	database database = new database();

	public MoneyIn(){ //Constructor that allows the class to be used globally.

	}


	public float getValue() { //Getters and setters for the variable float Value, will be used in other classes to retrieve information.
		return value;
	}
	public void setValue(float value) { //Will be used to define the variable Value
		this.value = value;
	}

	public String getReason() { //Getters and setters for the variable String Reason, will be used in other classes to retrive information.
		return reason;
	}
	public void setReason(String reason) { //Will be used to define the variable Reason.
		this.reason = reason;
	}

	public void Save(User user, Float value, String reason){ //Function to save the last transaction that has went through
		user.setLastPayment(getValue());
		user.setLastReason(getReason());
	}

	public void Transaction(User user, Float value, int ID) throws InputValidationException{ //Function to call the transaction of money coming in
		user.setBalance(user.getBalance() + value); //Money is coming in therefore the value will be added onto the overall balance
		setID(getID() + 1);
		
	}

	public void DatabaseUpdate(MoneyIn moneyin){
		database.DBMoneyIn(moneyin);
	}

	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


}
