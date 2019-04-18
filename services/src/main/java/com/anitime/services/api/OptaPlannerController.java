package com.anitime.services.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anitime.services.db.EmployeeRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isrs.converter.SampleEmployee;
import com.isrs.converter.SampleStation;
import com.isrs.roster.Employee;
import com.isrs.roster.Job;
import com.isrs.roster.JobAssignment;
import com.isrs.roster.JobSchedule; 

@RestController
@RequestMapping("/api/opta")
@CrossOrigin
public class OptaPlannerController {

	private EmployeeRepository employeeRepository;

	public OptaPlannerController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@RequestMapping(value = "/solve", method = RequestMethod.POST)
	public List<JobAssignment> solve(@RequestBody String request) {

		List<JobAssignment> result = new ArrayList<>();

		System.out.println("Request:" + request);

		try {
			// Prepare input list
			JobSchedule unsolvedCourseSchedule = prepareSchedule(request);

			// Invoke OptaPlanner Solver
			result = invokeSolver(unsolvedCourseSchedule);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	private JobSchedule prepareSchedule(String request) throws JsonParseException, JsonMappingException, IOException {

		// New JobSchedule
		JobSchedule unsolvedCourseSchedule = new JobSchedule();
		
		// Jackson Mapper
		ObjectMapper jacksonMapper = new ObjectMapper();

		// Parse root node
		JsonNode rootNode = jacksonMapper.readTree(request);

		// Prepare Employee List
		List<Employee> employeeList = new ArrayList<>();
		JsonNode employeesnode = rootNode.path("employees");
		System.out.println("employeesNode is = " + employeesnode.toString());
		
		SampleEmployee emp[] = jacksonMapper.readValue(employeesnode.textValue(), SampleEmployee[].class);

		Employee[] employeelist = new Employee[emp.length];

		for (int i = 0; i < emp.length; i++) {
			employeelist[i] = new Employee();
			employeelist[i].setName(emp[i].getFirstName() + emp[i].getLastName());
			employeelist[i].setEmployeeID(emp[i].getId());
			employeelist[i].setEmployeeGrade(emp[i].getGrade());
			employeelist[i].setPreferredLocation(new ArrayList<>());
			
			List<Integer> shiftList = new ArrayList<>();
			for (int shift : emp[i].getShifts()) {
				shiftList.add(shift);
			}
			employeelist[i].setShiftAvailability(shiftList);

			employeeList.add(employeelist[i]);
		}
		
		// Prepare Job List
		List<Job> jobList = new ArrayList<>();
		JsonNode stationnode = rootNode.path("stations");
		System.out.println("stationsNode is = " + stationnode.toString());
		
		SampleStation stat[] = jacksonMapper.readValue(stationnode.textValue(), SampleStation[].class);

		Job[] joblist = new Job[stat.length];

		for (int i = 0; i < stat.length; i++) {

			joblist[i] = new Job();
			joblist[i].setJobID(stat[i].getId());
			joblist[i].setShift(stat[i].getShift());
			joblist[i].setJobLocation(stat[i].getId());

			jobList.add(joblist[i]);
		}
		
		unsolvedCourseSchedule.setEmployeeList(employeeList);
		unsolvedCourseSchedule.setJobList(jobList);
		unsolvedCourseSchedule.setJobAssignmentList(createJobAssignmentList(jobList, employeeList));
		
		return unsolvedCourseSchedule;
	}

	private List<JobAssignment> invokeSolver(JobSchedule unsolvedCourseSchedule) {

		System.out.println("invokeSolver start ----------------------------->");
		
		System.out.println("Solver:"+unsolvedCourseSchedule);
		SolverFactory<JobSchedule> solverFactory = SolverFactory.createFromXmlResource("courseScheduleSolverConfiguration.xml");
		Solver<JobSchedule> solver = solverFactory.buildSolver();
		JobSchedule solvedCourseSchedule = solver.solve(unsolvedCourseSchedule);
		System.out.println("Solution:"+solvedCourseSchedule.toString());
		
		System.out.println("After solving schedule...................");
		for (JobAssignment jobAssignment : solvedCourseSchedule.getJobAssignmentList()) {
			System.out.println("JobID: " + jobAssignment.getJob().getJobID() + ", Shift: " + jobAssignment.getJob().getShift() + ", Location: " + jobAssignment.getJob().getJobLocation() + ", Employee: " + jobAssignment.getEmployee().getName());
		}
		System.out.println("......................................");
		
		System.out.println("invokeSolver end ----------------------------->");
		
		return solvedCourseSchedule.getJobAssignmentList();
	}

	private List<JobAssignment> createJobAssignmentList(List<Job> jobList, List<Employee> empList) {

		if(CollectionUtils.isEmpty(jobList) || CollectionUtils.isEmpty(empList)) {
			System.out.println("EMPTY LIST FOUND");
			return null;
		}
		
		System.out.println("JobList: " + jobList.size());
		System.out.println("EmployeeList: " + empList.size());

		List<JobAssignment> jobAssignmentList = new ArrayList<>();

		for(int x=0; x<jobList.size(); x++) {
			JobAssignment jobAssignment = new JobAssignment();
			jobAssignment.setEmployee(empList.get(x));
			jobAssignment.setJob(jobList.get(x));

			jobAssignmentList.add(jobAssignment);
		}

		System.out.println("Before solving schedule...................");
		for (JobAssignment jobAssignment : jobAssignmentList) {
			System.out.println("JobID: " + jobAssignment.getJob().getJobID() + ", Shift: " + jobAssignment.getJob().getShift() + ", Location: " + jobAssignment.getJob().getJobLocation() + ", Employee: " + jobAssignment.getEmployee().getName());
		}
		System.out.println("......................................");
		
		System.out.println("JobAssignmentList: " + jobAssignmentList.size());
		System.out.println("JobAssignmentList: " + jobAssignmentList);
		
		return jobAssignmentList;
	}

}
