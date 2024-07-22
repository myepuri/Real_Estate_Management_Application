package com.example.rems.controller;

import com.example.rems.entity.Additional_info;
import com.example.rems.entity.Address;
import com.example.rems.service.AdditionalInfoService;
import com.example.rems.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigInteger;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Resource
    private AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<String> addAddress(@RequestBody Address address){
        return new ResponseEntity<>(addressService.saveAddress(address),HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Address> getAddress(@PathVariable(name = "email") String email){
        return new ResponseEntity<>(addressService.getAddressByEmail(email),HttpStatus.OK);
    }



}
