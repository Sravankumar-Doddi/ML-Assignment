package com.bhavna.fileProcessor;

import java.io.IOException;

public class MainClass {
	
	public static void main(String[] args) throws IOException {
		PersonsService person = new PersonsService();
		person.getTheData("file.txt");
		
		person.getByChoice();
		
	}
}
