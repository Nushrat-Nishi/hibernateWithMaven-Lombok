package com.relationship.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;
    private String vehicleName;

}
