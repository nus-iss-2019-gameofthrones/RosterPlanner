import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Employee} from '../employees/model/employee';
import {Station} from '../stations/model/station';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private BASE_URL = "http://localhost:8082/api";
  //Employees
  private ALL_EMPLOYEES_URL = `${this.BASE_URL}\\employee\\all`;
  private GET_EMPLOYEE_URL = `${this.BASE_URL}/employee/getEmp/`;
  private SAVE_EMPLOYEE_URL = `${this.BASE_URL}\\employee\\save`;
  private UPDATE_EMPLOYEE_URL = `${this.BASE_URL}\\employee\\update`;
  private DELETE_EMPLOYEE_URL = `${this.BASE_URL}/employee/delete`;

  //Stations
  private ALL_STATIONS_URL = `${this.BASE_URL}\\station\\all`;
  private GET_STATIONS_URL = `${this.BASE_URL}/station/getEmp/`;
  private SAVE_STATIONS_URL = `${this.BASE_URL}\\station\\save`;
  private UPDATE_STATIONS_URL = `${this.BASE_URL}\\station\\update`;
  private DELETE_STATIONS_URL = `${this.BASE_URL}/station/delete`;

  //Planner
  private SOLVE_PLANNER_URL = `${this.BASE_URL}/opta/solve`;

  constructor(private http: HttpClient) { 

  }

  //Stations
  getAllStations() : Observable<Station[]>{
    return this.http.get<Station[]>(this.ALL_STATIONS_URL);
  }

  saveStation(station: Station) : Observable<any>{
    return this.http.post(this.SAVE_STATIONS_URL, station);
  }

  getStation(id: String) : Observable<Station>{
    return this.http.get<Station>(this.GET_STATIONS_URL + id);
  }

  updateStation(station: Station) : Observable<Employee>{
    return this.http.post<Employee>(this.UPDATE_STATIONS_URL, station);
  }

  deleteStation(station: Station) : Observable<any>{
    return this.http.post<Station>(this.DELETE_STATIONS_URL, station);
  }

  //Employees
  getAllEmployees() : Observable<Employee[]>{
    return this.http.get<Employee[]>(this.ALL_EMPLOYEES_URL);
  }

  saveEmployee(employee: Employee) : Observable<any>{
    return this.http.post(this.SAVE_EMPLOYEE_URL, employee);
  }

  getEmployee(id: String) : Observable<Employee>{
    return this.http.get<Employee>(this.GET_EMPLOYEE_URL + id);
  }

  updateEmployee(employee: Employee) : Observable<Employee>{
    return this.http.post<Employee>(this.UPDATE_EMPLOYEE_URL, employee);
  }

  deleteEmployee(employee: Employee) : Observable<any>{
    return this.http.post<Employee>(this.DELETE_EMPLOYEE_URL, employee);
  }

  //Planner
  solveResults(employees: any, stations: any) : Observable<any>{
    return this.http.post<Employee>(this.SOLVE_PLANNER_URL, {employees, stations});
  }
}
