package com.isrs.roster;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

public class JobScheduleScoreCalculator implements EasyScoreCalculator<JobSchedule> {
	
    @Override
    public HardSoftScore calculateScore(JobSchedule jobSchedule) {
        int hardScore = 0;
        int softscore = 0;
        Map<Integer, List<Job>> empJobList = new HashMap<>();

        for (JobAssignment jobAssignment : jobSchedule.getJobAssignmentList()){
            System.out.println("JobAssignment:"+jobAssignment);
            Job job = jobAssignment.getJob();
            Employee employee = jobAssignment.getEmployee();

            // Accumulate jobs assigned to each worker
            int empId = employee.getEmployeeID();
            if (empJobList.containsKey(empId)){
            	List<Job> tmpList = empJobList.get(empId);
            	tmpList.add(job);
                empJobList.put(empId, tmpList);
            } else {
            	List<Job> tmpList = new ArrayList<>();
            	tmpList.add(job);
                empJobList.put(empId, tmpList);
            }


            // Hard Contraints

            // No unassigned Job
            //if (jobAssignment.getEmployee() == null) {
            //    hardScore += -1;
            //}

            // No unavailable employee assigned
            if (!employee.getShiftAvailability().contains(job.getShift())){
                hardScore += -1;
            }

            // No. of jobs follow grade
            switch(employee.getEmployeeGrade()) {
                case 1:
                    if (empJobList.get(employee.getEmployeeID()).size() > 3){
                        hardScore += -1;
                    }
                case 2:
                    if (empJobList.get(employee.getEmployeeID()).size() > 2){
                        hardScore += -1;
                    }
                case 3:
                    if (empJobList.get(employee.getEmployeeID()).size() > 1){
                        hardScore += -1;
                    }
            }

            // No consecutive shifts, same shift
            for (Job assignedJob : empJobList.get(employee.getEmployeeID())) {
                if (Math.abs(assignedJob.getShift() - job.getShift()) < 2 && assignedJob.getJobID() != job.getJobID()){
                    hardScore += -1;
                }
            }


            // Soft Constraints
            if (employee.getPreferredLocation().contains(job.getJobLocation())){
                softscore += 1;
            }

        }
        System.out.println("Hardscore:"+hardScore);
        System.out.println("Softscore:"+softscore);
        System.out.println(HardSoftScore.of(hardScore, softscore));
        
        return HardSoftScore.of(hardScore, softscore);
    }
}