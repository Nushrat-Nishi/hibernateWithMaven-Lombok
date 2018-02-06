package com.TablePerClassInheritance.dto;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class TwoWheelerToyTablePerClass extends ToyTablePerClass{
    private String SteeringHandle;
}
