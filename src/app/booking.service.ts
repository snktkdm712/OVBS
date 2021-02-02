import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Booking } from './booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  private baseURL = "http://localhost:8080/booking";
  constructor(private httpClient: HttpClient) { }

  addbooking(booking: Booking): Observable<Object>{
      return this.httpClient.post(`${this.baseURL}`, booking);
    }

  getBookings(): Observable<Booking[]>{
      return this.httpClient.get<Booking[]>(`${this.baseURL}`);
    }
    delBooking(del:number): Observable<Object>{
      return this.httpClient.delete(`${this.baseURL}/${del}`);
    }
}
