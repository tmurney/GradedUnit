import java.util.*;

public class MoneyOut {

	private float value; //Variables established here
	private String reason;
	private int ID;

	database database = new database();

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public MoneyOut(){ //A public constructor with info to be added

	}

	public float getValue() { 			//Getters and setters are established here
		return value;
	}
	public void setValue(float value)  {
		this.value = value;
	}


	public String getReason() {
		return reason;
	}
	public void setReason(String reason){
		this.reason = reason;
	}


	public void Transaction(User user, Float value) throws InputValidationException{  //Function to make a transaction going Out

			user.setBalance(user.getBalance() - value); //Money is going out so the value will be taken from the overall balance

			if(user.getBalance() < 0){ //If the user has less than no money, they are in debt.
				user.setInDebt(true); //Making this boolean true means the user is in debt.
			}



	}

	public void Save(User user, Float value, String reason){ //Function to save the transaction as the last one made
		user.setLastPayment(getValue());
		user.setLastReason(getReason());
	}

	public void DatabaseUpdate(MoneyOut moneyout){
		database.DBMoneyOut(moneyout);
	}


}
