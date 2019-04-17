package com.isrs.roster;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.optaplanner.core.impl.heuristic.move.AbstractMove;
import org.optaplanner.core.impl.score.director.ScoreDirector;

public class EmployeeSwapMove extends AbstractMove<JobSchedule> {

    private JobAssignment leftEmployee;
    private JobAssignment rightEmployee;

    public EmployeeSwapMove(JobAssignment leftEmployee, JobAssignment rightEmployee) {
        this.leftEmployee = leftEmployee;
        this.rightEmployee = rightEmployee;
    }

    @Override
    public boolean isMoveDoable(ScoreDirector<JobSchedule> scoreDirector) {
        return !Objects.equals(leftEmployee.getEmployee(), rightEmployee.getEmployee());
    }

    @Override
    public EmployeeSwapMove createUndoMove(ScoreDirector<JobSchedule> scoreDirector) {
        return new EmployeeSwapMove(rightEmployee, leftEmployee);
    }

    @Override
    protected void doMoveOnGenuineVariables(ScoreDirector<JobSchedule> scoreDirector) {
        Employee oldLeftEmployee = leftEmployee.getEmployee();
        Employee oldRightEmployee = rightEmployee.getEmployee();
        scoreDirector.beforeVariableChanged(leftEmployee, "employee");
        leftEmployee.setEmployee(oldRightEmployee);
        scoreDirector.afterVariableChanged(leftEmployee, "employee");
        scoreDirector.beforeVariableChanged(rightEmployee, "employee");
        rightEmployee.setEmployee(oldLeftEmployee);
        scoreDirector.afterVariableChanged(rightEmployee, "employee");
    }

    @Override
    public EmployeeSwapMove rebase(ScoreDirector<JobSchedule> destinationScoreDirector) {
        return new EmployeeSwapMove(destinationScoreDirector.lookUpWorkingObject(leftEmployee),
                destinationScoreDirector.lookUpWorkingObject(rightEmployee));
    }

    @Override
    public String getSimpleMoveTypeDescription() {
        return getClass().getSimpleName() + "(" + JobAssignment.class.getSimpleName() + ".employee)";
    }

    @Override
    public Collection<? extends Object> getPlanningEntities() {
        return Arrays.asList(leftEmployee, rightEmployee);
    }

    @Override
    public Collection<? extends Object> getPlanningValues() {
        return Arrays.asList(leftEmployee.getEmployee(), rightEmployee.getEmployee());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof EmployeeSwapMove) {
            EmployeeSwapMove other = (EmployeeSwapMove) o;
            return new EqualsBuilder()
                    .append(leftEmployee, other.leftEmployee)
                    .append(rightEmployee, other.rightEmployee)
                    .isEquals();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(leftEmployee)
                .append(rightEmployee)
                .toHashCode();
    }

    @Override
    public String toString() {
        return leftEmployee + " {" + leftEmployee.getEmployee() +  "} <-> "
                + rightEmployee + " {" + rightEmployee.getEmployee() + "}";
    }

}