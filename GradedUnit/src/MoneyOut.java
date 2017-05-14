import java.util.*;

public class MoneyOut {

	private float value;
	private Date transactiondate;
	private String reason;
	
	public MoneyOut(){
		
	}
	
	public float getValue() {
		return value;
	}
	public void setValue(float value)  {
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
	public void setReason(String reason){
		this.reason = reason;
	}
	
	
	public void Transaction(User user, Float value) throws InputValidationException{
		
			user.setBalance(user.getBalance() - value);
			
			if(user.getBalance() < 0){
				user.setInDebt(true);
			}
		
		
		
	}


}
