package com.example.rems.controller;

import com.example.rems.entity.Additional_info;
import com.example.rems.service.AdditionalInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigInteger;

@RestController
@RequestMapping("/info")
public class AdditionalInfoController {

    @Resource
    private AdditionalInfoService additionalInfoService;

    @GetMapping("/{pid}")
    public ResponseEntity<Additional_info> getAllBookings(@PathVariable(name = "pid") BigInteger pid){
        return new ResponseEntity<>(additionalInfoService.getInfoByPid(pid),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addInfo(@RequestBody Additional_info additional_info){
        return new ResponseEntity<>(additionalInfoService.addInfo(additional_info),HttpStatus.OK);
    }


}
