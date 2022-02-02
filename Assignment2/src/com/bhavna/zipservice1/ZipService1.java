package com.bhavna.zipservice1;

import com.bhavna.area.*;

public interface ZipService1 {

	public Area getZipCode(int zipCode);
	
	public void printAll();
	
	public void addZipCode(int zipKey, Area area);
}
