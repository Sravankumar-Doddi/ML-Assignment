package com.bhavna.zipservice2;

import java.util.HashMap;
import java.util.Map;

import com.bhavna.area.Area;
import com.bhavna.zipservice1.*;

public class ZipService2 implements ZipService1  {

	static Map<Integer, Area>map;
	static {
	    map = new HashMap();
		map.put(505472, new Area("India","Telangana","Karimnagar", 505472));
		map.put(506001, new Area("India","Telangana","Warangal",5060001));
		map.put(505208, new Area("India","Telangana","Peddapelli",505208));
		map.put(500001, new Area("India","Telangana","Hyderaad",500001));
		map.put(508001, new Area("India","Telangana","Nalgonda",508001));
		map.put(500074, new Area("India","Telangana","RangaReddy",500074));
		map.put(502103, new Area("India","Telangana","Siddipet",502103));
		map.put(501401, new Area("India","Telangan","Medchal",501401));
	}		
	@Override
	public Area getZipCode(int zipCode) {
		return map.get(zipCode);
	}
	@Override
	public void printAll() {
		for(Map.Entry<Integer, Area> set : map.entrySet()) {
			System.out.println(set.getKey()+" "+set.getValue());
		}
	}
	@Override
	public void addZipCode(int zipKey, Area area) {
		map.put(zipKey, area);
	}
	public boolean isExists(int zip) {
		if(map.containsKey(zip)) {
			return true;
		}
		else {
			return false;
		}
    }

}