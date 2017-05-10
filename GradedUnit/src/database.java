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
			ResultSet rs = st.executeQuery("SELECT * FROM users WHERE Username = '" + user.getUsername() + "' AND Password = '" + user.getPassword());


			while(rs.next()){
				if(user.getUsername().equals(rs.getString("Username")) && user.getPassword().equals(rs.getString("Password"))){

					UrBankMain.setCurrentuser(user);

				} else {
					System.out.println("Incorrect");
				}
			}


		} catch(Exception e){
			System.out.println("Error: " + e);
			e.printStackTrace();
		}


		}

}



