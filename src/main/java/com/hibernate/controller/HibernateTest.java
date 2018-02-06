package com.hibernate.controller;

import com.relationship.dto.Address;
import com.relationship.dto.Book;
import com.relationship.dto.Home;
import com.relationship.dto.Laptop;
import com.relationship.dto.UserDetails;
import com.relationship.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HibernateTest {

    public static void main(String[] args){
        Set<Address> listOfAddresses = new HashSet<Address>();
        Collection<Address> listOfAddressesID = new ArrayList<Address>();

        Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
        Collection<Book> books = new ArrayList<Book>();
        Collection<Laptop> laptops = new ArrayList<Laptop>();



        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Car");
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Jeep");

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        Home home = new Home();
        home.setHomeName("Santiniketon");

        UserDetails user = new UserDetails();
       /* Address homeAddress = new Address();
        homeAddress.setCity("Amsterdam");
        homeAddress.setPinCode(1064);
        homeAddress.setState("west");
        homeAddress.setStreet("Senecastraat");

        Address officeAddress =new Address();
        officeAddress.setStreet("street2");
        officeAddress.setState("Hague");
        officeAddress.setCity("Utrecht");
        officeAddress.setPinCode(2345);

        listOfAddresses.add(homeAddress);
        listOfAddresses.add(officeAddress);

        listOfAddressesID.add(homeAddress);
        listOfAddressesID.add(officeAddress);*/

        user.setUserName("Nishi");
        //user.setHomeAddress(homeAddress);
        //user.setOfficeAddress(officeAddress);
        //user.setListOfAddresses(listOfAddresses);
        //user.setListOfAddressesID(listOfAddressesID);

        user.setHome(home);
        user.setVehicles(vehicles);

        Book book1 = new Book();
        book1.setBookName("satkahon");
        Book book2 = new Book();
        book2.setBookName("TinGoyenda");

        books.add(book1);
        books.add(book2);
        user.setBooks(books);

        book1.setUser(user);
        book2.setUser(user);


        Laptop laptop1=new Laptop();
        laptop1.setLaptopName("Dell");
        Laptop laptop2=new Laptop();
        laptop2.setLaptopName("Mac");

        /*laptops.add(laptop1);
        laptops.add(laptop2);
        user.setLaptops(laptops);*/
        user.getLaptops().add(laptop1);
        user.getLaptops().add(laptop2);
        laptop1.getUserList().add(user);
        laptop2.getUserList().add(user);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //session.save(user);
        session.persist(user); //used persist instead of save to avoid the following lines: (session.save(book1); session.save(book2);)
        session.save(vehicle1);
        session.save(vehicle2);
        session.save(home);
       /* session.save(book1);
        session.save(book2);*/
        session.save(laptop1);
        session.save(laptop2);
        session.getTransaction().commit();
        session.close();

        /*user = null;
        session = sessionFactory.openSession();
        user = (UserDetails) session.get(UserDetails.class,1);
        System.out.println(user.getListOfAddresses().size());
        session.close();*/
    }
}
