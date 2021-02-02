import { Component, OnInit } from '@angular/core';
import { Venue } from '../venue';
import { Router } from '@angular/router';
import { VenueService } from '../venue.service';

@Component({
  selector: 'app-venueregister',
  templateUrl:'./venueregister.component.html',
  styleUrls: ['./venueregister.component.css']
})
export class VenueregisterComponent implements OnInit {
  venue: Venue = new Venue();
con;
  constructor(private venueService: VenueService ,
    private router:Router ){ }
    
  saveVenue(){
    this.venue.vservices=true;
  this.venue.contact_no=this.con;
  console.log(this.con);
    this.venueService.createVenue(this.venue).subscribe(data =>{
  console.log(data);
  this.goToVowner();
},
error => console.log(error))};

goToVowner(){
  this.router.navigate(['/login'])
}

  ngOnInit(): void {
  }
  onSubmit(){
    console.log(this.venue);
    this.saveVenue();
  }
}
