package com.TablePerClassInheritance.dto;

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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //Not mandatory. But we can configure with it.
public class ToyTablePerClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int toyId;
    private String toyName;

}
