package com.isrs.converter;

import java.util.Arrays;

import javax.persistence.Id;

public class SampleEmployee {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private int grade;
    private int[] shifts;
    private int preferredLocation;
    private int[] preferredShifts;
        

	public SampleEmployee() {
		
	}
	
    public SampleEmployee(String firstName, String lastName, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }
    
	public int getPreferredLocation() {
		return preferredLocation;
	}

	public void setPreferredLocation(int preferredLocation) {
		this.preferredLocation = preferredLocation;
	}

	public int[] getShifts() {
		return shifts;
	}

	public void setShifts(int[] shifts) {
		this.shifts = shifts;
	}

	public int[] getPreferredShifts() {
		return preferredShifts;
	}

	public void setPreferredShifts(int[] preferredShifts) {
		this.preferredShifts = preferredShifts;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", grade=" + grade
				+ ", shifts=" + Arrays.toString(preferredShifts) + "]";
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
