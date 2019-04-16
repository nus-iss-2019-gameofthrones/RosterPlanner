import { Component, OnInit } from '@angular/core';
import { Employee } from '../employees/model/employee';
import { Station } from '../stations/model/station';
import { Router } from '@angular/router';
import { ApiService } from '../shared/api.service';

@Component({
  selector: 'app-planner',
  templateUrl: './planner.component.html',
  styleUrls: ['./planner.component.css']
})
export class PlannerComponent implements OnInit {
  employees: Employee[];
  stations: Station[];
  selectedEmployees: any[] = [];
  selectedStations: any[] = [];
  availableShifts: number[] = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
  availableShiftsHeader: String[] = ["Mon AM", "Mon PM", "Tue AM", "Tue PM", "Wed AM", "Wed PM", "Thu AM", "Thu PM", "Fri AM", "Fri PM"];
  empGrade: number = 0;

  //To be used when add is clicked
  empAvailableShifts: number[] = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
  selectedEmp: Employee;
  staAvailableShifts: number[] = [];
  selectedStation: Station;

  //employees array to add
  public employeesAdded: Employee[] = [];

  //Station array to add
  public stationsAdded: Station[] = [];

  constructor(private router:Router, private apiService:ApiService) { }

  ngOnInit() {
    this.getAllEmployees();
    this.getAllStations();
  }

  public getAllEmployees(){
    this.apiService.getAllEmployees().subscribe(
      res => {
        this.employees = res;
      },
      err => {alert("An error has occurred")}
    );
  }

  public getAllStations(){
    this.apiService.getAllStations().subscribe(
      res => {
        this.stations = res;
      },
      err => {alert("An error has occurred")}
    );
  }

  isChecked(obj, type, event){
    if(type == 1){
      if(event.target.checked){
        this.selectedEmployees.push(obj);
      }else{
        this.popObject(obj, type);
      }
    }

    if(type == 2){
      if(event.target.checked){
        this.selectedStations.push(obj);
      }else{
        this.popObject(obj, type);
      }
    }
  }

  selectOption(event){
    
    var emp = event.target.value;
    console.log("Id is "+emp);
    console.log(this.employees);
    if(emp != ""){
      this.selectedEmp = this.employees.find(x=>x.id === +emp);
      console.log(this.selectedEmp);
      this.empGrade = +(this.selectedEmp.grade);
    }else{
      this.empGrade = 0;
    }
  }

  popObject(obj, type){
    var index = 0;

    if(type == 1){
      index = this.selectedEmployees.indexOf(obj);
      this.selectedEmployees.splice(index, 1);
    }

    if(type == 2){
      index = this.selectedStations.indexOf(obj);
      this.selectedStations.splice(index, 1);
    }
  }

  manageClick(event){
    var isChecked = event.target.isChecked;
    var value = event.target.value;
    var index = this.empAvailableShifts.indexOf(+value);

    if(!isChecked && index > -1){
      this.empAvailableShifts.splice(index, 1);
    }else{
      var int1 = +value;
      //console.log("Value is" +int1)
      this.empAvailableShifts.push(int1);
    }
  }

  addEmployeeToList(){
    this.selectedEmp.preferredShifts = this.empAvailableShifts;
    this.employeesAdded.push(this.selectedEmp);
    var numberOfShifts=0;
    console.log(this.selectedEmp.grade);
    if(this.selectedEmp.grade === 1){
      numberOfShifts = 2;
    }else if(this.selectedEmp.grade === 2){
      numberOfShifts = 1;
    }else if(this.selectedEmp.grade === 3){
      numberOfShifts = 0;
    }

    for(let i = 0;i<0;i++){

      var empToadd:Employee = {
        id:this.selectedEmp.id,
        firstName: this.selectedEmp.firstName,
        lastName: this.selectedEmp.lastName,
        grade: this.selectedEmp.grade,
        preferredShifts: this.empAvailableShifts
      };
      this.employeesAdded.push(empToadd);
    }
    console.log(this.employeesAdded); 
  }

  selectStationOption(event){    
    var sta = event.target.value;
    if(sta != ""){
      this.selectedStation = this.stations.find(x=>x.id === +sta);
    }
    
  }

  manageStationClick(event){
    var isChecked = event.target.isChecked;
    var value = event.target.value;
    var index = this.staAvailableShifts.indexOf(+value);

    console.log(index);
    if(!isChecked && index > -1){
      this.staAvailableShifts.splice(index, 1);
    }else{
      var int1 = +value;
      console.log("Value is" +int1)
      this.staAvailableShifts.push(int1);
    }
    console.log(this.staAvailableShifts);
  }

  addStationToList(){
    //this.selectedStation.shift = this.staAvailableShifts;
  for(let i = 0;i<this.staAvailableShifts.length;i++){

    var staToadd:Station = {
      id:this.selectedStation.id,
      name: this.selectedStation.name,
      shift: this.staAvailableShifts[i]
    };
    this.stationsAdded.push(staToadd);
  }
  console.log(this.stationsAdded); 
  }

  solve(): void{
    
    var jsonEmp = JSON.stringify(this.employeesAdded);
    var jsonSta = JSON.stringify(this.stationsAdded);

    console.log("JSON EMP "+jsonEmp);
    console.log("JSON STA "+jsonSta);

    this.apiService.solveResults(jsonEmp, jsonSta).subscribe(
      res => {
        this.router.navigate(['/employees']);
      },
      err => {
        alert("An error has occurred");
      }
    );
    }
    
}
