package view;

import java.util.*;
import java.util.stream.Collectors;

import Model.Mobile;

public class Filter {
	public void getMobileFilter(List<Mobile> listOfMobile, Scanner sc)
	{
		System.out.println("Now You Have Entered in Filter Mode");
		System.out.println("Please Follow the instruction to make iteraction better");
		System.out.println("If you want to skip any filteration please enter -1");
		System.out.println("Enter Brand Name");
		String brand = sc.next();
		System.out.println("Enter Model Name");
		String model = sc.next();
		System.out.println("Enter Minimum RAM need");
		int minRam = sc.nextInt();
		System.out.println("Enter Maximum RAM need");
		int maxRam= sc.nextInt();
		System.out.println("Enter Minimum ROM need");
		int minRom= sc.nextInt();
		System.out.println("Enter Maximum ROM need");
		int maxRom = sc.nextInt();
		System.out.println("Enter Minimum battery capacity in mhA");
        int minBattery= sc.nextInt();
        System.out.println("Enter Maximum battery capacity in mhA");
        int maxBattery= sc.nextInt();
        System.out.println("Enter Minimum mobilePrice");
        int minPrice= sc.nextInt();
        System.out.println("Enter Maximum mobilePrice");
        int maxPrice= sc.nextInt();
        
        List<Mobile> filteredMobiles = filterMobiles(listOfMobile, brand, model, minRam, maxRam, minRom, maxRom, minBattery, maxBattery, minPrice, maxPrice);
		System.out.println("----------------filtered Mobiles---------------");
        for(Mobile x: filteredMobiles)
        {
        	System.out.println(x);
        	System.out.println("-----------------------------------------------");
        }
		
		
	}
    public List<Mobile> filterMobiles(List<Mobile> listOfMobile, String brand, String model,
            int minRam, int maxRam, int minRom, int maxRom,
            int minBattery, int maxBattery,
            int minPrice, int maxPrice) {

		return listOfMobile.stream()
			.filter(mobile ->
			(brand == null || "-1".equals(brand) || mobile.getMobileBrand().equalsIgnoreCase(brand))
			&& (model == null || "-1".equals(model) || mobile.getMobileModel().equalsIgnoreCase(model))
			&& (minRam == -1 || mobile.getMobileRam() >= minRam)
			&& (maxRam == -1 || mobile.getMobileRam() <= maxRam)
			&& (minRom == -1 || mobile.getMobileRom() >= minRom)
			&& (maxRom == -1 || mobile.getMobileRom() <= maxRom)
			&& (minBattery == -1 || mobile.getMobileBattery() >= minBattery)
			&& (maxBattery == -1 || mobile.getMobileBattery() <= maxBattery)
			&& (minPrice == -1 || mobile.getMobilePrice() >= minPrice)
			&& (maxPrice == -1 || mobile.getMobilePrice() <= maxPrice))
		.collect(Collectors.toList());
	}

}
