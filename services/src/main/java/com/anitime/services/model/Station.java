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
import java.util.Random;
import java.util.UUID;

@Entity
public class Station {

    @Id
    private int id;
    private String name;
    private int shift;

    protected Station(){
    	Random rand = new Random();
		int n = rand.nextInt(100000);
		
        this.id = n;
    }

    public Station(String name){
        this();
        this.name = name;
    }

	@Override
	public String toString() {
		return "Station [id=" + id + ", name=" + name + ", shifts=" + shift + "]";
	}

	public int getShifts() {
		return shift;
	}

	public void setShifts(int shift) {
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
}
