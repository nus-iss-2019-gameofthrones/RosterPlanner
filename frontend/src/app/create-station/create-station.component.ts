import { Component, OnInit } from '@angular/core';
import { Station } from '../stations/model/station';
import { ApiService } from '../shared/api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-create-station',
  templateUrl: './create-station.component.html',
  styleUrls: ['./create-station.component.css']
})
export class CreateStationComponent implements OnInit {

  station: Station = {
    id: 0,
    name: "",
    shift: 0
  }

  constructor(private apiService: ApiService, private activatedRoute:ActivatedRoute, private router: Router) { }

  ngOnInit() {
    
  }
  public saveStation(){
    console.log(this.station);
    this.apiService.saveStation(this.station).subscribe(
      res =>{
        this.router.navigate(['/stations']);
      },
      err =>{
        alert("An error has occurred.");
      }
    );
  }

}
