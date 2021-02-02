import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Vowner } from '../vowner';
import { VownerService } from '../vowner.service';
import { BookingService } from '../booking.service';
import { Booking } from '../booking';

@Component({
  selector: 'app-vowner',
  templateUrl: './vowner.component.html',
  styleUrls: ['./vowner.component.css']
})
export class VownerComponent implements OnInit {
a4;
  constructor(private r:Router,private vs:VownerService,private bks:BookingService) { }
vowner:Vowner =new Vowner();
booking:Booking[];
  ngOnInit(): void {
  }
  getbookings(){
    this.vowner.vOwner_id=parseInt(localStorage.getItem("void"));
this.vowner.vname=localStorage.getItem("vovname");
this.bks.getBookings().subscribe(data=>{
  this.booking=data;
})
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
