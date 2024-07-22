package com.example.rems.repository;

import com.example.rems.entity.Renter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface Renterrepo extends JpaRepository<Renter, BigInteger> {
    Renter findByRid(String email);

    void deleteByRid(String email);
}
