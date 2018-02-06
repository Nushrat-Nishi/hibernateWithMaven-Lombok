package com.hibernate.controller;

import com.singleTableInheritance.dto.FourWheelerToy;
import com.singleTableInheritance.dto.Toy;
import com.singleTableInheritance.dto.TwoWheelerToy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ToySingleTableTest {

    public static void main(String[] args){
        Toy toy = new Toy();
        toy.setToyName("Car");

        TwoWheelerToy bike = new TwoWheelerToy();
        bike.setToyName("Bike");
        bike.setSteeringHandle("Bike Steering Handle");

        FourWheelerToy car = new FourWheelerToy();
        car.setToyName("Porsche");
        car.setSteeringWheel("Porsche Steering Wheel");




        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(toy);
        session.save(bike);
        session.save(car);
        //session.persist(user); //used persist instead of save to avoid the following lines: (session.save(book1); session.save(book2);)
        session.getTransaction().commit();
        session.close();


    }
}
