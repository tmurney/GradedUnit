import java.util.*;

public class User {

	private String username;			//Variables are established here
	private String password;
	private String firstname;
	private String lastname;
	private float balance;
	private boolean isCorrect;
	private boolean inDebt;
	private float lastPayment;
	private String lastReason;


	public float getLastPayment() {    //Getters and Setters are established below
		return lastPayment;
	}

	public void setLastPayment(float lastPayment) {
		this.lastPayment = lastPayment;
	}

	public String getLastReason() {
		return lastReason;
	}

	public void setLastReason(String lastReason) {
		this.lastReason = lastReason;
	}

	public boolean isInDebt() {
		return inDebt;
	}

	public void setInDebt(boolean inDebt) {
		this.inDebt = inDebt;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}


	public String getUsername() {

		return username;
	}
	public void setUsername(String username) throws InputValidationException {
		if(username.matches("(\\p{ASCII}){2,12}")){ //If the input consists of ASCII characters and is between 2 and 12 characters
			this.username = username;
		} else {
			throw new InputValidationException();
		}

	}



	public String getPassword() {
		return password;
	}
	public void setPassword(String password) throws InputValidationException{
		if(password.matches("(\\p{ASCII}){2,12}")){ //If the input consists of ASCII characters and is between 2 and 12 characters
		this.password = password;
		} else{
			throw new InputValidationException();
		}
	}



	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) throws InputValidationException{
		if(firstname.matches("(\\p{Alpha})*")){ //If the name is in the alphabet
		this.firstname = firstname;
		} else {
			throw new InputValidationException();
		}
	}



	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) throws InputValidationException{
		if(lastname.matches("(\\p{Alpha})*")){ //If the surname is in the alphabet
		this.lastname = lastname;
		} else {
			throw new InputValidationException();
		}
	}


	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance){
		this.balance = balance;
	}

	public User(String username, String password, String firstname, String lastname, float balance) throws InputValidationException{ //Basic Constructor including all information
		setUsername(username);
		setPassword(password);
		setFirstname(firstname);
		setLastname(lastname);
		setBalance(balance);

	}

	public User(){ //Constructor with information that can be added later

	}




	}




