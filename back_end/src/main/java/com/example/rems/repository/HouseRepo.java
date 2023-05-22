package com.example.rems.repository;

import com.example.rems.domain.HouseProperty;
import com.example.rems.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Repository
public interface HouseRepo extends JpaRepository<House, BigInteger> {

    @Query(value = "SELECT new com.example.rems.domain.HouseProperty(p.pid ,h.location,h.number_of_rooms,h.sq_foot,p.pType,p.saleType,p.city,p.price,p.availability)"
            +" FROM House h INNER JOIN Property p ON h.propertyid = p.pid WHERE  p.city =?1 AND p.availability BETWEEN ?2 AND ?3")
    List<HouseProperty> findByLocationAndDate(String city, Date startDate, Date EndDate);

    void deleteByPropertyid(BigInteger id);
}
