package com.TablePerClassInheritance.dto;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class FourWheelerToyTablePerClass extends ToyTablePerClass{
    private String SteeringWheel;
}
