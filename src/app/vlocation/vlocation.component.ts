import { Component, OnInit } from '@angular/core';
import { VlocService } from '../vloc.service';
import { VenueService } from '../venue.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Venue } from '../venue';


@Component({
  selector: 'app-vlocation',
  templateUrl:'./vlocation.component.html',
  styleUrls: ['./vlocation.component.css']
})
export class VlocationComponent implements OnInit {
  venues:Venue[];
  constructor(private vlocservice:VlocService,
    private venueService:VenueService,
    private router:Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getvenues();
  }

  getvenues(){
var id =parseInt( localStorage.getItem("vloc"));
    console.log(id);
this.vlocservice.getvenue(id).subscribe(data=>{
  this.venues=data;
  console.log(data);
},
error=>console.error()
);
  }

}
