package com.singleTableInheritance.dto;

import com.singleTableInheritance.dto.Toy;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("Bike") //to change the Discriminator value in table
public class TwoWheelerToy extends Toy {
    private String SteeringHandle;
}
