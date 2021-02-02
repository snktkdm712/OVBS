import { Component, OnInit } from '@angular/core';
import { Vowner } from '../vowner';
import { VownerService } from '../vowner.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-venueownerregister',
  templateUrl: './venueownerregister.component.html',
  styleUrls: ['./venueownerregister.component.css']
})
export class VenueownerregisterComponent implements OnInit {
vowner: Vowner = new Vowner();

constructor( private vownerService:VownerService,
  private router:Router) { }

  saveVowner(){
    this.vowner.role="vowner";
    this.vownerService.createVowner(this.vowner).subscribe(
      data=>{
        console.log(data);
        this.goToVowner();
      }, error=>console.log(error))};

  ngOnInit(): void {
  }

  goToVowner(){
    this.router.navigate(['/rvenue'])
  }

  onSubmit(){
    console.log(this.vowner);
    this.saveVowner();
  }

}
