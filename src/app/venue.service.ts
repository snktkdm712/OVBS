import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Venue } from './venue';

@Injectable({
    providedIn:'root'
})
export class VenueService{
    private baseURL = "http://localhost:8080/venue";
    constructor(private httpClient: HttpClient) { }

    createVenue(venue: Venue): Observable<Object>{
        return this.httpClient.post(`${this.baseURL}`, venue);
      }
      getvenues(): Observable<Venue[]>{
        return this.httpClient.get<Venue[]>(`${this.baseURL}`);
      }
      getvenue(vname:string): Observable<Venue>{
        return this.httpClient.get<Venue>(`${this.baseURL}/${vname}`);
      }

}