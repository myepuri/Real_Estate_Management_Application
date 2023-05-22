import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
    selector: 'app-register',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

    constructor(private authService: AuthService) { }

    email: any;
  password: any;
  username: any;
  usertype: any;
  // AGENT
  agencyname: any;
  jobtitle: any;
  phone: any;
  // RENTER
  budget: any;
  moveindate: any;
  location: any;
  

    ngOnInit () {

    }

    registerHandler() {
        const registerUser = {
            email: this.email,
            password: this.password,
            name: this.username,
            user_type: this.usertype
        }
        console.log(registerUser)
        this.authService.registerUser(registerUser);

        if(this.usertype === "agent") {
            const agentInfo = {
                agency_name: this.agencyname,
                agid: this.email,
                job_title: this.jobtitle,
                name: this.username,
                phone: this.phone
              }
              console.log(agentInfo)
              this.authService.addAgentDetails(agentInfo);
        }
        
        if(this.usertype === "renter") {
            const renterInfo = {
                budget: this.budget,
                move_in_date: this.moveindate,
                name: this.username,
                preferred_location: this.location,
                rid: this.email
              }
              console.log(renterInfo)
              this.authService.addRenterDetails(renterInfo);
        }
        
    }
}