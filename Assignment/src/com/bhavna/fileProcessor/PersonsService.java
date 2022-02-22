package com.bhavna.fileProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PersonsService {

	Map<String, List<Persons>> map = new HashMap<>();
	Scanner scan = new Scanner(System.in);
	
	public void getTheData(String fileName) throws IOException {
		File file = new File(fileName);
		FileReader flr = new FileReader(file);
		BufferedReader br = new BufferedReader(flr);
		String str ;
		while((str = br.readLine()) != null) {
				String[] stdate = str.split("\\s+");
				
			 try {
					if(stdate.length!=4) {
						throw new ErrorMsg("Invalid Format!!!");
					}
					
					if(!stdate[0].matches("[a-zA-Z]+")) {
						throw new ErrorMsg("Invalid Name Format");
					}
					
					if (!stdate[1].matches("^(0?[1-9]|1[012])[\\/](0?[1-9]|[12][0-9]|3[01])$")) {
						//System.out.println(stdate[1]);
						throw new ErrorMsg("Invalid date format!!!");
					}
				
					if (!stdate[2].matches("([0]?\\d|1[0-2]):([0-5]?\\d)")) {
						throw new ErrorMsg("Invalid time format!!!");
					}
					
					if (!(stdate[3].equalsIgnoreCase("AM")|| stdate[3].equalsIgnoreCase("PM"))) {
						throw new ErrorMsg("Invalid meridiem!!!");
					}
					
					if (map.containsKey(stdate[1])) {
						List<Persons> prs =  map.get(stdate[1]);
						prs.add(new Persons(stdate[0], stdate[1], stdate[2]));
						map.put(stdate[1], prs);
					}
					else {
						List<Persons> prs2 = new ArrayList<>();
						prs2.add(new Persons(stdate[0], stdate[1], stdate[2]));
						map.put(stdate[1], prs2);
					}
				
			 }
			 catch(ErrorMsg m) {
				 System.out.println(m);
			 }
			 catch(Exception e) {
				 System.out.println(e);
			 }
		}	
	}
	
	public void loginsInDate(String date) {
		try {
			if (map.containsKey(date)) {
				System.out.println("No of users logged in the date: "+map.get(date).size());
				System.out.println(map.get(date));
			}
			else {
				throw new ErrorMsg("Enter details are not correct. Please enter correct details");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
}
	public void getAll() {
		for(Map.Entry<String, List<Persons>> m : map.entrySet()) {
			System.out.println(m.getKey());
			System.out.println("No of logins in this date : "+m.getValue().size());
			System.out.println(m.getValue());
			System.out.println("\n");
		}
	}
	char value ;
	public void getByChoice() {
		do {
			System.out.println("Enter 1 to get details of logged in persons in particular date ");
			System.out.println("Enter 2 to get all details on all dates");
			
			int cases = scan.nextInt();
			String date = "";
			
			switch(cases) {
			case (1):
				System.out.println("Enter the date in mm/dd format");
			    date = scan.next();
			    loginsInDate(date);
			    break;
			case (2):
				getAll();
			    break;
			default :
				System.out.println("Enter correct details");
			}
			System.out.println("do you want to continue ?? enter y/n");
			value = scan.next().charAt(0);
			if(value != 'y') {
				System.out.println("Program has been terminated Thank you!!!");
				break;
			}
		}while(value == 'y');
	}
	
}
