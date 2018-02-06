package com.relationship.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int homeId;
    private String homeName;
}
