package com.example.rems.repository;

import com.example.rems.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AddressRepo extends JpaRepository<Address, BigInteger> {
    Address findByEmail(String email);

    void deleteByEmail(String email);
}
