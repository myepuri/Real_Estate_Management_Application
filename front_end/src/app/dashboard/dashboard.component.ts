import { Component, OnInit, TemplateRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DashboardService } from '../dashboard.service';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.css']
})


export class DashboardComponent implements OnInit {

    bookings: any;
    rewards: any;
    panelOpenState = false; 
    username: any;
    startdate: any;
    enddate: any;
    constructor(private route: ActivatedRoute, private dashbaordService: DashboardService, private dialog: MatDialog, private router: Router) { }

    ngOnInit() {
        const email = this.route.snapshot.paramMap.get('email');
        console.log(email);
        this.dashbaordService.getMyBookings(email).subscribe(data => {
            this.bookings = data;
        })
        this.dashbaordService.getMyRewards(email).subscribe(data => {
            this.rewards = data;
        })
    }

    cancelBookingHandler(id: any) {
        this.dashbaordService.cancelBooking(id).subscribe(data => {
            console.log(data);
        })
    }

    updateBookingHandler(booking: any, updateBookingRef: TemplateRef<any>) {
        this.dialog.open(updateBookingRef, { data: booking})
    }

    updateBooking(updatedBooking: any) {
        console.log("ABOUT TO UPDATE");
        console.log(updatedBooking);
        let bookingToUpdateIndex = this.bookings.findIndex((booking: any) => booking.id === updatedBooking.id);
        this.bookings[bookingToUpdateIndex] = {
            id: this.bookings[bookingToUpdateIndex].id,
            pid: this.bookings[bookingToUpdateIndex].pid,
            name: this.username ? this.username : this.bookings[bookingToUpdateIndex].name,
            creditcard_number: this.bookings[bookingToUpdateIndex].creditcard_number,
            email: this.bookings[bookingToUpdateIndex].email,
            start_date: this.startdate ? this.startdate : this.bookings[bookingToUpdateIndex].start_date,
            end_date: this.enddate ? this.enddate : this.bookings[bookingToUpdateIndex].end_date,
            booking_amount: this.bookings[bookingToUpdateIndex].booking_amount
        }

        this.dashbaordService.updateBooking(this.bookings[bookingToUpdateIndex]).subscribe(data => {
            console.log(data)
        });
    }

    propertiesHandler() {
        this.router.navigate(['/properties', { email : this.bookings[0].email }]);
    }

}