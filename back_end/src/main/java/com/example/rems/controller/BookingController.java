package com.example.rems.controller;

import com.example.rems.domain.BookingDetails;
import com.example.rems.entity.Booking;
import com.example.rems.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/Booking")
public class BookingController {

    @Resource
    private BookingService bookingService;
    @PostMapping("/bookProperty")
    public ResponseEntity<String> bookProperty(@RequestBody List<BookingDetails> bookingDetails ){
        return  new ResponseEntity<>(bookingService.bookAProperty(bookingDetails), HttpStatus.OK);
    }

    @GetMapping("/getAll/{email}")
    public ResponseEntity<List<Booking>> getAllBookings(@PathVariable(name = "email") String email){
        return new ResponseEntity<>(bookingService.getAllBookings(email),HttpStatus.OK);
    }

    @PostMapping("/updatebooking")
    public  ResponseEntity<String> updateBooking(@RequestBody BookingDetails bookingDetails){
        return new ResponseEntity<>(bookingService.updatebooking(bookingDetails),HttpStatus.OK);
    }

    @DeleteMapping("/cancel/{id}")
    public  ResponseEntity<String> cancelBooking(@PathVariable(name = "id") BigInteger id){
        return new ResponseEntity<>(bookingService.cancelBooking(id),HttpStatus.OK);
    }
}
