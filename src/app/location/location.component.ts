import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css']
})
export class LocationComponent implements OnInit {
a=0;
  constructor(private router:Router ) { }

  ngOnInit(): void {
  }
  goto1(){
    this.a=1
    localStorage.setItem("vloc","1");
    this.router.navigate(['/vloc',this.a]);
  }
  goto2(){
    this.a=2;
    localStorage.setItem("vloc","2");
    this.router.navigate(['/vloc',this.a]);
  }
  goto3(){
    this.a=3;
    localStorage.setItem("vloc","3");
    this.router.navigate(['/vloc',this.a]);
  }
  goto4(){
    this.a=4;
    localStorage.setItem("vloc","4");
    this.router.navigate(['/vloc',this.a]);
  }
}
