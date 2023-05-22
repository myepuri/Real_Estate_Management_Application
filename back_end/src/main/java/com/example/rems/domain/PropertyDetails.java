package com.example.rems.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyDetails{
    private String location;
    private BigInteger number_of_rooms;
    private BigInteger sq_foot;
    private String building_type;
    private String property_type;
    private String saleType;
    private String city;
    private String state;
    private String zipcode;
    private String description;
    private BigInteger price;
    private String email;
    private String businessType;
    private Date availablity;
}
