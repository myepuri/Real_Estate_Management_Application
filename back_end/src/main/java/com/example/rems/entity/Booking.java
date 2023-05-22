package com.example.rems.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    private BigInteger id;

    @Column(name = "email")
    private String email;

    @Column(name = "pid")
    private BigInteger pid;

    @Column(name = "name")
    private String name;

    @Column(name = "creditcard_number")
    private BigInteger creditcard_number;

    @Column(name = "booking_amount")
    private Integer booking_amount;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date start_date;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date end_date;


}
