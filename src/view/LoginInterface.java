package view;

import java.util.Scanner;

import Models.AdminDAO;
import Models.UserDAO;
import Objects.Admin;
import Objects.User;

public class LoginInterface {
	
	public static void getLogging(Scanner sc)
	{	
		UserDAO umo = new UserDAO();
		AdminDAO amo = new AdminDAO();
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
			
			System.out.println("Enter Valid Mobile");
			String userMobileNo = sc.nextLine();
			
			while(umo.isUserMobileNoAvailable(userMobileNo))
			{
				System.out.println("User Email is Already exist");
				System.out.println("ReEnter User Email");
				userMobileNo = sc.nextLine();
			}
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
				userObject = new User( userName,userMobileNo, userAddress, userPassword);
				umo.addNewUser(userObject);
				new ClientInterface().clientOperation(sc, userObject);
			}
		}
		else if(option==(byte)2)
		{
			System.out.println("-------		Login		--------");
			System.out.println("Enter valid MobileNo");
			String userMobileNo = sc.next();
			//fetch from database
			while(!amo.isAdminMobileNoAvailable(userMobileNo)&&!umo.isUserMobileNoAvailable(userMobileNo))
			{
				System.out.println("user Mobile No is Not available");
				System.out.println("Renter valid Mobile No");
				userMobileNo = sc.next();
			}
			if(amo.isAdminMobileNoAvailable(userMobileNo))
			{
				Admin adminObject= amo.getAdminByMobileNo(userMobileNo);
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
						getLogging(sc);
				}
				new AdminInterface().adminOperations(sc, adminObject);
				
			}
			if(umo.isUserMobileNoAvailable(userMobileNo))
			{
				userObject= umo.getUserByMobileNo(userMobileNo);
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
						getLogging(sc);
				}
				new ClientInterface().clientOperation(sc, userObject);
			}
				
		}
	}
	public static void signIn(Scanner sc)
	{
		UserDAO umo = new UserDAO();
		User userObject ;
		System.out.println("Enter Name");
		String userName = sc.nextLine();
		
		System.out.println("Enter Valid MobileNo");
		String userMobileNo = sc.nextLine();
		
		while(umo.isUserMobileNoAvailable(userMobileNo))
		{
			System.out.println("User Mobile is Already exist");
			System.out.println("ReEnter User Mobile");
			userMobileNo = sc.nextLine();
		}

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
			userObject = new User( userName, userMobileNo, userAddress, userPassword);
			umo.addNewUser(userObject);
		}
	}
	
}