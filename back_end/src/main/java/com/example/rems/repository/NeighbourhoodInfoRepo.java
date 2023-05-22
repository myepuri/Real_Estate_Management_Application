package com.example.rems.repository;

import com.example.rems.entity.NeighbourhoodInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface NeighbourhoodInfoRepo extends JpaRepository<NeighbourhoodInfo, BigInteger> {
}
