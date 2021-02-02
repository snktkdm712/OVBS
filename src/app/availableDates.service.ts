import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Availabledates } from './availabledates';


@Injectable({
    providedIn:'root'
})
export class availableDatesService{
    private baseURL = "http://localhost:8080/availableDates";
    constructor(private httpClient: HttpClient) { }

    createVowner(availableDates: Availabledates): Observable<Object>{
        return this.httpClient.post(`${this.baseURL}`, availableDates);
      }
      getAvailableDates(): Observable<Availabledates[]>{
        return this.httpClient.get<Availabledates[]>(`${this.baseURL}`);
      }
}