package com.isrs.roster;

import org.optaplanner.core.impl.score.director.ScoreDirector;

public class JobScheduleMoveHelper {

    public static void moveEmployee(ScoreDirector<JobSchedule> scoreDirector, JobAssignment shiftAssignment, Employee toEmployee) {
        scoreDirector.beforeVariableChanged(shiftAssignment, "employee");
        shiftAssignment.setEmployee(toEmployee);
        scoreDirector.afterVariableChanged(shiftAssignment, "employee");
    }

    private JobScheduleMoveHelper() {
    }
}