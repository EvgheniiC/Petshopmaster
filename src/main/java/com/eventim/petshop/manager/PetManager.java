package com.eventim.petshop.manager;

import com.eventim.petshop.FacesUtils;
import com.eventim.petshop.entities.Customer;
import com.eventim.petshop.entities.CustomerRepository;
import com.eventim.petshop.entities.Pet;
import com.eventim.petshop.entities.PetRepository;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.beans.Customizer;
import java.util.Collection;
import java.util.Optional;

@Stateful
public class PetManager {

    @EJB
    private PetRepository petRepository;

    @EJB
    private CustomerRepository customerRepository;

    public void createPet(Integer customerId, String name) {
        if (!customerRepository.findCostumerById(customerId).isPetExist(name)){
        Pet pet = petRepository.createPet(name);
        customerRepository.addPetToCustomer(customerId, pet);}
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pets already exits"));
        }
    }

    public void deletePet(Integer customerId, String name) {
        if (customerRepository.findCostumerById(customerId).isPetExist(name)){

            Collection<Pet> temp =  customerRepository.findCostumerById(customerId).getPets();
            Optional<Pet> pet =  temp.stream().filter(p->p.getName().equals(name)).findFirst();
            if (pet.isPresent()) petRepository.deletePet(pet.get());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pets deleted")); }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pets not exits"));
        }
    }
}
