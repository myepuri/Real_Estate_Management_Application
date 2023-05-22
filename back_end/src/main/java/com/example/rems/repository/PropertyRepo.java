package com.example.rems.repository;

import com.example.rems.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface PropertyRepo extends JpaRepository<Property, BigInteger> {
}
