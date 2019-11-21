package com.eventim.petshop.entities;

import javax.ejb.Stateful;

@Stateful
public class PetRepository extends AbstractRepository {

    public Pet createPet(String name) {
        Pet pet = new Pet();
        pet.setName(name);
        entityManager.persist(pet);
        return pet;
    }
}
