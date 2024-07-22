package com.example.rems.repository;

import com.example.rems.entity.Creditcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CreditcardRepo extends JpaRepository<Creditcard, BigInteger> {
    Creditcard findByRid(String email);
}
