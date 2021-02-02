import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Venue } from './venue';

@Injectable({
  providedIn: 'root'
})
export class VlocService {

 
  private baseURL = "http://localhost:8080/vloc";
  constructor(private httpClient: HttpClient) { }



    getvenue(id:number): Observable<Venue[]>{
      return this.httpClient.get<Venue[]>(`${this.baseURL}/${id}`);
    }
    // getCustomer(email: String): Observable<Customer>{
    //   return this.httpClient.get<Customer>(`${this.baseURL}/a/${email}`);
    // }
}
