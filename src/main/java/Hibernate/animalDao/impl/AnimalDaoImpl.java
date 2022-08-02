package Hibernate.animalDao.impl;

import Hibernate.entity.Animal;
import Hibernate.animalDao.AnimalDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AnimalDaoImpl implements AnimalDao {
    private static SessionFactory sessionFactory;

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            return new Configuration()
                    .configure()
                    .buildSessionFactory();
        }
        return sessionFactory;
    }


    @Override
    public boolean add(Animal animal) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(animal);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Animal update(Animal animal) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        animal.setAge(animal.getAge()+1);
        animal.setId(1);
        session.update(animal);
        transaction.commit();
        session.close();
       return animal;
    }

    @Override
    public boolean delete(Animal animal) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        animal.setId(1);
        session.delete(animal);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Animal get(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Animal animal = session.get(Animal.class, id);
        transaction.commit();
        session.close();
        return animal;
    }
}
