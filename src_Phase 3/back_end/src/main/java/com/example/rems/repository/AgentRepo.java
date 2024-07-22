package com.example.rems.repository;

import com.example.rems.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AgentRepo extends JpaRepository<Agent, BigInteger> {
    void deleteByAgid(String email);

    Agent findByAgid(String email);
}
