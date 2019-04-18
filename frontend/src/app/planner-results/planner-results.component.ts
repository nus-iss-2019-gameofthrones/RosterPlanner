import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ApiService } from '../shared/api.service';
import { Employee } from '../employees/model/employee';
import { Station } from '../stations/model/station';
import { Assignment } from '../employees/model/assignment';

@Component({
  selector: 'app-planner-results',
  templateUrl: './planner-results.component.html',
  styleUrls: ['./planner-results.component.css']
})
export class PlannerResultsComponent implements OnInit {
  availableShiftsHeader: String[] = ["Mon AM", "Mon PM", "Tue AM", "Tue PM", "Wed AM", "Wed PM", "Thu AM", "Thu PM", "Fri AM", "Fri PM"];
  availableShifts: number[] = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
  employees: Employee[];
  stations: Station[];
  assignments:Assignment[];
  assignmentsStr:string;

  results: Employee[] = [
    {
      id:1,
      firstName: "Linda",
      lastName: "Soh",
      grade:1,
      preferredShifts: [0],
      station:["Admiralty"],
      preferredLocation:1
    },
    {
      id:2,
      firstName: "John",
      lastName: "Doe",
      grade:2,
      preferredShifts: [7],
      station:["Sembawang"],
      preferredLocation:1
    },
    {
      id:3,
      firstName: "George",
      lastName: "Ang",
      grade:2,
      preferredShifts: [4],
      station:["Yishun"],
      preferredLocation:1
    }
  ];

  constructor(private router:Router, private apiService:ApiService, private route: ActivatedRoute) { 
    console.log("called constructor");
    /*
    this.route.queryParams.subscribe(
      params =>{
        this.results = params['assignments'];
      }
    );
    */
   //this.results = this.route.snapshot.params.assignments;

    console.log("Results "+this.results);
  }

  ngOnInit() {    
    this.getAllEmployees();
    this.getAllStations();

    this.assignmentsStr = this.route.snapshot.params.assignments;
    this.assignments = JSON.parse(this.assignmentsStr);

    console.log("Results String"+this.assignmentsStr);
    console.log("Results "+this.assignments);
  }

  public getAllEmployees(){
    this.apiService.getAllEmployees().subscribe(
      res => {
        this.employees = res;
        console.log(this.employees);
      },
      err => {alert("An error has occurred")}
    );
  }

  public getAllStations(){
    this.apiService.getAllStations().subscribe(
      res => {
        this.stations = res;
        console.log(this.stations);
      },
      err => {alert("An error has occurred")}
    );
  }
/*
this.route.queryParams.subscribe(params => {
        this.userWithRole.user = JSON.parse(params["user"]);
      });

       "user": JSON.stringify(this.users[i])
*/
}
