package com.anitime.services.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.Random;

@Entity
public class Employee {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private int grade;
    private int[] preferredShifts;
        
    public int[] getShifts() {
		return preferredShifts;
	}

	public void setShifts(int[] preferredShifts) {
		this.preferredShifts = preferredShifts;
	}

	public Employee() {
		Random rand = new Random();
		int n = rand.nextInt(100000);
		
        this.id = n;
    }

    public Employee(String firstName, String lastName, int grade){
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
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
