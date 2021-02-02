import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VenueComponent } from '../venue/venue.component';
import { Booking } from '../booking';
import { BookingService } from '../booking.service';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
 b = new Booking();
 cust:Customer = new Customer();
 email;
  constructor(private router:Router,private bks:BookingService,private cser:CustomerService) { }



bdate:Date;
vname = localStorage.getItem("venue");
bprice=localStorage.getItem("bprice");
bkrate=10000;
id=localStorage.getItem("id");
  ngOnInit(): void {
    
  }
a(){
  console.log(this.bdate);
this.b.bkdate=String(this.bdate);
this.b.vname=this.vname;
this.b.venue_id=parseInt(this.id);
this.b.b_days=1;
this.b.p_status=true;

this.email=localStorage.getItem("user");
console.log(this.email);  
this.cser.getCustomer(this.email).subscribe(data=>{
  this.cust=data;
  console.log(this.cust);
  this.b.cust_id=this.cust.cust_id;
  console.log(this.b);
  this.bks.addbooking(this.b).subscribe(data=>{
    console.log(data);
    this.router.navigate(['/customer']);
});
});





}
}
