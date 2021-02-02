import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { VenueService } from '../venue.service';
import { Venue } from '../venue';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-venue',
  templateUrl: './venue.component.html',
  styleUrls: ['./venue.component.css']
})
export class VenueComponent implements OnInit {
 public  venue = new Venue();
 cust:Customer;
   a ;
   email;
   

   b=false;
  constructor(private cser:CustomerService, private venueService:VenueService,
    private router:Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.a = params.get("vname")
    })
    this.getvenue();
  }
  
  getvenue(){
  console.log(this.a);
    this.venueService.getvenue(this.a).subscribe(data=>{
      this.venue=data;
      console.log(data);
    },
    error=>console.error()
    );}

    book(){
this.email=localStorage.getItem("user");
console.log(this.email);  
this.cser.getCustomer(this.email).subscribe(data=>{
  this.cust=data;
  console.log(this.cust.firstName);
}) ;

      if(this.email!=null){
        console.log(this.venue.vname);
        localStorage.setItem("venue",this.venue.vname);
        localStorage.setItem("bprice",String(this.venue.vrate));
        localStorage.setItem("id",String(this.venue.v_id));  
        this.router.navigate(['/book']);
      }else{
        this.b=true;
      }
        }
}
