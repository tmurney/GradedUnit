/**
 *
 */

/**
 * @author Thomas Murney
 *
 */

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class database {

	public void DBLogin(User user){
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gradedunit", "root", ""); //Establishes a connection to the Database
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM users"); //SQL Command which displays all the information from the users table



			while(rs.next()){ //While the query is working
				if(user.getUsername().equals(rs.getString("Username")) && user.getPassword().equals(rs.getString("Password"))){ //If the username and password matches the details stored on the databse


					user.setUsername(rs.getString("Username")); //The login would be correct, so that user will go on the application with access to all the user's information.
					user.setPassword(rs.getString("Password"));
					user.setFirstname(rs.getString("First Name"));
					user.setLastname(rs.getString("Last Name"));
					user.setBalance(rs.getFloat("Balance"));


					user.setCorrect(true); //The login is correct and will be referred to for future use

				} else {
					user.setCorrect(false);

					System.out.println("Incorrect"); //Tested to see if the login is in fact incorrect, the console will respond incorrect.
				}
			}
		}

		catch(Exception e){ //Error handling for any issues with the database.
			System.out.println("Error: " + e); //Displays the exception being thrown
			e.printStackTrace(); //Refers to the specific area where the error is
		}



	}

	public void DBMoneyIn(MoneyIn moneyin){ //An intended function with the database. It does not work.
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gradedunit", "root", ""); //Connects to the database
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO moneyin(TransactionID, Value, Reason)" //The statement used to insert a new entry into the "moneyin" table
					+("VALUES (?, ?, ?")); //Values are empty for later input


			preparedStatement.setInt(1, moneyin.getID()); //Sets the values for entry from getters in the moneyin class
			preparedStatement.setFloat(2, moneyin.getValue());
			preparedStatement.setString(3, moneyin.getReason());

			preparedStatement.executeUpdate();



		} catch (SQLException e) { //If there is an error then a new exception will be thrown.
			System.out.println("Error" + e);
			e.printStackTrace();
		}



	}


	public void DBMoneyOut(MoneyOut moneyout){ //An intended function with the database, It does not work.
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gradedunit", "root", ""); //Connects to the database
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO moneyout(TransactionID, Value, Reason)" //The statement made to insert a new entry into the "moneyout" table
					+("VALUES (?, ?, ?")); //Values are empty for later input


			preparedStatement.setInt(1, moneyout.getID()); //Sets the values for entry from getters in the moneyout class
			preparedStatement.setFloat(2, moneyout.getValue());
			preparedStatement.setString(3, moneyout.getReason());

			preparedStatement.executeUpdate(); //Triggers action



		} catch (SQLException e) { //If there is an error then a new exception will be thrown.
			System.out.println("Error" + e);
			e.printStackTrace();
		}



	}

	public void DBUpdateBalance(User user){ //An intended function with the database, it does not work.
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gradedunit", "root", ""); //Connects to the database
			PreparedStatement preparedStatement = con.prepareStatement("UPDATE users)" //The statement used to update the balance
					+ ("SET Balance = ?"));

			preparedStatement.setFloat(1, user.getBalance()); //Sets the new balance
			preparedStatement.executeUpdate(); //Triggers action



		} catch (SQLException e) { //If there is an error then a new exception will be thrown.
			System.out.println("Error" + e);
			e.printStackTrace();
		}



	}




}



