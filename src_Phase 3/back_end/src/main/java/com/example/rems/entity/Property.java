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
@Table(name = "property")
public class Property {
    @Id
    @Column(name = "pid")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    private BigInteger pid;

    @Column(name="property_type")
    private String pType;

    @Column(name = "sale_type")
    private String saleType;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipcode")
    private String zipCode;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigInteger price;

    @Temporal(TemporalType.DATE)
    @Column(name = "availability")
    private Date availability;

    @OneToOne(mappedBy = "property")
    private House house;

    @OneToOne(mappedBy = "property")
    private Appartment appartment;

    @OneToOne(mappedBy = "property")
    private CommercialBuildings commercialBuildings;

//    @OneToMany(targetEntity = Booking.class , cascade = CascadeType.ALL)
//    @JoinColumn(name = "pb_fk", referencedColumnName = "pid")
//    private  List<Booking> bookings;


}
