package com.example.rems.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "creditcard")
public class Creditcard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "rid")
    private String rid;

    @Column(name = "creditcard_number")
    private BigInteger creditcard_number;

    @Column(name = "name")
    private String name;

    @Column(name = "expiry_date")
    private String expiry_date;

    @Column(name = "cvv")
    private BigInteger cvv;

    @Column(name = "billing_address")
    private String billing_address;
}
