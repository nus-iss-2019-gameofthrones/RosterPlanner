import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from './model/employee';
import { ApiService } from '../shared/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})

export class EmployeesComponent implements OnInit {
  employees: Employee[] = [];
  
  constructor(private apiService: ApiService, private router:Router) { }

  ngOnInit() {
    this.getAllEmployees();
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

  public saveEmployee(employee: Employee){
    this.apiService.saveEmployee(employee).subscribe(
      res =>{
        location.reload();
      },
      err =>{
        alert("An error has occurred.");
      }
    );
  }

  viewEmp(id: String){
    this.router.navigate(['/viewEmployee/'+id]);
  }

  deleteEmp(emp: Employee){
    this.apiService.deleteEmployee(emp).subscribe(
      res=>{
        location.reload();
      },
      err=>{
        alert('An error has occurred.');
      }
    );
  }
}
