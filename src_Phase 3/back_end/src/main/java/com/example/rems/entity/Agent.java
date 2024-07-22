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
@Table(name = "agent")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "agid")
    private String agid;

    @Column(name = "name")
    private String name;

    @Column(name = "job_title")
    private String job_title;

    @Column(name = "phone")
    private String phone;

    @Column(name = "agency_name")
    private String agency_name;

}
