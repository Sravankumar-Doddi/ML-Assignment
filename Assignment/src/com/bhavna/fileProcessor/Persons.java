package com.bhavna.fileProcessor;

import java.util.List;

public class Persons  {
	
	private String name;
	private String date;
	private String time;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Persons(String name, String date, String time) {
		this.name = name;
		this.date = date;
		this.time = time;
	}
	public Persons() {
		super();
	}
	@Override
	public String toString() {
		return "[name=" + name + ", date=" + date + ", time=" + time + "]";
	}

	
	
}
