package com.skumar.graphqldemo.beans;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ADDRESS",schema = "mys")
public class Address {

    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    @Column(name = "STREET_NAME")
    private String streetName;
    @Column(name = "CITY")
    private String city;

    @OneToOne(mappedBy = "address")
    private Client client;
}
