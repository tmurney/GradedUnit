import java.util.*;

public class User {

	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private float balance;




	public User(String username, String password, String firstname, String lastname, float balance) throws InputValidationException{
		setUsername(username);
		setPassword(password);
		setFirstname(firstname);
		setLastname(lastname);
		setBalance(balance);

	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) throws InputValidationException {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}
	public void setPassword(String password) throws InputValidationException{
		this.password = password;
	}



	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) throws InputValidationException{
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) throws InputValidationException{
		this.lastname = lastname;
	}


	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) throws InputValidationException{
		this.balance = balance;
	}




	}




