package com.isrs.roster;

import java.util.List;

public class Employee {
   
    private String name;
    private Integer employeeID;
    private Integer employeeGrade;
    private List<Integer> preferredLocation;
    private List<Integer> shiftAvailability;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }
    public Integer getEmployeeGrade() {
        return employeeGrade;
    }
    public void setEmployeeGrade(Integer employeeGrade) {
        this.employeeGrade = employeeGrade;
    }
    public List<Integer> getPreferredLocation() {
        return preferredLocation;
    }
    public void setPreferredLocation(List<Integer> preferredLocation) {
        this.preferredLocation = preferredLocation;
    }
	public List<Integer> getShiftAvailability() {
		return shiftAvailability;
	}
	public void setShiftAvailability(List<Integer> shiftAvailability) {
		this.shiftAvailability = shiftAvailability;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", employeeID=" + employeeID + ", employeeGrade=" + employeeGrade
				+ ", preferredLocation=" + preferredLocation + ", shiftAvailability=" + shiftAvailability + "]";
	}

	
	
}


    



