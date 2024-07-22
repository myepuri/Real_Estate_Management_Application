package com.example.rems.repository;

import com.example.rems.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, BigInteger> {
    Optional<Users> findByEmail(String email);
}
