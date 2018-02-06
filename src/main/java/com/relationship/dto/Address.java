package com.relationship.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {

    @Column(name = "CITY_NAME")
    private String city;

    @Column(name = "PIN_CODE")
    private int pinCode;

    @Column(name = "STATE_NAME")
    private String state;

    @Column(name = "STREET_NAME")
    private String street;

}
