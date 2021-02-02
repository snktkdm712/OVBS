import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from './user';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseURL = "http://localhost:8080/login/validateUser";

  constructor(private httpClient:HttpClient) {}
  validateUser(user:User): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, user);
  }

 

 
 }
