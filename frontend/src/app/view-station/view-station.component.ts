import { Component, OnInit } from '@angular/core';
import { Station } from '../stations/model/station';
import { ApiService } from '../shared/api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-view-station',
  templateUrl: './view-station.component.html',
  styleUrls: ['./view-station.component.css']
})
export class ViewStationComponent implements OnInit {
  station: Station = {
    id: 0,
    name: "",
    shift: 0
  }

  id:String;
  
  constructor(private apiService: ApiService, private activatedRoute:ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params =>{
      this.id = params['id'];
    });
    this.getStation(this.id);
  }

  public getStation(id: String){
    this.apiService.getStation(id).subscribe(
      res => {
        this.station = res;
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

  public updateStation(){
    this.apiService.updateStation(this.station).subscribe(
      res => {
        this.router.navigate(['/stations']);
      },
      err => {
        alert('An error has occurred');
      }
    );
  }

}
