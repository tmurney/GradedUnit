/**
 *
 */

/**
 * @author Thomas
 *
 */

import java.sql.*;
public class database {

	public void DBLogin(User user){
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gradedunit", "root", "");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM users");



			while(rs.next()){
				if(user.getUsername().equals(rs.getString("Username")) && user.getPassword().equals(rs.getString("Password"))){

					
					user.setUsername(rs.getString("Username"));
					user.setPassword(rs.getString("Password"));
					user.setFirstname(rs.getString("First Name"));
					user.setLastname(rs.getString("Last Name"));
					user.setBalance(rs.getFloat("Balance"));
					
					
					user.setCorrect(true);

				} else {
					user.setCorrect(false);
					
					System.out.println("Incorrect");
				}
			}
		}
			
		catch(Exception e){
			System.out.println("Error: " + e);
			e.printStackTrace();
		}


		
	}
	
	public void DBMoneyIn(MoneyIn moneyin){
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gradedunit", "root", "");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("INSERT INTO moneyin(value, reason) VALUES(moneyin.getValue(), moneyin.getReason())");
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void DBMoneyOut(MoneyOut moneyout){
		
	}

}



