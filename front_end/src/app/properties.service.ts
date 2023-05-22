import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class PropertyService {
  constructor(private http: HttpClient, private router: Router,) {}

    getApartments(location: any, startDate: any, endDate: any) {
        return this.http.get(`http://localhost:8080/Apartment/filter/${location}/${startDate}/${endDate}`)
    }

    getHouses(location: any, startDate: any, endDate: any) {
        return this.http.get(`http://localhost:8080/House/filter/${location}/${startDate}/${endDate}`)
    }

    getBuildings(location: any, startDate: any, endDate: any) {
        return this.http.get(`http://localhost:8080/commercialBuildings/filter/${location}/${startDate}/${endDate}`)
    }
}
