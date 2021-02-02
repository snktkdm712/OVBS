import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Customer } from './customer';

@Injectable({
    providedIn:'root'
})
export class CustomerService{
    private baseURL = "http://localhost:8080/customer";
    constructor(private httpClient: HttpClient) { }

    createCustomer(customer: Customer): Observable<Object>{
        return this.httpClient.post(`${this.baseURL}`, customer);
      }

      getcustomer(id:number): Observable<Customer>{
        return this.httpClient.get<Customer>(`${this.baseURL}/${id}`);
      }
      getCustomer(email: String): Observable<Customer>{
        return this.httpClient.get<Customer>(`${this.baseURL}/a/${email}`);
      }
}