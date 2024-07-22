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
public class BookingDetails {
    private BigInteger id;

    private String email;

    private BigInteger pid;

    private String name;

    private BigInteger creditcard_number;

    private Integer booking_amount;

    private Date start_date;

    private Date end_date;
}
