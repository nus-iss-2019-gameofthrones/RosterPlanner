package com.isrs.roster;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.optaplanner.core.impl.heuristic.selector.move.factory.MoveListFactory;

public class EmployeeSwapMoveFactory implements MoveListFactory<JobSchedule> {

    @Override
    public List<EmployeeSwapMove> createMoveList(JobSchedule jobSchedule) {
        List<JobAssignment> jobAssignmentList = jobSchedule.getJobAssignmentList();
        List<EmployeeSwapMove> moveList = new ArrayList<>();
        for (ListIterator<JobAssignment> leftIt = jobAssignmentList.listIterator(); leftIt.hasNext();) {
            JobAssignment leftJobAssignment = leftIt.next();
            for (ListIterator<JobAssignment> rightIt = jobAssignmentList.listIterator(leftIt.nextIndex()); rightIt.hasNext();) {
                JobAssignment rightJobAssignment = rightIt.next();
                moveList.add(new EmployeeSwapMove(leftJobAssignment, rightJobAssignment));
            }
        }
        return moveList;
    }

}