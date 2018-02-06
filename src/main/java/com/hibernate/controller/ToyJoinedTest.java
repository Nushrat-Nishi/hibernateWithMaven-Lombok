package com.hibernate.controller;

import com.joinedInheritance.dto.FourWheelerToyJoined;
import com.joinedInheritance.dto.ToyJoined;
import com.joinedInheritance.dto.TwoWheelerToyJoined;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ToyJoinedTest {

    public static void main(String[] args){
        ToyJoined toy = new ToyJoined();
        toy.setToyName("Car");

        TwoWheelerToyJoined bike = new TwoWheelerToyJoined();
        bike.setToyName("Bike");
        bike.setSteeringHandle("Bike Steering Handle");

        FourWheelerToyJoined car = new FourWheelerToyJoined();
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
