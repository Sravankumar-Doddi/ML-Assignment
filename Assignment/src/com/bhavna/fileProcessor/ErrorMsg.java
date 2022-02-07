package com.bhavna.fileProcessor;

public class ErrorMsg extends RuntimeException{
	
	@Override
	public String toString() {
		return "Enter details are not correct. Please enter correct details";
	}
	
}
