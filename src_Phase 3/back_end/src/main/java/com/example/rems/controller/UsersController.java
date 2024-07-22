package com.example.rems.controller;

import com.example.rems.domain.UserDetails;
import com.example.rems.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Resource
    private UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody UserDetails userDetails){
        return new ResponseEntity<>(usersService.loginService(userDetails), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> userSignup( @RequestBody  UserDetails userDetails){
        return new ResponseEntity<>(usersService.registerService(userDetails), HttpStatus.OK);
    }


}
