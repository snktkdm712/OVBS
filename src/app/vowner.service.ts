import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Vowner } from 'src/app/vowner';


@Injectable({
    providedIn:'root'
})
export class VownerService{
    private baseURL = "http://localhost:8080/vowner";
    constructor(private httpClient: HttpClient) { }

    createVowner(vowner: Vowner): Observable<Object>{
        return this.httpClient.post(`${this.baseURL}`, vowner);
      }
    
      getVownerList(): Observable<Vowner[]>{
        return this.httpClient.get<Vowner[]>(`${this.baseURL}`);
      }
      getvowner(id:number): Observable<Vowner>{
        return this.httpClient.get<Vowner>(`${this.baseURL}/${id}`);
      }
      getVowner(email: String): Observable<Vowner>{
        return this.httpClient.get<Vowner>(`${this.baseURL}/a/${email}`);
      }
}