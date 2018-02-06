package com.singleTableInheritance.dto;

import lombok.Data;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //Not mandatory. But we can configure with it.
@DiscriminatorColumn(name = "TOY_TYPE", discriminatorType = DiscriminatorType.STRING) //to change the Discriminator column name in table. not necessary in the table per class strategy.
public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int toyId;
    private String toyName;

}
