package com.joinedInheritance.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED) //Not mandatory. But we can configure with it.
public class ToyJoined {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int toyId;
    private String toyName;

}
