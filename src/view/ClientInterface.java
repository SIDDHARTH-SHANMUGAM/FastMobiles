package view;

import java.util.*;

import Models.BillDAO;
import Models.CartDAO;
import Models.MobileDAO;
import Models.OrderDAO;
import Objects.Bill;
import Objects.Cart;
import Objects.Order;
import Objects.User;

public class ClientInterface {
	public void clientOperation(Scanner sc, User userObject)
	{
		Filter fl = new Filter();
		MobileDAO mmo = new MobileDAO();
		CartDAO cmo = new CartDAO();
		OrderDAO omo= new OrderDAO();
		BillDAO bmo = new BillDAO();
		System.out.println("------------Welcome "+ userObject.getUserName()+" --------------");
		while(true)
		{
			System.out.println("Enter 1 to Peek Mobile");
			System.out.println("Enter 2 to Add to Cart");
			System.out.println("Enter 3 to View Cart");
			System.out.println("Enter 4 to Remove Cart");
			System.out.println("Enter 5 to purchase Mobile");
			System.out.println("Enter 6 to purchase History");
			
			byte b = sc.nextByte();
			switch(b)
			{
			case 1:
				fl.getMobileFilter(mmo.getAllMobiles(),sc );
				break;
			case 2:
				System.out.println("Enter Mobile Id to add to Cart");
				int mobileId = sc.nextInt();
				if(!mmo.isValidMobileId(mobileId))
				{
					System.out.println("!-----Sorry Entered Mobile Id is InValid--!!!!!!!!!!!!!!!");
					break;
				}
				if(cmo.isMobileInCart(mobileId, userObject.getUserId()))
				{
					System.out.println("Mobile Already in Cart");
					break;
				}
				if(cmo.addCart(new Cart(mobileId, userObject.getUserId())))
					System.out.println("Cart Added Successfully");
				break;
			case 3:
				List<Cart> listOfCartItems = cmo.getAllCartItems(userObject.getUserId());
				if(listOfCartItems.isEmpty())
				{
					System.out.println("!!!!!!!!!!!!!!!!!!!! --NO ITEMS AVAILABLE-- !!!!!!!!!!!!!!!!!");
					break;
				}
				for(Cart X : listOfCartItems)
				{
					System.out.println("--------------Cart No "+ X.getCartId()+" -----------------");
					System.out.println(mmo.getMobileByMobileId(X.getMobileId()));
				}
				System.out.println("-----------------------------------------------------------");
				System.out.println("If you want to continue Purchase enter 'Y' or 'y' else to Quit");
				String s = sc.next();
				if(!(s.charAt(0)=='Y'||s.charAt(0)=='y'))
				{
					break;
				}
				System.out.println("Enter Number Of Mobiles are need to Purchase");
				int n= sc.nextInt();
				if(n>listOfCartItems.size())
				{
					System.out.println("entered number should be less then the size of the cart");
					break;
				}
				int orderId = bmo.getBillCount();
				double totalAmount =0;
				List<Integer> mobileIds = new ArrayList<>();
				boolean bool= false;
				for(int i=1; i<=n; i++)
				{
					System.out.println("Enter"+(i==1?(i+" st"):(i+" nd"))+" MoblieId  (Space) count of Mobile ('enter the mobile id within your cart')");
					mobileId=sc.nextInt();
					while(!mmo.isValidMobileId(mobileId))
					{
						System.out.println("!!!!!!!!!!!!!!!! --Sorry Entered Mobile Id is NOT Valid-- !!!!!!!!!!!!!!!");
						System.out.println("Please ReEnter The MobileId");
						mobileId = sc.nextInt();
					}
					int count=sc.nextInt();
					if(!cmo.isMobileInCart(mobileId, userObject.getUserId()))
					{
						System.out.println("!!!!!!!!!!!!!!!!!!!! --The entered MobileId is Not in cart-- !!!!!!!!!!!");
						omo.removeOrder(orderId);
						bool=true;
						break;
					
					}
					if(mobileIds.contains(mobileId))
					{
						System.out.println("!!!!!!!!!!!!!!!!!!!! --Re Entered the Mobile ID-- !!!!!!!!!!!!!!!!!");
						omo.removeOrder(orderId);
						bool = true;
						break;
					}
					mobileIds.add(mobileId);
					if(mmo.getAvailable(mobileId)<count)
					{
						System.out.println("!!!!!!!!!!!!!!!! -- available count are "+mmo.getAvailable(mobileId)+" -- !!!!!!!!!!!!!!!");
						omo.removeOrder(orderId);
						bool = true;
						break;
					}
					omo.addOrder(new Order(orderId, mobileId, count));
					totalAmount = mmo.getMobilePrice(mobileId);
				}
				if(bool)
					break;
				System.out.println("Toatal Amount :		"+totalAmount);
				
				System.out.println("Enter 1 for Deliver and 2 for receive at shop");
				String purchaseType = "";
				int option= sc.nextInt();
				if(option==1)
				{
					purchaseType = "Delivery";
				}
				else
					purchaseType = "OfflineAtShop";
					
				System.out.println("Enter 'Y' to Confirm Bill");
				s = sc.next();
				if(s.charAt(0)=='Y'||s.charAt(0)=='y')
				{
					for(int mId: mobileIds)
					{
						if(cmo.isMobileInCart(mId, userObject.getUserId()))
						{
							cmo.removeCart(cmo.getCartById(mId, userObject.getUserId()));
						}
					}
					int billId = bmo.addBill(new Bill(userObject.getUserId() , purchaseType, orderId, totalAmount ));
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
			case 4:
				System.out.println("Enter the Cart Id to Remove");
				int cartId = sc.nextInt();
				if(cmo.removeCart(cartId))
				{
					System.out.println("!!!!!!!!!!!!!!!!! --Cart Removed Successfully-- !!!!!!!!!!!!!!!");
				}
				break;
			case 5:
				System.out.println("Enter Number Of Mobiles are need to Purchase");
				n= sc.nextInt();
				orderId = bmo.getBillCount();
				totalAmount =0;
				mobileIds = new ArrayList<>();
				bool = false;
				for(int i=1; i<=n; i++)
				{
					System.out.println("Enter"+(i==1?(i+" st"):(i+" nd"))+" MoblieId  (Space) count of Mobile");
					mobileId=sc.nextInt();
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
				
				System.out.println("Enter 1 for Deliver and 2 for receive at shop");
				purchaseType = "";
				option= sc.nextInt();
				if(option==1)
				{
					purchaseType = "Delivery";
				}
				else
					purchaseType = "OfflineAtShop";
					
				System.out.println("Enter 'Y' to Confirm Bill");
				s = sc.next();
				if(s.charAt(0)=='Y'||s.charAt(0)=='y')
				{
					int billId = bmo.addBill(new Bill(userObject.getUserId() , purchaseType, orderId, totalAmount ));
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
			case 6:
				System.out.println("-----------------Purchase History----------------");
				List<Bill>listOfBills = bmo.getBillByUserId(userObject.getUserId());
				if(listOfBills.isEmpty())
				{
					System.out.println("!!!!!!!!!!!!!!!NO HISTORY FOUND!!!!!!!!!!!!!!!!!!!!");
					break;
				}
				for(Bill bill : listOfBills)
				{
					
					System.out.println("Bill Id : "+bill.getBillId());
					System.out.println("Date : "+bill.getDate());
					List<Order> listOfOrders = omo.getOrdersById(bill.getBillId());
					for(Order t: listOfOrders)
					{
						System.out.println(t.getMobileId() +" "+t.getCount());
					}
					System.out.println("Total Amount : "+bill.getTotalAmount());
					System.out.println("Purchased Type : "+bill.getPurchaseType());
					System.out.println("-------------------------------------");
				}
				break;
			}
		}
	}
	
}