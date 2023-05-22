package com.example.rems.repository;

import com.example.rems.entity.Additional_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AdditionInfoRepo extends JpaRepository<Additional_info, BigInteger> {
}
