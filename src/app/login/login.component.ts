import { Component, OnInit, Input } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { Vowner } from '../vowner';

import { AdminService } from '../admin.service';
import { CustomerService } from '../customer.service';
import { VownerService } from '../vowner.service';
import { Customer } from '../customer';
import { Admin } from '../admin';
import { NavbarComponent } from '../navbar/navbar.component';


@Component({
  selector: 'app-login',
  templateUrl:'./login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 a1=false;
  w:NavbarComponent;
 user:User = new User();
customer:Customer=new Customer();
admin:Admin=new Admin();
vowner:Vowner=new Vowner();

  constructor(private userService:UserService,
    private adminService:AdminService,
    private customerService:CustomerService,
    private vownerService:VownerService,
   private router:Router) { }

  onSubmit(){
    this.validateUser();
  }
  
   validateUser(){
     this.userService.validateUser(this.user).subscribe((data:any) =>{
      this.user = data;
      console.log(data);
      localStorage.setItem('user',this.user.email)  
      this.goto();
    },
    error => console.log("Wrong Email or Password"));
    this.a1=true;
    this.router.navigate(['/login']);
  }    
  ngOnInit(): void {
  }
  goto(){
    var a=this.user.role;
    if(a!= null){
      switch (a) {
        case 'admin':
          this.admin.email=this.user.email;
          this.adminService.getAdmin(this.admin.email).subscribe(data=>{
            this.admin=data;
            console.log("HI");
          })
          console.log(this.admin.user_id);
          localStorage.setItem("id1",String(this.admin.user_id));
          this.searchadmin();
          
          break;
          case 'customer':
            this.customer.email=this.user.email;
            console.log(this.customer.email);
            this.searchcustomer();
            break;

          case 'vowner':
            this.vowner.email=this.user.email;
            console.log(this.vowner.email);
            this.searchvowner();
          break;
        default:
          this.router.navigate(['/login']);
          break;
      }
  
    }else{
      this.router.navigate(['/login']);
    }

  }

  searchadmin(){
    console.log(this.admin.email);
this.adminService.getAdmin(this.admin.email).subscribe((data:any)=>{
  this.admin=data;
  console.log(data);
  console.log(this.admin.user_id);
  this.router.navigate(['/admin']);
})
  }

  searchcustomer(){
    console.log(this.customer.email);
this.customerService.getCustomer(this.customer.email).subscribe((data:any)=>{
  this.customer=data;
  console.log(data);
  console.log(this.customer.cust_id);
  localStorage.setItem("custid",String(this.customer.cust_id));
  this.router.navigate(['/customer']); 
  })
}
searchvowner(){
  console.log(this.vowner.email);
this.vownerService.getVowner(this.vowner.email).subscribe((data:any)=>{
this.vowner=data;
console.log(data);
console.log(this.vowner.vOwner_id);
localStorage.setItem("void",String(this.vowner.vOwner_id));
localStorage.setItem("vovname",String(this.vowner.vname));
this.router.navigate(['/vowner']); 
})
}

   //to check user logged in or not
   isLoggedIn(){
    var email = localStorage.getItem('user');
    
  if(email == undefined || email == null || email == ''){
    return false;
  }
  return true;
}

//to logout the user
logout(){
  localStorage.removeItem('user');
  return true;
}

q(){
this.w.a1=false;
}


}


