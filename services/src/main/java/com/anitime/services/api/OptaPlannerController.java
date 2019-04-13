package com.anitime.services.api;

import com.anitime.services.db.EmployeeRepository;
import com.anitime.services.db.SkillRepository;
import com.anitime.services.model.Employee;
import com.anitime.services.model.Skill;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException; 

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
