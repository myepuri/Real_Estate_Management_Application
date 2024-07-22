package com.example.rems.controller;

import com.example.rems.domain.RenterDetails;
import com.example.rems.entity.Renter;
import com.example.rems.service.RenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/Renter")
public class RenterController {

    @Resource
    private RenterService renterService;

    @PostMapping("/add")
    public ResponseEntity<String> addRenter( @RequestBody RenterDetails renterDetails){

        return new ResponseEntity<>(renterService.addRenter(renterDetails), HttpStatus.OK);

    }

    @GetMapping("/email")
    public ResponseEntity<Renter> getRenterbyEmail(@PathVariable(name = "email") String email){
        return new ResponseEntity<>(renterService.getRenterDetails(email), HttpStatus.OK);
    }

    @DeleteMapping("/email")
    public ResponseEntity<String> deleteRenterbyEmail(@PathVariable(name = "email") String email){
        return new ResponseEntity<>(renterService.deleteRenter(email), HttpStatus.OK);
    }
}
