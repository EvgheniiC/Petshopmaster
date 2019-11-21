package com.eventim.petshop.manager;

import com.eventim.petshop.entities.CustomerRepository;
import com.eventim.petshop.entities.Pet;
import com.eventim.petshop.entities.PetRepository;

import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class PetManager {

    @EJB
    private PetRepository petRepository;

    @EJB
    private CustomerRepository customerRepository;

    public void createPet(Integer customerId, String name) {
        Pet pet = petRepository.createPet(name);
        customerRepository.addPetToCustomer(customerId, pet);
    }

}
