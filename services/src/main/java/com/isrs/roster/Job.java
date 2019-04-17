package com.isrs.roster;

public class Job {
	private Integer jobID;
    private Integer jobLocation;
    private Integer shift;

public Integer getJobID() {
    return jobID;
}
public void setJobID(Integer jobID) {
    this.jobID = jobID;
 }
public Integer getJobLocation() {
    return jobLocation;
}
public void setJobLocation(Integer jobLocation) {
    this.jobLocation = jobLocation;
 }

 public Integer getShift() {
     return shift;
 }
 public void setShift(Integer shift) {
	    this.shift = shift;
 }
@Override
public String toString() {
	return "Job [jobID=" + jobID + ", jobLocation=" + jobLocation + ", shift=" + shift + "]";
}
 
 
}