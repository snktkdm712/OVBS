import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
public a1 = true;
public a2 = true;
email = localStorage.getItem('user');
  constructor() { }

  ngOnInit(): void {
   console.log(this.email);
   this.islogged();
  }
  
 public islogged(){
    if(this.email == undefined || this.email == null || this.email == ''){
      this.a1=true;
      this.a2=false;
    }else{
      this.a2=true;
      this.a1=false;  
    }
    
  }
   
    logout(){
      console.log("daasdbaj");
      localStorage.removeItem('user');
    this.a1=true;
      this.a2=false;
      this.islogged();
    }
  
  }


