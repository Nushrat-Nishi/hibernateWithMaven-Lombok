package com.joinedInheritance.dto;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class TwoWheelerToyJoined extends ToyJoined {
    private String SteeringHandle;
}
