package com.example.rems.repository;

import com.example.rems.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepo extends JpaRepository<Booking , BigInteger> {

    List<Booking> findByEmail(String email);

    Optional<Booking> findById(BigInteger id);
}
