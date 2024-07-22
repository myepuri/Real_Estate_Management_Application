import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class DashboardService {
  constructor(private http: HttpClient, private router: Router,) {}

    getMyBookings(email: any) {
        return this.http.get(`http://localhost:8080/Booking/getAll/${email}`)
    }

    getMyRewards(email: any) {
        return this.http.get(`http://localhost:8080/rewards/${email}`)
    }

    cancelBooking(id: any) {
      return this.http.delete(`http://localhost:8080/Booking/cancel/${id}`)
    }

    updateBooking(bookingDetails: any) {
      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
      });
      return this.http
        .post('http://localhost:8080/Booking/updatebooking', bookingDetails, {
          headers: headers,
        })
    }
}
