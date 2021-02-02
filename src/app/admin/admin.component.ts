import { Component, OnInit } from '@angular/core';
import { Admin } from '../admin';
import { Router,ActivatedRoute } from '@angular/router';
import { AdminService } from '../admin.service';
import { Vowner } from '../vowner';
import { VownerService } from '../vowner.service';
import { Availabledates } from '../availabledates';
import { availableDatesService } from '../availableDates.service';
import { Venue } from '../venue';
import { VenueService } from '../venue.service';
import { Booking } from '../booking';
import { BookingService } from '../booking.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  admin:Admin;
  admins:Admin[];
 vowners:Vowner[];
 venues:Venue[];
 booking:Booking[];
availableDates:Availabledates[];
  constructor(private adminService:AdminService,
    private vownerService:VownerService,
    private availableDatesService:availableDatesService,
    private venueService:VenueService,
    private bks:BookingService,
    private router:Router,
    private route: ActivatedRoute) { }

    a1 = false;
    a2=false;
    a3=false;
    a4=false;
ngOnInit(): void {
  this.getadmin();
  }
  getadmin(){
    var id = parseInt(localStorage.getItem("id1"));
    this.adminService.getadmin(id).subscribe(data => {
      this.admin = data;
    });
  }
 getAdmins(){
    this.adminService.getAdminList().subscribe(data => {
      this.admins = data;
    });
  }
  showAdmins(){
    if (this.a1) {
      this.a1=false; 
    } else {
      this.a1=true; 
    }
     
    this.getAdmins();
  };
  getVowners(){
    this.vownerService.getVownerList().subscribe(data => {
      this.vowners = data;
    });
  }
  showVowners(){
    if (this.a2) {
      this.a2=false; 
    } else {
      this.a2=true; 
    }
     
    this.getVowners();
  };
  getavailableDates(){
  this.availableDatesService.getAvailableDates().subscribe(data => {
    this.availableDates = data;
  });
}
getvenueDetails(){
this.venueService.getvenues().subscribe(data => {
  this.venues = data;
});
}

showAVenuedetails(){
  if (this.a3) {
    this.a3=false; 
  } else {
    this.a3=true; 
  }
   
  // this.getavailableDates();
  this.getvenueDetails();
}

getbookings(){
  this.bks.getBookings().subscribe(data=>{
    this.booking=data;
    console.log(data);
    });  
}
showb(){
  if (this.a4) {
    this.a4=false; 
  } else {
    this.a4=true; 
  }

  this.getbookings();
}

}
