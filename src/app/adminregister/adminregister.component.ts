import { Component, OnInit } from '@angular/core';
import { Admin } from '../admin';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';


@Component({
  selector: 'app-adminregister',
  templateUrl: './adminregister.component.html',
  styleUrls: ['./adminregister.component.css']
})
export class AdminregisterComponent implements OnInit {
a;
  admin: Admin = new Admin();
  constructor(private adminService:AdminService,
    private router:Router) { }
    
    saveAdmin(){
      this.admin.role="admin";
      this.admin.account_balance=10000;
this.adminService.createAdmin(this.admin).subscribe(data =>{
  console.log(data);
  this.goToAdmin();
},
error => console.log(error))};

goToAdmin(){
  this.adminService.getAdmin(this.admin.email).subscribe(data=>{
    this.admin=data;
    console.log(this.admin.user_id);
  })
  this.a=this.admin.user_id
  this.router.navigate(['/login']);
}
  ngOnInit(): void {
  }
  onSubmit(){
    console.log(this.admin);
    this.saveAdmin();
  }
}
