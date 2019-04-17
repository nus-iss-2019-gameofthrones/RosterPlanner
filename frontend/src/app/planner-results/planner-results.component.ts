import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../shared/api.service';
import { Employee } from '../employees/model/employee';

@Component({
  selector: 'app-planner-results',
  templateUrl: './planner-results.component.html',
  styleUrls: ['./planner-results.component.css']
})
export class PlannerResultsComponent implements OnInit {
  availableShiftsHeader: String[] = ["Mon AM", "Mon PM", "Tue AM", "Tue PM", "Wed AM", "Wed PM", "Thu AM", "Thu PM", "Fri AM", "Fri PM"];
  availableShifts: number[] = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
  results: Employee[] = [
    {
      id:1,
      firstName: "Todd",
      lastName: "Frank",
      grade:1,
      preferredShifts: [1],
      station:"Kranji"
    },
    {
      id:2,
      firstName: "Greg",
      lastName: "Tio",
      grade:2,
      preferredShifts: [6],
      station:"Yishun"
    }
  ];

  constructor(private router:Router, private apiService:ApiService) { }

  ngOnInit() {
  }

}
