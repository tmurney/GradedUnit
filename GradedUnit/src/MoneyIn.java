import java.util.*;


public class MoneyIn {

	private float value;
	private Date transactiondate;
	private String reason;

	public MoneyIn(){ //Constructor that allows the class to be used globally.

	}


	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}


	public Date getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}


	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	
	public void Transaction(User user, Float value) throws InputValidationException{
		user.setBalance(user.getBalance() + value);
	}


}
