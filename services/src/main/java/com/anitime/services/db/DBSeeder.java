package com.anitime.services.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import com.anitime.services.model.*;
import com.anitime.services.db.*;

    @Component
    @ConditionalOnProperty(name = "noteit.db.recreate", havingValue = "true")
    public class DBSeeder implements CommandLineRunner {
        private SkillRepository skillRepository;
        private StationRepository stationRepository;
        private EmployeeRepository employeeRepository;

        public DBSeeder(SkillRepository skillRepository,
                        StationRepository stationRepository,
                        EmployeeRepository employeeRepository) {
            this.skillRepository = skillRepository;
            this.employeeRepository = employeeRepository;
            this.stationRepository = stationRepository;
        }


        @Override
        public void run(String... args) {
            // Remove all existing entities
            this.stationRepository.deleteAll();
            this.skillRepository.deleteAll();
            this.employeeRepository.deleteAll();


            // Save a default notebook
            Skill skill1 = new Skill("Grade 1");
            Skill skill2 = new Skill("Grade 2");
            Skill skill3 = new Skill("Grade 3");
            this.skillRepository.save(skill1);
            this.skillRepository.save(skill2);
            this.skillRepository.save(skill3);
            
            //Save default employee
            Employee emp1 = new Employee("John", "Doe", 1);
            this.employeeRepository.save(emp1);
            Employee emp2 = new Employee("Tommy", "Tan", 2);
            this.employeeRepository.save(emp2);
            Employee emp3 = new Employee("Greg", "Goh", 3);
            this.employeeRepository.save(emp3);
            Employee emp4 = new Employee("Andy", "Quek", 1);
            this.employeeRepository.save(emp4);
            Employee emp5 = new Employee("Anne", "May", 2);
            this.employeeRepository.save(emp5);
            Employee emp6 = new Employee("Linda", "Soh", 3);
            this.employeeRepository.save(emp6);
            Employee emp7 = new Employee("Eva", "Wong", 1);
            this.employeeRepository.save(emp7);
            Employee emp8 = new Employee("Gary", "Sim", 2);
            this.employeeRepository.save(emp8);
            Employee emp9 = new Employee("George", "Ang", 3);
            this.employeeRepository.save(emp9);
            Employee emp10 = new Employee("Jimmy", "Tang", 1);
            this.employeeRepository.save(emp10);
            Employee emp11 = new Employee("Erich", "Lee", 2);
            this.employeeRepository.save(emp11);
            
          //Save default station
            Station sta1 = new Station("Admiralty");
            this.stationRepository.save(sta1);
            
            System.out.println("Initialized database");
        }
    }

