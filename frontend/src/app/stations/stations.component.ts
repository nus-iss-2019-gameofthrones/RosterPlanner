import { Component, OnInit } from '@angular/core';
import { ApiService } from '../shared/api.service';
import { Router } from '@angular/router';
import { Station } from './model/station';

@Component({
  selector: 'app-stations',
  templateUrl: './stations.component.html',
  styleUrls: ['./stations.component.css']
})
export class StationsComponent implements OnInit {
  stations: Station[] = [];

  constructor(private apiService: ApiService, private router:Router) { }

  ngOnInit() {
    this.getAllStations();
  }

  public getAllStations(){
    this.apiService.getAllStations().subscribe(
      res => {
        this.stations = res;
      },
      err => {alert("An error has occurred")}
    );
  }

  public saveStation(station: Station){
    this.apiService.saveStation(station).subscribe(
      res =>{
        location.reload();
      },
      err =>{
        alert("An error has occurred.");
      }
    );
  }

  viewSta(id: String){
    this.router.navigate(['/viewStation/'+id]);
  }

  deleteSta(sta: Station){
    this.apiService.deleteStation(sta).subscribe(
      res=>{
        location.reload();
      },
      err=>{
        alert('An error has occurred.');
      }
    );
  }

}
