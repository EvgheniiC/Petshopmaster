package com.eventim.petshop.entities;

import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;


@Stateful
public class PetRepository extends AbstractRepository {

    private Pet pet;
    Customer customer;

    public Pet createPet(String name) {
        Pet pet = new Pet();
        pet.setName(name);
        entityManager.persist(pet);
        return pet;
    }

    public void deletePet(Pet pet) {
           entityManager.remove(pet);
       }
}
