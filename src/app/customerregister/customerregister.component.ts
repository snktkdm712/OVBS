import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-customerregister',
  templateUrl: './customerregister.component.html',
  styleUrls: ['./customerregister.component.css']
})
export class CustomerregisterComponent implements OnInit {

  customer:Customer=new Customer();

  constructor(private customerService:CustomerService,
    private router:Router) { }

    saveCustomer(){
      this.customer.role="customer";
      this.customer.bkstatus=false;
      this.customer.aadharNo=0;
      this.customerService.createCustomer(this.customer).subscribe(data =>{
        console.log(data);
        this.goToCustomer();
      },
      error=>console.log(error))
    };
goToCustomer(){
  this.router.navigate(['/login'])
}
  ngOnInit(): void {
  }

  onSubmit(){
    console.log(this.customer);
    this.saveCustomer();
  }

}
