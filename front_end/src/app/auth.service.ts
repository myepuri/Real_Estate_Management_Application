import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import {MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition} from '@angular/material/snack-bar';
import { MatSnackBarConfig } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient, private router: Router, private snackbar: MatSnackBar) {}

  horizontalPosition: MatSnackBarHorizontalPosition = 'end';
  verticalPosition: MatSnackBarVerticalPosition = 'top';
  config: MatSnackBarConfig = { duration: 3000,  horizontalPosition: this.horizontalPosition,
    verticalPosition: this.verticalPosition, }

  authenticateUser(loginDetails: any) {
    let headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });

    this.http
      .post('http://localhost:8080/users/login', loginDetails, {
        headers: headers,
        responseType: 'text',
      })
      .subscribe((data) => {
        if(['renter','agent'].includes(data)) {
           this.router.navigate(['/dashboard', { email: loginDetails.email}]);
        } else {
          this.snackbar.open("Login Failed. Try Again !", '', this.config);
        }
      });
  }

  registerUser(registerDetails: any) {
    let headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });
    this.http
      .post('http://localhost:8080/users/signup', registerDetails, {
        headers: headers,
        responseType: 'text',
      })
      .subscribe((data) => {
        if(data === "User/Agent Added SuccesFully") {
          console.log('Registration Succcessful !');
          console.log(data);
          this.snackbar.open("Registration Successful ! Please Login", '', this.config);
          this.router.navigate(['/login']);
        }
      });
  }

  addAgentDetails(agentDetails: any) {
    let headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });
    this.http
      .post('http://localhost:8080/Agent/add', agentDetails, {
        headers: headers,
        responseType: 'text',
      })
      .subscribe((data) => {
        console.log('Agent Add Succcessful !');
        console.log(data);
      });
  }

  addRenterDetails(renterDetails: any) {
    let headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });
    this.http
      .post('http://localhost:8080/Renter/add', renterDetails, {
        headers: headers,
        responseType: 'text',
      })
      .subscribe((data) => {
        console.log('Renter Add Succcessful !');
        console.log(data);
      });
  }
}
