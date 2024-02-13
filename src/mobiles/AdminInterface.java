package mobiles;


import java.util.Scanner;

public class AdminInterface {
	public void adminOperations(Scanner sc ,Admin adminObject, DbConnection con) {
		if(adminObject.getAdminRole().equals("Manager"))
		{
			while(true)
			{
				System.out.println("----------- Admin Interface ------------");
				System.out.println("Enter 1 to Add New Mobiles");
				System.out.println("Enter 2 to Update Mobiles Count in Stock");
				System.out.println("Enter 3 to Update Available Mobile Colors in Stock");
				System.out.println("Enter 4 to Remove Mobiles");
				System.out.println("Enter 5 to display all Mobiles");
				System.out.println("Enter 6 to search Mobiles using filters");
				
				byte x = sc.nextByte();
				switch(x)
				{
				case 1:
					sc.nextLine();
					System.out.println("Enter Mobile Model");
					String mobileModel = sc.nextLine();
					System.out.println("Enter Mobile Brand");
					String mobileBrand = sc.nextLine();
					System.out.println("Enter Mobile RAM");
					String mobileRam = sc.nextLine();
					System.out.println("Enter Mobile ROM");
					String mobileRom = sc.nextLine();
					System.out.println("Enter Mobile Processor");
					String mobileProcessor = sc.nextLine();
					System.out.println("Enter Mobile Battery Capacity");
					String mobileBattery = sc.nextLine();
					System.out.println("Enter Mobile Camera Quality");
					String mobileCamera = sc.nextLine();
					System.out.println("Enter Mobile Connectivities(seperate multiple components using ',')");
					String mobileConnectivities = sc.nextLine();
					System.out.println("Enter Mobile GPS");
					String mobileGPS = sc.nextLine();
					System.out.println("Enter Mobile Display");
					String mobileDisplay = sc.nextLine();
					System.out.println("Enter Mobile Dimensions");
					String mobileDimensions = sc.nextLine();
					System.out.println("Enter Available Mobile Colors");
					String availableColors= sc.nextLine();
					System.out.println("Enter Mobile Attachments");
					String attachments= sc.nextLine();
					System.out.println("Enter Mobile Price");
					int mobilePrice= sc.nextInt();
					System.out.println("Enter No of Mobile in Stack");
					int availableInStack= sc.nextInt();
					con.addMobile(new Mobile(mobileModel, mobileBrand, mobileRam, mobileRom, mobileProcessor, mobileBattery, mobileCamera, mobileConnectivities, mobileGPS, mobileDisplay, mobileDimensions, mobilePrice, availableColors, attachments, availableInStack));
					break;
					
				case 2:
					System.out.println("Enter the mobile id to Update");
					int mobileId = sc.nextInt();
					System.out.println("Enter the currently available count");
					availableInStack = sc.nextInt();
					con.updateMobileCount(mobileId, availableInStack);
		
					break;
				case 3:
					System.out.println("Enter the mobile id to Update");
					mobileId = sc.nextInt();
					System.out.println("Enter the Currently Available Count");
					sc.nextLine();
					availableColors = sc.nextLine();
					con.updateAvaliableColors(mobileId, availableColors);
					
					break;
				case 4:
					System.out.println("Enter the mobile id to Remove From Inventory");
					mobileId =sc.nextInt();
					System.out.println("Enter 'Y' if you are sure to remove mobile");
					if(sc.next().charAt(0)=='Y')
						con.removeMobile(mobileId);
					break;
				}
				
				
			}
			
		}
		else if(adminObject.getAdminRole().equals("Biller"))
		{
			while(true)
			{
				System.out.println("Enter 1 to Add Users");
				System.out.println("Enter 2 to Make Bills");				
			}
		}
	}
}
