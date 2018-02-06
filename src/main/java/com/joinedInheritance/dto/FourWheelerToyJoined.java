package com.joinedInheritance.dto;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class FourWheelerToyJoined extends ToyJoined {
    private String SteeringWheel;
}
