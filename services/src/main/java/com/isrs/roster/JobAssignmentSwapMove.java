package com.isrs.roster;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.optaplanner.core.impl.heuristic.move.AbstractMove;
import org.optaplanner.core.impl.score.director.ScoreDirector;

public class JobAssignmentSwapMove extends AbstractMove<JobSchedule> {

    private JobAssignment leftJobAssignment;
    private JobAssignment rightJobAssignment;

    public JobAssignmentSwapMove(JobAssignment leftJobAssignment, JobAssignment rightJobAssignment) {
        this.leftJobAssignment = leftJobAssignment;
        this.rightJobAssignment = rightJobAssignment;
    }

    @Override
    public boolean isMoveDoable(ScoreDirector<JobSchedule> scoreDirector) {
        return !Objects.equals(leftJobAssignment.getEmployee(), rightJobAssignment.getEmployee());
    }

    @Override
    public JobAssignmentSwapMove createUndoMove(ScoreDirector<JobSchedule> scoreDirector) {
        return new JobAssignmentSwapMove(rightJobAssignment, leftJobAssignment);
    }

    @Override
    protected void doMoveOnGenuineVariables(ScoreDirector<JobSchedule> scoreDirector) {
        Employee oldLeftEmployee = leftJobAssignment.getEmployee();
        Employee oldRightEmployee = rightJobAssignment.getEmployee();
        JobScheduleMoveHelper.moveEmployee(scoreDirector, leftJobAssignment, oldRightEmployee);
        JobScheduleMoveHelper.moveEmployee(scoreDirector, rightJobAssignment, oldLeftEmployee);
    }

    @Override
    public JobAssignmentSwapMove rebase(ScoreDirector<JobSchedule> destinationScoreDirector) {
        return new JobAssignmentSwapMove(destinationScoreDirector.lookUpWorkingObject(leftJobAssignment),
                destinationScoreDirector.lookUpWorkingObject(rightJobAssignment));
    }

    @Override
    public Collection<? extends Object> getPlanningEntities() {
        return Arrays.asList(leftJobAssignment, rightJobAssignment);
    }

    @Override
    public Collection<? extends Object> getPlanningValues() {
        return Arrays.asList(leftJobAssignment.getEmployee(), rightJobAssignment.getEmployee());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof JobAssignmentSwapMove) {
            JobAssignmentSwapMove other = (JobAssignmentSwapMove) o;
            return new EqualsBuilder()
                    .append(leftJobAssignment, other.leftJobAssignment)
                    .append(rightJobAssignment, other.rightJobAssignment)
                    .isEquals();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(leftJobAssignment)
                .append(rightJobAssignment)
                .toHashCode();
    }

    @Override
    public String toString() {
        return leftJobAssignment + " {" + leftJobAssignment.getEmployee() + "} <-> "
                + rightJobAssignment + " {" + rightJobAssignment.getEmployee() + "}";
    }

}