package com.eventim.petshop.manager;

import com.eventim.petshop.entities.Customer;
import com.eventim.petshop.entities.CustomerRepository;
import com.eventim.petshop.entities.Pet;
import com.eventim.petshop.entities.PetRepository;
import jdk.jfr.internal.Repository;
import org.bouncycastle.asn1.x500.style.RFC4519Style;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.util.Collection;
import java.util.List;

@Stateful
public class CustomerManager {

    @EJB
    private CustomerRepository customerRepository;

    public Customer getCustomerForId(int customerID){
        Customer customer = customerRepository.findCostumerById(customerID);
        return customer;
    }

    public Collection<Pet> getPetsForCustomer(Integer customerId) {
        return customerRepository.findCostumerById(customerId).getPets();
    }

    public List<Customer> getAll(){
        return customerRepository.findAllCustomers();

    }
}
