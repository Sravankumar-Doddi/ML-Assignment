package com.bhavna.area;

import com.bhavna.state.*;

public class Area extends State {
	
	public String area;
	public int zipCode;
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public Area(String countryName, String stateName, String area, int zipCode) {
		super.countryName = countryName;
		super.stateName = stateName;
		this.area = area;
		this.zipCode = zipCode;
	}
	
	@Override
	public String toString() {
		return "Address :"+countryName+", "+stateName+", "+area+", "+zipCode;
	}
}
