package mobiles;

import java.util.Scanner;

public class Login {
	
	public static void getLogging(Scanner sc, DbConnection con)
	{	
		
		//Objects
		User userObject ;
		
		System.out.println("------		LogIn Interface		-------");
		System.out.println("Enter 1 for Sign In");
		System.out.println("Enter 2 for LogIn");
		System.out.println("Enter ctrl+C to terminate");
		
		byte option =sc.nextByte();
		sc.nextLine();
		if(option==(byte)1)
		{
			System.out.println("Enter Name");
			String userName = sc.nextLine();
			
			System.out.println("Enter Valid Email");
			String userEmail = sc.nextLine();
			
			while(con.isUserEmailAvailable(userEmail))
			{
				System.out.println("User Email is Already exist");
				System.out.println("ReEnter User Email");
				userEmail = sc.nextLine();
			}

			System.out.println("Enter Mobile No");
			String userMobile = sc.nextLine();
			
			System.out.println("Enter Address");
			String userAddress = sc.nextLine();
			
			String userPassword ;
			String userConfirmPassword; 
			while(true)
			{
				System.out.println("Enter Password");
				userPassword = sc.next();
				//Validation
				
				System.out.println("Confirm Password");
				userConfirmPassword = sc.next();
				if(userPassword.equals(userConfirmPassword))
					break;
				else
					System.out.println("Confirm password is wrong");
			}
			
			System.out.println("Enter Y to submit details");
			System.out.println("Enter ctrl+C to terminate");
			char Y = sc.next().charAt(0);
			if(Y=='Y'||Y=='y')
			{
				userObject = new User(++User.noOfUser, userEmail, userName, userMobile, userAddress, 0, userPassword);
				con.addNewUser(userObject);
				new ClientInterface().clientOperation(sc, userObject, con);
			}
		}
		else if(option==(byte)2)
		{
			System.out.println("-------		Login		--------");
			System.out.println("Enter valid Email");
			String userEmail = sc.next();
			//fetch from database
			while(!con.isAdminEmailAvailable(userEmail)&&!con.isUserEmailAvailable(userEmail))
			{
				System.out.println("user Email is Not available");
				System.out.println("Renter valid Email");
				userEmail = sc.next();
			}
			if(con.isAdminEmailAvailable(userEmail))
			{
				Admin adminObject= con.getAdminByEmail(userEmail);
				System.out.println("Enter password");
				String userPassword = sc.next();
				while(!userPassword.equals(adminObject.getAdminPassword()))
				{
					System.out.println("--------	Wrong password	-------");
					System.out.println("--------	Do you Want to continue?????????");
					System.out.println("Enter Y to ReEnter Password");
					char Y = sc.next().charAt(0);
					if(Y=='Y'||Y=='y')
					{
						System.out.println("ReEnter password");
						userPassword = sc.next();
					}
					else
						getLogging(sc, con);
				}
				new AdminInterface().adminOperations(sc, adminObject, con);
				
			}
			if(con.isUserEmailAvailable(userEmail))
			{
				userObject= con.getUserByEmail(userEmail);
				System.out.println("Enter password");
				String userPassword = sc.next();
				while(!userPassword.equals(userObject.getUserPassword()))
				{
					System.out.println("--------	Wrong password	-------");
					System.out.println("--------	Do you Want to continue?????????");
					System.out.println("Enter Y to ReEnter Password");
					char Y = sc.next().charAt(0);
					if(Y=='Y'||Y=='y')
					{
						System.out.println("ReEnter password");
						userPassword = sc.next();
					}
					else
						getLogging(sc, con);
				}
				new ClientInterface().clientOperation(sc, userObject, con);
			}
				
		}
	}
	
}