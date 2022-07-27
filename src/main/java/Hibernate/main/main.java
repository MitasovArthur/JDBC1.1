package Hibernate.main;

import Hibernate.animalDao.AnimalDao;
import Hibernate.animalDao.impl.AnimalDaoImpl;
import Hibernate.entity.Animal;

public class main {
    private static AnimalDao animalDao = new AnimalDaoImpl();

    public static void main(String[] args) {
        Animal animal = Animal.builder()
                .name("jora")
                .age(15)
                .tail(false)
                .build();
        animalDao.add(animal);
        System.out.println(animalDao.get(1));
        animalDao.update(animal);
        System.out.println(animalDao.get(1));
        animalDao.delete(animal);
    }
}
