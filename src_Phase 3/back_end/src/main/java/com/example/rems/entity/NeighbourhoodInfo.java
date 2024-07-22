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
@Table(name = "neighbourhood_info")
public class NeighbourhoodInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "pid")
    private BigInteger pid;

    @Column(name = "land")
    private String land;

    @Column(name = "vacation_homes")
    private String vacation_homes;



}
