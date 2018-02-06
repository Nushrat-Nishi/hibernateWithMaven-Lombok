package com.hibernate.controller;

import com.TablePerClassInheritance.dto.FourWheelerToyTablePerClass;
import com.TablePerClassInheritance.dto.ToyTablePerClass;
import com.TablePerClassInheritance.dto.TwoWheelerToyTablePerClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ToyTablePerClassTest {

    public static void main(String[] args){
        ToyTablePerClass toy = new ToyTablePerClass();
        toy.setToyName("Car");

        TwoWheelerToyTablePerClass bike = new TwoWheelerToyTablePerClass();
        bike.setToyName("Bike");
        bike.setSteeringHandle("Bike Steering Handle");

        FourWheelerToyTablePerClass car = new FourWheelerToyTablePerClass();
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
