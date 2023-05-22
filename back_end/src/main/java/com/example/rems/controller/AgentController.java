package com.example.rems.controller;

import com.example.rems.domain.AgentDetails;
import com.example.rems.domain.PropertyDetails;
import com.example.rems.entity.Agent;
import com.example.rems.service.AgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/Agent")
public class AgentController {

    @Resource
    private AgentService agentService;

    @PostMapping("/add")
    public ResponseEntity<String> addAgent( @RequestBody  AgentDetails agentDetails){
        return new ResponseEntity<>(agentService.addAgent(agentDetails), HttpStatus.OK);
    }

    @PostMapping("/property")
    public ResponseEntity<String> addProperty( @RequestBody  PropertyDetails propertyDetails){
        return new ResponseEntity<>(agentService.addProperty(propertyDetails), HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Agent> getAgentbyEmail(@PathVariable(name = "email") String email){
        return new ResponseEntity<>(agentService.getAgentDetails(email), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAgent/{email}")
    public ResponseEntity<String> deleteAgentbyEmail(@PathVariable(name = "email") String email){
        return new ResponseEntity<>(agentService.deleteAgent(email), HttpStatus.OK);
    }
}
