import java.util.*;

public class MoneyOut {

	private float value;
	private Date transactiondate;
	private String reason;

	
	public float getValue() {
		return value;
	}
	public void setValue(float value) throws InputValidationException {
		this.value = value;
	}


	public Date getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(Date transactiondate) throws InputValidationException {
		this.transactiondate = transactiondate;
	}

	public String getReason() {
		return reason;
	}
	public void setReason(String reason) throws InputValidationException{
		this.reason = reason;
	}

}
