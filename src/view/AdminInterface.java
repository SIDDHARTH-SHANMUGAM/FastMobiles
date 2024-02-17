package view;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.BillDAO;
import Models.MobileDAO;
import Models.OrderDAO;
import Models.UserDAO;
import Objects.Admin;
import Objects.Bill;
import Objects.Mobile;
import Objects.Order;

public class AdminInterface {
	public void adminOperations(Scanner sc ,Admin adminObject) {
		MobileDAO mmo = new MobileDAO();
		OrderDAO omo = new OrderDAO();
		BillDAO bmo = new BillDAO();
		UserDAO umo = new UserDAO();
		Filter fl = new Filter();
		if(adminObject.getAdminRole().equals("Manager"))
		{
			while(true)
			{
				System.out.println("----------- Admin Interface ------------");
				System.out.println("Enter 1 to Add New Mobiles");
				System.out.println("Enter 2 to Update Mobiles Count in Stock");
				System.out.println("Enter 3 to Update Available Mobile Colors in Stock");
				System.out.println("Enter 4 to Remove Mobiles");
				System.out.println("Enter 5 to peek Mobiles");
				
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
					int mobileRam = sc.nextInt();
					System.out.println("Enter Mobile ROM");
					int mobileRom = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Mobile Processor");
					String mobileProcessor = sc.nextLine();
					System.out.println("Enter Mobile Battery Capacity");
					int mobileBattery = sc.nextInt();
					System.out.println("Enter Mobile Camera Quality");
					sc.nextLine();
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
					if(mmo.addMobile(new Mobile(mobileModel, mobileBrand, mobileRam, mobileRom, mobileProcessor, mobileBattery, mobileCamera, mobileConnectivities, mobileGPS, mobileDisplay, mobileDimensions, mobilePrice, availableColors, attachments, availableInStack)))
					{
						System.out.println("Mobile Added Successfully");
					}
					break;
					
				case 2:
					System.out.println("Enter the mobile id to Update");
					int mobileId = sc.nextInt();
					System.out.println("Enter the currently available count");
					availableInStack = sc.nextInt();
					if(mmo.updateMobileCount(mobileId, availableInStack)) {
						System.out.println("Mobile Available Count Updated Successfully");
					}
		
					break;
				case 3:
					System.out.println("Enter the mobile id to Update");
					mobileId = sc.nextInt();
					System.out.println("Enter the Current Colors Available");
					sc.nextLine();
					availableColors = sc.nextLine();
					if(mmo.updateAvaliableColors(mobileId, availableColors))
					{
						System.out.println("Mobile Available Colors Updated");
					}
					
					break;
				case 4:
					System.out.println("Enter the mobile id to Remove From Inventory");
					mobileId =sc.nextInt();
					System.out.println("Enter 'Y' if you are sure to remove mobile");
					String s = sc.next();
					if(s.charAt(0)=='Y'||s.charAt(0)=='y')
						if(mmo.removeMobile(mobileId))
						{
							System.out.println("Mobile Deleted Successfully");
						}
					break;
					
				case 5:
					fl.getMobileFilter(mmo.getAllMobiles(), sc);
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
				System.out.println("Enter 3 to Filter Mobiles");
				byte x = sc.nextByte();
				switch (x)
				{
				case 1:
					sc.nextLine();
					LoginInterface.signIn(sc);
					break;
					
				case 2:
					System.out.println("Enter User Mobie No");
					String userMobileNo = sc.next();
					int userId = umo.getUserByMobileNo(userMobileNo).getUserId();
					System.out.println("Enter Number Of Mobiles are need to Purchase");
					int n= sc.nextInt();
					int orderId = bmo.getBillCount();
					List<Integer> mobileIds = new ArrayList<>();
					int totalAmount =0;
					boolean bool=false;
					for(int i=1; i<=n; i++)
					{
						System.out.println("Enter"+(i==1?(i+" st"):(i+" nd"))+" MoblieId  (Space) count of Mobile");
						int mobileId=sc.nextInt();
						while(!mmo.isValidMobileId(mobileId))
						{
							System.out.println("!!!!!!!!!!! --Sorry Entered Mobile Id is Valid-- !!!!!!!!!!!!!!!");
							System.out.println("Please ReEnter The MobileId");
							mobileId = sc.nextInt();
						}
						if(mobileIds.contains(mobileId))
						{
							System.out.println("!!!!!!!!!!!!!!!  --Re Entered the Mobile ID--  !!!!!!!!!!!!!!!!!");
							omo.removeOrder(orderId);
							bool=true;
							break;
						}
						int count=sc.nextInt();
						if(mmo.getAvailable(mobileId)<count)
						{
							System.out.println("!!!!!!!!!!!!!!!!! -- available count are "+mmo.getAvailable(mobileId)+" -- !!!!!!!!!!!!!!!!");
							omo.removeOrder(orderId);
							bool = true;
							break;
						}
						omo.addOrder(new Order(orderId, mobileId, count));
						totalAmount = mmo.getMobilePrice(mobileId);
					}
					if(bool)
					{
						break;
					}
					System.out.println("Toatal Amount :		"+totalAmount);				
					System.out.println("Enter 'Y' to Confirm Bill");
					String s = sc.next();
					if(s.charAt(0)=='Y'||s.charAt(0)=='y')
					{
						int billId = bmo.addBill(new Bill(userId, "OfflineAtShop", orderId, totalAmount ));
						System.out.println("-----------------Bill----------------");
						System.out.println(bmo.getBillById(billId));
						List<Order> listOfOrders = omo.getOrdersById(orderId);
						for(Order t: listOfOrders)
						{
							System.out.println(t.getMobileId() +" "+t.getCount());
							mmo.decreaseCount(t.getMobileId(), t.getCount());
						}
						System.out.println("-------------------------------------");
					}
					else
					{
						omo.removeOrder(orderId);
					}
					break;
				case 3:
					fl.getMobileFilter(mmo.getAllMobiles(), sc);
					break;
				
				}
			}
		}
	}
}
