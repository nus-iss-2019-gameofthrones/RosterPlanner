import { Component, OnInit } from '@angular/core';
import { Employee } from '../employees/model/employee';
import { ApiService } from '../shared/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = {
    id: 0,
    firstName: "",
    lastName: "",
    grade: 0,
    preferredShifts: []
  }

  constructor(private apiService: ApiService, private router: Router) { }

  ngOnInit() {
  }

  saveEmployee(): void{
    this.apiService.saveEmployee(this.employee).subscribe(
      res => {
        this.router.navigate(['/employees']);
      },
      err => {
        alert("An error has occurred");
      }
    );
    }

}
