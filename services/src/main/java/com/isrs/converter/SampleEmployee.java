package com.isrs.converter;

import java.util.Arrays;
import java.util.List;

public class SampleEmployee {

//	private int id;
	
	private Integer id;
	
	private String firstname = null;
	private String lastname = null;
	//private int grade;
	
	private Integer grade;
	
   // private int[] shifts;
   // private int[] preferredshifts;

    private List<Integer> shifts;
    private List<Integer> preferredshifts;
    
    
    
   
	
	
	

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	
	/*
 	
 	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int[] getShifts() {
		return shifts;
	}
	public void setShifts(int[] shifts) {
		this.shifts = shifts;
	}

    public int[] getPreferredshifts() {
		return preferredshifts;
	}
	public void setPreferredshifts(int[] preferredshifts) {
		this.preferredshifts = preferredshifts;
	}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	@Override
	public String toString() {
		return "SampleEmployee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", grade=" + grade
				+ ", shifts=" + Arrays.toString(shifts) + ", preferredshifts=" + Arrays.toString(preferredshifts) + "]";
	}
	
	*/
	public List<Integer> getShifts() {
		return shifts;
	}
	public void setShifts(List<Integer> shifts) {
		this.shifts = shifts;
	}
	public List<Integer> getPreferredshifts() {
		return preferredshifts;
	}
	public void setPreferredshifts(List<Integer> preferredshifts) {
		this.preferredshifts = preferredshifts;
	}
	@Override
	public String toString() {
		return "SampleEmployee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", grade=" + grade
				+ ", shifts=" + shifts + ", preferredshifts=" + preferredshifts + "]";
	}

	
	
	
	
}
