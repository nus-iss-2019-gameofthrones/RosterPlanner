package com.isrs.converter;

public class SampleStation {
	
	private int id;
	private String name;
	private int shift;
	
	
	public SampleStation() {
		
	}
	
	public int getShift() {
		return shift;
	}
	public void setShift(int shift) {
		this.shift = shift;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SampleStation [id=" + id + ", name=" + name + ", shift=" + shift + "]";
	}
	
	
	

}
