
public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		
		try{ //Test: Alphabet Only
			user.setFirstname("Thomas");
			System.out.println("Pass");
			
		} catch(InputValidationException e){
			System.out.println("Fail");
		}
		
		try{ //Test: Alphabet Only
			user.setLastname("Murney");
			System.out.println("Pass");
		} catch(InputValidationException e){
			System.out.println("Fail");
		}

		
		try{ //Test: Should be alphabet only
			user.setFirstname("Thoma5");
			user.setLastname("m0rney");
			System.out.println("Fail");
		} catch(InputValidationException e){
			System.out.println("Pass");
		}
		
		try{ //Test: Username within ASCII
			user.setUsername("tmurney1");
			System.out.println("Pass");
		} catch(InputValidationException e) {
			System.out.println("Fail");
			
		}
		
		try{ //Test: Password is ASCII character
			user.setPassword("123456ttttf");
			System.out.println("Pass");
		} catch(InputValidationException e){
			System.out.println("Fail");
		}
		
		try{ //Test: Username and password length (must be no longer than 12 characters and no less than 2)
			user.setUsername("11111111111111");
			user.setPassword("123456ttttffff");
			System.out.println("Fail");
		} catch(InputValidationException e){
			System.out.println("Pass");
		}
		
		try{ //Test: Non ASCII Characters
			user.setUsername("$$");
			user.setPassword("£");
			System.out.println("Fail");
		} catch(InputValidationException e){
			System.out.println("Pass");
		}
		
		

	}

}
