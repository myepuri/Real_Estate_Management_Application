package com.example.rems.controller;

import com.example.rems.entity.Additional_info;
import com.example.rems.entity.NeighbourhoodInfo;
import com.example.rems.service.NeighbourhoodInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigInteger;

@RestController
@RequestMapping("/neighbour")
public class NeighbourHoodInfoController {

    @Resource
    private NeighbourhoodInfoService neighbourhoodInfoService;

    @GetMapping("/{pid}")
    public ResponseEntity<NeighbourhoodInfo> getAllBookings(@PathVariable(name = "pid") BigInteger pid){
        return new ResponseEntity<>(neighbourhoodInfoService.getInfoByPid(pid),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNeighbourHoodData(@RequestBody NeighbourhoodInfo neighbourhoodInfo){
        return new ResponseEntity<>(neighbourhoodInfoService.addNeighbourHoodInfo(neighbourhoodInfo),HttpStatus.OK);
    }


}
