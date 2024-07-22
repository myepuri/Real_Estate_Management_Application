package com.example.rems.controller;

import com.example.rems.entity.Creditcard;
import com.example.rems.service.CreditcardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigInteger;

@RestController
@RequestMapping("/card")
public class CreditcardController {

    @Resource
    private CreditcardService creditcardService;

    @PostMapping("/add")
    public ResponseEntity<String> addCard( @RequestBody Creditcard creditcard){
        return new ResponseEntity<>(creditcardService.addcard(creditcard),HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Creditcard> getCardByEmail(@PathVariable(name = "email")String email){
        return new ResponseEntity<>(creditcardService.getCardsbyEmail(email),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCard(@PathVariable(name = "id")BigInteger id){
        return new ResponseEntity<>(creditcardService.deleteCard(id),HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateCard( @RequestBody Creditcard creditcard){
        return new ResponseEntity<>(creditcardService.updateCreditCard(creditcard),HttpStatus.OK);
    }
}
