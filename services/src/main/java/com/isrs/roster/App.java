package com.isrs.roster;

import java.util.Arrays;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import com.isrs.roster.JobSchedule;
import com.isrs.roster.JobAssignment;

public class App 
{
	static JobSchedule unsolvedCourseSchedule = new JobSchedule();
	

	public static void setUp() 
	{
    	


    }
    public static void main( String[] args )
    
    {   
    	
    	System.out.println(unsolvedCourseSchedule);
    	SolverFactory<JobSchedule> solverFactory = SolverFactory.createFromXmlResource("courseScheduleSolverConfiguration.xml");
        Solver<JobSchedule> solver = solverFactory.buildSolver();
        JobSchedule solvedCourseSchedule = solver.solve(unsolvedCourseSchedule);
        System.out.println(solvedCourseSchedule);
       
 }
	
}