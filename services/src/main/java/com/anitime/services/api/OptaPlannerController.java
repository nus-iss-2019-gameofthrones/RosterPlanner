package com.anitime.services.api;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anitime.services.db.EmployeeRepository; 

@RestController
@RequestMapping("/api/opta")
@CrossOrigin
public class OptaPlannerController {

    private EmployeeRepository employeeRepository;

    public OptaPlannerController(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/solve")
    public List<Object> solve(@RequestBody String body){

        ArrayList<Object> result = new ArrayList<Object>();
        System.out.println("Printing stuff");
        System.out.println(body);
        JSONParser parser = new JSONParser();
        try {
			JSONObject json = (JSONObject) parser.parse(body);
			String empString = (String) json.get("employees");
			System.out.println("Printing json");
	        System.out.println(empString);
	        
	        String staString = (String) json.get("stations");
			System.out.println("Printing json stations");
	        System.out.println(staString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        return result;
    }


}
