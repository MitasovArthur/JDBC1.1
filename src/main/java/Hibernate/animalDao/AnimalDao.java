package Hibernate.animalDao;

import Hibernate.entity.Animal;

public interface AnimalDao {
    boolean add(Animal animal);
    Animal update(Animal animal);
    boolean delete(Animal animal);
    Animal get(int id);
}
