import { Component, OnInit } from '@angular/core';
import { Booking } from '../booking';
import { Router } from '@angular/router';
import { BookingService } from '../booking.service';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
a;
bookings:Booking[];
  constructor(private bookingService:BookingService,
    private router:Router) { }

    a1=false;
  ngOnInit(): void {
  }
  showBookings(){
  this.a=localStorage.getItem("custid");
    this.bookingService.getBookings().subscribe(data => {
      this.bookings=data;
      console.log(data);
    });

    if (this.a1) {
      this.a1=false; 
    } else {
      this.a1=true; 
    }
  }
  del(id:number){
    console.log(id);
    this.bookingService.delBooking(id).subscribe(data=>{
      console.log("deleted");
      this.router.navigate(['/customer']);
    })
  }
}
