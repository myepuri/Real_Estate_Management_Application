package com.example.rems.service;

import com.example.rems.entity.Creditcard;
import com.example.rems.repository.CreditcardRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Optional;

@Service
public class CreditcardService {

    @Resource
    private CreditcardRepo creditcardRepo;

    public String addcard(Creditcard creditcard) {
        creditcardRepo.save(creditcard);
        return "Success";

    }

    public Creditcard getCardsbyEmail(String email){
        return creditcardRepo.findByRid(email);
    }

    public String deleteCard(BigInteger id){
        creditcardRepo.deleteById(id);
        return "Success";
    }

    public String updateCreditCard(Creditcard creditcard){
        Optional<Creditcard> cardEntiry = creditcardRepo.findById(creditcard.getId());
        if (cardEntiry.isPresent()){
            Creditcard card = cardEntiry.get();
            card.setCreditcard_number(creditcard.getCreditcard_number());
            card.setCvv(creditcard.getCvv());
            card.setBilling_address(creditcard.getBilling_address());
            card.setExpiry_date(creditcard.getExpiry_date());
            card.setName(creditcard.getName());
            creditcardRepo.save(creditcard);
        }else {
            return "Card Not Found";
        }
        return "Card details Updated";
    }

}
