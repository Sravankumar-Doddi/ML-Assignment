package com.bhavna.main;

import java.util.Scanner;

import com.bhavna.area.Area;
import com.bhavna.zipservice2.ZipService2;

public class MainClass {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ZipService2 zservice2 = new ZipService2();
		int value = 0;
		do {
		System.out.println("Enter 1 to get the address :");
		System.out.println("Enter 2 to get all ZipCodes :");
		System.out.println("Enter 3 to add new ZipCode :");
		int number = scan.nextInt();
		switch(number) {
		case(1):
			System.out.println("Enter the ZipCode");
		    int zipc = scan.nextInt();
		    System.out.println(zservice2.getZipCode(zipc));
		    break;
		case(2):
			System.out.println("Here the all the available ZipCodes :");
		    zservice2.printAll();
		    break;
		case(3):
			System.out.println("Enter the ZipCode :");
		    int zipNew = scan.nextInt();
		    if (zservice2.isExists(zipNew)) {
				System.out.println("the Entered zipcode is already exists please enter the new ZipCode");
				break;
			}
		    System.out.println("Enter the Country Name :");
		    String countryName = scan.next();
		    System.out.println("Enter the State Name :");
		    String stateName = scan.next();
		    System.out.println("Enter the Area Name");
		    String area = scan.next();
		    zservice2.addZipCode(zipNew, new Area(countryName, stateName, area, zipNew));
		    break;
		default:
			System.out.println("Select the given option");
			break;
		}
		System.out.println("do you want to continue enter 8");
		value = scan.nextInt();
		if (value != 8) {
			System.out.println("------------------------");
			break;
		}
		}while(value == 8);
	}

}
