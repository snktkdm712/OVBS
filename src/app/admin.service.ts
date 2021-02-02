import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Admin } from './admin';

@Injectable({
    providedIn:'root'
})
export class AdminService{
    private baseURL = "http://localhost:8080/admin";
    constructor(private httpClient: HttpClient) { }

    createAdmin(admin: Admin): Observable<Object>{
        return this.httpClient.post(`${this.baseURL}`, admin);
      }

    getAdminList(): Observable<Admin[]>{
        return this.httpClient.get<Admin[]>(`${this.baseURL}`);
      }
      getadmin(id:number): Observable<Admin>{
        return this.httpClient.get<Admin>(`${this.baseURL}/${id}`);
      }
      getAdmin(email: String): Observable<Admin>{
        return this.httpClient.get<Admin>(`${this.baseURL}/a/${email}`);
      }
}