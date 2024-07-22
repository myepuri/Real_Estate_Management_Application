package com.example.rems.repository;

import com.example.rems.domain.CommercailProperty;
import com.example.rems.domain.HouseProperty;
import com.example.rems.entity.CommercialBuildings;
import com.example.rems.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Repository
public interface CommercialBuildingsRepo extends JpaRepository<CommercialBuildings, BigInteger> {

    @Query(value = "SELECT new com.example.rems.domain.CommercailProperty(p.pid ,c.location,c.business_type,c.sq_foot,p.pType,p.saleType,p.city,p.price,p.availability)"
            +" FROM CommercialBuildings c INNER JOIN Property p ON c.propertyid = p.pid WHERE  p.city =?1 AND p.availability BETWEEN ?2 AND ?3")
    List<CommercailProperty> findByLocationAndDate(String city, Date startDate, Date EndDate);
}
