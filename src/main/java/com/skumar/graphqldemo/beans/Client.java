package com.skumar.graphqldemo.beans;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CLIENT",schema = "mys")
public class Client {

    @Id
    @Column(name = "CLIENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    @Column(name = "FST_NAME")
    private String firstName;
    @Column(name = "LST_NAME")
    private String lastName;
    @Column(name = "MID_NAME")
    private String midName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    private Address address;
}
