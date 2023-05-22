package com.example.rems.repository;

import com.example.rems.entity.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface RewardsRepo extends JpaRepository<Reward, BigInteger> {
    List<Reward> findByEmail(String email);
}
