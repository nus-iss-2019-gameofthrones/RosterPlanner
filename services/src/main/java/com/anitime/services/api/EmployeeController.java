package com.anitime.services.api;

import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anitime.services.db.EmployeeRepository;
import com.anitime.services.model.Employee;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/all")
    public List<Employee> all(){
        return this.employeeRepository.findAll();
    }

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }
        Employee emp1 = new Employee(employee.getFirstName(),employee.getLastName(), employee.getGrade());
        this.employeeRepository.save(emp1);

        return employee;
    }
    
    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }
        this.employeeRepository.save(employee);

        return employee;
    }

    @GetMapping("/getEmp/{id}")
    public Optional<Employee> getEmp(@PathVariable String id){
        return this.employeeRepository.findById(Integer.parseInt(id));
    }
    
    @DeleteMapping("delete")
    public void delete(@RequestBody Employee employee){
        this.employeeRepository.delete(employee);
    }
}
