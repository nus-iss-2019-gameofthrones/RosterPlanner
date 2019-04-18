package com.isrs.converter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isrs.roster.Employee;
import com.isrs.roster.Job;

//import com.fasterxml.jackson.databind.ObjectMapper;

//import springboothelloworld.HanumanCode;

@RestController

@RequestMapping(value = "/springbootlearning")

public class UIConverter {
	/*

	@RequestMapping(value = "/")
	public String hello() {

		return "Hello Soorej";
	}

	// Concatenate

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String Add(@RequestParam String A, @RequestParam String B) {
		String S = A + B;
		return S;
	}

	@RequestMapping(value = "/sum", method = RequestMethod.GET)
	public String sum(@RequestParam int A, @RequestParam int B) {
		int S = A + B;

		return Integer.toString(S);
	}

	@RequestMapping(value = "/hanuman", method = RequestMethod.POST)
	public String hanu(@RequestBody String jsonDataInput) {

		// read json file data to String

		System.out.println("start hanuman");

		System.out.println("this is the mayaaau request body \n" + jsonDataInput);

		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		// Seperate Employee and Stations node

		JsonNode rootNode;

		try {
			rootNode = objectMapper.readTree(jsonDataInput);
			JsonNode employeesnode = rootNode.path("employees");
			JsonNode stationnode = rootNode.path("stations");

			System.out.println("employeesNode is = " + employeesnode.toString());
			System.out.println("stationsNode is = " + stationnode.toString());

			// convert json string to object
			// Employee emp = objectMapper.readValue(jsonData, Employee.class);

			// SampleEmployee emp[] = objectMapper.readValue(jsonDataInput,
			// SampleEmployee[].class);

			SampleEmployee emp[] = objectMapper.readValue(employeesnode.toString(), SampleEmployee[].class);
			SampleStation stat[] = objectMapper.readValue(stationnode.toString(), SampleStation[].class);

			System.out.println("*****Employee Objects*******");

			System.out.println("Employee Object0\n" + emp[0].toString());
			// System.out.println("Employee Object\n"+emp[0].getPreferredshifts()[1]);

			System.out.println("Employee Object1\n" + emp[1].toString());
			// System.out.println("Employee Object\n"+emp[1].getPreferredshifts()[2]);

			System.out.println("Employee Object2\n" + emp[2].toString());
			// System.out.println("Employee Object\n"+emp[2].getPreferredshifts()[3]);

			System.out.println("*****Station Objects*******");

			System.out.println("Station Object0 :" + stat[0].toString());
			System.out.println("Station Object1 :" + stat[1].toString());
			System.out.println("Station Object2 :" + stat[2].toString());

			// Convert this station object to job object

			// Convert Station Object received from Tommy to List of Jobs for Ritesh

			List<Job> joblistForPassing = new ArrayList<Job>();

			Job[] joblist = new Job[stat.length];

			for (int i = 0; i < stat.length; i++) {
				// SampleStation var = stat[i];

				joblist[i] = new Job();
				joblist[i].setJobID(stat[i].getId());
				joblist[i].setShift(stat[i].getShift());
				joblist[i].setJobLocation(Integer.parseInt(stat[i].getName()));

				joblistForPassing.add(joblist[i]);

			}

			System.out.println("*****After converting Station Objects To Job Objects*******");

			System.out.println("Job Object0 :" + joblist[0].toString());
			System.out.println("Job Object1 :" + joblist[1].toString());
			System.out.println("JOb Object2 :" + joblist[2].toString());

			System.out.println("*****jobist for passing after cretion is*******");
			System.out.println(joblistForPassing.toString());

			// Convert this SampleEmployee object to Employee List

			// Convert Employee Object received from Tommy to List of Employees for Ritesh

			List<Employee> employeelistForPassing = new ArrayList<Employee>();

			Employee[] employeelist = new Employee[emp.length];

			for (int i = 0; i < emp.length; i++) {
				// SampleStation var = emp[i];

				employeelist[i] = new Employee();
				employeelist[i].setName(emp[i].getFirstname() + emp[i].getLastname());
				employeelist[i].setEmployeeID(emp[i].getId());
				employeelist[i].setEmployeeGrade(emp[i].getGrade());
				employeelist[i].setPreferredLocation(emp[i].getPreferredshifts());
				employeelist[i].setShiftAvailability(emp[i].getPrefferedShifts());

				employeelistForPassing.add(employeelist[i]);

			}

			System.out.println("*****After converting Sample Employee Objects To Employee Objects*******");

			System.out.println("Job Object0 :" + employeelist[0].toString());
			System.out.println("Job Object1 :" + employeelist[1].toString());
			System.out.println("JOb Object2 :" + employeelist[2].toString());

			System.out.println("*****EmployeeList for passing after cretion is*******");
			System.out.println(employeelistForPassing.toString());

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return "haiii";

		// int a;
		// a=HanumanCode.HanumanMethod();

		// return Integer.toString(a);

	}
*/
}
