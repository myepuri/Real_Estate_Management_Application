import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  email: any;
  password: any;
  username: any;
  usertype: any;

  constructor(private appService: AuthService) {}

  ngOnInit() {}

  loginHandler() {
    const loginDetails = {
      email: this.email,
      password: this.password,
      name: this.username,
      user_type: this.usertype,
    };
    console.log(loginDetails);
    this.appService.authenticateUser(loginDetails);
  }
}
