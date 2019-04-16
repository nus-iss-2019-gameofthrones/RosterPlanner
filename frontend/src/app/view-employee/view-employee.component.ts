import { Component, OnInit } from '@angular/core';
import { Employee } from '../employees/model/employee';
import { ApiService } from '../shared/api.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-employee',
  templateUrl: './view-employee.component.html',
  styleUrls: ['./view-employee.component.css']
})
export class ViewEmployeeComponent implements OnInit {

  employee: Employee = {
    id: 0,
    firstName: "",
    lastName: "",
    grade: 0,
    preferredShifts: []
  }
  id:String;

  constructor(private apiService: ApiService, private activatedRoute:ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params =>{
      this.id = params['id'];
    });
    this.getEmployee(this.id);
  }

  public getEmployee(id: String){
    this.apiService.getEmployee(id).subscribe(
      res => {
        this.employee = res;
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

  public updateEmployee(){
    this.apiService.updateEmployee(this.employee).subscribe(
      res => {
        this.router.navigate(['/employees']);
      },
      err => {
        alert('An error has occurred');
      }
    );
  }

}
