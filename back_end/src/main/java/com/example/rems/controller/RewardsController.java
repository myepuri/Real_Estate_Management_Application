package com.example.rems.controller;

import com.example.rems.service.RewardsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/rewards")
public class RewardsController {

    @Resource
    private RewardsService rewardsService;

    @GetMapping("/{email}")
    public ResponseEntity<Integer> getAllBookings(@PathVariable(name = "email") String email){
        return new ResponseEntity<>(rewardsService.getTotalPointsByEmail(email),HttpStatus.OK);
    }


}
