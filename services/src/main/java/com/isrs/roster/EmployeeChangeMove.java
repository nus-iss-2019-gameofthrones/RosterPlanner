package com.isrs.roster;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.optaplanner.core.impl.heuristic.move.AbstractMove;
import org.optaplanner.core.impl.score.director.ScoreDirector;

public class EmployeeChangeMove extends AbstractMove<JobSchedule> {

    private JobAssignment shiftAssignment;
    private Employee toEmployee;

    public EmployeeChangeMove(JobAssignment shiftAssignment, Employee toEmployee) {
        this.shiftAssignment = shiftAssignment;
        this.toEmployee = toEmployee;
    }

    @Override
    public boolean isMoveDoable(ScoreDirector<JobSchedule> scoreDirector) {
        return !Objects.equals(shiftAssignment.getEmployee(), toEmployee);
    }

    @Override
    public EmployeeChangeMove createUndoMove(ScoreDirector<JobSchedule> scoreDirector) {
        return new EmployeeChangeMove(shiftAssignment, shiftAssignment.getEmployee());
    }

    @Override
    protected void doMoveOnGenuineVariables(ScoreDirector<JobSchedule> scoreDirector) {
        JobScheduleMoveHelper.moveEmployee(scoreDirector, shiftAssignment, toEmployee);
    }

    @Override
    public EmployeeChangeMove rebase(ScoreDirector<JobSchedule> destinationScoreDirector) {
        return new EmployeeChangeMove(destinationScoreDirector.lookUpWorkingObject(shiftAssignment),
                destinationScoreDirector.lookUpWorkingObject(toEmployee));
    }

    @Override
    public Collection<? extends Object> getPlanningEntities() {
        return Collections.singletonList(shiftAssignment);
    }

    @Override
    public Collection<? extends Object> getPlanningValues() {
        return Collections.singletonList(toEmployee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof EmployeeChangeMove) {
            EmployeeChangeMove other = (EmployeeChangeMove) o;
            return new EqualsBuilder()
                    .append(shiftAssignment, other.shiftAssignment)
                    .append(toEmployee, other.toEmployee)
                    .isEquals();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(shiftAssignment)
                .append(toEmployee)
                .toHashCode();
    }

    @Override
    public String toString() {
        return shiftAssignment + " {" + shiftAssignment.getEmployee() + " -> " + toEmployee + "}";
    }

}
