package com.isrs.roster;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.core.impl.heuristic.selector.move.factory.MoveListFactory;

public class EmployeeChangeMoveFactory implements MoveListFactory<JobSchedule> {

    @Override
    public List<EmployeeChangeMove> createMoveList(JobSchedule jobschedule) {
        List<EmployeeChangeMove> moveList = new ArrayList<>();
        List<Employee> employeeList = jobschedule.getEmployeeList();
        for (JobAssignment jobAssignment : jobschedule.getJobAssignmentList()) {
            for (Employee employee : employeeList) {
                moveList.add(new EmployeeChangeMove(jobAssignment, employee));
            }
        }
        return moveList;
    }

}