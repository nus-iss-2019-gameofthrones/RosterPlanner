package com.isrs.roster;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PlanningEntity
public class JobAssignment {
	
    Logger logger = LoggerFactory.getLogger("JobAssignment");

    private Employee employee;
    private Job job;

    @PlanningVariable(valueRangeProviderRefs = {"employee"})
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

	@Override
	public String toString() {
		return "JobAssignment [logger=" + logger + ", employee=" + employee + ", job=" + job + "]";
	}
    
    
    
    }

