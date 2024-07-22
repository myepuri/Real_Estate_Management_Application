package com.example.rems.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rewards")
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "pid")
    private BigInteger pid;

    @Column(name = "bid")
    private BigInteger bid;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "reward_point")
    private int reward_point;

}
