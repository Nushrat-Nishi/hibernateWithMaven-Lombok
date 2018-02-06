package com.singleTableInheritance.dto;

import com.singleTableInheritance.dto.Toy;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("Car") //to change the Discriminator value in table
public class FourWheelerToy extends Toy {
    private String SteeringWheel;
}
