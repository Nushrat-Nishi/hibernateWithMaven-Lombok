package com.relationship.dto;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)  //it's for the case, if there is no user available now.
    @JoinColumn(name = "USER_ID")
    private UserDetails user;
}
