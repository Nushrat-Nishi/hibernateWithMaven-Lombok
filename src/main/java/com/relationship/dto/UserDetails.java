
package com.relationship.dto;

import lombok.Data;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;

    @OneToOne
    @JoinColumn(name = "HOME_ID")
    private Home home;

    @OneToMany
    @JoinTable(name = "USER_VEHICLE",joinColumns = @JoinColumn(name = "USER_ID"),
    inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
    private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST) //cascade is used to avoid saving all the book objects.(session.save(book1); session.save(book2);)
    private Collection<Book> books = new ArrayList<Book>();

    @ManyToMany
    @JoinTable(name = "USER_LAPTOP",joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "LAPTOP_ID"))
    private Collection<Laptop> laptops = new ArrayList<Laptop>();


    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME")), @AttributeOverride(name = "pinCode", column = @Column(name = "HOME_PIN_CODE")), @AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME")), @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME"))})
    private Address homeAddress;

    @Embedded
    private Address officeAddress;

    @ElementCollection
    @JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
    private Set<Address> listOfAddresses = new HashSet();

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ADDRESS_COLLECTION", joinColumns = @JoinColumn(name = "USER_COLLECTION_ID"))
    @GenericGenerator(name = "sequence-gen", strategy = "sequence")
    @CollectionId(columns = {@Column(name = "ADDRESS_ID")}, generator = "sequence-gen", type = @Type(type = "long"))
    private Collection<Address> listOfAddressesID = new ArrayList();
}